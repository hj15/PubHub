package examples.pubhub.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@Column(name="isbn_13")
	private String isbn13;			// International Standard Book Number, unique
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private LocalDate publishDate;	// Date of publish to the website
	
	@Column
	private double price;
	
	@Column
	private byte[] content;
	
	public Book () {
		
	}

	// Constructor used when no date is specified
	public Book(String isbn, String title, String author, byte[] content) {
		this.isbn13 = isbn;
		this.title = title;
		this.author = author;
		this.publishDate = LocalDate.now();
		this.content = content;
	}
	
	// Constructor used when a date is specified
	public Book(String isbn, String title, String author, byte[] content, LocalDate publishDate) {
		this.isbn13 = isbn;
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
		this.content = content;
	}
	
	
	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ISBN: " + isbn13 + " | Title: " + title +
				" | Author: " + author + " | Publish Date: " + publishDate +
				" | Price: " + price;
	}
	
}
