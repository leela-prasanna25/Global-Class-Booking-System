package com.bookings.classbooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookings.classbooking.entity.Course;
import com.bookings.classbooking.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	private final CourseService courseService;
	
	public CourseController(CourseService courseService)
	{
		this.courseService=courseService;
	}
	
	@PostMapping
	public Course createCourse(@Valid @RequestBody Course course)
	{
		return courseService.saveCourse(course);
		
	}
	
	@GetMapping
	public List<Course> getAllCourses()
	{
		return courseService.getAllCourses();
	}
	

}
