package dev.betPawa.powermock;

import dev.betPawa.powermock.helper.UtilityClass;

import java.util.ArrayList;
import java.util.List;


public class SystemUnderTest {
    private Dependency dependency;

    public int methodUsingAnArrayListConstructor() {
        ArrayList list = new ArrayList();
        return list.size();
    }

    public int methodCallingAStaticMethod() {
        List<Integer> stats = dependency.retrieveAllStarts();
        long sum = 0;

        for (int stat: stats) {
            sum += stat;
        }
        return UtilityClass.staticMethod(sum);
    }

    private long privateMethodUnderTest() {
        List<Integer> stats = dependency.retrieveAllStarts();
        long sum = 0;
        for (int stat: stats) {
            sum += stat;
        }
        return sum;
    }
}

interface Dependency {
    List<Integer> retrieveAllStarts();
}
