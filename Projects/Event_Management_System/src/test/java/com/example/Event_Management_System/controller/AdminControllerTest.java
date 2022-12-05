package com.example.Event_Management_System.controller;

import com.example.Event_Management_System.entities.Event;
import com.example.Event_Management_System.entities.EventCategory;
import com.example.Event_Management_System.service.EventCategoryService;
import com.example.Event_Management_System.service.EventService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author Zulfa Attar
 */
@SpringBootTest(classes = {AdminControllerTest.class})
class AdminControllerTest {

    @Mock
    EventCategoryService eventCategoryService;

    @Mock
    EventService eventService;

    @InjectMocks
    AdminController adminController;

    List<EventCategory> eventCategories;
    EventCategory eventCategory;

    @Test
    void getEventCategory() {
        eventCategories = new ArrayList<>();
        eventCategories.add(new EventCategory(1L, "Weddings", false));
        eventCategories.add(new EventCategory(2L, "Parties", false));
        eventCategories.add(new EventCategory(3L, "Birthdays", false));

        when(eventCategoryService.getAllEventCategories()).thenReturn(eventCategories);

        ResponseEntity res = adminController.getEventCategory();
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(res.getBody(), eventCategories);
    }

    @Test
    void getEventCategoryById() {
        eventCategory = new EventCategory(1L, "Wedding", false);
        long categoryId = 1L;
        when(eventCategoryService.getEventCategoryById(categoryId)).thenReturn(eventCategory);

        ResponseEntity<EventCategory> res = adminController.getEventCategoryById(categoryId);
        assertEquals(HttpStatus.FOUND,res.getStatusCode());
        assertEquals(res.getBody(), eventCategory);
    }

    @Test
    void insertEventCategory() {

        eventCategory = new EventCategory(1L, "Parties", false);
        when(eventCategoryService.insertEventCategory(eventCategory)).
                thenReturn(eventCategory);

        ResponseEntity response = adminController.insertEventCategory(eventCategory);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(eventCategory, response.getBody());


    }

    @Test
    void updateEventCategory() {
        eventCategory = new EventCategory(1L, "Parties", false);

        when(eventCategoryService.updateEventCategory(eventCategory)).
                thenReturn(eventCategory);

        ResponseEntity response  = adminController.updateEventCategory(eventCategory);
        assertEquals(Optional.of(eventCategory), response.getBody());
        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    @Test
    void deleteEventCategory() {

        long countryId = 3L;
        ResponseEntity response = adminController.deleteEventCategory(countryId);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void getAllEvents() {
        Event event = new Event(1L, "Birthday Party",
                "SS Lawns", "Pune", 200,
                20000, 50, false );
        List<Event> events = new ArrayList<>();
        events.add(event);

        when(eventService.getAllEvents()).thenReturn(events);
        ResponseEntity response = adminController.getAllEvents();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(events,  response.getBody());

    }

    @Test
    void getAllEventOrganizer() {


    }

    @Test
    void getCustomers() {
    }
}