package com.topshow.entity;

import java.util.Date;

public class News {
	
	private Integer id;
	private String title;
	private String img;
	private Date release_time;
	private Integer browse_volume;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}
	public Integer getBrowse_volume() {
		return browse_volume;
	}
	public void setBrowse_volume(Integer browse_volume) {
		this.browse_volume = browse_volume;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", img=" + img + ", release_time=" + release_time
				+ ", browse_volume=" + browse_volume + ", content=" + content + "]";
	}
	

}
