package ru.itis.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();

        context.close();

        // Вручную нигде не создаем объект питомца, за нас создает Spring Container (applicationContext)
        // Избавляемся от перекомпиляции файла
        // Inversion of control - процесс передачи прав на создание и управление объектов
    }
}
