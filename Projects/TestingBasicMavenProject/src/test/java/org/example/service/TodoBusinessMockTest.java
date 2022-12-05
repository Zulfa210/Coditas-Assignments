package org.example.service;

import org.example.business.TodoBusinessImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Zulfa Attar
 */
public class TodoBusinessMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingMock(){
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList(
                "Learn Spring", "Learn Spring MVC", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("User")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("User");
        assertEquals(2, filteredTodos.size());
    }
}
