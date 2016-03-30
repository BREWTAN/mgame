package onight.zjfae.mfront.action;

import java.io.UnsupportedEncodingException;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.NActorProvider;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.CompleteHandler;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.otransio.api.beans.SendFailedBody;
import onight.tfw.outils.serialize.ISerializer;
import onight.tfw.outils.serialize.SerializerFactory;
import onight.zjfae.sfront.Setting.PBModule;
import onight.zjfae.sfront.Setting.PBSetting;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;

@iPojoBean
@NActorProvider
// @Provides(specifications = { IActor.class, PSenderService.class })
@Slf4j
@Data
public class ChangeSettingAction extends MobileModuleStarter<Message> {

	@Override
	public String[] getCmds() {
		return new String[] { "SET" };
	}

	
	@Override
	public String getModule() {
		return PBModule.FNT.name();
		
	}
	// http://localhost:8081/fnt/pbset.do?fh=VSETFNT000000J00&bd={"gcmd":"setfnt","jsondata":"abbcc"}

	protected ISerializer jsons = SerializerFactory.getSerializer(SerializerFactory.SERIALIZER_JSON);

	static ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);

	}
	@Override
	public void onPBPacket(final FramePacket pack, Message nubo, final CompleteHandler handler) {
		 PBSetting setting = (PBSetting)this.getPBBody(pack);
		 log.debug("setting= {}",setting);
		 Base64 base64=new Base64();
		 try {
			String jsonstr=new String(base64.decode(setting.getJsondata()),"UTF-8");
			log.debug("jsonstr= {}",jsonstr);
			mapper.readTree(jsonstr);
			FakeMapping.gcmd2Json.put(setting.getGcmd(), jsonstr);
			handler.onFinished(PacketHelper.toPBReturn(pack, PBSetting.newBuilder().setJsondata(jsonstr).setGcmd(setting.getGcmd()).build()));
			
		} catch (Exception e) {
			e.printStackTrace();
			handler.onFinished(PacketHelper.toPBReturn(pack, new SendFailedBody("JSON格式错误:"+e.getMessage(),null)));
		}
		 
	}

	@Override
	public Builder getPBBuilder() {
		return PBSetting.newBuilder();
	}

}
