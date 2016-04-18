package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 查询城市,公共,ChinaCityController,POST,JSON,/ife/chinaCity/loadCity.html@onight.mgame.utils.PBInfo(name = "PBIFE_chinaCity_loadCity", path = "/ife/chinaCity/loadCity.html") 
public class IF_查询城市 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String pno;//  ,省会编号,String,不校验,否,
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
	public static class TmbcityList {

		 @PBFields(name = ",城市编号,String,不校验,是,")
				String cno;//  ,城市编号,String,不校验,是,
		 @PBFields(name = ",城市名称,String,不校验,是,")
				String cname;//  ,城市名称,String,不校验,是,
		 @PBFields(name = ",所属省编号,String,不校验,是,")
				String pno;//  ,所属省编号,String,不校验,是,
		 @PBFields(name = ",城市区号,String,不校验,是,")
				String ctelno;//  ,城市区号,String,不校验,是,
}

		 List<TmbcityList>tmbcityList;// 
 
		 String tfw__reserved;//保留字段 

	}

}
