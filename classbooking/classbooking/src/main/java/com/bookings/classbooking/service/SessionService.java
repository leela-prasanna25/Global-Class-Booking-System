package com.bookings.classbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookings.classbooking.entity.Session;
import com.bookings.classbooking.repository.SessionRepository;

@Service
public class SessionService {
	
	private final SessionRepository sessionRepository;
	
	public SessionService(SessionRepository sessionRepository)
	{
       this.sessionRepository = sessionRepository;
	}
	
	public Session saveSessions(Session session)
	{
		return sessionRepository.save(session);
	}
	
	public List<Session> getAllSessions()
	{
		return sessionRepository.findAll();
	}
}
