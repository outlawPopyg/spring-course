package aop;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class University {
    private List<Student> students;

    public University() {
        students = new LinkedList<>();
    }

    public void addStudents() {
        Student s1 = new Student("Kalim", 2, 6.5);
        Student s2 = new Student("John", 3, 5.3);
        Student s3 = new Student("Dutch", 1, 8.3);

        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public List<Student> getStudents() {
        students.get(3);
        System.out.println("Начало метода getStudents" + " " + students);
        return students;
    }

    public String someMethod() {
        int a = 10 / 0;
        System.out.println("running someMethod()");
        return "Hello world!";
    }
}
