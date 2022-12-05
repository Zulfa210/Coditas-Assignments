package org.example.service;

import junit.framework.TestCase;
import org.example.business.TodoBusinessImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public class TodoServiceStubTest extends TestCase {

    public void testRetrieveTodos() {
    }

    @Test
    public void test(){
        TodoService todoServiceStub  = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceStub);

        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("User");
        assertEquals(true,filteredTodos.contains("Learn Spring"));
        assertEquals(true,filteredTodos.contains("Learn Spring Boot"));
        assertEquals(false, filteredTodos.contains("Learn to Dance"));
    }
}