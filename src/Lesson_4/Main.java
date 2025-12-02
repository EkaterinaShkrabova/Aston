package Lesson_4;

public class Main {
    public static void main(String[] args) {
        Dog bobik = new Dog("Bobik");
        bobik.run(600);
        bobik.swim(10);
        Cat murka = new Cat("Murka");
        murka.run(200);
        murka.swim(4);
        System.out.println("Всего животных " + Animal.counter);

        Bowl bowl = new Bowl(10);
        Cat[] cats = {
                new Cat("Мурзик"),
                new Cat("Барсик"),
                new Cat("Лиза"),
        };
        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        System.out.println("Статус котов:");
        for (Cat cat : cats) {
            cat.printStatus();
        }
        System.out.println("Добавляем в миску еще еды");
        bowl.addFood(10);

        for (Cat cat : cats) {
            if (cat.isHungry) {
                cat.eat(bowl);
            }
        }
        System.out.println("Статус котов:");
        for (Cat cat : cats) {
            cat.printStatus();
        }
        System.out.println("В миске осталось еды: " + bowl.getFood());



        Shape circle = new Circle(7, "Красный", "Желтый");
        Shape rectangle = new Rectangle(3, 5, "Зеленый", "Черный");
        Shape triangle = new Triangle(3, 1, 9, "Синий", "Белый");


        System.out.println("Круг:");
        circle.printProperties();

        System.out.println("Прямоугольник:");
        rectangle.printProperties();

        System.out.println("Треугольник:");
        triangle.printProperties();
    }
}