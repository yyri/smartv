package centrin.hbase.util;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.log4j.Logger;

/**
 * 数据库工具类
 * 
 * @author shengyidong
 * 
 */
public final class HbaseUtil {

	private static final Logger logger = Logger.getLogger(HbaseUtil.class);

	/**
	 * 数据表名
	 */
	private static final String HBASE_TABLE_SMARTV = "smartv";
	/**
	 * 临时表名
	 */
	private static final String HBASE_TABLE_SMARTV_TEMP = "smartv_temp";
	/**
	 * 数据表列族
	 */
	public static final byte[] HBASE_TABLE_FAMILY_SMARTV = "cf_smartv"
			.getBytes();
	/**
	 * 临时表列族
	 */
	public static final byte[] HBASE_TABLE_FAMILY_SMARTV_TEMP = "cf_temp"
			.getBytes();
	/**
	 * hbase连接
	 */
	private static Configuration cfg = null;

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public synchronized static Configuration getConfiguration() {
		if (cfg == null) {
			cfg = HBaseConfiguration.create();
		}
		return cfg;
	}

	/**
	 * 获取数据表
	 */
	public static HTable getSmartvTable() {
		try {
			return new HTable(getConfiguration(), HBASE_TABLE_SMARTV);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 获取临时表
	 */
	public static HTable getTempTable() {
		try {
			return new HTable(getConfiguration(), HBASE_TABLE_SMARTV_TEMP);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 自动生成行号
	 */
	public static String getSmartvRow() {
		StringBuffer result = new StringBuffer();
		result.append("smartv_");
		result.append(DatetimeUtil.getRowDateStr() + "_");
		result.append(UUID.randomUUID().toString().replace("-", ""));
		return result.toString();
	}

	/**
	 * 自动生成行号
	 */
	public static byte[] getSmartvRowBytes() {
		return getSmartvRow().getBytes();
	}

	/**
	 * 字节数组转化字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String bytesToStr(byte[] b) {
		if (b != null) {
			try {
				return new String(b, "UTF-8");
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	/**
	 * 保存数据
	 * 
	 * @param p
	 */
	public static void putSmartv(Put p) {
		try {
			getSmartvTable().put(p);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * get data
	 * 
	 * @param p
	 */
	public static Result getSmartv(Get p) {
		try {
			getSmartvTable().get(p);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 保存批量数据
	 * 
	 * @param puts
	 */
	public static void putsSmartv(List<Put> puts) {
		try {
			getSmartvTable().put(puts);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

}
