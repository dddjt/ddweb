package com.ddcb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ddcb.model.CourseModel;
import com.ddcb.model.CourseWithOrgModel;

public class CourseWithOrgMapper implements RowMapper<CourseWithOrgModel> {
	public CourseWithOrgModel mapRow(ResultSet rs, int index) throws SQLException {
		CourseWithOrgModel u = new CourseWithOrgModel(rs.getLong("id"), rs.getString("name"), rs.getString("course_abstract"),
				rs.getString("teacher"), rs.getString("image"), rs.getTimestamp("course_date"), rs.getString("course_date_readable"), 
				rs.getString("course_time"), rs.getString("course_length"), rs.getTimestamp("create_time"), rs.getInt("course_type"),
				rs.getString("course_field"), rs.getString("course_industry"), rs.getString("course_competency"), rs.getString("price"), 
				rs.getInt("people_count"), rs.getInt("study_people_count"), rs.getInt("has_collection"),
				rs.getLong("parent_id"), rs.getString("course_grade"),rs.getString("org_name"), rs.getLong("org_id"));
		return u;
	}
}