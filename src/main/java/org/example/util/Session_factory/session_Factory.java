package org.example.util.Session_factory;

import org.example.util.Employee.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class session_Factory {

    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null) {

               StandardServiceRegistryBuilder standardServiceRegistryBuilder =new StandardServiceRegistryBuilder();
               standardServiceRegistryBuilder.loadProperties("Application.properties");
               standardServiceRegistry =standardServiceRegistryBuilder.build();

                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                metadataSources.addAnnotatedClass(Employee.class);

                Metadata metadata = metadataSources.getMetadataBuilder().build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (standardServiceRegistry != null)
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
