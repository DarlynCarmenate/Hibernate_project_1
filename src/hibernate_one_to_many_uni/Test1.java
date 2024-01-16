package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try{
//            session = factory.getCurrentSession();
//
//            Department dep = new Department("HR", 500, 1200);
//            Employee emp1 = new Employee("John", "Watson", 600);
//            Employee emp2 = new Employee("Sherlock", "Holmes", 800);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.persist(dep);
//
//            session.getTransaction().commit();
//            --------------------------------------------

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Department dep = session.get(Department.class, 2);
//            System.out.println(dep);
//            System.out.println(dep.getEmps());
//
//            session.getTransaction().commit();
//            ------------------------------------------------------

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 1);
//            System.out.println(emp);
//            System.out.println(emp.getDepartment());
//            session.getTransaction().commit();
//            --------------------------------------------------

            session = factory.getCurrentSession();
            session.beginTransaction();

            Department dep = session.get(Department.class, 2);
//            при удалении департамента удаляются все его раюотники, но не наоборот
            session.remove(dep);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }
}
