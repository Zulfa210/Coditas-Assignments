package com.example.Event_Management_System.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zulfa Attar
 */
@Data
@NoArgsConstructor
public class EventDto {

    private long eventId;
    private String eventName;
    private String eventVenue;
    private String eventCity;
    private int eventVenueCapacity;
    public float eventBasePrice;
    public float pricePerPerson;
    private long eventCategory;
    private long eventOrganizer;

    public EventDto(long eventId, String eventName, String eventVenue, String eventCity, int eventVenueCapacity, float eventBasePrice, float pricePerPerson) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventCity = eventCity;
        this.eventVenueCapacity = eventVenueCapacity;
        this.eventBasePrice = eventBasePrice;
        this.pricePerPerson = pricePerPerson;
    }
}
