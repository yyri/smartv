package centrin.hbase;

import java.io.IOException;


public class TestMain {
	
	public static String row = "smartv_20120809105150937_fc9765c814a72aff932d58953e111222";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new Thread(new Row1()).start();
		new Thread(new Row2()).start();
	}

}
