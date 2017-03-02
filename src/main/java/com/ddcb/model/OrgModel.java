package com.ddcb.model;

public class OrgModel {

	private Long id;
	private String org_name;
	private String org_img;
	private String org_abstract;
		
	public OrgModel(){}

	public OrgModel(Long id, String org_name, String org_img, String org_abstract) {
		super();
		this.id = id;
		this.org_name = org_name;
		this.org_img = org_img;
		this.org_abstract = org_abstract;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getOrg_img() {
		return org_img;
	}

	public void setOrg_img(String org_img) {
		this.org_img = org_img;
	}

	public String getOrg_abstract() {
		return org_abstract;
	}

	public void setOrg_abstract(String org_abstract) {
		this.org_abstract = org_abstract;
	}
	
}
