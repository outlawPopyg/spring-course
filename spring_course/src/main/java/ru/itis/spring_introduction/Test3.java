package ru.itis.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
//            Pet pet = context.getBean("myPet", Pet.class);
//
//            Person person = new Person(pet);
//            person.callPet();

            Person person = context.getBean("myPerson", Person.class);
            person.callPet();

            System.out.println(person.getLastName() + " " + person.getAge());
        }

    }
}
