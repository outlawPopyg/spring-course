package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
       try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory()) {
           Employee emp = new Employee("Роман", "Абрамович", "Петух", 23242);
           Session session = factory.getCurrentSession();

           session.beginTransaction();
           session.save(emp);

           Employee employee = session.get(Employee.class, emp.getId());

           session.getTransaction().commit();
       }
    }
}
