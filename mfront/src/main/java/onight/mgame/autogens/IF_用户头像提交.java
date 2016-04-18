package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 用户头像提交,客户信息,UserHeaderController,POST,JSON,/ife/userheader/setUserHeader.html@onight.mgame.utils.PBInfo(name = "PBIFE_userheader_setUserHeader", path = "/ife/userheader/setUserHeader.html") 
public class IF_用户头像提交 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String x;//  ,图片x坐标点,String,不校验,否,
		String y;//  ,图片y坐标点,String,不校验,否,
		String w;//  ,图片宽,String,不校验,否,
		String h;//  ,图片长,String,不校验,否,
		String width;//  ,原图像宽度,String,不校验,否,
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
