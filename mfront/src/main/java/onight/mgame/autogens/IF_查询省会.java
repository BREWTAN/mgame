package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

// 查询省会,公共,ChinaCityController,POST,JSON,/ife/chinaCity/loadProvince.html@onight.mgame.utils.PBInfo(name = "PBIFE_chinaCity_loadProvince", path = "/ife/chinaCity/loadProvince.html") 
public class IF_查询省会 {
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
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class TmbprovList {

				String pno;//  ,省编号,String,不校验,是,
				String pname;//  ,省名称,String,不校验,是,
}

		 List<TmbprovList>tmbprovList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
