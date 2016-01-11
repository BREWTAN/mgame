package onight.mgame.acctcore.action;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import onight.act.ordbgens.act.entity.TActInfo;
import onight.mgame.accounts.Act.PBActCRUD;
import onight.mgame.accounts.Act.PBActCRUD.Operator;
import onight.mgame.accounts.Act.PBActRet;
import onight.mgame.accounts.Act.PBActRet.RetCode;
import onight.mgame.acctcore.startup.ModuleStarter;
import onight.osgi.annotation.NActorProvider;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.ojpa.api.exception.JPADuplicateIDException;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.outils.serialize.UUIDGenerator;

import org.apache.commons.lang3.StringUtils;

//@iPojoBean
@Slf4j
@NActorProvider
@Data
@EqualsAndHashCode(callSuper = true)
public class A00_CreateAccoutAction extends ModuleStarter<PBActCRUD> {// for

	@StoreDAO(domain = TActInfo.class, target = "actmysql")
	private OJpaDAO<TActInfo> tActInfoDao;

	@Override
	public String[] getCmds() {
		return new String[] { "A0" + Operator.CREATE_VALUE,//
		};
	}

	// 测试方式：
	// http://localhost:8081/act/pba00.do?fh=VLOGAUT000000J00&bd={"op":0,"pb_acct_info":{"act_name":"tany","cust_id":"1234","mchnt_id":"000"}}&gcmd=A00ACT
	@Override
	public void onPBPacket(FramePacket pack, PBActCRUD pbo, CompleteHandler handler) {
		log.debug("获取到消息：" + pbo);
		PBActRet.Builder rb = PBActRet.newBuilder();
		TActInfo actinfo = pbBeanUtil.copyFromPB(pbo.getPbActInfo(), new TActInfo());
		try {
			if (StringUtils.isBlank(actinfo.getActNo())) {
				actinfo.setActNo(UUIDGenerator.generate());
			}
			tActInfoDao.insert(actinfo);
			rb.setDesc("账户创建成功");
			rb.setStatus("0001");
			rb.setRetcode(RetCode.SUCCESS_VALUE);
			rb.setActNo(actinfo.getActNo());
		} catch (JPADuplicateIDException je) {
			// 账户已存在
			log.info("创建账户失败，已存在该账户," + actinfo.getActNo());
			rb.setDesc("账户已存在");
			rb.setStatus("0001");
			rb.setRetcode(RetCode.FAILED_VALUE);
		} catch (Exception e) {
			log.error("创建账户失败，结果未知", e);
			rb.setDesc("账户创建失败");
			rb.setStatus("0099");
			rb.setRetcode(RetCode.FAILED_VALUE);
		}
		handler.onFinished(PacketHelper.toPBReturn(pack, rb.build()));
	}

}
