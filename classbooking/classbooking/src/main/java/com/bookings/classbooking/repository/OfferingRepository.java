package com.bookings.classbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookings.classbooking.entity.Offering;

public interface OfferingRepository extends JpaRepository<Offering, Long> {

}
