package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> list = session.createQuery("from Employee")
                    .getResultList();

            System.out.println(list);
            System.out.println("---------------------------------");

            System.out.println(session.createQuery("from Employee where department = 'Глава банды'").getResultList());

            System.out.println("---------------------------------");
            Employee emp = session.get(Employee.class, 1);
            emp.setName("Калим");

            session.createQuery("update Employee set salary = '1000' where department = 'Глава банды'").executeUpdate();
            System.out.println("---------------------------------");


            session.delete(emp);

            session.getTransaction().commit();
        }
    }
}
