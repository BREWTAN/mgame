package mfront.test;

import onight.tfw.outils.bean.JsonPBUtil;
import onight.zjfae.mfront.Mobilezj.PEReg;
import onight.zjfae.mfront.action.FJsonPBFormat;

import com.google.protobuf.Message;
import com.google.protobuf.Message.Builder;

public class TestMSG {
	public static void main(String[] args) {
		String jsonstr = "{\"mobile\":\"13800138000\",\"image_code\":\"12334554\"}";
		try {
			Builder builder = PEReg.getDefaultInstance().newBuilderForType();
			
			JsonPBUtil.json2PB(jsonstr.getBytes(), builder);
			
			
			Message msg = builder.build();// 获取到的是一个PBmessage
			
			
			String str = new FJsonPBFormat().printToString(msg);
			System.out.println("str="+str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
