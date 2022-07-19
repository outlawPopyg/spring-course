package hibernate_one_to_many;

import hibernate_one_to_many.entity.Department;
import hibernate_one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory(); Session session = factory.getCurrentSession()) {

            Department department = new Department("IT", 300, 1200);
            Employee e1 = new Employee("Антон", "Ларичев", 3200);
            Employee e2 = new Employee("Калим", "Брылин", 1200);

            department.addEmployeeToDepartment(e1);
            department.addEmployeeToDepartment(e2);

            session.beginTransaction();

            session.save(department);

            session.getTransaction().commit();


        }
    }
}
