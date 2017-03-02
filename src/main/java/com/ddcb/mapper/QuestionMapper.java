package com.ddcb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ddcb.model.QuestionModel;

public class QuestionMapper implements RowMapper<QuestionModel> {
	public QuestionModel mapRow(ResultSet rs, int index) throws SQLException {
		QuestionModel u = new QuestionModel(rs.getLong("id"), rs.getString("user_id"), rs.getString("question"),
				rs.getInt("click_like"), rs.getLong("course_id"), rs.getString("user_name"), 
				rs.getString("create_time_readable"), rs.getInt("current_click_like"), rs.getTimestamp("create_time"));
		return u;
	}
}