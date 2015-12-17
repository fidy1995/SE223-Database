package dpp.bookstore.dao;

import dpp.bookstore.pojo.User;

import java.util.Vector;

/****************************************************************
 * 
 * The data access object interface for user.
 * 
 ****************************************************************/
public interface UserDao {
	// register user, insert into database
	public void addUser(User user) throws Exception;
	// update user password with username and new password
	public void editUserPassword(String username, String password) throws Exception;
	// update user email with username and new email
	public void editUserEmail(String username, String email) throws Exception;
	// delete user by name
	public void deleteUserByName(String username) throws Exception;
	// query all user 
	public Vector<User> queryAll() throws Exception;
	// query user by name
	public User queryByName(String username) throws Exception;
}
