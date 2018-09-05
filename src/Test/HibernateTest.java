package Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import examples.pubhub.model.Tag;

public class HibernateTest {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = null;
		
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception e){
			System.out.println("could not create connection!");
			e.printStackTrace();
			// The registry would be destroyed by SessionFactory, but we had trouble building 
			// SessionFactory so destroy it manually
			StandardServiceRegistryBuilder.destroy(registry);
		}
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Tag("1111111111111", "programming"));
		session.save(new Tag("1111111111111", "java"));
		session.save(new Tag("1111111111111", "enterprise"));
		session.getTransaction().commit();
	}	
}
