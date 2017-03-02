package com.ddcb.model;

public class OrgCourseModel {

	private Long id;
	private Long org_id;
	private Long course_id;
		
	public OrgCourseModel(){}

	public OrgCourseModel(Long id, Long org_id, Long course_id) {
		super();
		this.id = id;
		this.org_id = org_id;
		this.course_id = course_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Long org_id) {
		this.org_id = org_id;
	}

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	
}
