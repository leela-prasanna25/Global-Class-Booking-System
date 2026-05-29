package com.bookings.classbooking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookings.classbooking.entity.Booking;
import com.bookings.classbooking.entity.Session;
import com.bookings.classbooking.exception.BookingConflictException;
import com.bookings.classbooking.repository.BookingRepository;
import com.bookings.classbooking.repository.SessionRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SessionRepository sessionRepository;

    public BookingService(BookingRepository bookingRepository,
                          SessionRepository sessionRepository) {
        this.bookingRepository = bookingRepository;
        this.sessionRepository = sessionRepository;
    }

    
    @Transactional
    public synchronized Booking saveBooking(Booking booking) {
    	
    	 Long parentId = booking.getParent().getId();

         List<Booking> existingBookings =
                 bookingRepository.findByParentId(parentId);

         List<Session> newOfferingSessions =
                 sessionRepository.findByOfferingId(
                         booking.getOffering().getId());

         for (Booking existingBooking : existingBookings) {

             if (existingBooking.getOffering() == null) {
                 continue;
             }

             List<Session> existingSessions =
                     sessionRepository.findByOfferingId(
                             existingBooking.getOffering().getId());

             for (Session existingSession : existingSessions) {

                 for (Session newSession : newOfferingSessions) {

                     LocalDateTime existingStart =
                             existingSession.getStartTime();

                     LocalDateTime existingEnd =
                             existingSession.getEndTime();

                     LocalDateTime newStart =
                             newSession.getStartTime();

                     LocalDateTime newEnd =
                             newSession.getEndTime();

                     boolean overlap =
                             existingStart.isBefore(newEnd)
                             &&
                             newStart.isBefore(existingEnd);

                     if (overlap) {
                         throw new BookingConflictException(
                                 "Booking conflict detected");
                     }
                 }
             }
         }

         return bookingRepository.save(booking);
    	
    }
    

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}