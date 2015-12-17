package dpp.bookstore.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.user.*;

/******************************************************************
 * 
 * The user servlet.
 * Deal with user update, query and delete.
 * 
 ******************************************************************/
@WebServlet(
		name = "UserServlet", 
		urlPatterns = { "/user" }
)
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		String action = request.getParameter("action");
		Action readyAction = null;
		
		try {
			if (action.equals("delete")) {
				readyAction = new DeleteUserAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("password")) {
				readyAction = new EditUserPasswordAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("email")) {
				readyAction = new EditUserEmailAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("query")) {
				readyAction = new QueryUserAction();
				path = readyAction.execute(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
