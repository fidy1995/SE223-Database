package dpp.bookstore.pojo;

/****************************************************************
 * 
 * Plain Ordinary Java Object: User.
 * 
 * Database: users (username, password, email)
 * 
 ****************************************************************/
public class User {
	String username; // the username of user
	String password; // the password of user
	String email; // the email of user
	
	public void setUsername(String u) {
		this.username = u;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String p) {
		this.password = p;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String e) {
		this.email = e;
	}
	
	public String getEmail() {
		return email;
	}
}
