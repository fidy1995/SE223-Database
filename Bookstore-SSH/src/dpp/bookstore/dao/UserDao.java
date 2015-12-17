package dpp.bookstore.dao;

import java.util.Vector;

import dpp.bookstore.pojo.User;

public interface UserDao {
	// register user, insert into database
	public void addUser(User user) throws Exception;
	// update user 
	public void updateUser(User user) throws Exception;
	// delete user by name
	public void deleteUserByName(String username) throws Exception;
	// query all user 
	public Vector<User> queryAll() throws Exception;
	// query user by name
	public User queryByName(String username) throws Exception;
}
