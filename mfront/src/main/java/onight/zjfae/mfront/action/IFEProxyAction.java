package onight.zjfae.mfront.action;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.NActorProvider;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.CompleteHandler;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.otransio.api.beans.SendFailedBody;
import onight.tfw.otransio.api.beans.UnknowCMDBody;
import onight.tfw.outils.bean.JsonPBUtil;
import onight.tfw.outils.serialize.ISerializer;
import onight.tfw.outils.serialize.SerializerFactory;
import onight.zjfae.mfront.filter.SSOPacketHelper;
import onight.zjfae.mfront.service.IFEBeanMapping;

import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;

@iPojoBean
@NActorProvider
// @Provides(specifications = { IActor.class, PSenderService.class })
@Slf4j
@Data
public class IFEProxyAction extends MobileModuleStarter<Message> {

	protected HttpRequestor requestor = new HttpRequestor();

	SSOPacketHelper filter = new SSOPacketHelper();

	IFEBeanMapping bmap = new IFEBeanMapping();
	
	@Override
	public String[] getCmds() {
		requestor.reload();
		requestor.changeMaxTotal(props.get("pxy.http.conn.max", 10));
		bmap.init();
		return new String[] { "IFE" };
	}

	// http://localhost:8081/mzj/pbife.do?fh=VREGMZJ000000J00&bd={"pageIndex":"13800138000","image_code":"12334554"}&pbname=PBIFE_badasset_queryProjectReveal
	//	// http://localhost:8081/mzj/pbife.do?fh=VREGMZJ000000P00&pbname=PBIFE_badasset_queryProjectReveal

	protected ISerializer jsons = SerializerFactory.getSerializer(SerializerFactory.SERIALIZER_JSON);
	

	ThreadLocal<Builder> currentBuilder=new ThreadLocal<Builder>();
	
	@Override
	public void onPBPacket(final FramePacket pack, Message nubo, final CompleteHandler handler) {
		// log.debug("pack:" + pack);
		
		String pbname = pack.getExtStrProp("pbname");
		if (StringUtils.isBlank(pbname))  {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("pbname 不能为空", pack)));
		} else {
			Builder builder = bmap.getReqBuilder(pbname);
			if (builder == null) {
				handler.onFinished(PacketHelper.toPBReturn(pack, new UnknowCMDBody("未找到的命令:" + pbname, pack)));
			} else {
				try {
					currentBuilder.set(builder);
					JsonPBUtil.json2PB(pack.getBody(), builder);
					//builder.build();// 获取到的是一个PBmessage
					
					Message msg = getPBBody(pack);//
					//1.preprocess.== validate..前处理逻辑
					bmap.preProcess(msg, pbname);
					
					log.debug("msg=={}",msg);
					String str = new FJsonPBFormat().printToString(msg);
					log.debug("proxy:{}", str);

					String path = bmap.getEURL(pbname);
				
					log.debug("name:"+pbname+",url="+path);
					
					pack.setBody(str.getBytes("UTF-8"));
					// TODO: 1. 把他封装成json,并且发到客户端E/工程里面去
					String requestBody = jsons.serialize(pack.getBody()).toString();
					String body = requestor.post(requestBody,"http://10.18.13.104"+path);
					
					// TODO: 2. json,转换成PBMessage再发到客户端
					Builder retbuilder = (Builder) bmap.getResBuilder(pbname);
					JsonPBUtil.json2PB(body.getBytes("UTF-8"), retbuilder);
					
					PacketHelper.toPBReturn(pack, retbuilder.build());
					Message msg1 = getPBBody(pack);
					
					//postprocess 后处理逻辑
					bmap.postProcess(msg1, pbname);
					String str1 = new FJsonPBFormat().printToString(msg1);
				    retbuilder = (Builder) bmap.getResBuilder(pbname);
					JsonPBUtil.json2PB(str1.getBytes("UTF-8"), retbuilder);

//					
					handler.onFinished(PacketHelper.toPBReturn(pack, retbuilder.build()));
					

					
				} catch (Exception e) {
					// TODO： 转换失败时
					handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("消息转换失败："+e.getMessage(), null)));
				}finally{
					currentBuilder.set(null);
				}
				
				
				
				

			}
			
		}
	}


	@Override
	public Builder getPBBuilder() {
		return currentBuilder.get();
	}
	

	

}
