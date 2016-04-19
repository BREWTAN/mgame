package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 竞拍产品详情查询,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadBiddingInitWrap.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadBiddingInitWrap", path = "/ife/badasset/loadBiddingInitWrap.html") 
public class IF_竞拍产品详情查询 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",,String,,否,")
		String projectCode;//  ,,String,,否,
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
	public static class BiddingInitWrap {

		 @PBFields(name = ",项目编号,String,不校验,否,")
				String projectCode;//  ,项目编号,String,不校验,否,
		 @PBFields(name = ",项目名称,String,不校验,否,")
				String projectName;//  ,项目名称,String,不校验,否,
		 @PBFields(name = ",竞价方式,String,不校验,否,")
				String bayWay;//  ,竞价方式,String,不校验,否,
		 @PBFields(name = ",竞价方式,String,不校验,否,")
				String bayWayName;//  ,竞价方式,String,不校验,否,
		 @PBFields(name = ",起拍价格,String,不校验,否,")
				String startValue;//  ,起拍价格,String,不校验,否,
		 @PBFields(name = ",是否有保留价,String,不校验,否,")
				String ishold;//  ,是否有保留价,String,不校验,否,
		 @PBFields(name = ",参与人数,String,不校验,否,")
				String applyNum;//  ,参与人数,String,不校验,否,
		 @PBFields(name = ",出价幅度,String,不校验,否,")
				String bidRate;//  ,出价幅度,String,不校验,否,
		 @PBFields(name = ",竞拍结束,String,不校验,否,")
				String isBiddingEnd;//  ,竞拍结束,String,不校验,否,
		 @PBFields(name = ",是否报价,String,不校验,否,一次报价和协议报价")
				String hasOffer;//  ,是否报价,String,不校验,否,一次报价和协议报价
		 @PBFields(name = ",倒计时,String,不校验,否,一次报价和协议报价")
				String countDown;//  ,倒计时,String,不校验,否,一次报价和协议报价
		 @PBFields(name = ",竞买人编号,String,不校验,否,一次报价和协议报价")
				String brandCode;//  ,竞买人编号,String,不校验,否,一次报价和协议报价
		 @PBFields(name = ",当前最高价,String,不校验,否,一次报价和协议报价")
				String maxOfferPrice;//  ,当前最高价,String,不校验,否,一次报价和协议报价
}

		 BiddingInitWrap biddingInitWrap;// 
 
		 String tfw__reserved;//保留字段 

	}

}
