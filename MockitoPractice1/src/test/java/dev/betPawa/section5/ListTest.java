package dev.betPawa.section5;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

public class ListTest {

	@Test
	public void shouldTestSizeMethodOfListInterfaces() {
		var listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);

		assertEquals(2, listMock.size());
	}

	@Test
	public void shouldTestSizeMethodOfListInterfaces_ReturnsCorrectSizeMultipleValues() {
		var listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);

		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	public void shouldTestNonStubbedMethod_ShouldReturnDefaults() {
		var listMock = mock(List.class);
		when(listMock.get(2)).thenReturn(2);

		assertNull(listMock.get(3));
		assertEquals(2, listMock.get(2));
	}


	@Test
	public void shouldTestGetMethod_TestWithAnyInt() {
		var listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("betPawa Senior Dev");

		assertEquals("betPawa Senior Dev", listMock.get(2));
		assertEquals("betPawa Senior Dev", listMock.get(1));
	}



	@Test(expected = RuntimeException.class)
	public void test() {
		var listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException());
		var t = listMock.get(5);
	}

	@Test(expected = RuntimeException.class)
	public void test2() {
		List listMock = mock(List.class);
		when(listMock.subList(anyInt(), 2)).thenThrow(new RuntimeException());
		listMock.get(0);
	}


	@Test
	public void shouldTestGetMethod_UsingBDD() {
		//Given
		var listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("betPawa Senior Dev");
		//When is the actual value listMock.get(2)

		//Then
		assertThat(listMock.get(2), is("betPawa Senior Dev"));
	}
}
