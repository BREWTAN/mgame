package onight.zjfae.mfront.postproc.impl;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.postproc.AbstractPostFieldTracker;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.utils.PBMessageFlatten.ModifyValue;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;

@Slf4j
@Formatter("c2yuan")
public class Change2YuanFormatter extends AbstractPostFieldTracker {

	public Change2YuanFormatter(APPIfacePostproc procs) {
		super(procs);
	}

	@Override
	// 计算规则，先乘以0.01，然后在乘以10000
	public ModifyValue modTraceValue(Object v) {

		String patterns[] = StringUtils.stripAll(procs.getProcParams().trim().split(","));
		if (patterns.length < 2) {
			log.debug("格式化参数错误：" + v + ",formatter=" + procs.getProcParams() + ",proc.uuid=" + procs.getUuid());
			return null;
		}

		if (v == null || StringUtils.isBlank((String) v)) {
			return new ModifyValue("");
		}

		Double d = Double.parseDouble((String) v);
		if (patterns.length >= 3) {
			double mul = Double.parseDouble((String) patterns[2]);
			d = d * mul;
		}
		return new ModifyValue(String.format(patterns[0].trim(), d));
	}
}