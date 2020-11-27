package com.douglascapi.examschedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglascapi.examschedule.model.Course;
import com.douglascapi.examschedule.repository.CourseRepository;

@Service
public class CouseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	
}
