package com.ddcb.model;

import java.sql.Timestamp;

public class QuestionModel {

	private Long id;
	private String user_id;
	private String question;
	private Integer click_like;
	private Long course_id;
	private String user_name;
	private String create_time_readable;
	private Integer current_click_like;
	private Timestamp create_time;
	
	public QuestionModel() {}

	public QuestionModel(Long id, String user_id, String question, Integer click_like, Long course_id,
			String user_name, String create_time_readable, Integer current_click_like, Timestamp create_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.question = question;
		this.click_like = click_like;
		this.course_id = course_id;
		this.create_time_readable = create_time_readable;
		this.create_time = create_time;
		this.current_click_like = current_click_like;
		this.user_name = user_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getClick_like() {
		return click_like;
	}

	public void setClick_like(Integer click_like) {
		this.click_like = click_like;
	}

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public String getCreate_time_readable() {
		return create_time_readable;
	}

	public void setCreate_time_readable(String create_time_readable) {
		this.create_time_readable = create_time_readable;
	}

	public Integer getCurrent_click_like() {
		return current_click_like;
	}

	public void setCurrent_click_like(Integer current_click_like) {
		this.current_click_like = current_click_like;
	}
	
}