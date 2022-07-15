package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
            University university = context.getBean("university", University.class);
            university.addStudents();
            try {
                System.out.println(university.getStudents());
            } catch (Exception ignored) {}

            String s = university.someMethod();
            System.out.println(s);
        }
    }
}
