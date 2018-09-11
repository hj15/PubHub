package examples.pubhub.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import examples.pubhub.dao.BookDAO;
import examples.pubhub.dao.BookDAOImpl;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.dao.TagDAOImpl;

@Configuration
@EnableTransactionManagement
public class Config {
	
	@Bean
	public DataSource dataSource (){	
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/Testing");
		ds.setUsername("postgres");
		ds.setPassword("password");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(ds);
		factoryBean.setPackagesToScan(new String[] {"examples.pubhub.model"});
		Properties props = new Properties();
		props.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
		
		factoryBean.setHibernateProperties(props);
		return factoryBean;
	}
	
	@Bean
	public TagDAO tagDAO(SessionFactory sessionFactory) {
		TagDAOImpl impl = new TagDAOImpl();
		impl.setSessionFactory(sessionFactory);
		return impl;
	}
	
	@Bean 
	public PlatformTransactionManager txManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	
	
	
}
