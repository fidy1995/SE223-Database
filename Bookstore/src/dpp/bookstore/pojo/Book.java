package dpp.bookstore.pojo;

/****************************************************************
 * 
 * Plain Ordinary Java Object: Book.
 * 
 * Database: books (isbn, title, category, price)
 * 
 ****************************************************************/
public class Book {
	String isbn; // the International-Standard-Book-Number
	String title; // the title of a book
	String category; // the category of a book
	double price; // the price of a book
	
	public void setIsbn(String i) {
		this.isbn = i;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setTitle(String t) {
		this.title = t;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setCategory(String c) {
		this.category = c;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setPrice(double p) {
		this.price = p;
	}
	
	public double getPrice() {
		return price;
	}

}
