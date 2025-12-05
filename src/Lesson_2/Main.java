package Lesson_2;

public class Main {
    static void main() {
        String[][] array = {
                {"1", "8", "5", "3"},
                {"8", "15", "21", "11"},
                {"30", "21", "9", "1"},
                {"21", "14", "21", "6"}
        };
        try {
            int result = ArrayProcessor.processArray(array);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            array[5][0] = "test";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Обнаружена попытка обращения за границы массива: " + e.getMessage());
        }
    }
 }
