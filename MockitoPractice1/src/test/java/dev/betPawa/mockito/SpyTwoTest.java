package dev.betPawa.mockito;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTwoTest {

    @Test
    public void test(){
        List arrayListMock = mock(ArrayList.class);
        when(arrayListMock.size()).thenReturn(0);
        assertEquals(arrayListMock.size(), 0);


    }
}
