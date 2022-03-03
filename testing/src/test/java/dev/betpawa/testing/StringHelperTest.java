package dev.betpawa.testing;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {
    StringHelper helper = new StringHelper();

    @Test
    public void testTruncateAInFirst2Position_AInFirst2Position(){
        assertEquals("CD", helper.truncateAInFirst2Position("AACD"));
    }

    @Test
    public void testTruncateAInFirst2Position_AInFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Position("ACD"));
    }

    @Test
    public void testTruncateAInFirst2Position_NoAInString() {
        assertEquals("CDEF", helper.truncateAInFirst2Position("CDEF"));
    }

    @Test
    public void testTruncateAInFirst2Position_AInLast2Position() {
        assertEquals("CDAA", helper.truncateAInFirst2Position("CDAA"));
    }

    //"ABCD" => false, AB => true, A => false
    @Test
    public void areFirstAndLast2CharactersTheSame_FourRandomChars() {
        assertFalse(StringHelper.areFirstAndLast2CharsTheSame("ABCD"));
    }

    @Test
    public void areFirstAndLast2CharactersTheSame_2Chars() {
        assertTrue(StringHelper.areFirstAndLast2CharsTheSame("AB"));
    }

    @Test
    public void areFirstAndLast2CharsTheSame_BasicPositiveCase() {
        assertTrue(StringHelper.areFirstAndLast2CharsTheSame("ABAB"));
    }

}