package com.stackroute.thirdparty.model;

import java.util.Arrays;

public class NewsHead {

	@Override
	public String toString() {
		return "NewsHead [status=" + status + ", totalResults=" + totalResults + ", articles="
				+ Arrays.toString(articles) + "]";
	}
	String status;
	String totalResults;
	Article[] articles=new Article[50];
	
	
	
	public String getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Article[] getArticles() {
		return articles;
	}
	public void setArticles(Article[] articles) {
		this.articles = articles;
	}
	
	
}
