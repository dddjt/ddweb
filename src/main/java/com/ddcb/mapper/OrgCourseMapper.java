package com.ddcb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ddcb.model.OrgCourseModel;

public class OrgCourseMapper implements RowMapper<OrgCourseModel> {
	public OrgCourseModel mapRow(ResultSet rs, int index) throws SQLException {
		OrgCourseModel u = new OrgCourseModel(rs.getLong("id"), rs.getLong("org_id"), rs.getLong("course_id"));
		return u;
	}
}