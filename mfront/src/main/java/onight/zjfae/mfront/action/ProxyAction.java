package onight.zjfae.mfront.action;

import java.util.HashMap;

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
import onight.zjfae.mfront.Mobilezj.PECommand;
import onight.zjfae.mfront.Mobilezj.PEReg;
import onight.zjfae.mfront.Mobilezj.PERetReg;
import onight.zjfae.mfront.filter.SSOPacketHelper;
import onight.zjfae.mfront.service.HttpRequestor;

import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;

@iPojoBean
@NActorProvider
// @Provides(specifications = { IActor.class, PSenderService.class })
@Slf4j
@Data
public class ProxyAction extends MobileModuleStarter<Message> {

	protected HttpRequestor requestor = new HttpRequestor();

	SSOPacketHelper filter = new SSOPacketHelper();

	String proxyBaseUrl = "http://127.0.0.1/";

	
	HashMap<String, Message> cmd2PBBean = new HashMap<>();
	HashMap<String, Message> cmd2PBRetBean = new HashMap<>();

	@Override
	public String[] getCmds() {
		requestor.reload();
		requestor.changeMaxTotal(props.get("pxy.http.conn.max", 10));
		proxyBaseUrl = props.get("pxy.http.conn.baseurl", "http://127.0.0.1/");
		
		cmd2PBBean.put(PECommand.REG.name(),PEReg.getDefaultInstance());
		cmd2PBRetBean.put(PECommand.REG.name(), PERetReg.getDefaultInstance());

		return new String[] { "PXY" };
	}

	// http://localhost:8081/mzj/pbpxy.do?fh=VREGMZJ000000J00&bd={"mobile":"13800138000","image_code":"12334554"}
	protected ISerializer jsons = SerializerFactory.getSerializer(SerializerFactory.SERIALIZER_JSON);

	ThreadLocal<Builder> currentBuilder=new ThreadLocal<Builder>();
	
	@Override
	public void onPBPacket(final FramePacket pack, Message nubo, final CompleteHandler handler) {
		// log.debug("pack:" + pack);
		
		String cmd = pack.getFixHead().getCmd();//pack.getExtStrProp("gcmd");
		if (StringUtils.isBlank(cmd) || cmd.length() != 3) {
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("gcmd 不能为空", pack)));
		} else {
			Builder builder = (Builder)cmd2PBBean.get(cmd).newBuilderForType();
			if (builder == null) {
				handler.onFinished(PacketHelper.toPBReturn(pack, new UnknowCMDBody("未找到的命令:" + cmd, pack)));
			} else {
				try {
					currentBuilder.set(builder);
//					JsonPBUtil.json2PB(pack.getBody(), builder);
					//builder.build();// 获取到的是一个PBmessage
					
					Message msg = getPBBody(pack);//
					log.debug("msg=={}",msg);
					String str = new FJsonPBFormat().printToString(msg);
					log.debug("proxy:{}", str);
					
					
//					handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("消息转换成功", pack)));
					
					// TODO: 1. 把他封装成json,并且发到客户端E/工程里面去
					// String body = requestor.post(jsons.serialize(pack.getBody()),
					// proxyBaseUrl);
					
					// TODO: 2. json,转换成PBMessage再发到客户端
					// String body = requestor.post(jsons.serialize(pack.getBody()),
					// proxyBaseUrl);
					Builder retbuilder = (Builder) cmd2PBRetBean.get(cmd).newBuilderForType();
					str = FakeMapping.gcmd2Json.get(cmd+"MZJ");
					JsonPBUtil.json2PB(str.getBytes(), retbuilder);
					
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
