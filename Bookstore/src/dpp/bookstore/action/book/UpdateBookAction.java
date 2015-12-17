package dpp.bookstore.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.pojo.Book;
import dpp.bookstore.action.Action;
import dpp.bookstore.factory.DaoFactory;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for update books.
 * 
 ****************************************************************/
public class UpdateBookAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String path = null;
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		double price = Double.parseDouble(request.getParameter("price"));
		
		try {
			// book not exist, insert operation
			if (DaoFactory.getBookDao().queryByIsbn(isbn) == null && price > 0) {
				Book book = new Book();
				book.setIsbn(isbn);
				book.setTitle(title);
				book.setCategory(category);
				book.setPrice(price);
				DaoFactory.getBookDao().addBook(book);
				request.setAttribute("status", "Update success: isbn doesn't exist, added.");
				path = "/admin/book/updatestatus.jsp";
			}
			else { // book exist, update operation
				if (title != null) {
					DaoFactory.getBookDao().editBookTitle(isbn, title);
					request.setAttribute("status", "Update success.");
					path = "/admin/book/updatestatus.jsp";
				}
				else if (category != null) {
					DaoFactory.getBookDao().editBookCategory(isbn, category);
					request.setAttribute("status", "Update success.");
					path = "/admin/book/updatestatus.jsp";
				}
				else if (price > 0) {
					DaoFactory.getBookDao().editBookPrice(isbn, price);
					request.setAttribute("status", "Update success.");
					path = "/admin/book/updatestatus.jsp";
				}
				else {
					request.setAttribute("status", "Update failed: wrong argument(s)");
					path = "/admin/book/updatestatus.jsp";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return path;
	}

}
