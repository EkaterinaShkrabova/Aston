package Lesson_4;

public class Bowl {
    private int food;

    public Bowl(int foodAmount) {
        if (foodAmount < 0) {
            this.food = 0;
        } else {
            this.food = foodAmount;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            this.food += amount;
            System.out.println("В миске добавлено " + amount + " еды. Сейчас: " + this.food);
        }
    }

    public boolean takeFood(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (food >= amount) {
            food -= amount;
            return true;
        } else {

            return false;
        }
    }

    public int getFood() {
        return food;
    }

}