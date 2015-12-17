package dpp.bookstore.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.factory.*;
import dpp.bookstore.pojo.User;

/****************************************************************
 * 
 * The login servlet.
 * Deal with user login and logout.
 * 
 ****************************************************************/
@WebServlet(
		name = "LoginServlet",
		urlPatterns = { "/login" }
)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = new String();
		String action = request.getParameter("action");
		try {
			if (action.equals("login")) {
				// username
				String name = request.getParameter("username");
				// password
				String pass = request.getParameter("password");
				User user = DaoFactory.getUserDao().queryByName(name);
				if (user == null) { // if user doesn't exist
					request.setAttribute("status", "Login failed: Username doesn't exist.");
					path = "/logstatus.jsp";
				}
				else if (user.getPassword().equals(pass) == false) { // wrong password
					request.setAttribute("status", "Login failed: Wrong password.");
					path = "/logstatus.jsp";
				}
				else { // a successful login
					request.getSession().setAttribute("username", name);
					request.setAttribute("status", "Login success!");
					path = "/logstatus.jsp";
				}
			}
			else if (action.equals("logout")) {
				// clear username and his cart in session
				request.getSession().setAttribute("username", "");
				request.getSession().setAttribute("cart", "");
				request.setAttribute("status", "Logout success.");
				path = "/logstatus.jsp";
			}
			else { // debug action, never jumps in
				request.setAttribute("status", "Unknown error");
				path = "/logstatus.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
