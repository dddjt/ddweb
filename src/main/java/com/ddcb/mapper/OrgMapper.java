package com.ddcb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ddcb.model.OrgModel;

public class OrgMapper implements RowMapper<OrgModel> {
	public OrgModel mapRow(ResultSet rs, int index) throws SQLException {
		OrgModel u = new OrgModel(rs.getLong("id"), rs.getString("org_name"), rs.getString("org_img"),
				rs.getString("org_abstract"));
		return u;
	}
}