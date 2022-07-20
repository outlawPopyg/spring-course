package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory(); Session session = factory.getCurrentSession()) {

            Employee employee = new Employee("Kalim", "Ahmetchin", 1013);
            Employee employee2 = new Employee("Arthur", "Morgan", 1013);

            Department department = new Department("Game", 120, 139);
            department.addEmployeeToDepartment(employee);
            department.addEmployeeToDepartment(employee2);

            session.beginTransaction();

            session.save(department);

            session.getTransaction().commit();

        }
    }
}
