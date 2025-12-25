import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Test
    public void testTriangle() {
        double area = Triangle.triangleArea(3, 4, 5);
        assertEquals(6.0, area, 0.01);
    }
}
