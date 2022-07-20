package hibernate_many_to_many;


import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory(); Session session = factory.getCurrentSession()) {

            Section section = new Section("Футбол");

            Child child1 = new Child("Калим", 12);
            Child child2 = new Child("Иван", 14);
            Child child3 = new Child("Антон", 10);

            section.addChildToSection(child1);
            section.addChildToSection(child2);
            section.addChildToSection(child3);

            session.beginTransaction();

            session.save(section);

            session.getTransaction().commit();


        }
    }
}
