package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.Book;

/**
 * Interface for our Data Access Object to handle database queries related to Books.
 */
public interface BookDAO {

	public List<Book> getAllBooks();
	public List<Book> getBooksByTitle(String title);
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksLessThanPrice(double price);
	public Book getBookByISBN(String isbn);
	
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBookByISBN(String isbn);
}
