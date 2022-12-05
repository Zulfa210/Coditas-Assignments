package com.example.Event_Management_System.controller;

import com.example.Event_Management_System.EventManagementSystemApplication;
import com.example.Event_Management_System.entities.Event;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.SequenceGenerators;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zulfa Attar
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = EventManagementSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EventOrganizerControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    HttpHeaders httpHeaders = new HttpHeaders();

    public String createUrlWithPort(String uri){
        return "http://localhost:" + port + uri;
    }

    @Test
    @Order(1)

    void addEvent() throws JSONException {
        Event event = new Event(1L, "Birthday Party",
                "SS Lawns", "Pune", 200,
                20000, 50, false );
        HttpEntity<Event> request = new HttpEntity<Event>(event, httpHeaders);

        ResponseEntity<String> response = restTemplate.
                exchange(createUrlWithPort("/eventOrganizer/insertEvent"),
                        HttpMethod.POST, request,String.class);

        String expectedBody = "{\"eventId\":1,\"eventName\":\"Birthday Party\"," +
                "\"eventVenue\":\"SS Lawns\",\"eventCity\":\"Pune\",\"eventVenueCapacity\":200," +
                "\"eventBasePrice\":20000.0,\"pricePerPerson\":50.0,\"eventCategory\":null," +
                "\"averageFeedbackRating\":0.0,\"deleted\":false}";

        System.out.println(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        JSONAssert.assertEquals(expectedBody,response.getBody(), false);

    }

    @Test
    @Order(2)
    @Sql(statements = "insert into event_organizer values(1, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'EVENT_ORGANIZER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person, event_organizer_id) " +
            "values (4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250, 1);", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getEvents() throws JSONException {

        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate
                .exchange(createUrlWithPort("/eventOrganizer/getEvents/1"),
                        HttpMethod.GET,request, String.class);
        String expectedBody = "[{\"eventId\":1,\"eventName\":\"Wedding\",\"eventVenue\":" +
                "\"JJ Lawns\",\"eventCity\":\"Pune\",\"eventVenueCapacity\":1000," +
                "\"eventBasePrice\":20000.0,\"pricePerPerson\":250.0,\"eventCategory\":null,\"averageFeedbackRating\":4.0,\"deleted\":false}]";

        System.out.println(response);
        assertEquals(200, response.getStatusCodeValue());
        JSONAssert.assertEquals(expectedBody,  response.getBody(), false);


    }

    @Test
    @Sql(statements = "insert into event_booking_details values (1, ",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void acceptOrDeclineEventBooking() {


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