package onight.act.scala.entity

import org.apache.commons.codec.binary.StringUtils
import java.util.HashMap
import scala.beans.BeanProperty

class AccountInfo {
  @BeanProperty var actNo: String = null //1;    //账户号
  @BeanProperty var actName: String = null //2;  //账户名称
  @BeanProperty var actParent: String = null //3;  //上级账户信息
  @BeanProperty var actRoot: String = null //4;  //主账户信息
  @BeanProperty var custId: String = null //10;//客户号
  @BeanProperty var mchntId: String = null //20;//所属商户号
  @BeanProperty var channelId: String = null //21;//所属渠道号
  @BeanProperty var actType: String = null //30;//账户类型
  @BeanProperty var mnySmb: String = null //40;//货币符号
  @BeanProperty var catalog: String = null //50;//机构类型
  @BeanProperty var balance: Long = 0 //51;//余额
  @BeanProperty var point: Int =  5//52;//浮点数位数,默认保留5位
  @BeanProperty var modifyId: String = null //60;//更新人
  @BeanProperty var createTime: String = null //70;//创建时间
  @BeanProperty var updateTime: String = null //80;//更新时间
  @BeanProperty var memo: String = null //90;//备注
}

object AccountInfo {

}
