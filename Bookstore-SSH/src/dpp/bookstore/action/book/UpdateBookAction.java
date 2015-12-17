package dpp.bookstore.action.book;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.Book;
import dpp.bookstore.service.BookService;

public class UpdateBookAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String ADMIN = "admin";
	public static final String INDEX = "index";
	
	public HttpServletRequest request;
	
	private BookService bookService;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	private String isbn;
	private String title;
	private String category;
	private double price;
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String execute() {
		request = ServletActionContext.getRequest();
		
		if (!request.getSession().getAttribute("username").equals("admin")) {
			request.setAttribute("status", "Fatal: you are not administrator!");
			ServletActionContext.setRequest(request);
			return INDEX;
		}
		/*String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		double price = Double.parseDouble(request.getParameter("price"));*/
		
		try {
			Book book = bookService.queryByIsbn(isbn);
			// book not exist, insert operation
			if (book == null && price > 0) {
				book = new Book();
				book.setIsbn(isbn);
				book.setTitle(title);
				book.setCategory(category);
				book.setPrice(price);
				bookService.addBook(book);
				request.setAttribute("status", "Update success: isbn doesn't exist, added.");
			}
			else { // book exist, update operation
				boolean changed = false;
				if (title != null && title != "") {
					book.setTitle(title);
					changed = true;
				}
				if (category != null && category != "") {
					book.setCategory(category);
					changed = true;
				}
				if (price > 0) {
					book.setPrice(price);
					changed = true;
				}
				if (!changed){
					request.setAttribute("status", "Update failed: wrong argument(s)");
					ServletActionContext.setRequest(request);
					return ADMIN;
				}
				bookService.updateBook(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ServletActionContext.setRequest(request);
		return ADMIN;
	}
}