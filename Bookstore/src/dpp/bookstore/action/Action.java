package dpp.bookstore.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****************************************************************
 * 
 * The interface of action.
 * Provide execute function to business operations.
 * 
 ****************************************************************/
public interface Action {
	// returns forward path
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;
}
