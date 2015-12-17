package dpp.bookstore.service;

import java.util.Vector;

import dpp.bookstore.dao.UserDao;
import dpp.bookstore.pojo.User;

public class UserService {
	
	private UserDao dao;
	
	public void setDao(UserDao d) {
		dao = d;
	}

	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.addUser(user);
		} catch (Exception e) {
			throw e;
		}
	}

	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.updateUser(user);
		} catch (Exception e) {
			throw e;
		}
	}

	public void deleteUserByName(String username) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.deleteUserByName(username);
		} catch (Exception e) {
			throw e;
		}
	}

	public Vector<User> queryAll() throws Exception {
		// TODO Auto-generated method stub
		Vector<User> users = null;
		try {
			users = dao.queryAll();
		} catch (Exception e) {
			throw e;
		}
		
		return users;
	}

	public User queryByName(String username) throws Exception {
		// TODO Auto-generated method stub
		User user = null;
		try {
			user = dao.queryByName(username);
		} catch (Exception e) {
			throw e;
		}
		
		return user;
	}

}
