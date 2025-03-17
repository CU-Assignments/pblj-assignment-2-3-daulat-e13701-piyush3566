import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class Employee1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("piyush ", 24, 53000));
        employees.add(new Employee("gopal", 36, 63000));
        employees.add(new Employee("kunal", 24, 54000));
        employees.add(new Employee("rahul", 33, 44000));

        
        employees.sort(Comparator.comparing(e -> e.name));
        System.out.println("Sorted by Name:");
        employees.forEach(System.out::println);

   
        employees.sort(Comparator.comparingInt(e -> e.age));
        
        System.out.println("\nSorted by Age:");
        employees.forEach(System.out::println);

        employees.sort(Comparator.comparingDouble(e -> e.salary));
        System.out.println("\nSorted by Salary:");
        employees.forEach(System.out::println);
    }
}
