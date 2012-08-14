package centrin.hbase;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.RowLock;

import centrin.hbase.util.ColumnUtil;
import centrin.hbase.util.HbaseUtil;

public class Row2 implements Runnable {

	public Row2() {
		super();
	}

	public void run() {
		HTable table = HbaseUtil.getSmartvTable();
		try {
			Thread.sleep(1000);
			System.out.println("row2 begin ...");
			Get g = new Get(TestMain.row.getBytes());
			Result r = table.get(g);
			byte[] x = r.getValue(HbaseUtil.HBASE_TABLE_FAMILY_SMARTV, ColumnUtil.FILENAME);
			if (x == null) {
				System.out.println("kong");
			} else {
				System.out.println(HbaseUtil.bytesToStr(x));
			}
			System.out.println("row2 get value ...");
			RowLock lock = table.lockRow("test".getBytes());
			Put p = new Put(TestMain.row.getBytes(), lock);
			p.add(HbaseUtil.HBASE_TABLE_FAMILY_SMARTV, ColumnUtil.FILENAME, "row2"
					.getBytes());
			table.put(p);
			table.unlockRow(lock);
			System.out.println("222222222");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
