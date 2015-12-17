package dpp.bookstore.action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.service.UserService;

public class DeleteUserAction extends ActionSupport {
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

	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() {
		request = ServletActionContext.getRequest();
		//String name = String.valueOf(request.getParameter("username"));
		
		try {
			// if user dosen't exist
			if (userService.queryByName(username) == null) {
				request.setAttribute("status", "Delete failed: username doesn't exist.");
			}
			else if (username == "admin") {
				request.setAttribute("status", "Delete failed: DO NOT COMMIT SUICIDE!!");
			}
			else {
				userService.deleteUserByName(username);
				request.setAttribute("status", "Delete success.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.setRequest(request);
		return RETURN;
	}
}