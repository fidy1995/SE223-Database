package dpp.bookstore.pojo;

public class Book {
	private String isbn;
	private String title;
	private String category;
	private double price;
	
	public void setIsbn(String s) {
		isbn = s;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setCategory(String s) {
		category = s;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setPrice(double d) {
		price = d;
	}
	
	public double getPrice() {
		return price;
	}
}
