package com.douglascapi.examschedule.model;

import java.util.List;


public class CourseList {
	private List<CourseJson> Courses;

	public CourseList() {
		super();
	}

	public List<CourseJson> getCourses() {
		return Courses;
	}

	public void setCourses(List<CourseJson> courses) {
		Courses = courses;
	}	
	
}