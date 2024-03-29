package com.example.Event_Management_System.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Zulfa Attar
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventBookingDto {

    private Long bookingId;
    private String bookingStartDate;
    private String bookingEndDate;
    private int totalBookedSeats;
    private Long eventId;
    private Long customerId;
    public String eventTime;


}
