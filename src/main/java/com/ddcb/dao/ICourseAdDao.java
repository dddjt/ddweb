package com.ddcb.dao;

import com.ddcb.model.CourseAdModel;

public interface ICourseAdDao {

	public CourseAdModel getCourseAd();
	
	public boolean updateCourseAd(String adLink);
		
}