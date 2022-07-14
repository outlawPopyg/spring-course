package ru.itis.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml")) {
            Dog dog1 = context.getBean("myPet", Dog.class);
            Dog dog2 = context.getBean("myPet", Dog.class);
            System.out.println(dog1 == dog2); // true

            dog1.setName("Belka");
            dog2.setName("Strelka");
            System.out.println(dog1.getName() + " " + dog2.getName()); // Strelka Strlka
        }
    }
}
