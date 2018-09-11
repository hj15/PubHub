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

/**
 * Implementation for the BookDAO, responsible for querying the database for Book objects.
 */
@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public List<Book> getAllBooks() {
				
		Session session = sessionFactory.openSession();
			
		Query query = session.createQuery("FROM books");

		ArrayList<Book> books = (ArrayList<Book>) query.list();
			
		return books;
	}

	
	/*------------------------------------------------------------------------------------------------*/


	@Override
	public List<Book> getBooksByTitle(String title) {
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("FROM books WHERE title = :title");

		ArrayList<Book> books = (ArrayList<Book>) query.list();
		
		return books;
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public List<Book> getBooksByAuthor(String author) {
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("FROM books WHERE author = :author");

		ArrayList<Book> books = (ArrayList<Book>) query.list();
		
		return books;
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public List<Book> getBooksLessThanPrice(double price) {
		
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM books WHERE price < :price");
		ArrayList<Book> books = (ArrayList<Book>) query.list();

		
		return books;
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public Book getBookByISBN(String isbn) {
		
		Book book = sessionFactory.getCurrentSession().get(Book.class, isbn);
			
		return book;
	}


	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public void addBook(Book book) {
		
		List<Book> books = getAllBooks();
		
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn13().equals(book.getIsbn13())) {
				System.out.println("Book already added!");
			}
			else {
				Session session = sessionFactory.openSession();
				Query query = session.createQuery("INSERT INTO books");
			}
		}
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public void updateBook(Book book) {
					
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("UPDATE books  SET title = :title " + "WHERE author = :author " + "WHERE price = :price  " + " WHERE isbn = :isbn" );

		ArrayList<Book> books = (ArrayList<Book>) query.list();
				
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public void deleteBookByISBN(String isbn) {
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("DELETE books WHERE isbn = :isbn");
		
	}
	
}
