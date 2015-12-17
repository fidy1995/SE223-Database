package dpp.bookstore.action.book;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.Book;
import dpp.bookstore.service.BookService;

public class QueryBookAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	public static final String ADMIN = "admin";
	
	public HttpServletRequest request;
	
	private BookService bookService;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	private String method;
	private String content;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
	
	public String execute() {
		request = ServletActionContext.getRequest();
		//String method = request.getParameter("method");
		//String content = request.getParameter("content");
		Vector<Book> books = new Vector<Book>();
		String returnPath = null;
		try {
			// if no content, query all books
			if (content == null || content.equals("")) {
				books = bookService.queryAll();
			}
			else if (method.equals("title")) { // query by title
				books = bookService.queryByTitle(content);
			}
			else if (method.equals("isbn")) { // by isbn
				Book book = bookService.queryByIsbn(content);
				if (book != null) {
					books.add(book);
				}
			}
			else if (method.equals("category")) { // by category
				books = bookService.queryByCategory(content);
			}
			request.setAttribute("booklist", books);
			Object name = request.getSession().getAttribute("username");
			
			if (name != null && name.equals("admin")) {
				returnPath = ADMIN;
			}
			else {
				returnPath = RETURN;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.setRequest(request);
		return returnPath;
	}
}