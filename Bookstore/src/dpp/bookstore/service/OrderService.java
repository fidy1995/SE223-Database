package dpp.bookstore.service;

import java.util.Vector;

import dpp.bookstore.dao.OrderDao;
import dpp.bookstore.dao.OrderDaoImp;
import dpp.bookstore.database.DBConnection;
import dpp.bookstore.pojo.Order;

/****************************************************************
 * 
 * The business service operation class implement for OrderDao.
 * Provides the operations to read/write database.
 * 
 ****************************************************************/
public class OrderService implements OrderDao {
	private DBConnection dbconn = null;
	private OrderDaoImp dao = null;
	
	public OrderService() throws Exception {
		dbconn = new DBConnection();
		dao = new OrderDaoImp(this.dbconn.getConnection());
	}
	
	@Override
	public void pay(String username, String isbn, int quantity) throws Exception {
		try {
			this.dao.pay(username, isbn, quantity);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

	@Override
	public Vector<Order> queryByUsername(String username) throws Exception {
		Vector<Order> ret = new Vector<Order>();
		try {
			ret = this.dao.queryByUsername(username);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}
	
	@Override
	public Vector<Order> queryAll() throws Exception {
		Vector<Order> ret = new Vector<Order>();
		try {
			ret = this.dao.queryAll();
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}

	/*@Override
	public Vector<Order> queryByDate(String username, Date date, int length) throws Exception {
		Vector<Order> ret = new Vector<Order>();
		try {
			ret = this.dao.queryByDate(username, date, length);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}

	/*@Override
	public Vector<Order> queryByCategory(String username, String category) throws Exception {
		Vector<Order> ret = new Vector<Order>();
		try {
			ret = this.dao.queryByCategory(username, category);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}

	/*@Override
	public Vector<Order> queryByAllMethod(String username, Date date,
			int length, String category) throws Exception {
		Vector<Order> ret = new Vector<Order>();
		try {
			ret = this.dao.queryByAllMethod(username, date, length, category);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}*/

}
