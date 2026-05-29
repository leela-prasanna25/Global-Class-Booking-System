package com.bookings.classbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Parent parent;
	
	@ManyToOne
	@JoinColumn(name="offering_id")
	private Offering offering;
	
	public Booking() {
	}
	
	public Long getId() {
		return id;
	}
	
	public Parent getParent() {
		return parent;
	}
	
	public Offering getOffering() {
		return offering;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	public void setOffering(Offering offering) {
		this.offering = offering;
	}
	
    
}
