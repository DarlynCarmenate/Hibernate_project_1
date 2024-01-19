package hibernate_many_to_many;

import hibernate_many_to_many.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try{
//            session = factory.getCurrentSession();
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Anna", 5);
//            Child child2 = new Child("Tony", 6);
//            Child child3 = new Child("Johnny", 5);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.persist(section1);
//            session.getTransaction().commit();
//            -----------------------------------------------
//            session = factory.getCurrentSession();
//            Section section1 = new Section("Voleyball");
//            Section section2 = new Section("Basketball");
//            Section section3 = new Section("Baseball");
//            Child child1 = new Child("Igor", 10);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.persist(child1);
//            session.getTransaction().commit();
//            -----------------------------------------------
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//            session.getTransaction().commit();
//            -----------------------------------------------
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 3);
//            session.remove(section);
//            session.getTransaction().commit();
//            -----------------------------------------------
            session = factory.getCurrentSession();
            session.beginTransaction();

            Child child = session.get(Child.class, 4);
            session.remove(child);
            session.getTransaction().commit();
        }
        finally{
            session.close();
            factory.close();
        }
    }
}
