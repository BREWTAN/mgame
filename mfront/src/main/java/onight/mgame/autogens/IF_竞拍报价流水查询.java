package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 竞拍报价流水查询,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadOfferSerialWrap.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadOfferSerialWrap", path = "/ife/badasset/loadOfferSerialWrap.html") 
public class IF_竞拍报价流水查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",项目编号,String,不校验,否,")
		String projectCode;//  ,项目编号,String,不校验,否,
		 @PBFields(name = ",轮次,String,不校验,是,")
		String roundIndex;//  ,轮次,String,不校验,是,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class AList {

		 @PBFields(name = ",竞买人编号,String,不校验,否,")
				String brandCode;//  ,竞买人编号,String,不校验,否,
		 @PBFields(name = ",报价,String,不校验,否,")
				String myPay;//  ,报价,String,不校验,否,
		 @PBFields(name = ",报价时间,String,不校验,否,")
				String payTime;//  ,报价时间,String,不校验,否,
}

		 AList list;// 
 
		 String tfw__reserved;//保留字段 

	}

}
