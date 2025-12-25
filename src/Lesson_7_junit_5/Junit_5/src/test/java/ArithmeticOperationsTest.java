import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ArithmeticOperationsTest {

    @Test
    public void testAddition() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, ArithmeticOperations.subtract(3, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, ArithmeticOperations.multiply(2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2, ArithmeticOperations.divide(4, 2));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(4, 0));
    }
}