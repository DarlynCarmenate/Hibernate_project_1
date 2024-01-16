package hibernate.test;

import hibernate.test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Oleg", "Vasnetsov",
                    "IT", 900);
            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
