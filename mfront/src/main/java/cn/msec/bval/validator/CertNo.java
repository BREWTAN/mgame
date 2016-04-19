package cn.msec.bval.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CertNo extends RegexFM {

	@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface CertNoM {
		Class valClass() default CertNo.class;
	}
	
	@RegexFMA(pattern = "((\\d){6})((?:((?!0000)[0-9]{4}|[0-9]{2})(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29))((\\d){4}|(\\d){3}(X|x))")
	public class CertBean {
	}

	@Override
	public boolean init(Annotation a) {
		return super.init(CertBean.class.getAnnotation(RegexFMA.class));
	}
	
	@Override
	public boolean isValid(String v) {
		if(super.isValid(v)){
			return isAdult(v);
		}
		return false;
	}
	
	public boolean isAdult(String v){
		String birth = v.substring(6, 14);
		Calendar currentCalendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		try {
			date = sdf.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(currentCalendar.get(Calendar.YEAR) - calendar.get(Calendar.YEAR) > 18){
			return true;
		}
		if(currentCalendar.get(Calendar.YEAR) - calendar.get(Calendar.YEAR) == 18){
			if(currentCalendar.get(Calendar.MONTH) > calendar.get(Calendar.MONTH)){
				return true;
			}
			if(currentCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)){
				if(currentCalendar.get(Calendar.DAY_OF_MONTH) >= calendar.get(Calendar.DAY_OF_MONTH)){
					return true;
				}
			}
		}
		return false;
	}
}
