package com.bookings.classbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.classbooking.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
