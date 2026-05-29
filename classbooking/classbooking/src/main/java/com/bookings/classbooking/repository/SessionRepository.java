package com.bookings.classbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.classbooking.entity.Session;

public interface SessionRepository extends JpaRepository<Session , Long> {
	List<Session> findByOfferingId(Long offeringId);

}
