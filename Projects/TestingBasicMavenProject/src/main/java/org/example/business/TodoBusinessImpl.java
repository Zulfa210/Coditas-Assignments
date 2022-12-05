package org.example.business;

import org.example.service.TodoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class TodoBusinessImpl {

    public TodoService todoService;

    public TodoBusinessImpl() {
    }

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user){
        List<String> filteredTools = new ArrayList<>();

        List<String> todos = todoService.retrieveTodos(user);
        for(String todo: todos){
            if(todo.contains("Spring")) {
                filteredTools.add(todo);
            }
        }
        return filteredTools;
    }
}
