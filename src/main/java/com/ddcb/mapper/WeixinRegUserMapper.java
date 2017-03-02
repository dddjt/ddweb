package com.ddcb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ddcb.model.WeixinRegUserModel;

public class WeixinRegUserMapper implements RowMapper<WeixinRegUserModel> {
	public WeixinRegUserModel mapRow(ResultSet rs, int index) throws SQLException {
		WeixinRegUserModel u = new WeixinRegUserModel(rs.getString("user_name"),
				rs.getString("user_phone"), rs.getString("create_time"), rs.getString("user_pwd"),
				rs.getString("school"), rs.getString("major"), rs.getString("grade"), rs.getString("country"));
		return u;
	}
}