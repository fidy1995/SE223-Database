package dpp.bookstore.action.user;

import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.Action;
import dpp.bookstore.factory.DaoFactory;
import dpp.bookstore.pojo.User;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for update user email.
 * 
 ****************************************************************/
public class EditUserEmailAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String name = String.valueOf(request.getSession().getAttribute("username"));
		String oldmail = String.valueOf(request.getParameter("oldmail"));
		String newmail = String.valueOf(request.getParameter("newmail"));
		
		Vector<String> test = new Vector<String>();
		String[] sp = newmail.split("@"); // email is test@test
		test.addAll(Arrays.asList(sp));
		if (test.size() != 2) { // if email is valid
			request.setAttribute("status", "Edit email failed: invalid email address.");
			return "/user/emailstatus.jsp";
		}
		
		try {
			User user = DaoFactory.getUserDao().queryByName(name);
			if (user.getEmail().equals(oldmail) == false) { // wrong old mail
				request.setAttribute("status", "Edit email failed: wrong old email.");
			}
			else {
				DaoFactory.getUserDao().editUserEmail(name, newmail);
				request.setAttribute("status", "Edit email success.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("username", name);
		return "/user/emailstatus.jsp";
	}

}
