package com.topshow.entity;

public class About {
	
	private Integer id;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "About [id=" + id + ", content=" + content + "]";
	}
	
}
