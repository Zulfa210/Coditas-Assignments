package com.example.Event_Management_System.controller;

import com.example.Event_Management_System.entities.Event;
import com.example.Event_Management_System.entities.EventBooking;
import com.example.Event_Management_System.entities.EventOrganizer;
import com.example.Event_Management_System.service.EventBookingService;
import com.example.Event_Management_System.service.EventOrganizerService;
import com.example.Event_Management_System.service.EventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Zulfa Attar
 */

@WebMvcTest(EventOrganizerController.class)
class EventOrganizerControllerMockMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private EventBookingService eventBookingService;

    @MockBean
    private EventService eventService;


    @Test
    void addEvent() throws Exception {
        Event event = new Event(1L, "Birthday Party",
                "SS Lawns", "Pune", 200,
                20000, 50, false );
        when(eventService.insertEvent(any())).thenReturn(event);

        ObjectMapper mapper = new ObjectMapper();
        String jsonObject = mapper.writeValueAsString(event);

        mockMvc.perform(MockMvcRequestBuilders.post("/eventOrganizer/insertEvent")
                        .content(jsonObject)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath(".eventId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath(".eventName").value(event.getEventName()))
                .andDo(print());

    }

    @Test
    void getEvents() throws Exception {
        Event event = new Event(1L, "Birthday Party",
                "SS Lawns", "Pune", 200,
                20000, 50, false );
        List<Event> events = new ArrayList<>();
        events.add(event);
        long eventOrganizerId = 2L;

        when(eventService.getEvents(eventOrganizerId)).thenReturn(events);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/eventOrganizer/getEvents/{eventOrganiserId}",eventOrganizerId))
                .andExpect(MockMvcResultMatchers.jsonPath(".eventId").exists())
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void acceptOrDeclineEventBooking() throws Exception {
        EventBooking eventBooking = new EventBooking();
        eventBooking.setBookingStatus("BOOKED");
        eventBooking.setBookingId(1L);
        eventBooking.setEventStartDate(Date.valueOf("2022-12-12"));
        eventBooking.setEventEndDate(Date.valueOf("2022-12-13"));
        eventBooking.setTotalPrice(201000f);
        eventBooking.setNumberOfGuests(500);

        when(eventBookingService.
                confirmBooking(anyLong() ,anyString())).thenReturn(eventBooking);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/eventOrganizer/updateBooking/{bookingStatus}/{bookingId}",
                        "BOOKED", 1L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(".bookingId").exists())
                .andDo(print());

    }

    @Test
    void postponeEventBooking() {
    }

    @Test
    void getBookingsByEventOrganiser() {
    }

    @Test
    void updateEvent() {
    }

    @Test
    void deleteEvent() {
    }
}