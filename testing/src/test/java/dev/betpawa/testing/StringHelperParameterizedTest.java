package dev.betpawa.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
    StringHelper helper = new StringHelper();

    private String input;
    private String expectedOutput;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testCondition() {

        String[][] expectedOutputs = {
                {"AACD", "CD"},
                {"ACD", "CD"}
        };

        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testTruncateAInFirst2Position() {
        assertEquals(expectedOutput, helper.truncateAInFirst2Position(input));
    }
}
