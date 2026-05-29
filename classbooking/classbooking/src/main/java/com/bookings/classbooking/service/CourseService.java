package com.bookings.classbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookings.classbooking.entity.Course;
import com.bookings.classbooking.repository.CourseRepository;

@Service
public class CourseService {
	
	private final CourseRepository courseRepository;
	
	public CourseService(CourseRepository courseRepository)
	{
      this.courseRepository = courseRepository;
	}
	
	public Course saveCourse(Course course)
	{
		return courseRepository.save(course);
	}
	
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}
}
