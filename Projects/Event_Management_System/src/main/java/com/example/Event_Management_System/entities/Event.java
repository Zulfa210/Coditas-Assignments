package com.example.Event_Management_System.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "event_details")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private long eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_Venue")
    private String eventVenue;

    @Column(name = "event_city")
    private String eventCity;

    @Column(name = "event_venue_capacity")
    private int eventVenueCapacity;

    @Column(name = "event_base_price")
    private float eventBasePrice;

    @Column(name = "price_per_person")
    private float pricePerPerson;



    @JsonIgnore
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_category_id")
   // @JsonIgnore
    private EventCategory eventCategory;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_organizer_id")
    private EventOrganizer eventOrganizer;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EventBooking> eventBookings = new ArrayList<>();


    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "rating")
    private float averageFeedbackRating = 0.0f;

    public Event(long eventId,
                 String eventName,
                 String eventVenue,
                 String eventCity,
                 int eventVenueCapacity,
                 float eventBasePrice,
                 float pricePerPerson,
                 boolean isDeleted) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventCity = eventCity;
        this.eventVenueCapacity = eventVenueCapacity;
        this.eventBasePrice = eventBasePrice;
        this.pricePerPerson = pricePerPerson;
        this.isDeleted = isDeleted;
    }
}




