package dpp.bookstore.service;

import java.util.Vector;

import dpp.bookstore.dao.UserDao;
import dpp.bookstore.dao.UserDaoImp;
import dpp.bookstore.database.DBConnection;
import dpp.bookstore.pojo.User;

/****************************************************************
 * 
 * The business service operation class implement for UserDao.
 * Provides the operations to read/write database.
 * 
 ****************************************************************/
public class UserService implements UserDao {
	private DBConnection dbconn = null;
	private UserDao dao = null;
	
	public UserService() throws Exception {
		dbconn = new DBConnection();
		dao = new UserDaoImp(this.dbconn.getConnection());
	}

	@Override
	public void addUser(User user) throws Exception {
		try {
			this.dao.addUser(user);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

	@Override
	public void editUserPassword(String username, String password) throws Exception {
		try {
			this.dao.editUserPassword(username, password);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

	@Override
	public void editUserEmail(String username, String email) throws Exception {
		try {
			this.dao.editUserEmail(username, email);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

	@Override
	public void deleteUserByName(String username) throws Exception {
		try {
			this.dao.deleteUserByName(username);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
	}

	@Override
	public Vector<User> queryAll() throws Exception {
		Vector<User> ret = new Vector<User>();
		try {
			ret = this.dao.queryAll();
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}

	@Override
	public User queryByName(String username) throws Exception {
		User ret = new User();
		try {
			ret = this.dao.queryByName(username);
		} catch (Exception e){
			throw e;
		} finally {
			this.dbconn.close();
		}
		return ret;
	}
}
