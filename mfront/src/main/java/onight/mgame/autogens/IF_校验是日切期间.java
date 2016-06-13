package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@onight.mgame.utils.PBInfo(name = "PBIFE_systemcheck_checkIsDayCut", path = "/ife/systemcheck/checkIsDayCut.html")
public class IF_校验是日切期间 {
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
