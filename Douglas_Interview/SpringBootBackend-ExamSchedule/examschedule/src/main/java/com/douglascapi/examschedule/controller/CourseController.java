package com.douglascapi.examschedule.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.douglascapi.examschedule.model.Course;
import com.douglascapi.examschedule.model.CourseList;
import com.douglascapi.examschedule.service.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/")
public class CourseController {
	
	@Autowired
	CourseService courseService;

	//@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	
	@GetMapping("/examDates")
	public ResponseEntity<CourseList> getDates() throws JsonMappingException, JsonProcessingException, URISyntaxException{
		
		String json  = restTemplate.getForObject("https://douglascaapi.azurewebsites.net/courses/", String.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		CourseList result = mapper.readValue(json, CourseList.class);
		return new ResponseEntity<CourseList>(result, HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> get(){
		List<Course> courses = courseService.findAll();
		ResponseEntity<List<Course>> result = new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
		return result;
	}
}
