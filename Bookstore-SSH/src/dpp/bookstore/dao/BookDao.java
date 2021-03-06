package dpp.bookstore.dao;

import dpp.bookstore.pojo.Book;

import java.util.Vector;

/****************************************************************
 * 
 * The data access object interface for book.
 * 
 ****************************************************************/
public interface BookDao {
	// add a book to the database
	public void addBook(Book book) throws Exception;
	// update a book
	public void updateBook(Book book) throws Exception;
	// query all books
	public Vector<Book> queryAll() throws Exception;
	// query a single book by isbn
	public Book queryByIsbn(String isbn) throws Exception;
	// query books from database where book title includes string title
	public Vector<Book> queryByTitle(String title) throws Exception;
	// query books from database where book category includes string category
	public Vector<Book> queryByCategory(String category) throws Exception;
	// delete a book from database
	public void deleteByIsbn(String isbn) throws Exception;
}