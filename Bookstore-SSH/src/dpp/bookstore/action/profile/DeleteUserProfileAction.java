package dpp.bookstore.action.profile;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.service.UserProfileService;

public class DeleteUserProfileAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	
	public HttpServletRequest request;
	
	private UserProfileService userProfileService;
	
	private String username;
	
	public void setUsername(String s) {
		username = s;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String execute() {
		request = ServletActionContext.getRequest();
		//String name = String.valueOf(request.getParameter("username"));
		
		try {
			userProfileService = new UserProfileService();
			userProfileService.deleteUserProfile(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.setRequest(request);
		return RETURN;
	}
}