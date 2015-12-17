package dpp.bookstore.action.user;

import java.io.IOException;
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
 * Provides action for query all users.
 * 
 ****************************************************************/
public class QueryUserAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Vector<User> users = new Vector<User>();
		try {
			users = DaoFactory.getUserDao().queryAll();
			request.setAttribute("userlist", users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/user/users.jsp";
	}

}
