package dev.betPawa.businessservice.stub;

import dev.betPawa.businessservice.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
	}

	@Override
	public void deleteTodos(String todo) {

	}

	@Override
	public void countTodos(String todo) {

	}

	@Override
	public void countTodos2() {

	}
}
