package com.ddcb.model;

public class WeixinRegUserModel {

	private long id;
	private String user_name;
	private String user_phone;
	private String create_time;
	private String user_pwd;
	private String school;
	private String major;
	private String grade;
	private String country;
	
	public WeixinRegUserModel() {}
	
	public WeixinRegUserModel(String user_name, String user_phone, String create_time, String user_pwd, String school,
			String major, String grade, String country) {
		super();
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.create_time = create_time;
		this.user_pwd = user_pwd;
		this.school = school;
		this.major = major;
		this.grade = grade;
		this.country = country;
	}

	public WeixinRegUserModel(String user_name, String user_phone, String create_time, String user_pwd) {
		super();
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.create_time = create_time;
		this.user_pwd = user_pwd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "WeixinRegUserModel [id=" + id + ", user_name=" + user_name + ", user_phone=" + user_phone
				+ ", create_time=" + create_time + ", user_pwd=" + user_pwd + ", school=" + school + ", major=" + major
				+ ", grade=" + grade + ", country=" + country + "]";
	}
}
