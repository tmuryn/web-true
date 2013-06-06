package org.webtrue.core.model;

public class Authorship extends CommonModel {
	private String authorEmail;
	private String articleUid;

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getArticleUid() {
		return articleUid;
	}

	public void setArticleUid(String articleUid) {
		this.articleUid = articleUid;
	}

}
