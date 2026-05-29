package com.bookings.classbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.classbooking.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
