package dev.betPawa.powermock.helper;

public class UtilityClass {
    public static int staticMethod(long sum) {
        throw new RuntimeException("I want to be mocked out.");
    }
}
