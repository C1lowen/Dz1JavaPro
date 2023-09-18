package streamapithree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("Sophia", "Shestopal",18),
                new Student("Vlad", "Ignorik", 43),
                new Student("Maksim", "Feman", 20),
                new Student("Maksim", "Haman", 23),

        };

        List<Student> list = Arrays.stream(students)
                .filter(ageStudent -> ageStudent.getAge() >= 20)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
