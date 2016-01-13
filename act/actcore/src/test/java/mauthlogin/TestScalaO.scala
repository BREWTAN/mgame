package mauthlogin

import java.lang.reflect.Field
import java.sql.Timestamp
import scala.collection.JavaConversions.mapAsScalaMap
import onight.act.ordbgens.act.pbo.Actgens.PBTActInfo
import java.lang.reflect.Constructor
import scala.reflect.classTag
import scala.collection.mutable.HashMap
import com.google.protobuf.Message
import onight.act.ordbgens.act.pbo.Actgens.PBTActInfoOrBuilder

object TestScalaO {

  def instanceFromMap[T](row: HashMap[String, Object])(fields: Array[Field], constructor: Constructor[_]) = {
    val map = fields.map({ field =>
      val v = row.get(field.getName())
      println("FF:" + field.getName() + "(" + field.getType() + ")" + "(" + field.getGenericType() + ")" + ",=>" + v + ",type=" + v.getClass + ",v=" + v)
      if (v == null) {
        null
      } else {
        val cv = v match {
          case s: Some[_] =>
            val clazz = s.get.getClass()
            val sv = {
              if (field.getGenericType().eq(classOf[java.lang.String])) {
                s.get.asInstanceOf[String]
              } else if (field.getGenericType().eq(classOf[java.sql.Timestamp])) {
                new Timestamp(s.get.asInstanceOf[Long])
              } else if (field.getType == classOf[Option[_]]) {
                Option(s.get)
              } else {
                s.get.asInstanceOf[String]
              }
            }
            //            s.get.asInstanceOf[String]
            sv
          case None => null
        }
        cv
      }
    })
    constructor.newInstance(map.toArray[AnyRef]: _*).asInstanceOf[T]
  }

  case class AKOTActInfo(
    val ACT_NO: String = null,
    val ACT_NAME: String = null,
    val CUST_ID: String = null,
    val MCHNT_ID: String = null,
    val ACT_TYPE: String = null,
    val MNY_SMB: String = null,
    val CHANNEL_ID: String = null,
    val CATALOG: String = null,
    val ACT_YINIT_BAL: Option[Double] = null,
    val ACT_DINIT_BAL: Option[Double] = null,
    val ACT_CUR_BAL: Option[Double] = null,
    val ACT_STAT: Option[Double] = null,
    val ACT_MAXOD_AMT: Option[Double] = null,
    val ACT_CTRL_BAL: Option[Double] = null,
    val ACT_BAL_WARN_FLAG: String = null,
    val CREATE_TIME: Timestamp = null,
    val UPDATE_TIME: Timestamp = null,
    val MODIFY_ID: String = null,
    val MEMO: String = null,
    val __END: String = null)

  def main(args: Array[String]): Unit = {
    val act = PBTActInfo.newBuilder().setActNo("actonofsfs").setCustId("12322") //
      .setActCurBal(100.2).setCreateTime(System.currentTimeMillis()).build();

    val msg = PBTActInfo.newBuilder().getAllFields;

    PBTActInfo.newBuilder().getAllFields
    val it = act.getAllFields.entrySet().iterator();
    val vmap = act.getAllFields.map({ kv =>
      println((kv._1.getName.toUpperCase(), kv._2))
      (kv._1.getName.toUpperCase(), kv._2)
      //      println(_)s
    })
    println(vmap)
    val constructor = classTag[AKOTActInfo].runtimeClass.getConstructors()(0);
    val fields = classTag[AKOTActInfo].runtimeClass.getDeclaredFields().filter({ field =>
      field.setAccessible(true); true
    });
    println(instanceFromMap[AKOTActInfo](vmap.asInstanceOf[HashMap[String, Object]])(fields, constructor))
    //    println(vmap.asInstanceOf[AKOTActInfo])
    //   
    //    
    //    constructor.newInstance(vmap.toArray[])
    ////    .newInstance(vmap.toArray[AnyRef]: _*)
    //    println("ko=="+ko)
  }
}