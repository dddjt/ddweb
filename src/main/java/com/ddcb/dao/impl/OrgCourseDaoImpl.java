package com.ddcb.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddcb.dao.IOrgCourseDao;
import com.ddcb.dao.IOrgDao;

@Repository("orgCourseDao")
public class OrgCourseDaoImpl implements IOrgCourseDao {

	private static final Logger logger = LoggerFactory
			.getLogger(OrgCourseDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addOrgCourse(Long orgId, Long courseId) {
		try{
			String sql= "insert into org_course(org_id, course_id) values (?,?)";
			int num = jdbcTemplate.update(sql, orgId, courseId);
			return num > 0;
		}catch(Exception e){
			logger.error("exception : {}", e.toString());
		}
		return false;
	}

	@Override
	public boolean deleteOrgCourse(Long courseId) {
		try{
			String sql= "delete from org_course where course_id = ?";
			int num = jdbcTemplate.update(sql, courseId);
			return num > 0;
		}catch(Exception e){
			logger.error("exception : {}", e.toString());
		}
		return false;
	}
}