package com.example.Event_Management_System.controller;

import com.example.Event_Management_System.EventManagementSystemApplication;
import com.example.Event_Management_System.entities.EventBooking;
import com.example.Event_Management_System.model.dto.EventBookingDto;
import com.example.Event_Management_System.model.dto.FeedbackDto;
import org.json.JSONException;
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

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zulfa Attar
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = EventManagementSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    HttpHeaders httpHeaders = new HttpHeaders();

    public String createUrlWithPort(String uri){
        return "http://localhost:" + port + uri;
    }

    @Order(1)
    @Test
    @Sql(statements = "insert into event_organizer values(24, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'EVENT_ORGANIZER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person, event_organizer_id) " +
            "values (34, 4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250, 24);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into customer_details values (14, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'CUSTOMER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void addEventBooking() {
        EventBookingDto eventBookingDto = new EventBookingDto(
                3L, "2022-12-14", "2022-12-15", 200,
                34L, 14L, "10:30:00");

        HttpEntity<EventBookingDto> request = new HttpEntity<>(eventBookingDto, httpHeaders);

        ResponseEntity<String> response = restTemplate
                .exchange(createUrlWithPort("/customer/addEventBooking"),
                        HttpMethod.POST, request,String.class);
        System.out.println(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Order(2)
    @Test
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (35, 4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250);", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_organizer values(25, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'EVENT_ORGANIZER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into customer_details values (15, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'CUSTOMER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_booking_details values (16, 'PENDING','2022-12-12', '2022-12-13', '12:10',200 ,200000, 15, 35, 25);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void cancelEventBooking() {

    }

    @Order(3)
    @Test
    void getBookingsByCustomer() {

    }

    @Order(4)
    @Test
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (61, 4, 200000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (62, 4, 150000, 'Pune', 'Party', 'JJ Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (63, 4, 20000, 'Pune', 'Funeral', 'JJ Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void filterByEventPrice() {

        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                createUrlWithPort("/customer/filterByPrice/150000/200000"),
                HttpMethod.GET, request, String.class);

        String expectedBody = "[{\"eventId\":61,\"eventName\":\"Wedding\",\"eventVenue\":" +
                "\"JJ Lawns\",\"eventCity\":\"Pune\",\"eventVenueCapacity\":1000," +
                "\"eventBasePrice\":200000.0,\"pricePerPerson\":250.0,\"eventCategory\":null," +
                "\"averageFeedbackRating\":4.0,\"deleted\":false},{\"eventId\":62,\"eventName\":\"Party\"," +
                "\"eventVenue\":\"JJ Lawns\",\"eventCity\":\"Pune\",\"eventVenueCapacity\":1000," +
                "\"eventBasePrice\":150000.0,\"pricePerPerson\":250.0,\"eventCategory\":null," +
                "\"averageFeedbackRating\":4.0,\"deleted\":false}]";

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedBody, response.getBody());
        System.out.println(response);
    }

    @Order(5)
    @Test
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (64, 4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (65, 4.7, 15000, 'Pune', 'Party', 'JJ Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (66, 4.8, 2000, 'Pune', 'Funeral', 'JJ Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void filterByRating() throws JSONException {
        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                createUrlWithPort("/customer/filterByRating/4.6"),
                HttpMethod.GET, request, String.class);

        String expectedBody = "[{\"eventId\":65,\"eventName\":\"Party\",\"eventVenue\":\"JJ Lawns\"," +
                "\"eventCity\":\"Pune\",\"eventVenueCapacity\":1000,\"eventBasePrice\":15000.0,\"pricePerPerson" +
                "\":250.0,\"eventCategory\":null,\"averageFeedbackRating\":4.7,\"deleted\":false},{\"eventId" +
                "\":66,\"eventName\":\"Funeral\",\"eventVenue\":\"JJ Lawns\",\"eventCity\":\"Pune\"," +
                "\"eventVenueCapacity\":1000,\"eventBasePrice\":2000.0,\"pricePerPerson\":250.0,\"eventCategory" +
                "\":null,\"averageFeedbackRating\":4.8,\"deleted\":false}]";

        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expectedBody, response.getBody(), false);
        System.out.println(response);

    }

    @Order(6)
    @Test
    @Sql(statements = "insert into event_category values (30, 'Marriage', false);",
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person, event_category_id) " +
            "values (67, 4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250, 30);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person, event_category_id) " +
            "values (68, 4, 15000, 'Pune', 'Party', 'JJ Lawns', 1000, false, 250, 30);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (69, 4, 2000, 'Pune', 'Funeral', 'JJ Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void filterByEventCategory() throws JSONException {

        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                createUrlWithPort("/customer/getEvents/Marriage"),
                HttpMethod.GET, request, String.class);

        String expectedBody = "[{\"eventId\":67,\"eventName\":\"Wedding\",\"eventVenue\":\"JJ Lawns\"," +
                "\"eventCity\":\"Pune\",\"eventVenueCapacity\":1000,\"eventBasePrice\":20000.0,\"pricePerPerson" +
                "\":250.0,\"eventCategory\":{\"categoryId\":30,\"categoryName\":\"Marriage\",\"deleted\":false}," +
                "\"averageFeedbackRating\":4.0,\"deleted\":false},{\"eventId\":68,\"eventName\":\"Party\"," +
                "\"eventVenue\":\"JJ Lawns\",\"eventCity\":\"Pune\",\"eventVenueCapacity\":1000,\"eventBasePrice" +
                "\":15000.0,\"pricePerPerson\":250.0,\"eventCategory\":{\"categoryId\":30,\"categoryName\":" +
                "\"Marriage\",\"deleted\":false},\"averageFeedbackRating\":4.0,\"deleted\":false}]";

        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expectedBody, response.getBody(), false);
        System.out.println(response);

    }

    @Order(7)
    @Test
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (79, 4, 2000, 'Pune', 'Funeral', 'JJ Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into customer_details values (75, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'CUSTOMER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void addCustomerFeedback() throws JSONException {

        FeedbackDto feedbackDto = new FeedbackDto("Excellent Service", 4.5f, 79l, 75l);
        HttpEntity<FeedbackDto> request = new HttpEntity<>(feedbackDto, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createUrlWithPort("/customer/giveFeedback"), HttpMethod.POST, request,String.class);
        System.out.println(response);

        String expectedBody = "{\"feedbackId\":1,\"feedbackComment\":\"Excellent Service\",\"feedbackRating\":4.5}";
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        JSONAssert.assertEquals(expectedBody, response.getBody(), false);

    }

    @Order(8)
    @Test
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (54, 4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250);",
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (96, 4, 20000, 'Pune', 'Party', 'SS Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_details(event_id, rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (56, 4, 20000, 'Pune', 'Funeral', 'SK Lawns', 1000, false, 250);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getAllEvents() {

        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                createUrlWithPort("/customer/getEvents"), HttpMethod.GET, request,String.class);
        System.out.println(response);
        assertEquals(HttpStatus.OK ,response.getStatusCode());
    }

    @Order(9)
    @Test
    @Sql(statements = "insert into customer_details values (58, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'CUSTOMER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void updateCustomerDetails() {
        HttpEntity<>
    }

    @Order(10)
    @Test
    @Sql(statements = "insert into customer_details values (85, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'CUSTOMER');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void changePassword() {

    }
}