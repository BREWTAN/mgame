package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 我的申请记录（受让申请）,产品相关,BadAssetController,POST,JSON,/ife/badasset/loadMyBadAssetApply.html@onight.mgame.utils.PBInfo(name = "PBIFE_badasset_loadMyBadAssetApply", path = "/ife/badasset/loadMyBadAssetApply.html") 
public class IF_我的申请记录_受让申请_ {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String pageIndex;//  ,当前页,String,不校验,是,默认1
		String pageSize;//  ,页大小,String,不校验,是,默认10
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
	public static class PageInfo {

		 @PBFields(name = ",页大小,String,不校验,是,")
				String pageSize;//  ,页大小,String,不校验,是,
		 @PBFields(name = ",当前页,String,不校验,是,")
				String pageIndex;//  ,当前页,String,不校验,是,
		 @PBFields(name = ",总页数,String,不校验,是,")
				String pageCount;//  ,总页数,String,不校验,是,
		 @PBFields(name = ",总条数,String,不校验,是,")
				String totalCount;//  ,总条数,String,不校验,是,
}

		 @PBFields(name = ",申请记录列表,List,不校验,是,")
PageInfo pageInfo;// 
 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TaBadProjectApplyWrapList {

		 @PBFields(name = ",项目编号,String,不校验,是,")
				String projectCode;//  ,项目编号,String,不校验,是,
		 @PBFields(name = ",项目名称,String,不校验,是,")
				String projectName;//  ,项目名称,String,不校验,是,
		 @PBFields(name = ",项目状态,String,不校验,是,")
				String projectStatus;//  ,项目状态,String,不校验,是,
		 @PBFields(name = ",项目状态-名称,String,不校验,是,")
				String projectStatusName;//  ,项目状态-名称,String,不校验,是,
		 @PBFields(name = ",挂牌价,String,不校验,是,")
				String quotationPrice;//  ,挂牌价,String,不校验,是,
		 @PBFields(name = ",保证金金额,String,不校验,是,")
				String amount;//  ,保证金金额,String,不校验,是,
		 @PBFields(name = ",保证金截至时间,String,不校验,是,")
				String depositDeadline;//  ,保证金截至时间,String,不校验,是,
		 @PBFields(name = ",保证金缴纳状态,String,不校验,是,")
				String payStatus;//  ,保证金缴纳状态,String,不校验,是,
		 @PBFields(name = ",保证金缴纳状态-名称,String,不校验,是,")
				String payStatusName;//  ,保证金缴纳状态-名称,String,不校验,是,
		 @PBFields(name = ",是否需要缴纳保证金,String,不校验,是,1-是，0-否")
				String need2Pay;//  ,是否需要缴纳保证金,String,不校验,是,1-是，0-否
		 @PBFields(name = ",保证金缴纳方式,String,不校验,是,")
				String marginPayFrom;//  ,保证金缴纳方式,String,不校验,是,
		 @PBFields(name = ",保证金缴纳方式-名称,String,不校验,是,")
				String marginPayFromName;//  ,保证金缴纳方式-名称,String,不校验,是,
		 @PBFields(name = ",审核状态,String,不校验,是,")
				String auditStatus;//  ,审核状态,String,不校验,是,
		 @PBFields(name = ",审核状态-名称,String,不校验,是,")
				String auditStatusName;//  ,审核状态-名称,String,不校验,是,
		 @PBFields(name = ",是否已过挂牌时间,String,不校验,是,1-是，0-否")
				String isOutOfPublicTime;//  ,是否已过挂牌时间,String,不校验,是,1-是，0-否
		 @PBFields(name = ",是否出局,String,不校验,是,1-是，0-否")
				String isOutFlag;//  ,是否出局,String,不校验,是,1-是，0-否
}

		 List<TaBadProjectApplyWrapList>taBadProjectApplyWrapList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
