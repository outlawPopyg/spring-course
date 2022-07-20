package hibernate_one_to_many_uni;


import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
//        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Department.class)
//                .buildSessionFactory(); Session session = factory.getCurrentSession()) {
//
//            Department department = new Department("HR", 300, 1200);
//            Employee e1 = new Employee("Патрик", "Свуонсон", 3200);
//            Employee e2 = new Employee("Гай", "Ричи", 1200);
//            department.addEmployeeToDepartment(e1);
//            department.addEmployeeToDepartment(e2);
//
//            session.beginTransaction();
//
//            session.save(department);
//
//            session.getTransaction().commit();
//
//        }
    }
}
