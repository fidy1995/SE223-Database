package dpp.bookstore.dao;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;

public class UserProfileImp implements UserProfileDao {
	
	private MongoCollection<Document> coll = null;
	private Document d = null;
	private Document d2 = null;
	
	public UserProfileImp(MongoCollection<Document> c) {
		coll = c;
		d = new Document();
		d2 = new Document();
	}
	
	@Override
	public Document getUserProfile(String uname) throws Exception {
		// TODO Auto-generated method stub
		d.append(USERNAME, uname);
		return coll.find(d).first();
	}

	@Override
	public void updateUserEmail(String uname, String email) throws Exception {
		// TODO Auto-generated method stub
		d.append(USERNAME, uname);
		d2.append(EMAIL, email);
		System.out.println("dao" + uname);
		coll.updateOne(d, new BasicDBObject().append("$set", d2));
	}

	@Override
	public void updateUserQQ(String uname, String qq) throws Exception {
		// TODO Auto-generated method stub
		d.append(USERNAME, uname);
		d2.append(QQ, qq);
		coll.findOneAndUpdate(d, new BasicDBObject().append("$set", d2));
	}

	@Override
	public void updateUserTel(String uname, String tel) throws Exception {
		// TODO Auto-generated method stub
		d.append(USERNAME, uname);
		d2.append(TEL, tel);
		coll.findOneAndUpdate(d, new Document().append("$set", d2));
	}

	@Override
	public void deleteUserProfile(String uname) throws Exception {
		// TODO Auto-generated method stub
		d.append(USERNAME, uname);
		coll.findOneAndDelete(d);
	}

	@Override
	public void insertUserProfile(String uname) throws Exception {
		// TODO Auto-generated method stub
		d.append(USERNAME, uname);
		coll.insertOne(d);
	}

}
