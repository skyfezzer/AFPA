package test;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
 
public class HibernateOracleTestXML {

   public static void main(String[] args) {

       final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
               .configure() // configures settings from hibernate.cfg.xml
               .build();
       
       SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
       
       Session session = factory.openSession();
       
       Transaction transaction = session.beginTransaction();
        
       //Customer customer = new Customer("Alexander", "alexander@gmail.com");
        
       //session.save(customer);
        
       transaction.commit();           
       session.close();
       factory.close();
       
//       try {
//
//           
//       } catch (Exception ex) {
//           StandardServiceRegistryBuilder.destroy(registry);
//       }
   }
 
}