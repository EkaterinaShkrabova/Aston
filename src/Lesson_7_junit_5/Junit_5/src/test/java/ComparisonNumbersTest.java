import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComparisonNumbersTest {

    @Test
    public void testCompareGreater() {
        assertEquals("Больше", ComparisonNumbers.compare(5, 3));
    }

    @Test
    public void testCompareLess() {
        assertEquals("Меньше", ComparisonNumbers.compare(3, 5));
    }

    @Test
    public void testCompareEqual() {
        assertEquals("Равно", ComparisonNumbers.compare(5, 5));
    }
}