package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 我的推荐收入,客户信息,FriendsRecommendController,POST,JSON,/ife/friendsrecommend/userRecommendInfo.html@onight.mgame.utils.PBInfo(name = "PBIFE_friendsrecommend_userRecommendInfo", path = "/ife/friendsrecommend/userRecommendInfo.html") 
public class IF_我的推荐收入 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String startDate;//  ,开始日期,String,不校验,否,
		String endDate;//  ,结束日期,String,不校验,否,
		 String tfw__reserved;//保留字段

	}

	// ======RESponse==========

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		String mobile;//  ,手机号,String,不校验,是,
		String registNum;//  ,注册奖励,String,不校验,是,
		String bindCardNum;//  ,绑定奖励,String,不校验,是,
		String investNum;//  ,投资奖励,String,不校验,是,
		 String tfw__reserved;//保留字段 

	}

}
