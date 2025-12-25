import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleTest {
    @Test
    public void testTriangleAreaValid() {
        assertEquals(Triangle.triangleArea(3, 4, 5), 6.0, 0.0001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaInvalid() {
        Triangle.triangleArea(1, 2, 10);
        Triangle.triangleArea(-3, 4, 5);
    }
}
