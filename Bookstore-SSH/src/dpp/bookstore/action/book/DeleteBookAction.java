package dpp.bookstore.action.book;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.service.BookService;

public class DeleteBookAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String ADMIN = "admin";
	public static final String INDEX = "index";
	
	private HttpServletRequest request;
	
	private BookService bookService;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	private String isbn;
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String s) {
		isbn = s;
	}
	
	public String execute() {
		request = ServletActionContext.getRequest();
		if (!request.getSession().getAttribute("username").equals("admin")) {
			request.setAttribute("status", "Fatal: you are not administrator!");
			ServletActionContext.setRequest(request);
			return INDEX;
		}
		//String isbn = request.getParameter("isbn");
		try {
			if (bookService.queryByIsbn(isbn) == null) {
				request.setAttribute("status", "Delete failed: isbn doesn't exist.");
			}
			else {
				bookService.deleteByIsbn(isbn);
				request.setAttribute("status", "Delete success.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.setRequest(request);
		return ADMIN;
	}
}