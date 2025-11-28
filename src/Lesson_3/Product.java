package Lesson_3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Product {
    private String name;
    private LocalDate date;
    private String producer;
    private String countryOfOrigin;
    private int price;
    private boolean StateOfBooking;

    public Product(String name, LocalDate date, String producer, String countryOfOrigin, int price, boolean StateOfBooking) {
        this.name = name;
        this.date = date;
        this.producer = producer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.StateOfBooking = StateOfBooking;

    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата: " + date);
        System.out.println("Производитель: " + producer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Забронирован покупателем: " + (StateOfBooking ? "да" : "нет"));
    }


}


