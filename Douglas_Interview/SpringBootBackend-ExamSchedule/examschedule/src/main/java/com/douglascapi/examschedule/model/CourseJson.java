package com.douglascapi.examschedule.model;

import java.util.List;

public class CourseJson {
	private String Area;
    private String Course;
    private List<SectionJson> Sections;
    
    public CourseJson() {
		super();
	}
	public CourseJson(String area, String course, List<SectionJson> sections) {
		super();
		Area = area;
		Course = course;
		Sections = sections;
	}
	
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public List<SectionJson> getSections() {
		return Sections;
	}
	public void setSections(List<SectionJson> sections) {
		Sections = sections;
	}
    
    
}
