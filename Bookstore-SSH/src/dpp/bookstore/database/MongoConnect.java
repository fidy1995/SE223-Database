package dpp.bookstore.database;

import com.mongodb.MongoClient;
import com.mongodb.client.*;

import org.bson.Document;

public class MongoConnect {
	private static final String URL = "localhost";
	private static final int PORT = 27017;
	//private static final String USER = "dpp";
	//private static final String PASSWORD = "dpp";
	
	private static final String DBNAME = "My_bookstore";
	private static final String COLLNAME = "UserProfile";
	
	private MongoClient conn = null;
	private MongoDatabase db = null;
	private MongoCollection<Document> coll = null;

	public MongoConnect() throws Exception {
		try {
			conn = new MongoClient(URL, PORT);
			db = conn.getDatabase(DBNAME);
			//boolean auth = db.auth(USER, PASSWORD);
			coll = db.getCollection(COLLNAME);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public MongoCollection<Document> getCollection() {
		return coll;
	}

	public void close() throws Exception {
		if (conn != null) {  
			try {
				conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
