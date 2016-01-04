package onight.mgame.acctcore.action;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.act.ordbgens.act.entity.TActInfo;
import onight.act.ordbgens.act.entity.TActInfoExample;
import onight.act.persist.entity.UserCount;
import onight.mgame.accounts.Act.PBActCRUD;
import onight.mgame.accounts.Act.PBActCRUD.Operator;
import onight.mgame.accounts.Act.PBActRet;
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
public class AccoutAction extends ModuleStarter<PBActCRUD> {// for

	@StoreDAO(domain = TActInfo.class, target = "actmysql")
	private OJpaDAO<TActInfo> tActInfoDao;

	@StoreDAO(domain = UserCount.class, target = "actmysql")
	private OJpaDAO<UserCount> userCountDao;
	
	@Override
	public String[] getCmds() {
		return new String[] {
				"A0" + Operator.MODIFY_VALUE, //
				"A0" + Operator.FREEZE_VALUE, //
				"A0" + Operator.DELETE_VALUE, //
		};
	}

	@Override
	public void onPBPacket(FramePacket pack, PBActCRUD pbo, CompleteHandler handler) {
		log.debug("获取到消息：" + pbo);
		PBActRet.Builder rb = PBActRet.newBuilder();
		rb.setActNo(pbo.getPbActInfo().getActNo());
		if (pbo.getOp() == Operator.CREATE) {

			// 创建账户
		}
		
		TActInfoExample ex=new TActInfoExample();
		ex.createCriteria().andActNoEqualTo("abc");
		
		Object ret=tActInfoDao.selectByExample(ex);
		System.out.println("select result="+ret);
		UserCount uc=new UserCount();
		uc.setCust_id("abc");
		
		Object ucs=userCountDao.selectByExample(uc);
		System.out.println("ucs=="+ucs);
		// if(pbo.getLogintype()==1||pbo.getLogintype()==0){
		// //根据ID登录
		// TFGLoginUser user=tfgloginUserDao.selectByPrimaryKey(new
		// TFGLoginUserKey(Long.valueOf(
		// pbo.getUserid())));
		// if(user!=null){
		// if(user.getPassword() == pbo.getPwd()){
		// rb.setStatus("SUCCESS").setRetcode(0);
		// }else{
		// rb.setStatus("FAILED").setRetcode(-1).setDesc("密码错误");
		// }
		// }else{
		// rb.setStatus("FAILED").setRetcode(-2).setDesc("用户id不存在");
		// }
		// }else{
		// rb.setStatus("FAILED").setRetcode(-3).setDesc("登录方式不正确");
		// }
		handler.onFinished(PacketHelper.toPBReturn(pack, rb.build()));
	}

}
