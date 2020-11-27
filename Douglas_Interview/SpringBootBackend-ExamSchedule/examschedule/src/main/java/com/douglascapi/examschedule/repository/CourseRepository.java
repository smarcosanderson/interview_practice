package com.douglascapi.examschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.douglascapi.examschedule.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
