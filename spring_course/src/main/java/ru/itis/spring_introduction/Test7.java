package ru.itis.spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test7 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(Config2.class)) {
            Person person = context.getBean("personBean", Person.class);
            System.out.println(person.getLastName() + " " + person.getAge());
//            person.callPet();
        }
    }
}
