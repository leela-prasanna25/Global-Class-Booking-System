package com.bookings.classbooking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Session {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     private LocalDateTime startTime;
     private LocalDateTime endTime;
     
     @ManyToOne
     @JoinColumn(name="offering_id")
     private Offering offering;
     
     public Session()
     {
    	 
     }
     
     public Long getId() {
    	 return id;
     }
     
     public LocalDateTime getStartTime() {
		 return startTime;
	 }
     
     public LocalDateTime getEndTime() {
    	 return endTime;
     }
     
     public Offering getOffering()
     {
    	 return offering;
     }
     
     public void setStartTime(LocalDateTime startTime) {
		 this.startTime = startTime;
	 }
     
     public void setEndTime(LocalDateTime endTime) {
		 this.endTime = endTime;
	 }
	 
	 public void setOffering(Offering offering)
	 {
		 this.offering = offering;
	 }
	 

}
