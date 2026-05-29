package com.bookings.classbooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookings.classbooking.entity.Booking;
import com.bookings.classbooking.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	private final BookingService bookingService;
	
	public BookingController(BookingService bookingService)
	{
		this.bookingService=bookingService;
	}
	
	@PostMapping
	public Booking createBooking(@RequestBody Booking booking)
	{
		return bookingService.saveBooking(booking);
		
	}
	
	@GetMapping
	public List<Booking> getAllBookings()
	{
		return bookingService.getAllBookings();
	}

}
