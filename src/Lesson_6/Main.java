package Lesson_6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static void main(String[] args) {
        Student vasya = new Student("Vasya", "1", 5, List.of(5.0, 2.0, 9.0));
        Student petya = new Student("Petya", "5", 1, List.of(3.0, 1.0, 2.0));
//        System.out.println(vasya.getName());
        List<Student> arrayList = new ArrayList<>();
        arrayList.add(vasya);
        arrayList.add(petya);
//        System.out.println(arrayList);
        deleteStudent(arrayList);
        System.out.println(arrayList);
        promoteStudents(arrayList);
        System.out.println("Перевод на следующий курс студентов с оценкой >= 3: " + arrayList);
        Set<Student> studentSet = new HashSet<>(arrayList);
        printStudents(studentSet, 1);

        PhoneGuide guide = new PhoneGuide();
        guide.add("Иванов","123-45-67");
        guide.add("Петров","234-56-78");
        guide.add("Лебедев","890-12-34");
        guide.add("Сидоров","345-67-89");
        System.out.println("Телефоны Иванова:");
        List<String> numbersIvanov = guide.get("Иванов");
        if (numbersIvanov != null) {
            for (String number : numbersIvanov) {
                System.out.println(number);
            }
        } else {
            System.out.println("Фамилия не найдена");
        }

        System.out.println("Телефоны Петрова:");
        List<String> numbersPetrov = guide.get("Петров");
        if (numbersPetrov != null) {
            for (String number : numbersPetrov) {
                System.out.println(number);
            }
        } else {
            System.out.println("Фамилия не найдена");
        }

        System.out.println("Телефоны Смирнова:");
        List<String> numbersSmirnov = guide.get("Смирнов");
        if (numbersSmirnov != null) {
            for (String number : numbersSmirnov) {
                System.out.println(number);
            }
        } else {
            System.out.println("Фамилия не найдена");
        }
    }

    public static void deleteStudent(List<Student> students) {
        for (Student s : new ArrayList<>(students)) {
//          System.out.println(s);
            double sum = 0;
            double avg = 0;
            for (Double num : s.getGrades()) {
                sum = sum + num;
            }
            avg = sum / s.getGrades().size();
            if (avg <= 3) {
                students.remove(s);
            }
        }
    }

    public static void promoteStudents(List<Student> students) {
        for (Student s : students) {
            double sum = 0;
            for (Double grade : s.getGrades()) {
                sum += grade;
            }
            double avg = sum / s.getGrades().size();
            if (avg >= 3) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}

