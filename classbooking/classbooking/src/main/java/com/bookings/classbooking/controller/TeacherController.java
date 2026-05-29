package com.bookings.classbooking.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookings.classbooking.entity.Teacher;
import com.bookings.classbooking.service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService)
	{
		this.teacherService=teacherService;
	}
	
	@PostMapping
	public Teacher createTeacher(@Valid @RequestBody Teacher teacher)
	{
		return teacherService.saveTeacher(teacher);
	}
	
	@GetMapping
	public List<Teacher> getAllTeachers()
	{
		return teacherService.getAllTeachers();
	}
}
