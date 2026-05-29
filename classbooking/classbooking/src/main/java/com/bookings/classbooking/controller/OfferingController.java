package com.bookings.classbooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookings.classbooking.entity.Offering;
import com.bookings.classbooking.service.OfferingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/offerings")
public class OfferingController {
	
	private final OfferingService offeringService;
	
	public OfferingController(OfferingService offeringService)
	{
		this.offeringService=offeringService;
	}
	
	@PostMapping
	public Offering createOffering(@Valid @RequestBody Offering offering)
	{
		return offeringService.saveOffering(offering);
	}
	
	@GetMapping
	public List<Offering> getAllOfferings()
	{
		return offeringService.getAllOfferings();
	}

}
