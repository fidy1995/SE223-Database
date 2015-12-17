package dpp.bookstore.pojo;

import java.util.Date;

public class Order {
	private String uname;
	private String isbn;
	private int amount;
	private Date paytime;
	
	public void setUsername(String s) {
		uname = s;
	}
	
	public String getUsername() {
		return uname;
	}
	
	public void setIsbn(String s) {
		isbn = s;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setAmount(int i) {
		amount = i;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setPaytime(Date d) {
		paytime = d;
	}
	
	public Date getPaytime() {
		return paytime;
	}
}
