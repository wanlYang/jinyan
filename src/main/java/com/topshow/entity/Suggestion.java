package com.topshow.entity;

public class Suggestion {

	private Integer id;
	private String username;
	private String phone;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Suggestion [id=" + id + ", username=" + username + ", phone=" + phone + ", content=" + content + "]";
	}
	
	
}
