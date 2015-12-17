package dpp.bookstore.dao;

import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dpp.bookstore.pojo.Book;

/****************************************************************
 * 
 * The data access object implement for BookDao.
 * Provides the direct read or write to the database.
 * 
 ****************************************************************/
public class BookDaoImp implements BookDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet ret = null;
	
	public BookDaoImp(Connection c) {
		this.conn = c; // set connection
	}

	@Override
	public void addBook(Book book) throws Exception {
		String sql = "insert into books (isbn, title, category, price)"
				+ "values (?, ?, ?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, book.getIsbn());
		this.pstmt.setString(2, book.getTitle());
		this.pstmt.setString(3, book.getCategory());
		this.pstmt.setDouble(4, book.getPrice());
		pstmt.executeUpdate();
		this.pstmt.close();
	}

	@Override
	public void editBookTitle(String isbn, String title) throws Exception {
		String sql = "update books set title = ? where isbn = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, title);
		this.pstmt.setString(2, isbn);
		pstmt.executeUpdate();
		this.pstmt.close();
	}

	@Override
	public void editBookCategory(String isbn, String category) throws Exception {
		String sql = "update books set category = ? where isbn = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, category);
		this.pstmt.setString(2, isbn);
		pstmt.executeUpdate();
		this.pstmt.close();
	}

	@Override
	public void editBookPrice(String isbn, double price) throws Exception {
		String sql = "update books set price = ? where isbn = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setDouble(1, price);
		this.pstmt.setString(2, isbn);
		pstmt.executeUpdate();
		this.pstmt.close();
	}

	@Override
	public Vector<Book> queryAll() throws Exception {
		String sql = "select * from books";
		this.pstmt = this.conn.prepareStatement(sql);
		Vector<Book> books = new Vector<Book>();
		ret = pstmt.executeQuery();
		while (ret.next()) {
			Book book = new Book();
			book.setIsbn(ret.getString("isbn"));
			book.setTitle(ret.getString("title"));
			book.setCategory(ret.getString("category"));
			book.setPrice(ret.getDouble("price"));
			books.add(book);
		}
		this.pstmt.close();
		if (books.size() == 0) {
			return null;
		}
		return books;
	}

	@Override
	public Book queryByIsbn(String isbn) throws Exception {
		String sql = "select * from books where isbn = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, isbn);
		ret = pstmt.executeQuery();
		if (!ret.next()) {
			this.pstmt.close();
			return null;
		}
		Book book = new Book();
		book.setIsbn(ret.getString("isbn"));
		book.setTitle(ret.getString("title"));
		book.setCategory(ret.getString("category"));
		book.setPrice(ret.getDouble("price"));
		this.pstmt.close();
		return book;
	}

	@Override
	public Vector<Book> queryByTitle(String title) throws Exception {
		String sql = "select * from books where title like ? or title like ? or title like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + title);
		this.pstmt.setString(2, title + "%");
		this.pstmt.setString(3, "%" + title + "%");
		Vector<Book> books = new Vector<Book>();
		ret = pstmt.executeQuery();
		while (ret.next()) {
			Book book = new Book();
			book.setIsbn(ret.getString("isbn"));
			book.setTitle(ret.getString("title"));
			book.setCategory(ret.getString("category"));
			book.setPrice(ret.getDouble("price"));
			books.add(book);
		}
		this.pstmt.close();
		if (books.size() == 0) {
			return null;
		}
		return books;
	}

	@Override
	public Vector<Book> queryByCategory(String category) throws Exception {
		String sql = "select * from books where category like ? or category like ? or category like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + category);
		this.pstmt.setString(2, category + "%");
		this.pstmt.setString(3, "%" + category + "%");
		Vector<Book> books = new Vector<Book>();
		ret = pstmt.executeQuery();
		while (ret.next()) {
			Book book = new Book();
			book.setIsbn(ret.getString("isbn"));
			book.setTitle(ret.getString("title"));
			book.setCategory(ret.getString("category"));
			book.setPrice(ret.getDouble("price"));
			books.add(book);
		}
		this.pstmt.close();
		if (books.size() == 0) {
			return null;
		}
		return books;
	}

	@Override
	public void deleteByIsbn(String isbn) throws Exception {
		String sql = "delete from books where isbn = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, isbn);
		pstmt.executeUpdate();
		this.pstmt.close();
	}

}
