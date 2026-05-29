package com.bookings.classbooking.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

@Service
public class TimeZoneService {

    public ZonedDateTime convertTime(
            LocalDateTime sessionTime,
            String teacherZone,
            String parentZone) {

        ZonedDateTime teacherTime =
                sessionTime.atZone(
                        ZoneId.of(teacherZone));

        return teacherTime.withZoneSameInstant(
                ZoneId.of(parentZone));
    }
}