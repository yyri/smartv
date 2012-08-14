package centrin;

import static org.junit.Assert.*;

import org.junit.Test;

public class LuceneServiceTest {

	String docsPath = "E:\\workspace\\hadoop\\hadoop\\test\\org\\apache\\lucene\\demo\\test-files\\docs";
	String indexPath1 = "E:\\workspace\\hadoop\\hadoop\\test\\org\\apache\\lucene\\demo\\test-files\\index1";
	String indexPath2 = "E:\\workspace\\hadoop\\hadoop\\test\\org\\apache\\lucene\\demo\\test-files\\index2";

	@Test
	public void testIndexDocs() {
		LuceneService.indexFiles("", docsPath, "content", indexPath1, true);
	}

	@Test
	public void testSearchDocs() throws Exception {
		int repeat = 10;
		while (repeat > 0) {
			LuceneService.search("GPL", "contents", 20, indexPath1, false);
			LuceneService.search("Linux", "contents", 20, indexPath1, false);
			LuceneService.search("Kernel", "contents", 20, indexPath1, false);
			LuceneService.search("Version", "contents", 20, indexPath1, false);
			LuceneService.search("中国人民币", "contents", 20, indexPath1, true);
			LuceneService.search("said", "contents", 20, indexPath1, true);
			LuceneService.search("SaaS", "contents", 20, indexPath1, true);
			repeat--;
		}
	}

	@Test
	public void testIndexAndSearchKws() throws Exception {
		String field = "kw";
		String field2 = "content";
		boolean newIndex = false;
		int repeat = 1000;

		if (newIndex) {
			LuceneService.indexKws("a.mp3", "你好", "亲爱的顾客你好，让你久等了", field,
					indexPath2, false);
			LuceneService.indexKws("b.mp3", "hello",
					"waiting...hello dear, i am waiting for you", field,
					indexPath2, false);
			LuceneService.indexKws("c.mp3", "你好", "亲爱的顾客你好，让你久等了", field2,
					indexPath2, false);
			LuceneService.indexKws("d.mp3", "hello",
					"waiting...hello dear, i am waiting for you", field2,
					indexPath2, false);
		}

		while (repeat > 0) {
			LuceneService.searchKws("你好", field, 20, indexPath2, true);
			LuceneService.searchKws("hello", field, 20, indexPath2, true);
			LuceneService.searchKws("你好", field2, 20, indexPath2, true);
			LuceneService.searchKws("hello", field2, 20, indexPath2, true);
			repeat--;
		}
	}

}
