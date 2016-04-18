package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 用户头像读取,客户信息,UserHeaderController,POST,文件流,/ife/userheader/viewUserHeader.html@onight.mgame.utils.PBInfo(name = "PBIFE_userheader_viewUserHeader", path = "/ife/userheader/viewUserHeader.html") 
public class IF_用户头像读取 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String type;//  ,图片类型,String,不校验,是,tem-头像上传预览时非空
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
