package Lesson_6;

import java.util.ArrayList;
import java.util.List;

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

    }

    public static void deleteStudent(List<Student> students) {
        for (Student s : new ArrayList<>(students)) {
//            System.out.println(s);
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
}

