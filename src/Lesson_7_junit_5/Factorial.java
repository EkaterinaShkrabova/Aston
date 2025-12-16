package Lesson_7_junit_5;

public class Factorial {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть положительным");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
