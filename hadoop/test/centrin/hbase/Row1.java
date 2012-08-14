package centrin.hbase;

import java.io.IOException;

import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.RowLock;

import centrin.hbase.util.ColumnUtil;
import centrin.hbase.util.HbaseUtil;

public class Row1 implements Runnable {

	public Row1() {
		super();
	}

	public void run() {
		HTable table = HbaseUtil.getSmartvTable();
		try {
			RowLock lock = table.lockRow("test".getBytes());
			Put p = new Put(TestMain.row.getBytes(), lock);
			p.add(HbaseUtil.HBASE_TABLE_FAMILY_SMARTV, ColumnUtil.FILENAME, "row1".getBytes());
			System.out.println("row1 slpeep before ...");
			Thread.sleep(10000);
			table.put(p);
			table.unlockRow(lock);
			System.out.println("1111111111111");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
