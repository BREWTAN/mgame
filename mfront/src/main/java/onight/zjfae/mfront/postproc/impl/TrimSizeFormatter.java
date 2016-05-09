package onight.zjfae.mfront.postproc.impl;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.postproc.AbstractPostFieldTracker;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.utils.PBMessageFlatten.ModifyValue;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;

@Slf4j
@Formatter("trimsize")
public class TrimSizeFormatter extends AbstractPostFieldTracker {

	public TrimSizeFormatter(APPIfacePostproc procs) {
		super(procs);
	}

	@Override
	public ModifyValue modTraceValue(Object v) {
		String patterns[] = procs.getProcParams().split(",");
		if (patterns.length < 2) {
			log.debug("格式化参数错误：" + v + ",formatter=" + procs.getProcParams());
			return null;
		}
		try {
			if (v == null) {
				return new ModifyValue(patterns[1]);
			} else {
				int length = Integer.parseInt(patterns[0]);
				String strv = ((String) v);
				return new ModifyValue(strv.substring(0, Math.min(length, strv.length() - 1)));
			}
		} catch (Throwable e) {
			log.debug("格式化错误：" + v + ",formatter=" + procs.getProcParams(), e);
			return new ModifyValue(patterns[1].trim());
		}
	}
}
