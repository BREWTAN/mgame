package onight.mgame.acctcore.action;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import onight.act.ordbgens.act.entity.TActInfo;
import onight.act.ordbgens.act.entity.TActInfoExample;
import onight.act.ordbgens.act.entity.TActInfoKey;
import onight.mgame.accounts.Act.PBAccountInfo;
import onight.mgame.accounts.Act.PBActCRUD;
import onight.mgame.accounts.Act.PBActCRUD.Operator;
import onight.mgame.accounts.Act.PBActRet;
import onight.mgame.accounts.Act.PBActRet.RetCode;
import onight.mgame.acctcore.startup.ModuleStarter;
import onight.osgi.annotation.NActorProvider;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;

//@iPojoBean
@Slf4j
@NActorProvider
@Data
@EqualsAndHashCode(callSuper = true)
public class A30_QueryActByExampleAction extends ModuleStarter<PBActCRUD> {// for

	@StoreDAO(domain = TActInfo.class, target = "actmysql",example=TActInfoExample.class,keyclass=TActInfoKey.class)
	private OJpaDAO<TActInfo> tActInfoDao;

	@Override
	public String[] getCmds() {
		return new String[] { "A" + Operator.QUERYBYEXAMPLE_VALUE,//
		};
	}

	// 测试方式：
	// http://localhost:8081/act/pba30.do?fh=VA30ACT000000J00&bd={"op":3,"pb_act_info":{"act_name":"tany"}}&gcmd=A30ACT
	@Override
	public void onPBPacket(FramePacket pack, PBActCRUD pbo, CompleteHandler handler) {
		log.debug("获取到消息：" + pbo);
		PBActRet.Builder rb = PBActRet.newBuilder();
		TActInfo actinfo = pbBeanUtil.copyFromPB(pbo.getPbActInfo(), new TActInfo());
		TActInfoExample example = (TActInfoExample) tActInfoDao.getExample(actinfo);
		List<Object> actinfos = tActInfoDao.selectByExample(example);

		rb.setRetcode(RetCode.SUCCESS_VALUE);
		if (actinfos == null || actinfos.size() == 0) {
			rb.setDesc("未找到相关账户:" + pbo.getPbActInfo().getActNo());
			rb.setStatus("1001");// 未找到
		} else {
			rb.setStatus("0000");// 已经找到
			for(Object obj:actinfos){
				TActInfo result=(TActInfo)obj;
				rb.addPbActInfo(pbBeanUtil.<PBAccountInfo> toPB(PBAccountInfo.newBuilder(), result));
			}
		}

		handler.onFinished(PacketHelper.toPBReturn(pack, rb.build()));
	}

}
