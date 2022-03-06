package dev.betPawa.mockito;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;


public class SpyTest {

	@Test
	public void test() {
		List arrayListMock = mock(ArrayList.class);
		stub(arrayListMock.size()).toReturn(5);
	}

	@Test
	public void testSpy() {
		List arrayListSpy = spy(ArrayList.class);
		stub(arrayListSpy.size()).toReturn(5);
		assertThat(arrayListSpy.size(), is(5));
	}

	@Test
	public void testSpy2() {
		List arrayListSpy = spy(ArrayList.class);
		stub(arrayListSpy.size()).toReturn(5);
		arrayListSpy.add("t");
		verify(arrayListSpy, never()).remove("t");
	}

	@Test
	public void testSpy3() {
		String stringMock = mock(String.class);
		stringMock.contains("e");
		verify(stringMock, never()).length();
	}



}
