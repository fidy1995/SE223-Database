package dpp.bookstore.service;

import java.util.Vector;

import dpp.bookstore.dao.BookDao;
import dpp.bookstore.pojo.Book;

public class BookService {
	
	private BookDao dao;
	
	public void setDao (BookDao d) {
		dao = d;
	}

	public void addBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.addBook(book);
		} catch (Exception e) {
			throw e;
		}
	}

	public void updateBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.updateBook(book);
		} catch (Exception e) {
			throw e;
		}
	}

	public Vector<Book> queryAll() throws Exception {
		// TODO Auto-generated method stub
		Vector<Book> books = null;
		try {
			books = dao.queryAll();
		} catch (Exception e) {
			throw e;
		}

		return books;
	}

	public Book queryByIsbn(String isbn) throws Exception {
		// TODO Auto-generated method stub
		Book book = null;
		try {
			book = dao.queryByIsbn(isbn);
		} catch (Exception e) {
			throw e;
		}

		return book;
	}

	public Vector<Book> queryByTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		Vector<Book> books = null;
		try {
			books = dao.queryByTitle(title);
		} catch (Exception e) {
			throw e;
		}

		return books;
	}

	public Vector<Book> queryByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		Vector<Book> books = null;
		try {
			books = dao.queryByCategory(category);
		} catch (Exception e) {
			throw e;
		}

		return books;
	}

	public void deleteByIsbn(String isbn) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.deleteByIsbn(isbn);
		} catch (Exception e) {
			throw e;
		}
	}

}
