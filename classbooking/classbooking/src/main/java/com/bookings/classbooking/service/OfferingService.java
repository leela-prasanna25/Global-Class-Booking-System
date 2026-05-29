package com.bookings.classbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookings.classbooking.entity.Offering;
import com.bookings.classbooking.repository.OfferingRepository;

@Service
public class OfferingService {
	
	private final OfferingRepository offeringRepository;
	
	public OfferingService(OfferingRepository offeringRepository)
	{
		this.offeringRepository=offeringRepository;
	}
	
	public Offering saveOffering(Offering offering)
	{
		return offeringRepository.save(offering);
	}
	
    public List<Offering> getAllOfferings()
    {
	  return offeringRepository.findAll();
    }

}
