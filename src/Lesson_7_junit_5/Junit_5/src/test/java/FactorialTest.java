import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FactorialTest {
    @Test
    public void testFactorial () {
        assertEquals(120, Factorial.factorial(5));
        assertEquals(1, Factorial.factorial(0));
        assertEquals(1, Factorial.factorial(1));
    }
}
