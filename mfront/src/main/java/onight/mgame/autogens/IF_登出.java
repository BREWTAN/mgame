package onight.mgame.autogens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onight.mgame.utils.PBFields;


//登出,servlet,POST,JSON,/front/logout.html
@onight.mgame.utils.PBInfo(name = "PBIFE_logout", path = "/ife/logout.html")
public class IF_登出 {
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
        @PBFields(name = ",returnCode,")
        String returnCode;//  ,returnCode,String,不校验,是,
        @PBFields(name = ",returnMsg,")
        String returnMsg;//  ,returnMsg,String,不校验,是,
        String tfw__reserved;//保留字段
    }
}