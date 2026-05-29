package com.bookings.classbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookings.classbooking.entity.Teacher;
import com.bookings.classbooking.repository.TeacherRepository;

@Service
public class TeacherService {
	
	private final TeacherRepository teacherRepository;
	
	public TeacherService(TeacherRepository teacherRepository)
	{
		this.teacherRepository=teacherRepository;
	}
	
	public Teacher saveTeacher(Teacher teacher)
	{
		return teacherRepository.save(teacher);
	}
	
	public List<Teacher> getAllTeachers()
	{
		return teacherRepository.findAll();
	}

}
