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
//        if ("Dummy1".equals(user)) {
//            return List.of();
//        }
        List<String> todos = todoService.retrieveTodos(user);

        return todos.stream().filter(todo -> todo.contains("Spring"))
                                                   .collect(Collectors.toUnmodifiableList());
    }
}
