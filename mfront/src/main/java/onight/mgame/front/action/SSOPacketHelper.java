package onight.mgame.front.action;

import lombok.extern.slf4j.Slf4j;
import onight.sm.Ssm.PBCommand;
import onight.sm.Ssm.PBModule;
import onight.sm.Ssm.PBSSO;
import onight.sm.Ssm.PBSSORet;
import onight.tfw.otransio.api.PacketHelper;
import onight.tfw.otransio.api.beans.FramePacket;

import org.apache.commons.lang3.StringUtils;

@Slf4j
public class SSOPacketHelper {

	public static FramePacket getSSOGetPacket(FramePacket pack) {
		if (StringUtils.isBlank(pack.getExtHead().getSMID()))
			return null;
		PBSSO sso = PBSSO.newBuilder().setSmid(pack.getExtHead().getSMID()).build();
		FramePacket getsso = PacketHelper.genASyncPBPack(PBCommand.GET.name(), PBModule.SSM.name(), sso);
		return getsso;
	}

	public static PBSSORet parseRet(byte[] body) {
		try {
			return PBSSORet.newBuilder().mergeFrom(body).build();
		} catch (Exception e) {
			return null;
		}
	}

}
