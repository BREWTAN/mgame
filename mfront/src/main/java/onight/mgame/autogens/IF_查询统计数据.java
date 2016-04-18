package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 查询统计数据,公共,StatisticController,POST,JSON,/ife/statistic/queryStatisticData.html@onight.mgame.utils.PBInfo(name = "PBIFE_statistic_queryStatisticData", path = "/ife/statistic/queryStatisticData.html") 
public class IF_查询统计数据 {
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
		 String tfw__reserved;//保留字段 

	}

}
