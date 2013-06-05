package org.webtrue.core.model;

public class Article extends CommonModel {
	private String title;
	private String content;
	private String authorUid;

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

}
