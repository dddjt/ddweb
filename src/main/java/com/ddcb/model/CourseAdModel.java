package com.ddcb.model;

import java.sql.Timestamp;

public class CourseAdModel {

	private Integer id;
	private String ad_link;
	private Timestamp update_time;
	private Timestamp create_time;
	
	public CourseAdModel() {}

	public CourseAdModel(Integer id, String ad_link, Timestamp update_time, Timestamp create_time) {
		super();
		this.id = id;
		this.ad_link = ad_link;
		this.update_time = update_time;
		this.create_time = create_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAd_link() {
		return ad_link;
	}

	public void setAd_link(String ad_link) {
		this.ad_link = ad_link;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	
}
