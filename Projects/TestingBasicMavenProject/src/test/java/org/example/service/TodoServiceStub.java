package org.example.service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class TodoServiceStub implements TodoService{
    @Override
    public List<String> retrieveTodos(String user) {
       // if(user.equalsIgnoreCase("User"))
        return Arrays.asList("Learn Spring", "Learn Spring Boot", "Learn to Dance");

//        else
//            return Arrays.asList();
    }
}
