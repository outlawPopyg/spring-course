package ru.itis.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml")) {
//            Cat cat = context.getBean("catBean", Cat.class);
//            cat.say();

//            Person person = context.getBean("personBean", Person.class);
//            System.out.println(person.getLastName() + " " + person.getAge());

            Dog dog = context.getBean("dogBean", Dog.class);

        }
    }
}
