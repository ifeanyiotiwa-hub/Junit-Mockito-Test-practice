package dev.betPawa.businessservice;

import java.util.List;

public interface TodoService {
    List<String> retrieveTodos(String user);
    void deleteTodos(String todos);

    void countTodos(String todo);
    void countTodos2();

}
