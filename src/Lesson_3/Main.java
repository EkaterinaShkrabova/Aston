package Lesson_3;

import java.time.LocalDate;
import java.time.Month;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Шоколад", LocalDate.of(2025, 11, 25), "Спартак", "Беларусь", 5, false);
        product1.printInfo();


        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Молочная шоколадка", LocalDate.of(2025, Month.JUNE, 5), "Milka", "Швейцария", 12, true);

        productsArray[1] = new Product("Темный 70%", LocalDate.of(2024, Month.DECEMBER, 15), "Комунарка", "Беларусь", 4, false);

        productsArray[2] = new Product("Белый шоколад", LocalDate.of(2025, Month.JANUARY, 20), "Ritter Sport", "Германия", 13, true);

        productsArray[3] = new Product("Аленка", LocalDate.of(2025, Month.FEBRUARY, 2), "Спартак", "Беларусь", 6, false);

        productsArray[4] = new Product("Карамельная", LocalDate.of(2024, Month.AUGUST, 30), "Godiva", "Бельгия", 16, true);

        for (
                Product p : productsArray) {
            p.printInfo();
        }

        Park.Attraction attraction1 = new Park.Attraction( "Карусель", LocalTime.of(10, 00), LocalTime.of(18, 00), 5);
        attraction1.printInfo();

    }
}