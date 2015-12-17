package dpp.bookstore.action.user;

import javax.servlet.http.HttpServletRequest;
  

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.User;
import dpp.bookstore.service.UserService;

public class LoginAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String FAILED = "failed";
	public static final String SUCCESS = "success";
	
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

	public String execute() {
		try {
			request = ServletActionContext.getRequest();
			
			User user = userService.queryByName(username);
			if (user == null) { // if user doesn't exist
				request.setAttribute("status", "Login failed: Username doesn't exist.");
				ServletActionContext.setRequest(request);
				return FAILED;
			}
			else if (user.getPassword().equals(password) == false) { // wrong password
				request.setAttribute("status", "Login failed: Wrong password.");
				ServletActionContext.setRequest(request);
				return FAILED;
			}
			else { // a successful login
				request.getSession().setAttribute("username", username);
				request.setAttribute("status", "Login success!");
				ServletActionContext.setRequest(request);
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("status", "Never here!");
		ServletActionContext.setRequest(request);
		return FAILED;
	}
}