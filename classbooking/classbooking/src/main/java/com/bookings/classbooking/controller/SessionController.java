package com.bookings.classbooking.controller;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bookings.classbooking.dto.SessionTimeDTO;
import com.bookings.classbooking.entity.Booking;
import com.bookings.classbooking.entity.Offering;
import com.bookings.classbooking.entity.Parent;
import com.bookings.classbooking.entity.Session;
import com.bookings.classbooking.repository.BookingRepository;
import com.bookings.classbooking.repository.ParentRepository;
import com.bookings.classbooking.repository.SessionRepository;
import com.bookings.classbooking.service.SessionService;
import com.bookings.classbooking.service.TimeZoneService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;
    private final BookingRepository bookingRepository;
    private final ParentRepository parentRepository;
    private final SessionRepository sessionRepository;
    private final TimeZoneService timeZoneService;

    public SessionController(
            SessionService sessionService,
            BookingRepository bookingRepository,
            ParentRepository parentRepository,
            SessionRepository sessionRepository,
            TimeZoneService timeZoneService) {

        this.sessionService = sessionService;
        this.bookingRepository = bookingRepository;
        this.parentRepository = parentRepository;
        this.sessionRepository = sessionRepository;
        this.timeZoneService = timeZoneService;
    }

    @PostMapping
    public Session createSession(
    		@Valid @RequestBody Session session) {

        return sessionService.saveSessions(session);
    }

    @GetMapping
    public List<Session> getAllSessions() {

        return sessionService.getAllSessions();
    }

    @GetMapping("/parent/{parentId}")
    public List<SessionTimeDTO> getSessionsForParent(
            @PathVariable Long parentId) {

        Parent parent =
                parentRepository.findById(parentId)
                        .orElseThrow();

        String parentZone =
                parent.getTimezone();

        List<Booking> bookings =
                bookingRepository.findByParentId(parentId);

        List<SessionTimeDTO> response =
                new ArrayList<>();

        for (Booking booking : bookings) {

            Offering offering =
                    booking.getOffering();

            String teacherZone =
                    offering.getTeacher()
                            .getTimezone();

            List<Session> sessions =
                    sessionRepository.findByOfferingId(
                            offering.getId());

            for (Session session : sessions) {

                ZonedDateTime start =
                        timeZoneService.convertTime(
                                session.getStartTime(),
                                teacherZone,
                                parentZone);

                ZonedDateTime end =
                        timeZoneService.convertTime(
                                session.getEndTime(),
                                teacherZone,
                                parentZone);

                response.add(
                        new SessionTimeDTO(
                                session.getId(),
                                start.toString(),
                                end.toString()));
            }
        }

        return response;
    }
}