package dev.betPawa.businessimpl;

import dev.betPawa.businessservice.TodoService;
import dev.betPawa.businessservice.stub.TodoServiceStub;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

	private TodoBusinessImpl todoBusinessImpl;

	@Before
	public void setup() {
		TodoService todoServiceMock = mock(TodoService.class);
		//Create a Mock
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		when(todoServiceMock.retrieveTodos("Dummy1")).thenReturn(List.of());
		when(todoServiceMock.retrieveTodos(null))
				.thenThrow(NullPointerException.class);

		todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

	}


	@Test
	public void testRetrieveTodosRelatedToSpring_RandomTest() {


		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(Arrays.asList("Learn Spring MVC", "Learn Spring"), filteredTodos);
	}


	@Test
	public void testRetrieveTodosRelatedToSpring_TestListSize() {


		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_forEmptyList() {



		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy1");

		assertEquals(Collections.emptyList(), filteredTodos);
	}


	@Test(expected = NullPointerException.class)
	public void testRetrieveTodosRelatedToSpring_shouldHandleNull() {

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring(null);
		assertEquals(List.of(), filteredTodos);
	}


}