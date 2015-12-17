package dpp.bookstore.dao;

import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dpp.bookstore.pojo.User;

public class UserDaoImp implements UserDao {

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
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user != null) {
			getCurrentSession().save(user);
		}
	}

	@Override
	public void updateUser(User user)
			throws Exception {
		// TODO Auto-generated method stub
		if (user != null) {
			getCurrentSession().update(user);
		}
	}

	@Override
	public void deleteUserByName(String username) throws Exception {
		// TODO Auto-generated method stub
		User user = (User) getCurrentSession()
				.get(dpp.bookstore.pojo.User.class, new String(username));
		if (user != null) {
			getCurrentSession().delete(user);
		}
	}

	@Override
	public Vector<User> queryAll() throws Exception {
		// TODO Auto-generated method stub
		Query user = getCurrentSession().createQuery("from dpp.bookstore.pojo.User");
		Vector<User> users = new Vector<User>(user.list());
		return users;
	}

	@Override
	public User queryByName(String username) throws Exception {
		// TODO Auto-generated method stub
		User user = (User)getCurrentSession()
				.get(dpp.bookstore.pojo.User.class, new String(username));
		return user;
	}

}
