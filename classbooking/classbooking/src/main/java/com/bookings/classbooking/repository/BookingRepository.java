package com.bookings.classbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.classbooking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	List<Booking> findByParentId(Long parentId);
}

