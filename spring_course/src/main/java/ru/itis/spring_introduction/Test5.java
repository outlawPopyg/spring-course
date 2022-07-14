package ru.itis.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml")) {
            Dog dog = context.getBean("myPet", Dog.class);
            dog.say();
//            Dog bean created
//            init method
//            Bow-wow
//            destroy method
        }
    }
}
