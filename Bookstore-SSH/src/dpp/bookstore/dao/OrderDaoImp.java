package dpp.bookstore.dao;

import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dpp.bookstore.pojo.Order;

public class OrderDaoImp implements OrderDao {
	
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
	public void pay(Order order)
			throws Exception {
		// TODO Auto-generated method stub
		if (order != null) {
			getCurrentSession().save(order);
		}
	}

	@Override
	public Vector<Order> queryByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		Query order = getCurrentSession().createQuery("from dpp.bookstore.pojo.Order as o "
				+ "where o.username = :name").setParameter("name", username);
		Vector<Order> orders = new Vector<Order>(order.list());
		return orders;
	}

	@Override
	public Vector<Order> queryAll() throws Exception {
		// TODO Auto-generated method stub
		Query order = getCurrentSession().createQuery("from dpp.bookstore.pojo.Order");
		Vector<Order> orders = new Vector<Order>(order.list());
		return orders;
	}
}
