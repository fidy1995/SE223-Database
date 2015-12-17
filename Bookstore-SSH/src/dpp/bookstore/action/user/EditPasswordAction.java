package dpp.bookstore.action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.User;
import dpp.bookstore.service.UserService;

public class EditPasswordAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	public static final String ADMIN = "admin";
	
	public HttpServletRequest request;
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String username;
	private String oldpass;
	private String newpass;
	private String newpassa;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldpass() {
		return oldpass;
	}

	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public String getNewpassa() {
		return newpassa;
	}

	public void setNewpassa(String newpassa) {
		this.newpassa = newpassa;
	}

	public String execute() {
		request = ServletActionContext.getRequest();
		/*String name = String.valueOf(request.getSession().getAttribute("username"));
		String oldpass = String.valueOf(request.getParameter("oldpass"));
		String newpass = String.valueOf(request.getParameter("newpass"));
		String newpassa = String.valueOf(request.getParameter("newpassa"));*/
		
		try {
			if (request.getSession().getAttribute("username").equals("admin")) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(newpass);
				userService.updateUser(user);
				request.setAttribute("status", "Edit password success.");
				ServletActionContext.setRequest(request);
				return ADMIN;
			}
			if (newpass.equals(newpassa) == false) {
				request.setAttribute("status", "Edit password failed: differ passwords.");
			}
			else if (userService.queryByName(username).getPassword().equals(oldpass) == false) {
				request.setAttribute("status", "Edit password failed: incorrect old password.");
			}
			else {
				User user = new User();
				user.setUsername(username);
				user.setPassword(newpass);
				userService.updateUser(user);
				request.setAttribute("status", "Edit password success.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("username", username);
		ServletActionContext.setRequest(request);
		return RETURN;
	}
}