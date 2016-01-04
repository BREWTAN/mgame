package onight.mgame.mauthlogin.action;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.mgame.mauthlogin.Login.PBLogin;
import onight.mgame.mauthlogin.Login.PBRetLogin;
import onight.mgame.mauthlogin.startup.ModuleStarter;
import onight.osgi.annotation.NActorProvider;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUser;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUserKey;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;

//@iPojoBean
@Slf4j
@NActorProvider
@Data
public class LoginAction extends ModuleStarter<PBLogin>  {// for

	@StoreDAO(domain = TFGLoginUser.class)
	private OJpaDAO<TFGLoginUser> tfgloginUserDao;

	@Override
	public String[] getCmds() {
		return new String[]{"LIN"};
	}

	@Override
	public void onPBPacket(FramePacket pack, PBLogin pbo, CompleteHandler handler) {
		log.debug("获取到消息：" + pbo);
		PBRetLogin.Builder rb = PBRetLogin.newBuilder();
		rb.setUserid(pbo.getUserid());
		if(pbo.getLogintype()==1||pbo.getLogintype()==0){
			//根据ID登录
			TFGLoginUser user=tfgloginUserDao.selectByPrimaryKey(new TFGLoginUserKey(Long.valueOf(
					pbo.getUserid())));
			if(user!=null){
				if(user.getPassword() == pbo.getPwd()){
					rb.setStatus("SUCCESS").setRetcode(0);
				}else{
					rb.setStatus("FAILED").setRetcode(-1).setDesc("密码错误");
				}
			}else{
				rb.setStatus("FAILED").setRetcode(-2).setDesc("用户id不存在");
			}
		}else{
			rb.setStatus("FAILED").setRetcode(-3).setDesc("登录方式不正确");
		}
		handler.onFinished(PacketHelper.toPBReturn(pack,rb.build()));
	}

	

}
