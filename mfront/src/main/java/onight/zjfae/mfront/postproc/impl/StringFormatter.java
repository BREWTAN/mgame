package onight.zjfae.mfront.postproc.impl;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.postproc.AbstractPostFieldTracker;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.utils.PBMessageFlatten.ModifyValue;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;

@Slf4j
@Formatter("stringformat")
public class StringFormatter extends AbstractPostFieldTracker {

	public StringFormatter(APPIfacePostproc procs) {
		super(procs);
	}

	@Override
	public ModifyValue modTraceValue(Object v) {
		String patterns[] = StringUtils.stripAll(procs.getProcParams().trim().split(","));
		if (patterns.length < 2) {
			log.debug("格式化参数错误：" + v + ",formatter=" + procs.getProcParams()+",proc.uuid="+procs.getUuid());
			return null;
		}
		try {
			if (v == null) {
				return new ModifyValue(patterns[1].trim());
			} else {
				return new ModifyValue(String.format(patterns[0].trim(), v));
			}
		} catch (Throwable e) {
			log.debug("格式化错误：" + v + ",formatter=" + procs.getProcParams(), e);
			if ("{}".equals(patterns[1].trim())) {
				return new ModifyValue(patterns[1].trim());
			}
			return null;
		}
	}
}
