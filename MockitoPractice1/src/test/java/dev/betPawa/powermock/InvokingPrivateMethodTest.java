package dev.betPawa.powermock;

import dev.betPawa.powermock.helper.UtilityClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.*;


@RunWith(PowerMockRunner.class)
public class InvokingPrivateMethodTest {

    @Mock
    private Dependency dependency;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    @Test
    public void testPrivateMethod() throws Exception {
        List<Integer> stats = Arrays.asList(1, 2, 3, 4, 5);
        when(dependency.retrieveAllStarts()).thenReturn(stats);

//        long result = systemUnderTest.privateMethodUnderTest();
        long result = Whitebox.invokeMethod(systemUnderTest, "ivateMethodUnderTes");
        assertThat(result, is(10));
    }

}