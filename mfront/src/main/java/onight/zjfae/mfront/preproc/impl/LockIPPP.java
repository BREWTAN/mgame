package onight.zjfae.mfront.preproc.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import onight.tfw.otransio.api.PackHeader;
import onight.tfw.otransio.api.beans.FramePacket;
import onight.zjfae.mfront.preproc.AbstractPreProc;
import onight.zjfae.mfront.preproc.annotation.APreProcessor;
import onight.zjfae.ordbgens.app.entity.APPIfacePreproc;

import org.apache.commons.lang3.StringUtils;

import com.google.protobuf.Message.Builder;

@Slf4j
@APreProcessor("lockip")
public class LockIPPP extends AbstractPreProc {
	List<String> ipRex = new ArrayList<String>();

	public LockIPPP(APPIfacePreproc procs) {
		super(procs);
		if (StringUtils.isNotBlank(procs.getKeyRex())) {
			for (String ipx : procs.getKeyRex().split(",")) {
				ipRex.add(ipx);
			}
		}
	}

	@Override
	public boolean doPreProc(FramePacket fp) {
		String ip = fp.getExtStrProp(PackHeader.PEER_IP);
		if (StringUtils.isNotBlank(ip)) {
			for (String ipx : ipRex) {
				if (ip.matches(ipx)) {
					return true;
				}
			}
		}
		return false;
	}

}
