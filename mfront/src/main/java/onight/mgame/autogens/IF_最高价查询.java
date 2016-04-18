package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 最高价查询,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadCurrentMaxOfferPrice.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadCurrentMaxOfferPrice", path = "/ife/badasset/loadCurrentMaxOfferPrice.html") 
public class IF_最高价查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String projectCode;//  ,项目编号,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",当前最高价,String,不校验,否,")
		String offerMaxPrice;//  ,当前最高价,String,不校验,否,
		 String tfw__reserved;//保留字段 

	}

}
