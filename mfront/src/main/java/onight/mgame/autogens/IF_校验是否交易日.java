package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBFields;

@onight.mgame.utils.PBInfo(name = "PBIFE_systemcheck_checkIsTradeDay", path = "/ife/systemcheck/checkIsTradeDay.html")
public class IF_校验是否交易日 {
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
