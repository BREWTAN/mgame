package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 上传用户头像,客户信息,UserHeaderController,POST,JSON,/ife/userheader/uploadExec.html@onight.mgame.utils.PBInfo(name = "PBIFE_userheader_uploadExec", path = "/ife/userheader/uploadExec.html") 
public class IF_上传用户头像 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String imageFile;//  ,文件名,MultipartFile,,否,
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
