package dev.betpawa.testing.classtotest;


import dev.betpawa.testing.AssertTest;
import dev.betpawa.testing.StringHelper;
import dev.betpawa.testing.StringHelperParameterizedTest;
import dev.betpawa.testing.StringHelperTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({AssertTest.class, StringHelperTest.class, StringHelperParameterizedTest.class})
public class SampleTestSuiteUsage {
}
