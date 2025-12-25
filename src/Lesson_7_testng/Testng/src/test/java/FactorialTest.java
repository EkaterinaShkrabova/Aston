import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {
    @Test
    public void testFactorialPositive() {
        assertEquals(Lesson_7_testng.Factorial.factorial(5), 120);
        assertEquals(Lesson_7_testng.Factorial.factorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Lesson_7_testng.Factorial.factorial(-1);
    }
}
