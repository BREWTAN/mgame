package onight.mgame.acctcore.action;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import onight.act.ordbgens.act.entity.TActFund;
import onight.act.ordbgens.act.entity.TActInfo;
import onight.act.ordbgens.act.entity.TActInfoKey;
import onight.mgame.accounts.Act.PBAccountInfo;
import onight.mgame.accounts.Act.PBActRet;
import onight.mgame.accounts.Act.PBActRet.RetCode;
import onight.mgame.accounts.Act.PBFundLog;
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
public class F03_QueryFundAction extends ModuleStarter<PBFundLog> {// for

	@StoreDAO(domain = TActInfo.class, target = "actmysql")
	private OJpaDAO<TActInfo> tActInfoDao;

	@StoreDAO(domain = TActFund.class, target = "actmysql")
	private OJpaDAO<TActFund> tActFundDao;

	@Override
	public String[] getCmds() {
		return new String[] { "F03",//
		};
	}

	// 测试方式：//TODO，没做完
	// http://localhost:8081/act/pba03.do?fh=VA03ACT000000J00&bd={"op":3,"pb_act_info":{"act_no":"ff8080815177cd97015177cf3d880002"}}&gcmd=A03ACT
	@Override
	public void onPBPacket(FramePacket pack, PBFundLog pbo, CompleteHandler handler) {
		log.debug("获取到消息：" + pbo);
		PBActRet.Builder rb = PBActRet.newBuilder();
		TActInfo actinfo = tActInfoDao.selectByPrimaryKey(new TActInfoKey(pbo.getTxSno()));

		rb.setRetcode(RetCode.SUCCESS_VALUE);
		if (actinfo == null) {
			rb.setDesc("未找到相关账户:" + pbo.getTxSno());
			rb.setStatus("1001");// 未找到
		} else {
			rb.setStatus("0000");// 已经找到
			rb.setActNo(actinfo.getActNo());
			rb.addPbActInfo(pbBeanUtil.<PBAccountInfo> toPB(PBAccountInfo.newBuilder(), actinfo));
		}

		handler.onFinished(PacketHelper.toPBReturn(pack, rb.build()));
	}

}
