package onight.act.scala.persist

import onight.async.mysql.commons.SimpleDAO
import scala.concurrent.ExecutionContext
import java.util.concurrent.Executors
import scala.reflect.classTag
import java.math.BigDecimal

object ACTDAOs {
  implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(10))

  case class KOActInfo(val ACT_NO: String = null, //账户号
    val ACT_NAME: String = null, //账户名称
    val CUST_ID: String = null, //客户号
    val MCHNT_ID: String = null, //所属商户号
    val CHANNEL_ID: String = null, //所属渠道号
    val ACT_TYPE: String = null, //账户类型
    val MNY_SMB: String = null, //货币符号
    val CATALOG: String = null, //机构类型
    val ACT_CUR_BAL: Option[BigDecimal] = null, //余额
    val ACT_STAT: String = null,//状态
    val MODIFY_ID: String = null, //更新人
    val CREATE_TIME: String = null, //创建时间
    val UPDATE_TIME: String = null, //更新时间
    val MEMO: String = null //备注
    )

  object actInfoDAO extends SimpleDAO[KOActInfo] {
    val ttag = classTag[KOActInfo];
    val tablename = "T_ACT_INFO";
    val keyname = "ACT_NO"
  }

}
