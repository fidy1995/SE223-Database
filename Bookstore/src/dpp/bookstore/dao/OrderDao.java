package dpp.bookstore.dao;

import dpp.bookstore.pojo.Order;

import java.util.Vector;

/****************************************************************
 * 
 * The data access object interface for order.
 * 
 ****************************************************************/
public interface OrderDao {
	// insert cart into database to become an order
	public void pay(String username, String isbn, int quantity) throws Exception;
	// query order by username
	public Vector<Order> queryByUsername(String username) throws Exception;
	// query all orders
	public Vector<Order> queryAll() throws Exception;
}
