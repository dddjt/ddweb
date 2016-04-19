package com.ddcb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ddcb.model.CourseAdModel;

public class CourseAdMapper implements RowMapper<CourseAdModel> {
	public CourseAdModel mapRow(ResultSet rs, int index) throws SQLException {
		CourseAdModel u = new CourseAdModel(rs.getInt("id"), rs.getString("ad_link"), 
				rs.getTimestamp("update_time"), rs.getTimestamp("create_time"));
		return u;
	}
}