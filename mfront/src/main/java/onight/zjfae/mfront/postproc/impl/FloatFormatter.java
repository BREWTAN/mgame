package onight.zjfae.mfront.postproc.impl;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.postproc.AbstractPostFieldTracker;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.utils.PBMessageFlatten.ModifyValue;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;

import org.apache.commons.lang3.StringUtils;

@Slf4j
@Formatter("floatformat")
public class FloatFormatter extends AbstractPostFieldTracker {

	public FloatFormatter(APPIfacePostproc procs) {
		super(procs);
	}

	@Override
	public ModifyValue modTraceValue(Object v) {
		String patterns[] = StringUtils.stripAll(procs.getProcParams().trim().split(","));
		if (patterns.length < 2) {
			log.debug("格式化参数错误：" + v + ",formatter=" + procs.getProcParams() + ",proc.uuid=" + procs.getUuid());
			return null;
		}

		try {
			if (v == null || StringUtils.isBlank((String) v)) {
				return new ModifyValue(patterns[1].trim());
			} else {
				Double d = Double.parseDouble((String) v);
				if (patterns.length >= 3) {
					double mul = Double.parseDouble((String) patterns[2]);
					d = d * mul;
				}
				return new ModifyValue(String.format(patterns[0].trim(), d));
			}
		} catch (Throwable e) {
			log.debug("格式化错误：" + v + ",formatter=" + procs.getProcParams(), e);
//			return new ModifyValue(patterns[1].trim());
			if ("{}".equals(patterns[1].trim())) {
				return new ModifyValue(patterns[1].trim());
			}
			return null;
		}
	}
	public static void main(String[] args) {
		System.out.println(String.format("%.2f", 1.0));
	}
}
