package Lesson_2;

public class Main {
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSumBetween();
        positiveOrNegative();
        positiveOrNegativeBoolean();
        stringRepeat();

    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 8;
        int b = 1;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 5;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }

    }

    public static void compareNumbers() {
        int a = 15;
        int b = 100;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }

    }

    public static void checkSumBetween() {
        int a = 11;
        int b = 20;
        int c = a + b;
        if (c >= 10 && c <= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void positiveOrNegative() {
        int a = -5;
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");

        }
    }

    public static void positiveOrNegativeBoolean() {
        int a = -100;
        if (a >= 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    public static void stringRepeat() {
        String a1 = "Hello ";
        int b = 3;
        String repeated = a1.repeat(b);
        System.out.println(repeated);


    }
}
