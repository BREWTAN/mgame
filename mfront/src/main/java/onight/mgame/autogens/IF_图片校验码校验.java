package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 图片校验码校验,公共,ImageValidateCodeController,POST,JSON,/ife/imagevalidatecode/checkImageValidateCode.html@onight.mgame.utils.PBInfo(name = "PBIFE_imagevalidatecode_checkImageValidateCode", path = "/ife/imagevalidatecode/checkImageValidateCode.html") 
public class IF_图片校验码校验 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String imageCode;//  ,验证码,String,5,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 String tfw__reserved;//保留字段 

	}

}
