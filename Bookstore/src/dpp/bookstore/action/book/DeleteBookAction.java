package dpp.bookstore.action.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.Action;
import dpp.bookstore.factory.DaoFactory;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for delete books.
 * 
 ****************************************************************/
public class DeleteBookAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String path = null;
		String isbn = request.getParameter("isbn");
		try {
			if (DaoFactory.getBookDao().queryByIsbn(isbn) == null) {
				request.setAttribute("status", "Delete failed: isbn doesn't exist.");
				path = "/admin/book/deletestatus.jsp";
			}
			else {
				DaoFactory.getBookDao().deleteByIsbn(isbn);
				request.setAttribute("status", "Delete success.");
				path = "/admin/book/deletestatus.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
