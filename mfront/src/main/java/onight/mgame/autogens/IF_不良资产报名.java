package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 不良资产报名,产品相关,BadAssetController,POST,JSON,/ife/badasset/projectApply.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_projectApply", path = "/ife/badasset/projectApply.html") 
public class IF_不良资产报名 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",项目编号,String,不校验,否,")
		String projectCode;//  ,项目编号,String,不校验,否,
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
