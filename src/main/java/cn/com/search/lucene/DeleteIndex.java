package cn.com.search.lucene;

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.core.IKAnalyzer5x;

public class DeleteIndex {
	public static void main(String[] args) {
		String indexDir = "D:\\lucene";
		Directory dir;
		try {
			dir = FSDirectory.open(Paths.get(indexDir));
			// 标准分词器
			Analyzer analyzer = new IKAnalyzer5x();
			IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
			IndexWriter writer = new IndexWriter(dir, iwc);
			writer.deleteAll();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
