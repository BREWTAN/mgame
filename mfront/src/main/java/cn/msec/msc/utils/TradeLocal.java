package cn.msec.msc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

public class TradeLocal {

	static class TradeSet {
		SimpleDateFormat sf_yyMMdd = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat sf_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sf_yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sf_yyMMddHHmmss_sss = new SimpleDateFormat("yyMMddHHmmss.SSS");
		SimpleDateFormat sf_HHmmss = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat sf_yyyyMMddTHHmmss = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SimpleDateFormat sf_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
		ZBXLogSet zbxlogs;
		long entrytime = System.currentTimeMillis();
		Map<String, String> transTypeMap = new HashMap<String, String>();
	}

	@Data
	static class ZBXLogSet {
		String P[] = new String[] { "1", "", "", "", "" };
		String Cost[] = new String[] { "", "", "", "", "" };
		String Money = "";

	}

	static class ExtThreadLocal extends ThreadLocal<TradeSet> {
		@Override
		protected TradeSet initialValue() {
			return new TradeSet();
		}
	}

	static ExtThreadLocal local;
	static {
		local = new TradeLocal.ExtThreadLocal();
	}

	public static String getLocalID() {
		return "" + System.identityHashCode(local.get());
	}

	public static SimpleDateFormat getSDF_yyMMdd() {
		return local.get().sf_yyMMdd;
	}

	public static SimpleDateFormat getSDF_yyyyMMdd() {
		return local.get().sf_yyyyMMdd;
	}

	public static SimpleDateFormat getSDF_yyyyMMddHHmmss() {
		return local.get().sf_yyyyMMddHHmmss;
	}

	public static SimpleDateFormat getSDF_yyyyMMddTHHmmss() {
		return local.get().sf_yyyyMMddTHHmmss;
	}

	public static SimpleDateFormat getSDF_yyMMddHHmmss_sss() {
		return local.get().sf_yyMMddHHmmss_sss;
	}

	public static SimpleDateFormat getSDF_yyyy_MM_dd() {
		return local.get().sf_yyyy_MM_dd;
	}

	public static SimpleDateFormat getSDF_HHmmss() {
		return local.get().sf_HHmmss;
	}

	public static String getToday() {
		return local.get().sf_yyMMdd.format(new Date());
	}

	public static String getLToday() {
		return local.get().sf_yyyyMMdd.format(new Date());
	}

	public static long getEntryTimeMS() {
		return local.get().entrytime;
	}

	public static String zbxLogs(String module, String status) {
		ZBXLogSet zlog = local.get().zbxlogs;
		;
		return "[ZBX]::" + module //
				// + "|MSGID:" + pack.getMsgsentid() //
				// + "|MCHID:" + getMchntid() //
				+ "|S:" + status + "|M:" + zlog.Money//
				+ "|P0:" + zlog.P[0]//
				+ "|P1:" + zlog.P[1] + "|P2:" + zlog.P[2]//
				+ "|C:" + (System.currentTimeMillis() - local.get().entrytime)//
				+ "|C0:" + zlog.Cost[0] + //
				"|C1:" + zlog.Cost[1] + //
				"|C2:" + zlog.Cost[2] + //
				"|";
	}

	public static void logCostTime(int id, long cost) {
		local.get().zbxlogs.Cost[id] = String.valueOf(cost);
	}

	public static void logCounter(int id, long count) {
		local.get().zbxlogs.P[id] = String.valueOf(count);
	}

	public static void logMoney(long count) {
		local.get().zbxlogs.Money = String.valueOf(count);
	}

	public static void clean() {
		local.get().entrytime = System.currentTimeMillis();
		local.get().zbxlogs = new ZBXLogSet();
	}

	public static Date getDateFromyyMMddHHmmss_sss(String datestr) throws ParseException {
		return local.get().sf_yyMMddHHmmss_sss.parse(datestr);
	}

}
