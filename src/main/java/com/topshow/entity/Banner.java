package com.topshow.entity;

public class Banner {
	
	private Integer id;
	
	private String imgLocal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImgLocal() {
		return imgLocal;
	}

	public void setImgLocal(String imgLocal) {
		this.imgLocal = imgLocal;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", imgLocal=" + imgLocal + "]";
	}
	
	

}
