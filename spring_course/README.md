## IOC & DI

+ **Inversion of control** - Передача программистом прав
  на создание и управление объектами Spring-у
+ **Dependency Injection** - (является частью IOC) DI делает объекты нашего
  приложения слабо зависимыми друг от друга. Способы внедрения зависимостей:
    * С помощью конструкторов
      ```xml
      <bean id="myPet" class="ru.itis.Dog" />
      
      <bean id="myPerson" class="ru.itis.Person">
        <constructor-arg ref="myPet" />
      </bean>
      ```
    * С помоьщю сеттеров (берется значение поля name: pet и конвертуруется в setPet и вызывается)
      ```xml
      <bean id="myPet" class="ru.itis.Dog" />
      
      <bean id="myPerson" class="ru.itis.Person">
        <property name="pet" ref="myPet" />
        <property name="age" value="19" />
        <property name="lastName" value="Ahmetchin" />
      </bean>
      ```
    * Autowiring

`applicationContext.xml` - файл конфигурации  

Откуда брать .properties значения
```xml
<context:property-placeholder location="classpath:app.properties" />
```
## Bean Scope
- singleton - дефолтный scope
    + Такой бин создаётся сразу после прочтения Spring
      Container-ом конфиг файла
    + Является общим для всех, кто запросит его у Spring
      Container-а
    + Тодходит для stateless объектов.
```xml
<bean id="pet" class="ru.itis.spring_introduction.Dog" scope="singleton" />
```
- prototype
    + Такой бин создаётся только после обращения к
      Spring Container-у с помощью метода getBean
    + Для каждого такого обращения создаётся новый бин
      в Spring Container-е
    + Подходит для stateful объектов.
```xml
<bean id="pet" class="ru.itis.spring_introduction.Dog" scope="prototype" />
```