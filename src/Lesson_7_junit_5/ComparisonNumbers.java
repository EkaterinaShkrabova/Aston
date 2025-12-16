package Lesson_7_junit_5;

public class ComparisonNumbers {

    public static String compare(int a, int b) {
        if (a > b) {
            return "Больше";
        } else if (a < b) {
            return "Меньше";
        } else {
            return "Равно";
        }
    }
}
