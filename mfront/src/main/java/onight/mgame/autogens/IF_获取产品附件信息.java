package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 获取产品附件信息,产品相关,PrdQueryController,POST,JSON,/ife/prdquery/prdQueryProductAttachment.html@onight.mgame.utils.PBInfo(name = "PBIFE_prdquery_prdQueryProductAttachment", path = "/ife/prdquery/prdQueryProductAttachment.html") 
public class IF_获取产品附件信息 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 @PBFields(name = ",产品编号,String,不校验,否,")
		String productCode;//  ,产品编号,String,不校验,否,
		 @PBFields(name = ",可见标志,String,不校验,否,1 详情  2认购 3 挂单  4 买卖 5 生成支付宝合同文件")
		String visibleFlag;//  ,可见标志,String,不校验,否,1 详情  2认购 3 挂单  4 买卖 5 生成支付宝合同文件
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
	public static class TaProductAttachmentList {

		 @PBFields(name = ",附件编号,String,不校验,是,")
				String id;//  ,附件编号,String,不校验,是,
		 @PBFields(name = ",附件类型,String,不校验,是,")
				String type;//  ,附件类型,String,不校验,是,
		 @PBFields(name = ",上传路径,String,不校验,是,")
				String uploadDir;//  ,上传路径,String,不校验,是,
		 @PBFields(name = ",上传时间,String,不校验,是,")
				String publishTime;//  ,上传时间,String,不校验,是,
		 @PBFields(name = ",RECEIVE_RANGE,String,不校验,是,")
				String receiveRange;//  ,RECEIVE_RANGE,String,不校验,是,
		 @PBFields(name = ",上传人,String,不校验,是,")
				String publisher;//  ,上传人,String,不校验,是,
		 @PBFields(name = ",产品数据库编号,String,不校验,是,")
				String productId;//  ,产品数据库编号,String,不校验,是,
		 @PBFields(name = ",标题,String,不校验,是,")
				String title;//  ,标题,String,不校验,是,
		 @PBFields(name = ",创建时间,String,不校验,是,")
				String gmtCreate;//  ,创建时间,String,不校验,是,
		 @PBFields(name = ",修改时间,String,不校验,是,")
				String gmtModify;//  ,修改时间,String,不校验,是,
		 @PBFields(name = ",产品代码,String,不校验,是,")
				String productCode;//  ,产品代码,String,不校验,是,
		 @PBFields(name = ",是否可见,String,不校验,是,")
				String visibleFlag;//  ,是否可见,String,不校验,是,
		 @PBFields(name = ",备注,String,不校验,是,")
				String memo;//  ,备注,String,不校验,是,
}

		 List<TaProductAttachmentList>taProductAttachmentList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
