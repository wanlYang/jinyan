package com.topshow.entity;

public class Cources {
	
	private Integer id;
	private String tableImg;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTableImg() {
		return tableImg;
	}
	public void setTableImg(String tableImg) {
		this.tableImg = tableImg;
	}
	@Override
	public String toString() {
		return "Cources [id=" + id + ", tableImg=" + tableImg + "]";
	}
	
	

}
