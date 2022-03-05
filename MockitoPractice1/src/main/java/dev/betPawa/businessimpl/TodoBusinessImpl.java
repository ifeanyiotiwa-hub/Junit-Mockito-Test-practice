package dev.betPawa.businessimpl;

import dev.betPawa.businessservice.TodoService;

import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoBusinessImpl {
    private final TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {

        if (user == null) {
            throw new NullPointerException();
        }
        List<String> todos = todoService.retrieveTodos(user);

        return todos.stream().filter(todo -> todo.contains("Spring"))
                                                   .collect(Collectors.toUnmodifiableList());
    }


    public void deleteTodosNotRelatedToSpring(String user) {

        List<String> todos = todoService.retrieveTodos(user);

        todos.forEach(todo -> {
            if (!todo.contains("Spring")) {
                todoService.deleteTodos(todo);
            }
        });
    }

    public void countTodosRelatedToSpring(String user) {

        List<String> todos = todoService.retrieveTodos(user);
        int count = 0;
        todos.forEach(todo -> {
            if (todo.contains("Spring")) {
                todoService.countTodos2();
            }
        });
    }

    public void countTodosRelatedToSpring2(String user) {

        List<String> todos = todoService.retrieveTodos(user);
        int count = 0;
        todos.forEach(todo -> {
            if (todo.contains("Spring")) {
                todoService.countTodos2();
            }
        });
    }
}
