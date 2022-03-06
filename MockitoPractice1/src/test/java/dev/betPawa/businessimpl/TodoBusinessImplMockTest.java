package dev.betPawa.businessimpl;

import dev.betPawa.businessservice.TodoService;
import dev.betPawa.businessservice.stub.TodoServiceStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;

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


	@Test
	public void testRetrieveTodosRelatedToSpring_UsingBDD() {

		//GIVEN
		TodoService todoServiceMock = mock(TodoService.class);
		//Create a Mock
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);


		//WHEN
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		//THEN
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_UsingBDD() {

		//GIVEN
		TodoService todoServiceMock = mock(TodoService.class);
		//Create a Mock
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);


		//WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		//THEN
		verify(todoServiceMock).deleteTodos("Learn To Dance");
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring2_UsingBDD() {

		//GIVEN
		TodoService todoServiceMock = mock(TodoService.class);
		//Create a Mock
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);


		//WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		//THEN
		verify(todoServiceMock, never()).deleteTodos("Learn Spring");
	}


	@Test
	public void testCountRelatedToSpring_UsingBDD() {
		//GIVEN
		TodoService todoServiceMock = mock(TodoService.class);
		//Create a Mock
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);


		//WHEN
		todoBusinessImpl.countTodosRelatedToSpring("Dummy");

		//THEN
		verify(todoServiceMock, atLeast(0)).countTodos("Learn Spring");
	}



	@Test
	public void testCountRelatedToSpring2_UsingBDD() {

		//GIVEN
		TodoService todoServiceMock = mock(TodoService.class);
		//Create a Mock
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);


		//WHEN
		todoBusinessImpl.countTodosRelatedToSpring("Dummy");

		//THEN
		verify(todoServiceMock,  times(2)).countTodos2();
	}

	@Test
	public void testCountRelatedToSpring2_UsingArgumentCaptor() {

		//GIVEN
		TodoService todoServiceMock = mock(TodoService.class);
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		//Create a Mock
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);


		//WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		//THEN
		then(todoServiceMock).should().deleteTodos(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getValue(), is("Learn To Dance"));
//		verify(todoServiceMock,  times(2)).countTodos2();
	}

	@Test
	public void testCountRelatedToSpring2_UsingArgumentCaptorMultipleTimes() {

		//GIVEN
		TodoService todoServiceMock = mock(TodoService.class);
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		//Create a Mock
		List<String> todos = Arrays.asList("Learn Github", "Learn Spring", "Learn To Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);


		//WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		//THEN
		then(todoServiceMock).should(times(2)).deleteTodos(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getAllValues(), is(List.of("Learn Github", "Learn To Dance")) );
//		verify(todoServiceMock,  times(2)).countTodos2();
	}
}