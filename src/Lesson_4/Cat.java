package Lesson_4;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        this.appetite = 3;
        this.isHungry = true;
        maxRun = 200;
        maxSwim = 0;

    }
    public boolean isHungry;
    public int appetite;

    public void eat (Bowl bowl) {
        System.out.println(name + " хочет съесть " + appetite + " еды.");
        boolean success = bowl.takeFood(appetite);
        if (success) {
            isHungry = false;
            System.out.println(name + " съел " + appetite + " еды и стал сытым.");
        } else {
            System.out.println(name + " не смог поесть, в миске недостаточно еды.");
        }
    }

    public void printStatus() {
        System.out.println(name + " сытый: " + (isHungry ? "нет" : "да"));
    }
}


