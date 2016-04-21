package onight.mgame.autogens;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBFields;

// 风险测评获取问题,客户信息,RiskAssessmentController,POST,JSON,/ife/riskassessment/queryRiskAssessmentQuestion.html
@onight.mgame.utils.PBInfo(name = "PBIFE_riskassessment_queryRiskAssessmentQuestion", path = "/ife/riskassessment/queryRiskAssessmentQuestion.html")
public class IF_风险测评获取问题_Fix {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String tfw__reserved;// 保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		@Data
		@AllArgsConstructor
		@NoArgsConstructor
		public static class TcAssessmentT {

			@PBFields(name = ",模板编号,String,不校验,是,")
			String id;// ,模板编号,String,不校验,是,
			@PBFields(name = ",模板名称,String,不校验,是,")
			String templateName;// ,模板名称,String,不校验,是,
			@PBFields(name = ",模板类型,String,不校验,是,")
			String templateType;// ,模板类型,String,不校验,是,
			@PBFields(name = ",风险测评问题列表,List,不校验,是,")
			List<TcAssessmentQList> tcAssessmentQList;// ,风险测评问题列表,List,不校验,是,

			@Data
			@AllArgsConstructor
			@NoArgsConstructor
			public static class TcAssessmentQList {

				@PBFields(name = ",评估表问题PK,String,不校验,是,")
				String id;// ,评估表问题PK,String,不校验,是,
				@PBFields(name = ",评估问题,String,不校验,是,")
				String question;// ,评估问题,String,不校验,是,
				@PBFields(name = ",评估问题权重,String,不校验,是,")
				String weight;// ,评估问题权重,String,不校验,是,
				@PBFields(name = ",CheckBox RadioBox Text,String,不校验,是,")
				String type;// ,CheckBox\RadioBox\Text,String,不校验,是,
				@PBFields(name = ",答题系统模板PK,String,不校验,是,")
				String tId;// ,答题系统模板PK,String,不校验,是,
				@PBFields(name = ",状态,String,不校验,是,VALID(有效)  INVALID(失效)")
				String status;// ,状态,String,不校验,是,VALID(有效) INVALID(失效)
			}

			@PBFields(name = ",答案列表,List,不校验,是,")
			List<TcAssessmentAList> tcAssessmentAList;// ,答案列表,List,不校验,是,

			@Data
			@AllArgsConstructor
			@NoArgsConstructor
			public static class TcAssessmentAList {

				@PBFields(name = ",评估表答案PK,String,不校验,是,")
				String id;// ,评估表答案PK,String,不校验,是,
				@PBFields(name = ",评估表问题PK,String,不校验,是,")
				String qId;// ,评估表问题PK,String,不校验,是,
				@PBFields(name = ",评估问题答案,String,不校验,是,")
				String answer;// ,评估问题答案,String,不校验,是,
				@PBFields(name = ",评估问题答案分数,String,不校验,是,")
				String point;// ,评估问题答案分数,String,不校验,是,
				@PBFields(name = ",评估问题答案权重(A-Z),String,不校验,是,")
				String weight;// ,评估问题答案权重(A-Z),String,不校验,是,
			}
		}

		TcAssessmentT tcAssessmentT;//

		String tfw__reserved;// 保留字段

	}

}
