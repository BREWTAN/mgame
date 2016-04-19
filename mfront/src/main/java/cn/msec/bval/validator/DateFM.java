package cn.msec.bval.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import lombok.NoArgsConstructor;

import org.apache.commons.lang3.StringUtils;

import cn.msec.msc.utils.TradeLocal;

@NoArgsConstructor
public class DateFM implements IVal {

	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD,
			ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface DateFMA {
		String value() default "yyyyMMdd";

		boolean notnull() default false;

		Class<? extends IVal> valClass() default DateFM.class;
	}

	public interface SDFSafe {
		public SimpleDateFormat sdf();
	}

	public class SDF_yyMMdd implements IVal {

		@Override
		public boolean init(Annotation a) {
			return true;
		}

		@Override
		public boolean isValid(String v) {
			try {
				sdfSafe.sdf().parse(v);
				return true;
			} catch (ParseException e) {
			}
			return false;
		}

	}

	boolean notnull;

	SDFSafe sdfSafe;

	@Override
	public boolean init(Annotation a) {
		try {
			if (a instanceof DateFMA) {
				final String patten = ((DateFMA) a).value();
				if (patten.equals("yyyyMMdd")) {
					sdfSafe = new SDFSafe() {
						@Override
						public SimpleDateFormat sdf() {
							// TODO Auto-generated method stub
							return TradeLocal.getSDF_yyyyMMdd();
						}
					};
				} else if (patten.equals("yyyyMMddHHmmss")) {
					sdfSafe = new SDFSafe() {
						@Override
						public SimpleDateFormat sdf() {
							// TODO Auto-generated method stub
							return TradeLocal.getSDF_yyyyMMddHHmmss();
						}
					};
				} else if (patten.equals("yyMMddHHmmss.SSS")) {
					sdfSafe = new SDFSafe() {
						@Override
						public SimpleDateFormat sdf() {
							// TODO Auto-generated method stub
							return TradeLocal.getSDF_yyMMddHHmmss_sss();
						}
					};
				} else {
					sdfSafe = new SDFSafe() {
						@Override
						public SimpleDateFormat sdf() {
							return new SimpleDateFormat(patten);
						}
					};
				}
				notnull = ((DateFMA) a).notnull();
			} else {
				return false;
			}
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean isValid(String v) {
		try {
			if (StringUtils.isBlank(v))
				return !notnull;
			sdfSafe.sdf().parse(v);
			return true;
		} catch (ParseException e) {
		}

		return false;
	}

}
