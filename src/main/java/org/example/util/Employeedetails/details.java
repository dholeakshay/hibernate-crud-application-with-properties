package org.example.util.Employeedetails;

import org.example.util.Employee.Employee;
import org.hibernate.Session;
import org.example.util.Session_factory.session_Factory;

import java.io.Serializable;

public class details {
    public static void main(String[] args) {

        try (Session session = session_Factory.getSessionFactory().openSession()){
            Employee employee =createEmployee();
            session.beginTransaction();
            Serializable serializable = session.save(employee);
            Integer id =(Integer)serializable;
           session.getTransaction().commit();
            System.out.println(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    private static Employee createEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Akshay");
        employee.setSalary(1);
        return employee;
    }
}
