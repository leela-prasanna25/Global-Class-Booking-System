package com.bookings.classbooking.dto;

public class SessionTimeDTO {

    private Long sessionId;
    private String parentStartTime;
    private String parentEndTime;

    public SessionTimeDTO(Long sessionId,
                          String parentStartTime,
                          String parentEndTime) {
        this.sessionId = sessionId;
        this.parentStartTime = parentStartTime;
        this.parentEndTime = parentEndTime;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public String getParentStartTime() {
        return parentStartTime;
    }

    public String getParentEndTime() {
        return parentEndTime;
    }
}