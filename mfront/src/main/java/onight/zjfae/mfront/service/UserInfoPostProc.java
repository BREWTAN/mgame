package onight.zjfae.mfront.service;

import com.google.protobuf.Message;

import onight.tfw.outils.bean.JsonPBUtil;
import onight.zjfae.afront.gens.PBIFEUserbaseinfoGetBasicInfo.PBIFE_userbaseinfo_getBasicInfo;
import onight.zjfae.afront.gens.PBIFEUserbaseinfoGetBasicInfo.PBIFE_userbaseinfo_getBasicInfo.Builder;
import onight.zjfae.mfront.service.IFEBeanMapping.PostProc;

public class UserInfoPostProc implements PostProc {

	@Override
	public void postDO(Message message, String pbname) {
	
		Builder userInfo =(Builder)message.toBuilder();
		if(userInfo.getCertificateCode()==""){
			userInfo.setCertificateCode("99");
		}
		message=userInfo.build();

	}
	public static void main(String[] args){
		UserInfoPostProc userInfo= new UserInfoPostProc();
		String jsonstr = "{\"mobile\":\"13800138000\",\"name\":\"12334554\"}";
		Builder builder = PBIFE_userbaseinfo_getBasicInfo.getDefaultInstance().newBuilderForType();
		
		JsonPBUtil.json2PB(jsonstr.getBytes(), builder);
		
		
		Message msg = builder.build();// 获取到的是一个PBmessage
		
		userInfo.postDO(msg,jsonstr);
	}

}
