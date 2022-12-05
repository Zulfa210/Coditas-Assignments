package com.example.Event_Management_System.controller;

import com.example.Event_Management_System.entities.Customer;
import com.example.Event_Management_System.entities.Event;
import com.example.Event_Management_System.entities.EventCategory;
import com.example.Event_Management_System.entities.EventOrganizer;
import com.example.Event_Management_System.service.CustomerService;
import com.example.Event_Management_System.service.EventCategoryService;
import com.example.Event_Management_System.service.EventOrganizerService;
import com.example.Event_Management_System.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Zulfa Attar
 */

@ComponentScan(basePackages = "com.example.Event_Management_System")
@SpringBootTest(classes = {AdminControllerMockMvcTest.class})
@ContextConfiguration
@AutoConfigureMockMvc
  //  @WebMvcTest(AdminController.class)
class AdminControllerMockMvcTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    EventCategoryService eventCategoryService;

    @Mock
    EventService eventService;

    @Mock
    EventOrganizerService eventOrganizerService;

    @Mock
    CustomerService customerService;

    @InjectMocks
    AdminController adminController;

//    @MockBean
//    EventCategoryService eventCategoryService;
//
//    @MockBean
//    EventService eventService;
//
//    @MockBean
//    EventOrganizerService eventOrganizerService;
//
//    @MockBean
//    CustomerService customerService;




    EventCategory eventCategory;
    List<EventCategory> eventCategories;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }


    @Test
    void getEventCategory() throws Exception {

        eventCategories = new ArrayList<>();
        eventCategories.add(new EventCategory(1L, "Weddings", false));
        eventCategories.add(new EventCategory(2L, "Parties", false));
        eventCategories.add(new EventCategory(3L, "Birthdays", false));


        when(eventCategoryService.getAllEventCategories()).thenReturn(eventCategories);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/admin/getEventCategories").
                        accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpectAll(MockMvcResultMatchers.jsonPath(".categoryId").exists())
                .andDo(print());

    }

    @Test
    void getEventCategoryById() throws Exception {
        eventCategory = new EventCategory(2L, "Birthday Party", false);
        when(eventCategoryService.getEventCategoryById(2L)).thenReturn(eventCategory);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/admin/getEventCategoryById")
                        .param("categoryId", "2"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.jsonPath(".categoryId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath(".categoryName").value("Birthday Party"))
                .andExpect(MockMvcResultMatchers.jsonPath(".deleted").value(false))
                .andDo(print());
    }

    @Test
    void insertEventCategory() throws Exception {

        eventCategory = new EventCategory(2L, "Birthday Party", false);
        when(eventCategoryService.insertEventCategory(eventCategory)).thenReturn(eventCategory);

        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(eventCategory);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/admin/insertEventCategory")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }


    @Test
    void updateEventCategory() throws Exception {
        eventCategory = new EventCategory(2L, "Birthday Party", false);
        when(eventCategoryService.updateEventCategory(eventCategory)).thenReturn(eventCategory);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(eventCategory);


        this.mockMvc.perform(MockMvcRequestBuilders.put("/admin/updateEventCategory")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(".categoryId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath(".categoryName").value("Birthday Party"))
                .andExpect(MockMvcResultMatchers.jsonPath(".deleted").value(false))
                .andDo(print());
    }

    @Test
    void deleteEventCategory() throws Exception {
        eventCategory = new EventCategory(2L, "Birthday Party", false);

        this.mockMvc.perform(MockMvcRequestBuilders.delete(
                "/admin/deleteEventCategory/{eventCategoryId}",
                        eventCategory.getCategoryId()))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getAllEvents() throws Exception {
        Event event = new Event(1L, "Birthday Party",
                "SS Lawns", "Pune", 200,
                20000, 50, false );
        List<Event> events = new ArrayList<>();
        events.add(event);

        when(eventService.getAllEvents()).thenReturn(events);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/admin/getEvents"))
                .andExpect(MockMvcResultMatchers.jsonPath(".eventId").exists())
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void getAllEventOrganizers() throws Exception {

        EventOrganizer eventOrganizer = new EventOrganizer();
        eventOrganizer.setEventOrganizerName("Zulfa");
        eventOrganizer.setEventOrganizerEmail("zulfa@gmail.com");
        eventOrganizer.setEventOrganizerId(1L);
        eventOrganizer.setEventOrganizerPhone(927218100L);

        List<EventOrganizer> eventOrganizers = new ArrayList<>();
        eventOrganizers.add(eventOrganizer);

        when(eventOrganizerService.getAllEventOrganizers()).thenReturn(eventOrganizers);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/admin/getEventOrganizers"))
                .andExpect(MockMvcResultMatchers.jsonPath(".eventOrganizerId").exists())
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void getCustomers() throws Exception {

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerName("Zulfa");
        customer.setCustomerEmail("zulfa@gmail.com");
        customer.setCustomerPhoneNo(918291100L);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);

        when(customerService.getAllCustomers()).thenReturn(customers);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/admin/getCustomers"))
                .andExpect(MockMvcResultMatchers.jsonPath(".customerId").exists())
                .andExpect(status().isOk())
                .andDo(print());
    }
}