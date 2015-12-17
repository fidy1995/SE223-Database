package dpp.bookstore.service;

import org.bson.Document;

import dpp.bookstore.database.MongoConnect;
import dpp.bookstore.dao.UserProfileDao;
import dpp.bookstore.dao.UserProfileImp;

public class UserProfileService {
	
	private MongoConnect mc = null;
	private UserProfileDao dao = null;
	
	public UserProfileService() throws Exception {
		mc = new MongoConnect();
		dao = new UserProfileImp(mc.getCollection());
	}
	
	public Document getUserProfile(String uname) throws Exception {
		// TODO Auto-generated method stub
		Document up = null;
		try {
			up = dao.getUserProfile(uname);
		} catch (Exception e) {
			throw e;
		} finally {
			mc.close();
		}
		
		return up;
	}

	public void updateUserEmail(String uname, String email) throws Exception {
		// TODO Auto-generated method stub
		try {
			System.out.println("service" + uname);
			dao.updateUserEmail(uname, email);
		} catch (Exception e) {
			throw e;
		} finally {
			mc.close();
		}
	}

	public void updateUserQQ(String uname, String qq) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.updateUserQQ(uname, qq);
		} catch (Exception e) {
			throw e;
		} finally {
			mc.close();
		}
	}

	public void updateUserTel(String uname, String tel) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.updateUserTel(uname, tel);
		} catch (Exception e) {
			throw e;
		} finally {
			mc.close();
		}
	}

	public void deleteUserProfile(String uname) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.deleteUserProfile(uname);
		} catch (Exception e) {
			throw e;
		} finally {
			mc.close();
		}
	}

	public void insertUserProfile(String uname) throws Exception {
		// TODO Auto-generated method stub
		try {
			dao.insertUserProfile(uname);
		} catch (Exception e) {
			throw e;
		} finally {
			mc.close();
		}
	}

}
