package centrin.hbase.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 时间日期工具类
 * @author shengyidong
 *
 */
public final class DatetimeUtil {

	private static final Logger logger = Logger.getLogger(DatetimeUtil.class);

	public static final String YEAR_MONTH_DAY_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String YEARMONTHDAYHHMMSS = "yyyyMMddHHmmss";

	public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";

	public static String dateToStr(Date date, String format) {
		try {
			return (date == null) ? "" : new SimpleDateFormat(format).format(date);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "";
	}
	
	public static String dateToStr(Date date){
		try {
			return (date == null) ? "" : new SimpleDateFormat(YEAR_MONTH_DAY_HH_MM_SS).format(date);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "";
	}
	
	public static String getRowDateStr() {
		long l = System.currentTimeMillis();
		long ws = l % 1000;
		return dateToStr(new Date(l), YEARMONTHDAYHHMMSS) + ws;
	}
	
}
