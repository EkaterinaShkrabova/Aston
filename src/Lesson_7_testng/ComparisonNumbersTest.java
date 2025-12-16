package Lesson_7_testng;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ComparisonNumbersTest {

@Test
public void testCompareGreater() {
    assertEquals(ComparisonNumbers.compare(5, 3), "больше");
}

@Test
public void testCompareLess() {
    assertEquals(ComparisonNumbers.compare(3, 5), "меньше");
}

@Test
public void testCompareEqual() {
    assertEquals(ComparisonNumbers.compare(5, 5), "равно");
}
}
