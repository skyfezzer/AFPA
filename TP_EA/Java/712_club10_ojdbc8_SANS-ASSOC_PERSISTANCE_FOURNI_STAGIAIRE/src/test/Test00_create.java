package test;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author xav
 * schéma club10
 * aucune relation entre les classes, 2 entités mappées
 *Important, dans le fichier de config Hibernate, vous êtes en « create »
 *<property name="hbm2ddl.auto">create</property>
 */
public class Test00_create
{
	public static void main(String[] args) {
		
	//Création d'un registre
       final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
               .configure() // configures settings from hibernate.cfg.xml
               .build();
       
		//Creation d'une fabrique de session
       SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
       
       //Creation d'une session = le contexte Hibernate
       Session session = sessionFactory.openSession();
	
	
		//La structure des tables est créée conformément au mapping 
		// pas besoin de retirer l'auto-commmit
		
		session.close();
		sessionFactory.close();

//	finally{
//		session.close();
//	
//	}
	}

}
