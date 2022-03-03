package dev.betpawa.testing;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AssertTest {

    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }

    @Test
    public void testAssertEquals() {
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void testAssertFalse() {
        assertFalse("should be false", false);
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull("should not be null", new Object());
    }

    @Test
    public void testAssertNotSame() {
        assertNotSame("Should not be same", new Object(), new Object());
    }

    @Test
    public void testAssertNull() {
        assertNull("should be null", null);
    }

    @Test
    public void testAssertSame() {
        Integer aNumber = 768;
        assertSame("should be same", aNumber, aNumber);
    }

    @Test
    public void testThatBothContainsString() {
        assertThat("albumen", both(containsString("a")).and(containsString("b")));
    }

    @Test
    public void testAssertThatEveryItemContainsString() {
        assertThat(Arrays.asList("fun", "ban", "net"), everyItem(containsString("n")));
    }

    @Test
    public void testAssertHasItems() {
        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }


    @Test(timeout = 1600, expected = AssertionError.class)
    public void testEmptyListSize() {
        assertEquals(1, 0);
    }
}