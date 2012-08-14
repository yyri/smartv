package centrin.examples;

public class Article {
	public Article(){
	}
	public Article(int id, String content, String title) {
		this.setId(id);
		this.setContent(content);
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	String title;
	String content;

}
