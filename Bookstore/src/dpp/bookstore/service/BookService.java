package dpp.bookstore.service;

import java.util.Vector;

import dpp.bookstore.dao.BookDao;
import dpp.bookstore.dao.BookDaoImp;
import dpp.bookstore.database.DBConnection;
import dpp.bookstore.pojo.Book;

/****************************************************************
 * 
 * The business service operation class implement for BookDao.
 * Provides the operations to read/write database.
 * 
 ****************************************************************/
public class BookService implements BookDao {
	private DBConnection dbconn = null;
	private BookDao dao = null;
	
	public BookService() throws Exception {
		dbconn = new DBConnection();
		dao = new BookDaoImp(this.dbconn.getConnection());
	}

	@Override
	public void addBook(Book book) throws Exception {
		try {
			this.dao.addBook(book);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

	/*@Override
	public void editBookIsbn(String isbn, String isbnew) throws Exception {
		try {
			this.dao.editBookIsbn(isbn, isbnew);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}*/

	@Override
	public void editBookTitle(String isbn, String title) throws Exception {
		try {
			this.dao.editBookTitle(isbn, title);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

	@Override
	public void editBookCategory(String isbn, String category) throws Exception {
		try {
			this.dao.editBookCategory(isbn, category);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

	@Override
	public void editBookPrice(String isbn, double price) throws Exception {
		try {
			this.dao.editBookPrice(isbn, price);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

	@Override
	public Vector<Book> queryAll() throws Exception {
		Vector<Book> ret = new Vector<Book>();
		try {
			ret = this.dao.queryAll();
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}

	@Override
	public Book queryByIsbn(String isbn) throws Exception {
		Book ret = new Book();
		try {
			ret = this.dao.queryByIsbn(isbn);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}

	@Override
	public Vector<Book> queryByTitle(String title) throws Exception {
		Vector<Book> ret = new Vector<Book>();
		try {
			ret = this.dao.queryByTitle(title);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}

	@Override
	public Vector<Book> queryByCategory(String category) throws Exception {
		Vector<Book> ret = new Vector<Book>();
		try {
			ret = this.dao.queryByCategory(category);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}

	@Override
	public void deleteByIsbn(String isbn) throws Exception {
		try {
			this.dao.deleteByIsbn(isbn);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

}
