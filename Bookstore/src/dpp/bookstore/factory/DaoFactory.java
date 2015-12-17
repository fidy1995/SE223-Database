package dpp.bookstore.factory;

import dpp.bookstore.dao.BookDao;
import dpp.bookstore.dao.OrderDao;
import dpp.bookstore.dao.UserDao;
import dpp.bookstore.service.*;

/****************************************************************
 * 
 * Abstract factory to get business service operator class.
 * 
 ****************************************************************/
public class DaoFactory {
	
	public static BookDao getBookDao() throws Exception {
		return new BookService();
	}
	
	public static OrderDao getOrderDao() throws Exception {
		return new OrderService();
	}
	
	public static UserDao getUserDao() throws Exception {
		return new UserService();
	}
}
