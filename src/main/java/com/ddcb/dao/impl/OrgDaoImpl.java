package com.ddcb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.ddcb.dao.ICourseDao;
import com.ddcb.dao.IOrgDao;
import com.ddcb.mapper.CourseMapper;
import com.ddcb.mapper.LiveClassApplyMapper;
import com.ddcb.mapper.LiveClassShareMapper;
import com.ddcb.mapper.LiveCourseMapper;
import com.ddcb.mapper.OrgMapper;
import com.ddcb.mapper.SelectCourseMapper;
import com.ddcb.mapper.UserMapper;
import com.ddcb.model.CourseModel;
import com.ddcb.model.LiveClassApplyModel;
import com.ddcb.model.LiveCourseModel;
import com.ddcb.model.LiveCourseShareModel;
import com.ddcb.model.OrgModel;
import com.ddcb.model.SelectCourseModel;
import com.ddcb.model.UserModel;

@Repository("orgDao")
public class OrgDaoImpl implements IOrgDao {

	private static final Logger logger = LoggerFactory
			.getLogger(OrgDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addOrg(String orgName, String orgImg, String org_abstract) {
		try{
			String sql= "insert into org(org_name, org_img, org_abstract) values (?,?,?)";
			int num = jdbcTemplate.update(sql, orgName, orgImg, org_abstract);
			return num > 0;
		}catch(Exception e){
			logger.error("exception : {}", e.toString());
		}
		return false;
	}
	
	@Override
	public boolean delOrgById(Long id) {
		try{
			String sql= "delete from org where id=?";
			int num = jdbcTemplate.update(sql, id);
			return num > 0;
		}catch(Exception e){
			logger.error("exception : {}", e.toString());
		}
		return false;
	}

	@Override
	public List<OrgModel> getAllOrg() {
		List<OrgModel> list = null;
		try {
			String sql = "select * from org";
			list = jdbcTemplate.query(sql, new RowMapperResultSetExtractor<OrgModel>(
							new OrgMapper()));
		} catch (Exception e) {
			logger.error("exception : {}", e.toString());
		}
		return list;
	}
}