package dpp.bookstore.action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.User;
import dpp.bookstore.service.UserService;

public class RegisterAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String INDEX = "index";
	public static final String FAILED = "failed";
	
	public HttpServletRequest request;
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String username;
	private String password;
	private String passa;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassa() {
		return passa;
	}

	public void setPassa(String passa) {
		this.passa = passa;
	}

	public String execute() {
		request = ServletActionContext.getRequest();
		try {
			/*String name = request.getParameter("username");
			String pass = request.getParameter("password");
			String passa = request.getParameter("passa");*/
			if (password.equals(passa) == false) { // passwords not the same
				request.setAttribute("status", "Register failed: Differ passwords.");
				ServletActionContext.setRequest(request);
				return FAILED;
			}
			else if (userService.queryByName(username) != null) { // user exists
				request.setAttribute("status", "Register failed: Username already exists.");
				ServletActionContext.setRequest(request);
				return FAILED;
			}
			else {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				userService.addUser(user);
				request.setAttribute("status", "Register succeed.");
				request.getSession().setAttribute("username", username);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.setRequest(request);
		return INDEX;
	}
}