package com.ddcb.dao.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddcb.dao.ICourseAdDao;
import com.ddcb.mapper.CourseAdMapper;
import com.ddcb.model.CourseAdModel;

@Repository("courseAdDao")
public class CourseAdDaoImpl implements ICourseAdDao {

	private static final Logger logger = LoggerFactory
			.getLogger(CourseAdDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public CourseAdModel getCourseAd() {
		CourseAdModel cam = null;
		try {
			String sql = "select * from course_ad";
			cam = jdbcTemplate.queryForObject(sql, new CourseAdMapper());
		} catch (Exception e) {
			logger.error("exception : {}", e.toString());
		}
		return cam;
	}

	@Override
	public boolean updateCourseAd(String adLink) {
		String sql = "update course_ad set ad_link=?, update_time=? where id=1";
		int affectedRows = 0;
		try {
			affectedRows = jdbcTemplate.update(sql, adLink, new Timestamp(System.currentTimeMillis()));
		} catch(Exception ex) {
			logger.error(ex.toString());
		}
		return affectedRows != 0;
	}	
}