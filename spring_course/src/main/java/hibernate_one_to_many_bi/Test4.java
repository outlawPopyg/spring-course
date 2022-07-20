package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory(); Session session = factory.getCurrentSession()) {

            Department department = new Department("HR", 300, 1200);
            Employee e1 = new Employee("Патрик", "Свуонсон", 3200);
            Employee e2 = new Employee("Гай", "Ричи", 1200);
            e1.setDepartment(department);
            e2.setDepartment(department);

            session.beginTransaction();

            System.out.println(session.get(Department.class, 5).getEmployeeList());


            session.getTransaction().commit();

        }
    }
}
