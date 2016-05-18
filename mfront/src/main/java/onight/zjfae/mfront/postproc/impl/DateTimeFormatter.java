package onight.zjfae.mfront.postproc.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
		String patterns[] = StringUtils.stripAll(procs.getProcParams().trim().split(","));
		if (patterns.length < 2) {
			log.debug("格式化参数错误：" + v + ",formatter=" + procs.getProcParams()+",proc.uuid="+procs.getUuid());
			return null;
		}
		try {
			SimpleDateFormat srcsdf = new SimpleDateFormat(patterns[0].trim());
			SimpleDateFormat dstsdf = new SimpleDateFormat(patterns[1].trim());
			Date date = srcsdf.parse((String) v);
			String dst = dstsdf.format(date);
			return new ModifyValue(dst);
		} catch (ParseException e) {
			log.debug("格式化错误：" + v + ",formatter=" + procs.getProcParams(), e);
			if (patterns.length >= 3 && !StringUtils.isBlank(patterns[2].trim())) {
				if ("{}".equals(patterns[2].trim())) {
					try {
						SimpleDateFormat dstsdf = new SimpleDateFormat(patterns[1].trim());
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
	public static void main(String[] args) {
		try {
			SimpleDateFormat srcsdf = new SimpleDateFormat("E MMM d HH:mm:ss z YYYY");

			System.out.println("date=="+srcsdf.format(new Date()));
			Date date = srcsdf.parse("Tue May 10 10:36:46 GMT+08:00 2016");
			System.out.println("date="+date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
