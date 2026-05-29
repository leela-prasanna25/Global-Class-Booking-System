package com.bookings.classbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookings.classbooking.entity.Parent;
import com.bookings.classbooking.repository.ParentRepository;

@Service
public class ParentService {
	private final ParentRepository parentRepository;
	
	public ParentService(ParentRepository parentRepository)
	{
		this.parentRepository=parentRepository;
	}

	public Parent saveParent(Parent parent)
	{
	return parentRepository.save(parent);
	}
	
	public List<Parent> getAllParents()
	{
		return parentRepository.findAll();
	}
}

