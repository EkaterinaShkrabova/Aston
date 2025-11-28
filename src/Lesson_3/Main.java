package Lesson_3;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Шоколад", LocalDate.of(2025, 11, 25), "Спартак", "Беларусь", 5, false);
        product1.printInfo();


        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Шоколадка Сливочно-ореховая", LocalDate.of(2025, Month.JUNE, 5), "Кондитерская Престиж", "Швейцария", 120, true);

        productsArray[1] = new Product("Темный 70%", LocalDate.of(2024, Month.DECEMBER, 15), "Luxe Cocoa", "Италия", 150, false);

        productsArray[2] = new Product("Белый с малиной", LocalDate.of(2025, Month.JANUARY, 20), "Aurora Foods", "Германия", 130, true);

        productsArray[3] = new Product("Мята и травы", LocalDate.of(2025, Month.FEBRUARY, 2), "Nordic Delights", "Швеция", 140, true);

        productsArray[4] = new Product("Карамель облаков", LocalDate.of(2024, Month.AUGUST, 30), "CocoaStory", "Бельгия", 160, true);

        for (
                Product p : productsArray) {
            p.printInfo();
        }

    }
}