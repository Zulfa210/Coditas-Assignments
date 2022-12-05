package com.example.Event_Management_System.controller;

import com.example.Event_Management_System.EventManagementSystemApplication;
import com.example.Event_Management_System.entities.Event;
import com.example.Event_Management_System.entities.EventCategory;
import org.json.JSONException;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Zulfa Attar
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ComponentScan(basePackages = "com.example.Event_Management_System")
@SpringBootTest(classes = EventManagementSystemApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class AdminControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    HttpHeaders httpHeaders = new HttpHeaders();

    private String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }

    @Test
    @Order(1)
    @Sql(statements = "insert into event_category values (1, 'Party', false)",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "insert into event_category values (2, 'Wedding', false);",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getEventCategory() throws  JSONException {
        HttpEntity<EventCategory> entity = new HttpEntity<EventCategory>(null, httpHeaders);

        //URI url = new URI("http://localhost:" + port + "/admin/getEventCategories");
        String expected = "[{\"categoryId\":1,\"categoryName\":\"Party\",\"deleted\":false},{\"categoryId\":2,\"categoryName\":\"Wedding\",\"deleted\":false}]";


        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/admin/getEventCategories"),HttpMethod.GET, entity, String.class);
        assertEquals(200, response.getStatusCodeValue());
        System.out.println(response);

        JSONAssert.assertEquals(expected, response.getBody(),false);
    }

    @Test
    @Order(2)
    @Sql(statements = "insert into event_category values (3, 'Funeral', false)",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getEventCategoryById() throws JSONException {
        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/admin/getEventCategoryById?categoryId=3"),HttpMethod.GET, request, String.class);

        String expected = "{\"categoryId\":3,\"categoryName\":\"Funeral\",\"deleted\":false}";
        System.out.println(response);
        assertEquals(302, response.getStatusCodeValue());
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    @Order(3)
    void insertEventCategory() throws JSONException {

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        EventCategory eventCategory = new EventCategory(4, "Birthday Party", false);
        HttpEntity<EventCategory> request = new HttpEntity<>(eventCategory, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/admin/insertEventCategory"), HttpMethod.POST, request, String.class);

        String expected = "{\"categoryId\":4,\"categoryName\":\"Birthday Party\",\"deleted\":false}";

        System.out.println(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        JSONAssert.assertEquals(expected, response.getBody(),false);

    }

    @Test
    @Order(5)
    @Sql(statements = "insert into event_category values (5 , 'New Party', false)",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void updateEventCategory() throws JSONException {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        EventCategory eventCategory = new EventCategory(5, "New Birthday Party", false);
        HttpEntity<EventCategory> request = new HttpEntity<>(eventCategory, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/admin/updateEventCategory"), HttpMethod.PUT, request, String.class);

        String expected = "{\"categoryId\":5,\"categoryName\":\"New Birthday Party\",\"deleted\":false}";

        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, response.getBody(),false);

    }

    @Test
    @Order(6)
    @Sql(statements = "insert into event_category values (6, 'Wedding', false)",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void deleteEventCategory() throws JSONException {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(null,httpHeaders);
        String expected = "{\"categoryId\":6,\"categoryName\":\"Wedding\",\"deleted\":true}";

        ResponseEntity<String> response = restTemplate.
                exchange(createURLWithPort("/admin/deleteEventCategory/6"), HttpMethod.DELETE, httpEntity, String.class);

        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, response.getBody(),false);
    }

    @Test
    @Order(7)
    @Sql(statements = "insert into event_details(rating, event_base_price, event_city," +
            " event_name, event_venue, event_venue_capacity, is_deleted, price_per_person) " +
            "values (4, 20000, 'Pune', 'Wedding', 'JJ Lawns', 1000, false, 250);", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getAllEvents() throws JSONException {

        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/admin/getEvents"),HttpMethod.GET, request, String.class);

        String expected = "[{\"eventId\":1,\"eventName\":\"Wedding\",\"eventVenue\":" +
                "\"JJ Lawns\",\"eventCity\":\"Pune\",\"eventVenueCapacity\":1000," +
                "\"eventBasePrice\":20000.0,\"pricePerPerson\":250.0,\"eventCategory\":null,\"averageFeedbackRating\":4.0,\"deleted\":false}]";
        System.out.println(response);
        assertEquals(200, response.getStatusCodeValue());
        JSONAssert.assertEquals(expected, response.getBody(), false);


    }

    @Test
    @Order(8)
    @Sql(statements = "insert into event_organizer values(1, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'EVENT_ORGANIZER');",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getAllEventOrganizer() throws JSONException {

        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/admin/getEventOrganizers"),
                HttpMethod.GET,
                request,
                String.class );

        String expected = "[{\"eventOrganizerId\":1,\"eventOrganizerName\":\"Zulfa\"," +
                "\"eventOrganizerEmail\":\"zulfa@gmail.com\",\"eventOrganizerPhone\":9287366123," +
                "\"events\":[],\"bookings\":[],\"role\":\"EVENT_ORGANIZER\",\"deleted\":false}]";
        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, response.getBody(), true);

    }

    @Test
    @Order(9)
    @Sql(statements = "insert into customer_details values (1, 'zulfa@gmail.com', 'Zulfa', '9287366123', false, 'CUSTOMER');",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getCustomers() throws JSONException {


        HttpEntity<String> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/admin/getCustomers"),
                HttpMethod.GET,
                request,
                String.class );

        String expected = "[{\"customerId\":1,\"customerName\":\"Zulfa\"," +
                "\"customerEmail\":\"zulfa@gmail.com\",\"customerPhoneNo\":9287366123," +
                "\"feedbacks\":[],\"eventBookings\":[],\"role\":\"CUSTOMER\",\"deleted\":false}]";
        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }
}