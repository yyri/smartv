package centrin.examples;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

public class LuceneHelloWorld {
	public static void createIndexFile() {
		IndexWriter indexWriter = null;
		try {
			// ��Ҫ�ķִ���
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
			// ���������ĸ��汾��IndexWriterConfig
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
					Version.LUCENE_36, analyzer);
			// ����ϵͳ�ļ�----- ./ ��ǰ·���µ�
			Directory directory = new SimpleFSDirectory(new File("./indexDir/"));
			indexWriter = new IndexWriter(directory, indexWriterConfig);
			// ��ȡʵ�����
			Article article = new Article(11, "��XX�ĳ���", "XX");
			// indexWriter�������
			Document doc = new Document();
			// �ı���������� ���� ����
			/*
			 * doc.add(new Field("title","�й����׶�������",Store.YES,Index.ANALYZED));
			 * doc.add(new
			 * Field("content","�й����׶��ڱ���",Store.YES,Index.ANALYZED));
			 */
			doc.add(new Field("id", article.getId().toString(), Store.YES,
					Index.ANALYZED));
			doc.add(new Field("title", article.getTitle().toString(),
					Store.YES, Index.ANALYZED));
			doc.add(new Field("content", article.getContent().toString(),
					Store.YES, Index.ANALYZED));
			// ��ӵ�������ȥ
			indexWriter.addDocument(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (indexWriter != null) {
				try {
					indexWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// �����ѯ����Ҫ�õ����������ǽ���������ʹ���ʱ�Ľ�������ͬ
	public static void searchIndexFileResult() throws IOException {
		List<Article> articles = new ArrayList<Article>();
		// �õ�������Ŀ¼
		Directory directory = new SimpleFSDirectory(new File("./indexDir/"));
		// ����Ŀ¼��һ��indexReader
		IndexReader indexReader = IndexReader.open(directory);
		// System.out.println(indexReader.maxDoc());
		// ��ȡ��Сֵ��document����
		// Document doc=indexReader.document(0);
		// ��ȡ���ֵ��document����
		// Document doc=indexReader.document(indexReader.maxDoc()-1);
		// document�����get(�ֶ�����)������ȡ�ֶε�ֵ
		/*
		 * System.out.println(doc.get("id"));
		 * System.out.println(doc.get("title"));
		 * System.out.println(doc.get("content"));
		 */
		int n = indexReader.maxDoc();
		for (int i = 0; i < n; i++) {
			Document doc = indexReader.document(i);
			Article article = new Article();
			if (doc.get("id") == null) {
				System.out.println("idΪ��");
			} else {
				article.setId(Integer.parseInt(doc.get("id")));
				article.setTitle(doc.get("title"));
				article.setContent(doc.get("content"));
				articles.add(article);
			}
		}
		for (Article article : articles) {
			System.out.println(article.toString());
			System.out.println(article.getId());
		}
	}

	public static void main(String[] args) throws IOException {
		// ����Ҫ�������ļ�
		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		createIndexFile();
		end = System.currentTimeMillis();
		System.out.println("Indexing Cost " + (end - start) + " ms");
		// �������ļ��в�ѯ����
		start = System.currentTimeMillis();
		searchIndexFileResult();
		end = System.currentTimeMillis();
		System.out.println("Search Cost " + (end - start) + " ms");
		// ��ý����Ȼ�������Ӧ�ó�����
	}
}
