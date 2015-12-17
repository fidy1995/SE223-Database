package dpp.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

import dpp.bookstore.pojo.Order;

/****************************************************************
 * 
 * The data access object implement for OrderDao.
 * Provides the direct read or write to the database.
 * 
 ****************************************************************/
public class OrderDaoImp implements OrderDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet ret = null;
	
	public OrderDaoImp(Connection c) {
		this.conn = c;
	}

	@Override
	public void pay(String username, String isbn, int quantity) throws Exception {
		String sql = "insert into orderform (username, isbn, quantity, paiddate)"
				+ "values (?, ?, ?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		this.pstmt.setString(2, isbn);
		this.pstmt.setInt(3, quantity);
		Date utilDate = new Date();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		this.pstmt.setDate(4, date);
		pstmt.executeUpdate();
		this.pstmt.close();
	}

	@Override
	public Vector<Order> queryByUsername(String username) throws Exception {
		String sql = "select * from orderform where username = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		ret = pstmt.executeQuery();
		Vector<Order> orders = new Vector<Order>();
		while (ret.next()) {
			Order order = new Order();
			order.setUsername(ret.getString("username"));
			order.setIsbn(ret.getString("isbn"));
			order.setQuantity(ret.getInt("quantity"));
			java.sql.Date sqlDate = ret.getDate("paiddate");
			Date date = new Date(sqlDate.getTime());
			order.setPaiddate(date);
			orders.add(order);
		}
		this.pstmt.close();
		if (orders.size() == 0) {
			return null;
		}
		return orders;
	}
	
	@Override
	public Vector<Order> queryAll() throws Exception {
		String sql = "select * from orderform";
		this.pstmt = this.conn.prepareStatement(sql);
		ret = pstmt.executeQuery();
		Vector<Order> orders = new Vector<Order>();
		while (ret.next()) {
			Order order = new Order();
			order.setUsername(ret.getString("username"));
			order.setIsbn(ret.getString("isbn"));
			order.setQuantity(ret.getInt("quantity"));
			java.sql.Date sqlDate = ret.getDate("paiddate");
			Date date = new Date(sqlDate.getTime());
			order.setPaiddate(date);
			orders.add(order);
		}
		this.pstmt.close();
		if (orders.size() == 0) {
			return null;
		}
		return orders;
	}

	/*@Override
	public Vector<Order> queryByDate(String username, Date date, int length) throws Exception {
		Date dateBefore = new Date(date.getTime() - (long)length * 24 * 3600 * 1000);
		if (username.equals("admin")) {
			String sql = "select * from orderForm where paiddate between ? and ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setDate(1, (java.sql.Date)dateBefore);
			this.pstmt.setDate(2, (java.sql.Date)date);
		} 
		else {
			String sql = "select * from orderForm where username = ? and paiddate between ? and ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, username);
			this.pstmt.setDate(2, (java.sql.Date)dateBefore);
			this.pstmt.setDate(3, (java.sql.Date)date);
		}
		ret = pstmt.executeQuery();
		Vector<Order> orders = new Vector<Order>();
		while (ret.next()) {
			Order order = new Order();
			order.setUsername(ret.getString("username"));
			order.setIsbn(ret.getString("isbn"));
			order.setQuantity(ret.getInt("quantity"));
			order.setPaiddate(ret.getDate("paiddate"));
			orders.add(order);
		}
		this.pstmt.close();
		return orders;
	}

	/*@Override
	public Vector<Order> queryByCategory(String username, String category) throws Exception {
		String sql = "insert into books (isbn, title, category, price)"
				+ "values (?, ?, ?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.executeUpdate();
		this.pstmt.close();
		return null;
	}

	@Override
	public Vector<Order> queryByAllMethod(String username, Date date,
			int length, String category) throws Exception {
		String sql = "insert into books (isbn, title, category, price)"
				+ "values (?, ?, ?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.executeUpdate();
		this.pstmt.close();
		return null;
	}*/

}
