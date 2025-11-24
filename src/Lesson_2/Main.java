package Lesson_2;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSumBetween();
        printPositiveOrNegative();
        positiveOrNegativeTrueOrFalse();
        stringRepeat("Hello", 3);
        boolean isLeapYear = isLeapYear(2000);
        System.out.println(isLeapYear);
        change1To0And0To1();
        createArrayFrom1To100();


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

    public static void printPositiveOrNegative() {
        int a = -5;
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");

        }
    }

    public static void positiveOrNegativeTrueOrFalse() {
        int a = -100;
        if (a >= 0) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

    public static void stringRepeat(String a1, int b) {

        String repeated = a1.repeat(b);
        System.out.println(repeated);
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static void change1To0And0To1() {

        int[] arrayNumbers1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arrayNumbers1.length; i++) {
            if (arrayNumbers1[i] == 1) {
                arrayNumbers1[i] = 0;
            } else if (arrayNumbers1[i] == 0) {
                arrayNumbers1[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arrayNumbers1));

    }

    public static void createArrayFrom1To100() {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        System.out.println(Arrays.toString(numbers));
    }


}
