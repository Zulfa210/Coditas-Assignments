package com.example.Event_Management_System.service;

import com.example.Event_Management_System.entities.EventCategory;
import com.example.Event_Management_System.repository.EventCategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Zulfa Attar
 */
@SpringBootTest
class EventCategoryServiceImplementationTest {

    @InjectMocks
    private EventCategoryServiceImplementation eventCategoryService;

    @Mock
    private EventCategoryRepository eventCategoryRepository;

    @Test
    void insertEventCategory() {

    }

    @Test
    void getAllEventCategories() {
        List<EventCategory> categories = new ArrayList<>();
        categories.add(new EventCategory(1L, "Weddings", false));
        categories.add(new EventCategory(2L, "Parties", false));
        categories.add(new EventCategory(3L, "Birthdays", false));
        when(eventCategoryRepository.findAll()).thenReturn(categories);

        assertEquals(3, eventCategoryService.getAllEventCategories().size());

    }

    @Test
    void updateEventCategory() {
    }


    @Test
    void getEventCategoryById(){

        List<EventCategory> categories = new ArrayList<>();
        categories.add(new EventCategory(1L, "Weddings", false));
        categories.add(new EventCategory(2L, "Parties", false));
        categories.add(new EventCategory(3L, "Birthdays", false));
        when(eventCategoryRepository.findAll()).thenReturn(categories);
        System.out.println(eventCategoryService.getEventCategoryById(2));


        assertEquals(2, eventCategoryService.getEventCategoryById(2).getCategoryId());
    }


    @Test
    public void testAddCategory(){
        EventCategory eventCategory = new EventCategory
                (1L, "Weddings", false);
        when(eventCategoryRepository.save(eventCategory)).thenReturn(eventCategory);

        assertEquals(eventCategory,eventCategoryService.insertEventCategory(eventCategory));


    }

    @Test
    public void testDeleteEventCategory(){
        long countryId = 2L;

        EventCategory eventCategory = new EventCategory
                (countryId, "Weddings", false);
        when(eventCategoryRepository.findById(countryId)).thenReturn(Optional.of(eventCategory));
        when(eventCategoryRepository.save(eventCategory)).thenReturn(eventCategory);

        eventCategoryService.deleteEventCategory(countryId);
        verify(eventCategoryRepository, timeout(1)).save(eventCategory);
    }
}