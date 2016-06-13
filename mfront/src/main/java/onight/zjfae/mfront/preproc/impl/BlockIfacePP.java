package onight.zjfae.mfront.preproc.impl;

import org.apache.commons.lang3.StringUtils;

import onight.tfw.otransio.api.beans.FramePacket;
import onight.zjfae.mfront.preproc.AbstractPreProc;
import onight.zjfae.mfront.preproc.annotation.APreProcessor;
import onight.zjfae.ordbgens.app.entity.APPIfacePreproc;

@APreProcessor("block")
public class BlockIfacePP extends AbstractPreProc {
	boolean open = false;

	public BlockIfacePP(APPIfacePreproc procs) {
		super(procs);
		open = StringUtils.isBlank(procs.getKeyRex()) || StringUtils.equalsIgnoreCase("1", procs.getKeyRex())
				|| StringUtils.equalsIgnoreCase("true", procs.getKeyRex())
				|| StringUtils.equalsIgnoreCase("on", procs.getKeyRex());
	}

	@Override
	public boolean doPreProc(FramePacket fp) {
		return open;
	}
}