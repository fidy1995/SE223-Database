package dpp.bookstore.service;

import java.util.Vector;

import dpp.bookstore.dao.OrderDao;
import dpp.bookstore.pojo.Order;

public class OrderService {
	
	private OrderDao dao;
	
	public void setDao(OrderDao d) {
		dao = d;
	}

	public void pay(Order order) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.pay(order);
		} catch (Exception e) {
			throw e;
		}
	}

	public Vector<Order> queryByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		Vector<Order> orders = null;
		try {
			orders = dao.queryByUsername(username);
		} catch (Exception e) {
			throw e;
		}
		
		return orders;
	}

	public Vector<Order> queryAll() throws Exception {
		// TODO Auto-generated method stub
		Vector<Order> orders = null;
		try {
			orders = dao.queryAll();
		} catch (Exception e) {
			throw e;
		}
		
		return orders;
	}

}
