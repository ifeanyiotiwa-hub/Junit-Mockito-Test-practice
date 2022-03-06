package dev.betPawa.powermock;

import dev.betPawa.powermock.helper.UtilityClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;



@PrepareForTest({UtilityClass.class})
@RunWith(PowerMockRunner.class)
public class SystemUnderTestTest {

    @Mock
    private Dependency dependency;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    @Test
    public void testStaticMethod() throws Exception {
        List<Integer> stats = Arrays.asList(1, 2, 3, 4, 5);
//        stub(dependency.retrieveAllStarts()).toReturn(stats);
        PowerMockito.mockStatic(UtilityClass.class);

        when(dependency.retrieveAllStarts()).thenReturn(stats);
        when(UtilityClass.staticMethod(6)).thenReturn(150);

        int result = systemUnderTest.methodCallingAStaticMethod();
        assertEquals(154, result);
    }

}