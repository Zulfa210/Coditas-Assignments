package com.example.Event_Management_System.controller;

import com.example.Event_Management_System.EventManagementSystemApplication;
import com.example.Event_Management_System.entities.Event;
import com.example.Event_Management_System.model.dto.EventBookingDto;
import com.example.Event_Management_System.model.dto.EventDto;
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

import java.sql.Date;
import java.sql.Time;

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
//        Event event = new Event(1L, "Birthday Party",
//                "SS Lawns", "Pune", 200,
//                20000, 50, false );

        EventDto event = new EventDto(10L, "Birthday Party",
                "SS Lawns", "Pune", 200,
                20000, 50);
        HttpEntity<EventDto> request = new HttpEntity<EventDto>(event, httpHeaders);

        ResponseEntity<String> response = restTemplate.
                exchange(createUrlWithPort("/eventOrganizer/insertEvent"),
                        HttpMethod.POST, request,String.class);

        String expectedBody = "{\"eventId\":2,\"eventName\":\"Birthday Party\"," +
                "\"eventVenue\":\"SS Lawns\",\"eventCity\":\"Pune\",\"eventVenueCapacity\":200," +
                "\"eventBasePrice\":20000.0,\"pricePerPerson\":50.0,\"eventCategory\":null," +
                "\"averageFeedbackRating\":0.0,\"deleted\":false}";

        System.out.println(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        JSONAssert.assertEquals(expectedBody,response.getBody(), false);
    }

    @Test
    @Order(2)
    @Sql(statements = "insert into event_organizer values(11, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'EVENT_ORGANIZER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person, event_organizer_id) " +
            "values (22, 4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250, 11);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getEvents() throws JSONException {

        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate
                .exchange(createUrlWithPort("/eventOrganizer/getEvents/11"),
                        HttpMethod.GET,request, String.class);
        String expectedBody = "[{\"eventId\":22,\"eventName\":\"Wedding\",\"eventVenue\":" +
                "\"JJ Lawns\",\"eventCity\":\"Pune\",\"eventVenueCapacity\":1000," +
                "\"eventBasePrice\":20000.0,\"pricePerPerson\":250.0,\"eventCategory\":null,\"averageFeedbackRating\":4.0,\"deleted\":false}]";

        System.out.println(response);
        assertEquals(200, response.getStatusCodeValue());
        JSONAssert.assertEquals(expectedBody,  response.getBody(), false);


    }

    @Test
    @Order(3)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (35, 4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250);", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_organizer values(25, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'EVENT_ORGANIZER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into customer_details values (15, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'CUSTOMER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_booking_details values (16, 'PENDING','2022-12-12', '2022-12-13', '12:10',200 ,200000, 15, 35, 25);",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void acceptOrDeclineEventBooking() throws JSONException {

        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate
                .exchange(createUrlWithPort("/eventOrganizer/updateBooking/ACCEPTED/16"),
                        HttpMethod.PUT, request, String.class);
        System.out.println(response);
        String expectedBody = "{\"bookingId\":16,\"eventTime\":\"12:10:00\",\"eventStartDate\":" +
                "\"2022-12-13\",\"eventEndDate\":\"2022-12-12\",\"totalPrice\":200000.0,\"" +
                "numberOfGuests\":200,\"bookingStatus\":\"ACCEPTED\"}";
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expectedBody, response.getBody(), false);

    }

    @Test
    @Order(4)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (4, 4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250);", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_organizer values(3, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'EVENT_ORGANIZER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into customer_details values (2, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'CUSTOMER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_booking_details values (2, 'ACCEPTED','2022-12-12', '2022-12-13', '12:10',200 ,200000, 2, 4, 3);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void postponeEventBooking() throws JSONException {
        EventBookingDto eventBookingDto = new EventBookingDto(
                2L, "2022-12-12", "2022-12-12",
                500, 4L,2L, "12:30");
        HttpEntity<EventBookingDto> request = new HttpEntity<>(eventBookingDto, httpHeaders);
        ResponseEntity<String> response = restTemplate
                .exchange(createUrlWithPort("/eventOrganizer/postponeBooking"),
                        HttpMethod.PUT, request, String.class);
        System.out.println(response);
        String expectedBody = "{\"bookingId\":2,\"eventTime\":\"12:10:00\",\"eventStartDate\"" +
                ":\"2022-12-12\",\"eventEndDate\":\"2022-12-12\",\"totalPrice\":200000.0," +
                "\"numberOfGuests\":200,\"bookingStatus\":\"pending\"}";
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expectedBody, response.getBody(), false);

    }

    @Test
    @Order(5)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (5, 4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 400, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_organizer values(4, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'EVENT_ORGANIZER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into customer_details values (3, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'CUSTOMER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_booking_details values (3, 'ACCEPTED','2022-12-12', '2022-12-13', '12:10',250 ,200000, 3, 5, 4);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_booking_details values (4, 'ACCEPTED','2022-12-14', '2022-12-15', '12:30',300 ,200000, 3, 5, 4);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getBookingsByEventOrganiser() throws JSONException {

        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate
                .exchange(createUrlWithPort("/eventOrganizer/getEventBookings/4"),
                        HttpMethod.GET, request, String.class);
        System.out.println(response);
        String expectedBody = "[{\"bookingId\":3,\"eventTime\":\"12:10:00\",\"eventStartDate\":" +
                "\"2022-12-13\",\"eventEndDate\":\"2022-12-12\",\"totalPrice\":200000.0,\"numberOfGuests" +
                "\":250,\"bookingStatus\":\"ACCEPTED\"},{\"bookingId\":4,\"eventTime\":\"12:30:00\"," +
                "\"eventStartDate\":\"2022-12-15\",\"eventEndDate\":\"2022-12-14\",\"totalPrice\":200000.0," +
                "\"numberOfGuests\":300,\"bookingStatus\":\"ACCEPTED\"}]";
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expectedBody, response.getBody(), false);
    }

    @Test
    @Order(6)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (6, 4, 20000, 'Pune', 'Party', 'SS Lawns', 400, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void updateEvent() throws JSONException {

        EventDto event = new EventDto(6L, "Birthday Party",
                "SS Lawns", "Pune", 400,
                20000, 250);
        HttpEntity<EventDto> request = new HttpEntity<EventDto>(event, httpHeaders);

        ResponseEntity<String> response = restTemplate.
                exchange(createUrlWithPort("/eventOrganizer/updateEvent"),
                        HttpMethod.PUT, request,String.class);

        String expectedBody = "{\"eventId\":6,\"eventName\":\"Birthday Party\",\"eventVenue\":" +
                "\"SS Lawns\",\"eventCity\":\"Pune\",\"eventVenueCapacity\":400,\"eventBasePrice\"" +
                ":20000.0,\"pricePerPerson\":250.0,\"eventCategory\":null,\"averageFeedbackRating\":4.0," +
                "\"deleted\":false}";

        System.out.println(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        JSONAssert.assertEquals(expectedBody,response.getBody(), false);
    }

    @Test
    @Order(7)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (7, 4, 20000, 'Pune', 'Party', 'SS Lawns', 400, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void deleteEvent() {
        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate
                .exchange(createUrlWithPort("/eventOrganizer/deleteEvent/6"), HttpMethod.DELETE, request, String.class);
        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}