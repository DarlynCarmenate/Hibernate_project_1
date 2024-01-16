package hibernate.test;

import hibernate.test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee emp = session.get(Employee.class, 2);
//            session.remove(emp);

            session.createQuery("delete Employee where name = 'Elena'")
                            .executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
