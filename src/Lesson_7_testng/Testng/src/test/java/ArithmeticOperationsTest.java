import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsTest {

    @Test
    public void testAddition() {
        assertEquals(ArithmeticOperations.add(2, 3), 5);
    }

    @Test
    public void testSubtraction() {
        assertEquals(ArithmeticOperations.subtract(3, 2), 1);
    }

    @Test
    public void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(2, 3), 6);
    }

    @Test
    public void testDivision() {
        assertEquals(ArithmeticOperations.divide(4, 2), 2.0, 0.0001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(4, 0);
    }
}