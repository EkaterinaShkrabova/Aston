package Lesson_4;

public interface Shape {
    double getPerimeter();
    double getArea();

    String getFillColor();
    String getBorderColor();

    // Дефолтные методы для вывода характеристик
    default void printProperties() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}

