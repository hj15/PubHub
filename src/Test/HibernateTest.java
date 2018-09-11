package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import examples.pubhub.config.Config;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Tag;

public class HibernateTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		TagDAO tagDAO = (TagDAO)context.getBean(TagDAO.class);
		
		Tag tag = new Tag("1111111111111", "programming");
		
		System.out.println(tag);
	}	
}
