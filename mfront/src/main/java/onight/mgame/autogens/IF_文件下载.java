package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;
import onight.mgame.utils.PBFields;
import lombok.NoArgsConstructor;

// 文件下载,产品相关,PrdQueryController,POST,文件流,/ife/prdquery/prdDownloadProcuctAttachment.html@onight.mgame.utils.PBInfo(name = "PBIFE_prdquery_prdDownloadProcuctAttachment", path = "/ife/prdquery/prdDownloadProcuctAttachment.html") 
public class IF_文件下载 {
	// =======REQuest==============

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {

		String filePath;//  ,,String,,否,
		String fileName;//  ,,String,,否,
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
