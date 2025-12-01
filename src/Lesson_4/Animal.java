package Lesson_4;

public class Animal {
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    public static int counter;

    public Animal(String name) {
        this.name = name;
        counter++;
    }

    public boolean run(int length) {
        if (length <= maxRun)
            {
                System.out.println(name + " пробежал " + length);

                return true;
            }

        else{
                System.out.println(name + " не может пробежать " + length);
                return false;
            }
        }



            public boolean swim ( int length){
                if (maxSwim <= 0) {
                    System.out.println(name + " не умеет плавать");
                    return false;
                }
                if (length <= maxSwim) {
                    System.out.println(name + " проплыл " + length);
                    return true;
                } else {
                    System.out.println(name + " не может проплыть " + length);
                    return false;
                }

            }
        }