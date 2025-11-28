package Lesson_3;

import java.time.LocalTime;

public class Park {

    class Attraction {
        private String name;
        private LocalTime openTime;
        private LocalTime closeTime;
        private int price;

        public Attraction(String name, LocalTime openTime, LocalTime closeTime, int price) {
            this.name = name;
            this.openTime = openTime;
            this.closeTime = closeTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + openTime + " - " + closeTime);
            System.out.println("Цена: " + price);
        }
    }
}
