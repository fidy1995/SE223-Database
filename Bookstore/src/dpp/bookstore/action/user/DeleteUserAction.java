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
 * Provides action for delete user.
 * 
 ****************************************************************/
public class DeleteUserAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String name = String.valueOf(request.getParameter("username"));
		
		try {
			// if user dosen't exist
			if (DaoFactory.getUserDao().queryByName(name) == null) {
				request.setAttribute("status", "Delete failed: username doesn't exist.");
			}
			else if (name == "admin") {
				request.setAttribute("status", "Delete failed: DO NOT COMMIT SUICIDE!!")
			}
			else {
				DaoFactory.getUserDao().deleteUserByName(name);
				request.setAttribute("status", "Delete success.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/admin/user/deletestatus.jsp";
	}

}
