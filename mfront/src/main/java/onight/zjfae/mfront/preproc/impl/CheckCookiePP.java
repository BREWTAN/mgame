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
@APreProcessor("checkcookie")
public class CheckCookiePP extends AbstractPreProc {
	List<String[]> cookieChecks = new ArrayList<String[]>();

	public CheckCookiePP(APPIfacePreproc procs) {
		super(procs);
		if (StringUtils.isNotBlank(procs.getKeyRex())) {
			for (String ck : procs.getKeyRex().split(",")) {
				if (StringUtils.isNotBlank(ck)) {
					cookieChecks.add(ck.split("="));
				}
			}
		}
	}

	@Override
	public boolean doPreProc(FramePacket fp, Builder builder) {
		for (String[] str : cookieChecks) {
			String v = fp.getExtStrProp(str[0]);
			if (v != null) {
				if (str.length <= 1)
					return true;
				if (v.matches(str[1]))
					return true;
			}
		}
		return false;
	}

}
