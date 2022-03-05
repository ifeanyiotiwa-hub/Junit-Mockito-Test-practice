package dev.betPawa.businessimpl;

import dev.betPawa.businessservice.TodoService;
import dev.betPawa.businessservice.stub.TodoServiceStub;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplStubTest {


	@Test
	public void testRetrieveTodosRelatedToSpring_RandomTest() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(Arrays.asList("Learn Spring MVC", "Learn Spring"), filteredTodos);
	}


	@Test
	public void testRetrieveTodosRelatedToSpring_TestListSize() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_forEmptyList() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy1");

		assertEquals(Collections.emptyList(), filteredTodos);
	}


	@Test(expected = NullPointerException.class)
	public void testRetrieveTodosRelatedToSpring_shouldHandleNull() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring(null);
		assertEquals(List.of(), filteredTodos);
	}


}