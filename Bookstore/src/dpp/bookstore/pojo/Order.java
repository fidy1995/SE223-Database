package dpp.bookstore.pojo;

import java.util.Date;

/****************************************************************
 * 
 * Plain Ordinary Java Object: Order.
 * 
 * Database: orderform (username, isbn, quantity, paiddate)
 * 
 ****************************************************************/
public class Order {
	String username; // the buyer username
	String isbn; // the book he bought
	int quantity; // the quantity
	Date paiddate; // the date when paid
	
	public void setUsername(String u) {
		this.username = u;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setIsbn(String i) {
		this.isbn = i;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setQuantity(int q) {
		this.quantity = q;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setPaiddate(Date d) {
		this.paiddate = d;
	}
	
	public Date getPaiddate() {
		return paiddate;
	}

}
