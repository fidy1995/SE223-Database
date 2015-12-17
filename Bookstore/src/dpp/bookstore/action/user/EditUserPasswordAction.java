package dpp.bookstore.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.Action;
import dpp.bookstore.factory.DaoFactory;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for update user password.
 * 
 ****************************************************************/
public class EditUserPasswordAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String name = String.valueOf(request.getSession().getAttribute("username"));
		String oldpass = String.valueOf(request.getParameter("oldpass"));
		String newpass = String.valueOf(request.getParameter("newpass"));
		String newpassa = String.valueOf(request.getParameter("newpassa"));
		
		try {
			if (newpass.equals(newpassa) == false) {
				request.setAttribute("status", "Edit password failed: differ passwords.");
			}
			else if (DaoFactory.getUserDao().queryByName(name).getPassword().equals(oldpass) == false) {
				request.setAttribute("status", "Edit password failed: incorrect old password.");
			}
			else {
				DaoFactory.getUserDao().editUserPassword(name, newpass);
				request.setAttribute("status", "Edit password success.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("username", name);
		return "/user/passwordstatus.jsp";
	}

}
