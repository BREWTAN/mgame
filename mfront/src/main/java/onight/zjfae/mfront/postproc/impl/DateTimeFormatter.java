package onight.zjfae.mfront.postproc.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.postproc.AbstractPostFieldTracker;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.utils.PBMessageFlatten.ModifyValue;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;

import org.apache.commons.lang3.StringUtils;

@Slf4j
@Formatter("datetime")
public class DateTimeFormatter extends AbstractPostFieldTracker {
	public DateTimeFormatter(APPIfacePostproc procs) {
		super(procs);
	}

	@Override
	public ModifyValue modTraceValue(Object v) {
		if (v == null || StringUtils.isBlank((String) v))
			return null;
		String patterns[] = procs.getProcParams().split(",");
		if (patterns.length < 2) {
			log.debug("格式化参数错误：" + v + ",formatter=" + procs.getProcParams());
			return null;
		}
		try {
			SimpleDateFormat srcsdf = new SimpleDateFormat(patterns[0]);
			SimpleDateFormat dstsdf = new SimpleDateFormat(patterns[1]);
			Date date = srcsdf.parse((String) v);
			String dst = dstsdf.format(date);
			return new ModifyValue(dst);
		} catch (ParseException e) {
			log.debug("格式化错误：" + v + ",formatter=" + procs.getProcParams(), e);
			if (patterns.length >= 3 && !StringUtils.isBlank(patterns[2])) {
				if ("{}".equals(patterns[2])) {
					try {
						SimpleDateFormat dstsdf = new SimpleDateFormat(patterns[1]);
						return new ModifyValue(dstsdf.format(new Date()));
					} catch (Exception e1) {
						return new ModifyValue("");
					}
				} else {
					return new ModifyValue(patterns[2].trim());
				}
			}
		}
		return null;

	}
}
