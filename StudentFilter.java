import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + "%)";
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("piyush", 82),
            new Student("gopal", 74),
            new Student("cheten", 90),
            new Student("rahul", 65),
            new Student("elefant", 78)
        );

        List<String> topStudents = students.stream()
            .filter(s -> s.marks > 75) 
            .sorted(Comparator.comparingDouble(s -> -s.marks)) 
            .map(s -> s.name) 
            .collect(Collectors.toList());

         System.out.println("Students scoring above 75% (sorted by marks): " + topStudents);
    }
}
