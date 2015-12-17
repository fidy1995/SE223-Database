package dpp.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import dpp.bookstore.pojo.User;

/****************************************************************
 * 
 * The data access object implement for UserDao.
 * Provides the direct read or write to the database.
 * 
 ****************************************************************/
public class UserDaoImp implements UserDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet ret = null;
	
	public UserDaoImp(Connection c) {
		this.conn = c;
	}

	@Override
	public void addUser(User user) throws Exception {
		String sql = "insert into users (username, password, email)"
				+ "values (?, ?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUsername());
		this.pstmt.setString(2, user.getPassword());
		this.pstmt.setString(3, user.getEmail());
		pstmt.executeUpdate();
		this.pstmt.close();

	}

	@Override
	public void editUserPassword(String username, String password) throws Exception {
		String sql = "update users set password = ? where username = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, password);
		this.pstmt.setString(2, username);
		pstmt.executeUpdate();
		this.pstmt.close();
	}

	@Override
	public void editUserEmail(String username, String email) throws Exception {
		String sql = "update users set email = ? where username = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, email);
		this.pstmt.setString(2, username);
		pstmt.executeUpdate();
		this.pstmt.close();

	}

	@Override
	public void deleteUserByName(String username) throws Exception {
		String sql = "delete from users where username = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		pstmt.executeUpdate();
		this.pstmt.close();
	}

	@Override
	public Vector<User> queryAll() throws Exception {
		String sql = "select * from users";
		this.pstmt = this.conn.prepareStatement(sql);
		ret = pstmt.executeQuery();
		Vector<User> users = new Vector<User>();
		while (ret.next()) {
			User user = new User();
			user.setUsername(ret.getString("username"));
			user.setPassword(ret.getString("password"));
			user.setEmail(ret.getString("email"));
			users.add(user);
		}
		this.pstmt.close();
		if (users.size() == 0) {
			return null;
		}
		return users;
	}

	@Override
	public User queryByName(String username) throws Exception {
		String sql = "select * from users where username = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		ret = pstmt.executeQuery();
		if (!ret.next()) {
			this.pstmt.close();
			return null;
		}
		User user = new User();
		user.setUsername(ret.getString("username"));
		user.setPassword(ret.getString("password"));
		user.setEmail(ret.getString("email"));
		this.pstmt.close();
		return user;
	}

}
