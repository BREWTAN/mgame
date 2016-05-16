package starstart.cgw.scala.service

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import scala.collection.JavaConversions.asScalaBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.Promise
import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.DeserializationConfig.Feature
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.map.SerializationConfig
import org.codehaus.jackson.node.ArrayNode
import org.codehaus.jackson.node.MissingNode
import org.codehaus.jackson.node.ObjectNode
import com.google.protobuf.Message
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.LService
import onight.scala.commons.PBUtils
import onight.scala.commons.SessionModules
import onight.tfw.async.CallBack
import onight.tfw.async.CompleteHandler
import onight.tfw.ntrans.api.annotation.ActorRequire
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.FramePacket
import onight.zjfae.afront.Amobilezj.PBFramePacket
import onight.zjfae.afront.Amobilezj.PEACommand
import onight.zjfae.afront.Amobilezj.PWMergeProxy
import onight.zjfae.afront.Amobilezj.PWRetMerges
import onight.zjfae.mfront.action.FJsonPBFormat
import onight.zjfae.mfront.action.IFEProxyAction
import onight.tfw.outils.bean.JsonPBUtil

@NActorProvider
object CGWMsgMergeActor extends SessionModules[PWMergeProxy] {
  override def service = CGWMsgMergeService
  @ActorRequire //  @BeanProperty
  var iFEProxyAction: IFEProxyAction = null;
  def setIFEProxyAction(iFEProxyAction: IFEProxyAction) = {
    this.iFEProxyAction = iFEProxyAction;
  }

  def getIFEProxyAction(): IFEProxyAction = {
    return iFEProxyAction;
  }

}

object CGWMsgMergeService extends OLog with PBUtils with LService[PWMergeProxy] {

  //  val bmap = new IFEBeanMapping();

  override def cmd: String = PEACommand.MER.name();
  val jsonmapper = new ObjectMapper();

  val threadExec = new ThreadPoolExecutor(10, 100, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
  jsonmapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  jsonmapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
  jsonmapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);

  def change(parent: JsonNode, pathname: String, keyname: String, newValue: String, path: String): Boolean = {
    // Now, recursively invoke this method on all properties
    val it = parent.getFields
    if (pathname.indexOf(path) < 0) {
      return false;
    }
    if (pathname.equals(path)) {
      (parent.asInstanceOf[ObjectNode]).put(keyname, newValue);
      return true;
    }
    while (it.hasNext()) {
      val child = it.next();
      val vpath = path.length() match {
        case 0 => child.getKey()
        case _ => path + "." + child.getKey()
      }
      println("path:" + vpath + ",idex=" + pathname.indexOf(vpath))
      if (pathname.indexOf(vpath) >= 0) {
        if (child.getValue.isArray()) {
          val cit = child.getValue.asInstanceOf[ArrayNode].iterator()
          while (cit.hasNext()) {
            val cch = cit.next();
            if (cch.isInstanceOf[ObjectNode]) {
              change(cch, pathname, keyname, newValue, vpath);
            }
          }
        } else {
          if (child.getValue.isInstanceOf[ObjectNode])
            change(child.getValue, pathname, keyname, newValue, vpath);
        }

      }
    }

    return false;

  }

  def getAndSetvalue(parent: JsonNode, pathkey: (String, String), path: String, newValue: Option[JsonNode]): JsonNode = {
    // Now, recursively invoke this method on all properties
    val it = parent.getFields
    if (pathkey._1.indexOf(path) < 0) {
      return null;
    }
    if (pathkey._1.equals(path)) {
      newValue match {
        case Some(node) => (parent.asInstanceOf[ObjectNode]).put(pathkey._2, node);
        case None =>
      }
      return (parent.asInstanceOf[ObjectNode]).path(pathkey._2);
    }
    while (it.hasNext()) {
      val child = it.next();
      val vpath = path.length() match {
        case 0 => child.getKey()
        case _ => path + "." + child.getKey()
      }
      //      println("path:" + vpath + ",idex=" + pathkey._1.indexOf(vpath))
      if (pathkey._1.indexOf(vpath) >= 0) {
        if (child.getValue.isArray()) {
          val cit = child.getValue.asInstanceOf[ArrayNode].iterator()
          while (cit.hasNext()) {
            val cch = cit.next();
            if (cch.isInstanceOf[ObjectNode]) {
              return getAndSetvalue(cch, pathkey, vpath, newValue);
            }
          }
        } else {
          if (child.getValue.isInstanceOf[ObjectNode])
            return getAndSetvalue(child.getValue, pathkey, vpath, newValue);
        }

      }
    }

    return null;

  }
  def getPacket(pack: FramePacket,xp:PBFramePacket):String = {
     val jsonStr = if (pack.getFixHead.getEnctype()=='P') {
      val builder = CGWMsgMergeActor.iFEProxyAction.getBmap().getReqBuilder(xp.getPbname);
      builder.mergeFrom(xp.getPbbody);
      new FJsonPBFormat().printToString(builder.build());
    } else {
      xp.getJsbody;
    }
     return jsonStr
  }

  def proxyPacket(pack: FramePacket, proxypack: PBFramePacket, p: Promise[PBFramePacket.Builder]): Future[PBFramePacket.Builder] = {

    var jsonStr: String = "";
    if (pack.getFixHead.getEnctype()=='P') {
      val builder = CGWMsgMergeActor.iFEProxyAction.getBmap().getReqBuilder(proxypack.getPbname);
      builder.mergeFrom(proxypack.getPbbody);
      jsonStr = new FJsonPBFormat().printToString(builder.build());
    } else {
      jsonStr = proxypack.getJsbody;
    }

    val cb = new CallBack[Message]() {
      def onSuccess(message: Message) {
        val pbv = PBFramePacket.newBuilder();
        pbv.setGcmd(proxypack.getGcmd);
        pbv.setExts(proxypack.getExts);
        if (pack.getFixHead.getEnctype()=='P') {
          pbv.setPbbody(message.toByteString());
        } else {
          pbv.setJsbody(new FJsonPBFormat().printToString(message));
        }

        pbv.setPackId(proxypack.getPackId);
        if (proxypack.getNextpacksCount > 0) {
          val nexts = proxypack.getNextpacksList.map { xp =>
            val nextp = Promise[PBFramePacket.Builder]();
            if (proxypack.getClonefieldsList.size() > 0) {
              val nextPacketbuilder = xp.toBuilder();
              val dstnode = jsonmapper.readTree(getPacket(pack,xp));//jsonmapper.readTree(xp.getJsbody)
              val srcnode =  jsonmapper.readTree(new FJsonPBFormat().printToString(message));//jsonmapper.readTree(getPacket(pack,pbv.build()));//jsonmapper.readTree(pbv.getJsbody)
              log.debug("srcnode=" + srcnode)
              log.debug("dstnode=" + dstnode)
              var overrided: Int = 0;
              proxypack.getClonefieldsList.foreach { key =>
                //replace with last packet element
                val keys = key.split("->");
                if (keys.length == 2) {
                  //                  log.debug("replaceKEY:{}", keys);
                  val v = getAndSetvalue(srcnode, getpathkey(keys(0)), "", None)
                  if (v != MissingNode.getInstance) {
                    if (getAndSetvalue(dstnode, getpathkey(keys(1)), "", Some(v)) != MissingNode.getInstance) {
                      //                      log.debug("overrided:OK.for key:,dstnode=:{}" + dstnode)
                      overrided = overrided + 1;
                    }
                  }
                }
              }
              if (overrided != proxypack.getClonefieldsList.size()) {
                log.debug("cannot send to next because props not found");
                Future { PBFramePacket.newBuilder() }
              } else {
                //                log.debug("overrided:OK.for key:,dstnode=:{}" + dstnode)
//                nextPacketbuilder.setJsbody(dstnode.toString());
                if (pack.getFixHead.getEnctype()=='P') {
                  val builder = CGWMsgMergeActor.iFEProxyAction.getBmap().getReqBuilder(nextPacketbuilder.getPbname);
                  JsonPBUtil.json2PB(dstnode, builder);
                  nextPacketbuilder.setPbbody(builder.build().toByteString());
                } else {
                  nextPacketbuilder.setJsbody(dstnode.toString());
                }
                      
                proxyPacket(pack, nextPacketbuilder.build(), nextp)
              }
            } else {
              proxyPacket(pack, xp, nextp)
            }
          }
          Future.sequence(nexts).onComplete { results =>
            results.map(_.map { result =>
              //              log.debug("next.merge:OK:" + result)
              pbv.addNextpacks(result)
            })
            p.success(pbv);
          }
          //          }.map { x => ??? }
        } else {
          p.success(pbv);
        }
      }
      def onFailed(e: Exception, v: Message) {
        log.warn("requestfailed:", e);
        p.failure(e);
      }
    };

    threadExec.execute(new Runnable() {
      def run() {
        try {
          val msg = CGWMsgMergeActor.iFEProxyAction.postJsonMessage(pack, jsonStr, proxypack.getPbname);
          cb.onSuccess(msg);
        } catch {
          case t: Throwable => cb.onFailed(new Exception(t), null);
        }
      }
    })

    p.future;
  }

  def transPacket(fp: FramePacket): PBFramePacket.Builder = {
    val pbf = PBFramePacket.newBuilder();
    pbf.setGcmd(fp.getModuleAndCMD());
    pbf.setExts(new String(fp.getExtHead.genBytes()));
    pbf.setJsbody(new String(fp.getBody))
    return pbf;
  }

  def onPBPacket(pack: FramePacket, pbo: PWMergeProxy, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PWRetMerges.newBuilder();

    val maps = pbo.getPacketsList().map { proxypack =>
      val p = Promise[PBFramePacket.Builder]();
      proxyPacket(pack, proxypack, p)
    }
    Future.sequence(maps).onComplete { results =>
      if (results.isFailure) {
        ret.setRetcode(999999)
        ret.setRetmsg("网络请求繁忙")
      } else {
        results.map(p =>
          p.map { x =>
            ret.addRetpack(x)
          })
      }

      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));

    }

  }

  def getpathkey(fullpath: String): (String, String) = {
    val idx = fullpath.lastIndexOf(".")
    if (idx < 0) return ("", fullpath);
    return (fullpath.substring(0, idx).trim(), fullpath.substring(idx + 1).trim());

  }
  def main(args: Array[String]): Unit = {
    val srcjsontext = """
  {"datas": {"pbact": [{"act_no_new": "src1","act_name": "test","cust_id": "1","mchnt_id": "11123","channel_id": "a","act_yinit_bal": 0.0,"act_dinit_bal": 0.0,"act_cur_bal": 0.0,"act_maxod_amt": 0.0,"act_ctrl_bal": 0.0,"create_time": 1460082613000,"update_time": 1460082613000}]}}
"""
    val dstjsontext = """
  {"fh":"VMERCGW000000J00","eh":{},"body":{"retcode": 0,"retpack": [{"gcmd": "QUEACT","datas": {"pbact": [{"act_no": "1","act_name": "test","cust_id": "1","mchnt_id": "11123","channel_id": "a","act_yinit_bal": 0.0,"act_dinit_bal": 0.0,"act_cur_bal": 0.0,"act_maxod_amt": 0.0,"act_ctrl_bal": 0.0,"create_time": 1460082613000,"update_time": 1460082613000}]}}]}}
"""

    val srcnode = jsonmapper.readTree(srcjsontext);
    val dstnode = jsonmapper.readTree(dstjsontext);
    println(srcnode);
    println(dstnode);
    val keys = "datas.pbact.act_no_new -> body.retpack.datas.pbact.act_no_new".split("->")
    val srckey = keys(0)
    val dstkey = keys(1);

    val v = getAndSetvalue(srcnode, getpathkey(srckey), "", None)
    println("srcv = " + v + ":" + v.asText())
    println("srcv = " + srckey)
    if (v != MissingNode.getInstance) {
      getAndSetvalue(dstnode, getpathkey(dstkey), "", Some(v))
    }
    println(dstnode);

  }
}