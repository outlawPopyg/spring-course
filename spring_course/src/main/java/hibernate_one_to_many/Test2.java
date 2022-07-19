package hibernate_one_to_many;

import hibernate_one_to_many.entity.Department;
import hibernate_one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory(); Session session = factory.getCurrentSession()) {


            session.beginTransaction();

            Department department = session.get(Department.class, 3);
            System.out.println(department.getEmployeeList());

            Employee employee = session.get(Employee.class, 5);
            System.out.println(employee.getDepartment());

            session.getTransaction().commit();


        }
    }
}
