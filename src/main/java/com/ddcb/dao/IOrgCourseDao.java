package com.ddcb.dao;

public interface IOrgCourseDao {
	
	public boolean addOrgCourse(Long orgId, Long courseId);
	
	public boolean deleteOrgCourse(Long courseId);
	
}