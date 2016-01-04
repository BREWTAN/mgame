package onight.mgame.mauthlogin.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.mgame.mauthlogin.Register.PBRegister;
import onight.mgame.mauthlogin.Register.PBRetRegister;
import onight.mgame.mauthlogin.startup.ModuleStarter;
import onight.osgi.annotation.iPojoBean;
import onight.tfg.ordbgens.tfg.entity.TFGLoginUser;
import onight.tfg.ordbgens.tfg.entity.TFGUserInfo;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ntrans.api.ActorService;
import onight.tfw.ntrans.api.annotation.ActorRequire;
import onight.tfw.ojpa.api.IJPAClient;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.TransactionExecutor;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.ojpa.api.exception.JPAException;
import onight.tfw.orouter.api.IQClient;
import onight.tfw.otransio.api.PSenderService;
import onight.tfw.otransio.api.PackHeader;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.tfw.proxy.IActor;

import org.apache.felix.ipojo.annotations.Provides;

@iPojoBean
@Slf4j
@Provides(specifications = {IJPAClient.class,IActor.class,PSenderService.class,IQClient.class,ActorService.class})
@Data
public class RegisterAction extends ModuleStarter<PBRegister> {// for

	@StoreDAO(domain = TFGLoginUser.class)
	private OJpaDAO<TFGLoginUser> tfgloginUserDao;

	
	@ActorRequire
	private LoginAction loginAction;
	
	@StoreDAO(domain = TFGUserInfo.class)
	private OJpaDAO<TFGUserInfo> tfgUserInfoDao;
	
	@Override
	public String[] getCmds() {
		return new String[]{"REG"};
	}


	@Override
	public void onPBPacket(FramePacket pack, PBRegister pbo, CompleteHandler handler) {
		log.debug("获取到消息：" + pack);
		log.debug("loginaction:dao==:"+loginAction.getTfgloginUserDao());
		final TFGUserInfo userinfo = new TFGUserInfo();
		userinfo.setAddress(pbo.getAddress());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		try {
			userinfo.setBirthday(sdf.parse(pbo.getBirthday()));
		} catch (ParseException e) {
			log.warn("birthday error:", e);
		}
		userinfo.setCity(pbo.getCity());
		userinfo.setCountry(pbo.getCountry());
		userinfo.setCreateTime(new Date());
		userinfo.setEmail(pbo.getEmail());
		userinfo.setFace(pbo.getFace());
		userinfo.setFaceUrl(pbo.getFaceurl());
		userinfo.setGender(pbo.getGender());
		userinfo.setMobile(pbo.getMobile());
		userinfo.setNickname(pbo.getNickname());
		userinfo.setQqId(pbo.getQqid());
		userinfo.setRegIp(pack.getExtProp(PackHeader.PEER_IP));
		userinfo.setRegTime(new Date());
		userinfo.setRenren(pbo.getRenren());
		userinfo.setSecurityEmail(pbo.getEmail());
		userinfo.setUserName(pbo.getUsername());
		// userinfo.setUserId(userId);
		userinfo.setWechatId(pbo.getWechatid());
		userinfo.setWeibo(pbo.getWeibo());

		final TFGLoginUser loginuser = new TFGLoginUser();
		loginuser.setCreateTime(new Date());
		loginuser.setEmail(pbo.getEmail());
		loginuser.setLoginId(pbo.getNickname());
		loginuser.setMobile(pbo.getMobile());
		loginuser.setNickname(pbo.getNickname());
		loginuser.setPassword(pbo.getPwd());
		loginuser.setRegType("0");
		loginuser.setStatus(0);

		Object ret = null;
		PBRetRegister.Builder pb = PBRetRegister.newBuilder();

		try {
			ret = tfgloginUserDao.doInTransaction(new TransactionExecutor() {
				@Override
				public Object doInTransaction() {
					tfgloginUserDao.insert(loginuser);
					tfgUserInfoDao.insert(userinfo);
					return true;
				}
			});
			if (ret != null && ret.equals(true)) {
				pb.setRetcode(0).setStatus("SUCCESS").setUserid(String.valueOf(userinfo.getUserId()));
			} else {
				pb.setRetcode(-1).setStatus("FAILED").setUserid(String.valueOf(userinfo.getUserId()));

			}
		} catch (JPAException e) {
			log.warn("create user error:", e);
			pb.setRetcode(-1).setStatus("FAILED").setUserid(String.valueOf(userinfo.getUserId())).setDesc(e.getMessage());
		}
		
		handler.onFinished(PacketHelper.toPBReturn(pack,pb.build()));

	}

	

}
