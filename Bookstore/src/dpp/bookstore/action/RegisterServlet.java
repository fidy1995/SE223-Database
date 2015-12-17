package dpp.bookstore.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.factory.DaoFactory;
import dpp.bookstore.pojo.User;

/****************************************************************
 * 
 * The register servlet.
 * Deal with user register.
 * 
 ****************************************************************/
@WebServlet(
		name = "RegisterServlet",
		urlPatterns = { "/register" }
)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/****************************
	 *  Check if email is valid.
	 ****************************/
	public boolean validEmail(String email) {
		int count = 0; // the '@' count
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				count++;
			}
		}
		if (count != 1) { //no '@' or more than one
			return false;
		}
		return true;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		try {
			String name = request.getParameter("username");
			String pass = request.getParameter("password");
			String passa = request.getParameter("passa");
			String mail = request.getParameter("email");
			if (pass.equals(passa) == false) { // passwords not the same
				request.setAttribute("status", "Register failed: Differ passwords.");
				path = "regstatus.jsp";
			}
			else if (!this.validEmail(mail)) { // email invalid
				request.setAttribute("status", "Register failed: Email not valid.");
				path = "regstatus.jsp";
			}
			else if (DaoFactory.getUserDao().queryByName(name) != null) { // user exists
				request.setAttribute("status", "Register failed: Username already exists.");
				path = "regstatus.jsp";
			}
			else {
				User user = new User();
				user.setUsername(name);
				user.setPassword(pass);
				user.setEmail(mail);
				DaoFactory.getUserDao().addUser(user);
				request.setAttribute("status", "Register succeed.");
				request.getSession().setAttribute("username", name);
				path = "regstatus.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
