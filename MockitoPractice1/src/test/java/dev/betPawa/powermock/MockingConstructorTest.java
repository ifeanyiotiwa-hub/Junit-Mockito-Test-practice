package dev.betPawa.powermock;

import dev.betPawa.powermock.helper.UtilityClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;


@PrepareForTest({UtilityClass.class})
@RunWith(PowerMockRunner.class)
public class MockingConstructorTest {

    @Mock
    private ArrayList mockList;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    @Test
    public void testMockingConstructor() throws Exception {
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

        int size = systemUnderTest.methodUsingAnArrayListConstructor();

        assertNotEquals(1, size);
    }

}