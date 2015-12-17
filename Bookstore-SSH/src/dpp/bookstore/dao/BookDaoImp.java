package dpp.bookstore.dao;

import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import dpp.bookstore.pojo.Book;

public class BookDaoImp implements BookDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory ses) {
		sessionFactory = ses;
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		if (book != null) {
			getCurrentSession().save(book);
		}
	}

	@Override
	public void updateBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		if (book != null) {
			getCurrentSession().update(book);
		}
	}

	@Override
	public Vector<Book> queryAll() throws Exception {
		// TODO Auto-generated method stub
		Query book = getCurrentSession()
				.createQuery("from dpp.bookstore.pojo.Book");
		Vector<Book> books = new Vector<Book>(book.list());
		return books;
	}

	@Override
	public Book queryByIsbn(String isbn) throws Exception {
		// TODO Auto-generated method stub
		Book book = (Book)getCurrentSession()
				.get(dpp.bookstore.pojo.Book.class, new String(isbn));
		return book;
	}

	@Override
	public Vector<Book> queryByTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		Query book = getCurrentSession()
				.createQuery("from dpp.bookstore.pojo.Book as b where b.title"
				+ " like :name").setParameter("name", "%" + title + "%");
		Vector<Book> books = new Vector<Book>(book.list());
		return books;
	}

	@Override
	public Vector<Book> queryByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		Query book = getCurrentSession()
				.createQuery("from dpp.bookstore.pojo.Book as b where b.category"
				+ " like :name").setParameter("name", "%" + category + "%");
		Vector<Book> books = new Vector<Book>(book.list());
		return books;
	}

	@Override
	public void deleteByIsbn(String isbn) throws Exception {
		// TODO Auto-generated method stub
		Book book = (Book)getCurrentSession()
				.get(dpp.bookstore.pojo.Book.class, new String(isbn));
		if (book != null) {
			getCurrentSession().delete(book);
		}
	}

}
