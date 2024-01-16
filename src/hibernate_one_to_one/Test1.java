package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try{
//            Session session = factory.getCurrentSession();
//            Employee emp = new Employee("Oleg", "Vasnetsov",
//                    "IT", 900);
//            Detail detail = new Detail("Placetas", "987866",
//                    "carmenate@mail.ru");
//            emp.setEmpDetail(detail);
//            session.beginTransaction();
//            session.persist(emp);
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            session.remove(emp);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }
}
