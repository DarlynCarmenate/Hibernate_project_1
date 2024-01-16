package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try{
//            session = factory.getCurrentSession();
//            Employee emp = new Employee("Misha", "Kuznetsov",
//                    "Sales", 900);
//            Detail detail = new Detail("Perm", "987856",
//                    "misha@mail.ru");
//            emp.setEmpDetail(detail);
//            detail.setEmployee(emp);
//            session.beginTransaction();
//            session.persist(detail);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 3);
//            System.out.println(detail.getEmployee());
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 2);
            detail.getEmployee().setEmpDetail(null);
            session.remove(detail);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }
}
