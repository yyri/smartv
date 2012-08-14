package centrin;

import java.io.IOException;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.RowLock;
import org.apache.hadoop.hbase.client.Scan;
import org.junit.Test;

import centrin.hbase.TestMain;
import centrin.hbase.util.ColumnUtil;
import centrin.hbase.util.HbaseUtil;

public class HBaseServiceTest {

	public static String rowKey = "smartv_20120814161832203_545004929955475b8bf4e30877cb758d";

	@Test
	public void connect() {
	}

	@Test
	public void get() throws IOException {
		HTable table = HbaseUtil.getSmartvTable();
		Get get = new Get(rowKey.getBytes());
		Result rs = table.get(get);
		for (KeyValue kv : rs.raw()) {
			System.out.print(new String(kv.getRow()) + " ");
			System.out.print(new String(kv.getFamily()) + ":");
			System.out.print(new String(kv.getQualifier()) + " ");
			System.out.print(kv.getTimestamp() + " ");
			System.out.println(new String(kv.getValue()));
		}
	}

	@Test
	public void scan() throws IOException {
		HTable table = HbaseUtil.getSmartvTable();
		Scan s = new Scan();
		s.addColumn(ColumnUtil.CF, ColumnUtil.FILENAME);
		s.addColumn(ColumnUtil.CF, ColumnUtil.KEYWORDCOUNTALL);
		ResultScanner scanner = table.getScanner(s);
		int repeat = 100;
		for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {
			System.out.println(rr);
			repeat--;
			if (repeat < 0) {
				break;
			}
		}
	}

	@Test
	public void put() {
		HTable table = HbaseUtil.getSmartvTable();
		RowLock lock;
		try {
			lock = table.lockRow("test".getBytes());
			Put p = new Put(TestMain.row.getBytes(), lock);
			p.add(HbaseUtil.HBASE_TABLE_FAMILY_SMARTV, ColumnUtil.FILENAME,
					"row2".getBytes());
			HbaseUtil.putSmartv(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
