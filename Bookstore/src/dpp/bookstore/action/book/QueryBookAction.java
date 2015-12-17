package dpp.bookstore.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.Action;
import dpp.bookstore.pojo.Book;
import dpp.bookstore.factory.*;

import java.util.Vector;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for query books.
 * 
 ****************************************************************/
public class QueryBookAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String path = null;
		String method = request.getParameter("method");
		String content = request.getParameter("content");
		Vector<Book> books = new Vector<Book>();
		try {
			// if no content, query all books
			if (content == null || content.equals("")) {
				books = DaoFactory.getBookDao().queryAll();
			}
			else if (method.equals("bytitle")) { // query by title
				books = DaoFactory.getBookDao().queryByTitle(content);
			}
			else if (method.equals("byisbn")) { // by isbn
				Book book = DaoFactory.getBookDao().queryByIsbn(content);
				if (book != null) {
					books.add(book);
				}
			}
			else if (method.equals("bycategory")) { // by category
				books = DaoFactory.getBookDao().queryByCategory(content);
			}
			request.setAttribute("booklist", books);
			if (request.getSession().getAttribute("username") != null
					&& request.getSession().getAttribute("username").equals("admin")) {
				path = "/admin/book/querybook.jsp";
			}
			else {
				path = "/book/booklist.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}
