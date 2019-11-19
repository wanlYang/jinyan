package com.topshow.entity;

public class Video {
	
	private Integer id;
	private String local;
	private String video_img;
	private String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideo_img() {
		return video_img;
	}
	public void setVideo_img(String video_img) {
		this.video_img = video_img;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", local=" + local + ", video_img=" + video_img + ", title=" + title + "]";
	}
	
}
