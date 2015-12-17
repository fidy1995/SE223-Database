package dpp.bookstore.action.user;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.User;
import dpp.bookstore.service.UserService;

public class QueryUserAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	
	public HttpServletRequest request;
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() {
		request = ServletActionContext.getRequest();
		Vector<User> users = new Vector<User>();
		try {
			users = userService.queryAll();
			request.setAttribute("userlist", users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.setRequest(request);
		return RETURN;
	}
}