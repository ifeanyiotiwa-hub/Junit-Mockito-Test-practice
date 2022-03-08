package dev.betPawa.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
//import static org.powermock.api.mockito.PowerMockito.when;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class UtilsTest {

    @Test
    public void testStaticMethodPrint() {
        PowerMockito.mockStatic(Utils.class);
        when(Utils.print("Hello")).thenReturn(true);
        when(Utils.print("Wrong Message")).thenReturn(false);

        assertTrue(Utils.print("Hello"));
        assertFalse(Utils.print("Wrong Message"));

        PowerMockito.verifyStatic(Utils.class, atLeast(2));
        Utils.print(anyString());
    }

}