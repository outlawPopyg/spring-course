package hibernate2;

import hibernate2.entity.Detail;
import hibernate2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory(); Session session = factory.getCurrentSession()) {

            Employee e1 = new Employee("Антон", "Залупин", "IT", 2432);
            Detail d1 = new Detail("Казань", "43454", "anton_zalupin@gmail.com");

            session.beginTransaction();

            System.out.println(session.get(Detail.class, 1).getEmployee());

            session.getTransaction().commit();


        }
    }
}
