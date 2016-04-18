package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 获取个人风险等级,客户信息,RiskAssessmentController,POST,JSON,/ife/riskassessment/queryUserRiskLevel.html@onight.mgame.utils.PBInfo(name = "PBIFE_riskassessment_queryUserRiskLevel", path = "/ife/riskassessment/queryUserRiskLevel.html") 
public class IF_获取个人风险等级 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		 @PBFields(name = ",风险等级,String,不校验,是,")
		String riskLevel;//  ,风险等级,String,不校验,是,
		 @PBFields(name = ",风险测评过期日期,String,不校验,是,yyyy-MM-dd")
		String riskExpiredDate;//  ,风险测评过期日期,String,不校验,是,yyyy-MM-dd
		 String tfw__reserved;//保留字段 

	}

}
