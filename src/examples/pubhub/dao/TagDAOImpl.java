package examples.pubhub.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import examples.pubhub.model.Book;
import examples.pubhub.utilities.DAOUtilities;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Tag;


/**
 * Implementation for the TagDAO, responsible for querying the database for Tag objects.
 */
@Repository
@Transactional
public class TagDAOImpl implements TagDAO{
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Tag> getAllTagsForBook(String isbn) {
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("SELECT bt.isbn, b.isbn" + "book_tags bt JOIN books b" + "ON bt.isbn = b.isbn" + "WHERE bt.isbn13 = :isbn");

		ArrayList<Tag> tags = (ArrayList<Tag>) query.list();
			
		return tags;
	}

	/*------------------------------------------------------------------------------------------------*/
	
	@Override
	public List<Book> getAllBooksForTag(String tag) {
		
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("SELECT bt.isbn, b.isbn" + "book_tags bt JOIN books b" + "ON bt.isbn = b.isbn" + "WHERE bt.tagName = :tag");

		ArrayList<Book> books = (ArrayList<Book>) query.list();
			
		return books;
	}	
	
	/*------------------------------------------------------------------------------------------------*/
	
	@Override
	public void addTag(Tag tag) {
		
		List<Tag> tags = getAllTagsForBook(tag.getIsbn13());
		
		for(int i = 0; i < tags.size(); i++) {
    		if(tags.get(i).getTagName().equals(tag.getTagName())) {
    			System.out.print("Tag already added to book!");
    			}
    		else {
    			Session session = sessionFactory.openSession();
    			Query query = session.createQuery("INSERT INTO book_tags");
    			}
		}
    }
	
	/*------------------------------------------------------------------------------------------------*/

	@Override
	public void removeTag(Tag tag) {
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("DELETE book_tags WHERE tagName = :tag.getTagName");
		
	    }
	
	/*------------------------------------------------------------------------------------------------*/
	
	@Override
    public void updateTag(Tag oldTag, Tag newTag) {
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("UPDATE book_tags SET tagName = :newTag WHERE tagName = :oldTag " + "AND isbn = :newTag.getIsbn13");	
    }
}
	
       
   
