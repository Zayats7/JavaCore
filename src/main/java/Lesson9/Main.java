package Lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alexei", Arrays.asList(new Course("Programming"), new Course("Managment"),
                new Course("Testing"))));
        students.add(new Student("Elias", Arrays.asList(new Course("Programming"), new Course("Testing"),
                new Course("Math"), new Course("Economy"))));
        students.add(new Student("Iana", Arrays.asList(new Course("Graphics"), new Course("Gaming"),
                new Course("ProCreate"), new Course("Testing"))));

        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));

        Course course = new Course("Testing");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
