package onight.zjfae.mfront.action;

import java.io.IOException;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.NActorProvider;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ntrans.api.ActorService;
import onight.tfw.ntrans.api.annotation.ActorRequire;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.otransio.api.beans.SendFailedBody;
import onight.tfw.otransio.api.beans.UnknowCMDBody;
import onight.tfw.outils.bean.JsonPBUtil;
import onight.tfw.outils.serialize.ISerializer;
import onight.tfw.outils.serialize.SerializerFactory;
import onight.zjfae.mfront.filter.SSOPacketHelper;
import onight.zjfae.mfront.preproc.PreProcResult;
import onight.zjfae.mfront.service.HttpRequestor;
import onight.zjfae.mfront.service.IFEBeanMapping;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.StaticServiceProperty;
import org.apache.http.client.ClientProtocolException;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;

@iPojoBean
@NActorProvider
// @Provides(specifications = { IActor.class, PSenderService.class })
// @Instantiate(name = "iFEProxyAction")
// @Provides(specifications = ActorService.class, properties = {
// @StaticServiceProperty(name = "name", value = "iFEProxyAction", type =
// "java.lang.String") })
@Slf4j
public class IFEProxyAction extends MobileModuleStarter<Message> {

	protected HttpRequestor requestor = new HttpRequestor();

	SSOPacketHelper filter = new SSOPacketHelper();

	IFEBeanMapping bmap = new IFEBeanMapping();

	public IFEBeanMapping getBmap() {
		return bmap;
	}

	String backendurl;

	@Override
	public String[] getCmds() {
		requestor.reload();
		requestor.changeMaxTotal(props.get("pxy.http.conn.max", 10));
		bmap.init();
		backendurl = props.get("app.backend.url", "http://10.18.13.142");
		log.debug("backendurl=" + backendurl);
		return new String[] { "IFE" };
	}

	// http://localhost:8081/mzj/pbife.do?fh=VREGMZJ000000J00&bd={"pageIndex":"13800138000","image_code":"12334554"}&pbname=PBIFE_badasset_queryProjectReveal
	// //
	// http://localhost:8081/mzj/pbife.do?fh=VREGMZJ000000P00&pbname=PBIFE_badasset_queryProjectReveal

	protected ISerializer jsons = SerializerFactory.getSerializer(SerializerFactory.SERIALIZER_JSON);

	ThreadLocal<Builder<?>> currentBuilder = new ThreadLocal<Builder<?>>();

	@ActorRequire
	@Setter
	@Getter
	ConfigProcessor cfgProc;

	public Message resultToErrorPacket(String returnCode, String returnMsg, String pbname) {
		Builder retbuilder = (Builder) bmap.getResBuilder(pbname);
		if (retbuilder != null) {
			JsonPBUtil.json2PB("{\"returnCode\":\"" + returnCode + "\",\"returnMsg\":\"" + returnMsg + "\"}", retbuilder);
			return retbuilder.build();
		} else {
			return null;
		}

	}

	@Override
	public void onPBPacket(final FramePacket pack, Message nubo, final CompleteHandler handler) {
		// log.debug("pack:" + pack);

		String pbname = pack.getExtStrProp("pbname");
		if (StringUtils.isBlank(pbname)) {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("pbname 不能为空", pack)));
		} else {
			Builder builder = bmap.getReqBuilder(pbname);
			if (builder == null) {
				handler.onFinished(PacketHelper.toPBReturn(pack, new UnknowCMDBody("未找到的命令:" + pbname, pack)));
			} else {
				try {
					currentBuilder.set(builder);
					Message msg = getPBBody(pack);//
					// 1.preprocess.== validate..前处理逻辑
					log.debug("msg==" + msg);
					try {
						PreProcResult ppResult = cfgProc.preDO(pack, builder, pbname);
						if (ppResult != null) {
							String str = ppResult.getPreproc().getProcParams();
							Message retmsg;
							if (str != null) {
								int idx = str.indexOf(",");
								if (idx >= 0) {
									String errcode = str.substring(0, idx);
									String errmessage = "接口被屏蔽";
									if (idx < str.length() - 1) {
										errmessage = str.substring(idx + 1);
									}
									retmsg = resultToErrorPacket(str.substring(0, idx), errmessage, pbname);
								} else {
									retmsg = resultToErrorPacket("I19999", "接口被屏蔽", pbname);
								}
								handler.onFinished(PacketHelper.toPBReturn(pack, retmsg));
								return;
							}
						}

					} catch (Exception e) {
						log.debug("preprocError", e);
						Message retmsg = resultToErrorPacket("I09999", "系统前处理异常", pbname);
						handler.onFinished(PacketHelper.toPBReturn(pack, retmsg));
						return;
					}

					log.debug("msg=={}", msg);
					String str = null;
					String requestBody = null;
					String path = bmap.getEURL(pbname);
					if (pack.getBody() == null || pack.getBody().length == 0) {
						requestBody = "";
					} else {
						if (pack.getFixHead().getEnctype() == 'P') {
							str = new FJsonPBFormat().printToString(msg);
						} else {
							str = new String(pack.getBody(), "UTF-8");
						}
						log.debug("proxy:{}", str);
						requestBody = str;
					}
					log.debug("name:" + pbname + ",url=" + path);
					try {
						Message retmsg = postJsonMessage(pack, requestBody, pbname);
						log.debug("posProc_result=" + retmsg);
						handler.onFinished(PacketHelper.toPBReturn(pack, retmsg));
						int size = pack.getFixHead().getBodysize();
						log.debug("retfh = {},extSize={},bodySize={}", pack.getFixHead().toStrHead(), pack.getFixHead().getExtsize(), size);
					} catch (Exception e) {
						log.warn("系统处理异常：" + pbname, e);
						Message retmsg = resultToErrorPacket("I29999", "系统后处理异常", pbname);
						handler.onFinished(PacketHelper.toPBReturn(pack, retmsg));

					}

				} catch (Exception e) {
					// 转换失败时
					log.debug("ex=", e);
					// handler.onFinished(PacketHelper.toPBReturn(pack, new
					// SendFailedBody("消息转换失败：" + e.getMessage(), null)));
					Message retmsg = resultToErrorPacket("I39999", "系统处理异常", pbname);
					handler.onFinished(PacketHelper.toPBReturn(pack, retmsg));
				} finally {
					currentBuilder.set(null);
				}

			}

		}
	}

	public Message postJsonMessage(FramePacket pack, String requestBody, String pbname) throws ClientProtocolException, IOException {
		String path = bmap.getEURL(pbname);
		String jsonStr = requestor.post(pack, requestBody, backendurl + path);
		// String jsonStr =
		// requestor.post(pack,requestBody,"http://172.16.28.85:8080"+path);
		// 报文格式整理
		if (jsonStr.startsWith("{\"errorCode\":")) {
			jsonStr = jsonStr.replaceAll("error", "return");
		} else if (!pbname.equals("PBIFE_login")) {
			int zjidx = jsonStr.indexOf("\"zjsWebResponse\":");
			if (zjidx > 0 && zjidx < 10) {
				int startidx = jsonStr.indexOf(":") + 1;
				int endidx = jsonStr.lastIndexOf("}");
				if (startidx < endidx) {
					jsonStr = jsonStr.substring(startidx, endidx);
				} else {
					return resultToErrorPacket("I49999", "系统服务接口异常", pbname);
				}
			}
		}
		// 2. json,转换成PBMessage再发到客户端
		Builder retbuilder = (Builder) bmap.getResBuilder(pbname);

		JsonPBUtil.json2PB(jsonStr.getBytes("UTF-8"), retbuilder);
		// try{
		bmap.postProcess(retbuilder, pbname);
		cfgProc.postDO(retbuilder, pbname);

		Message retmsg = retbuilder.build();

		log.debug("posProc_result=" + retmsg);
		return retmsg;
		// }catch(Exception e){
		// handler.onFinished(PacketHelper.toPBReturn(pack, new
		// SendFailedBody("消息后置处理："+e.getMessage(), null)));
		// }
	}

	@Override
	public Builder<?> getPBBuilder() {
		return currentBuilder.get();
	}
}