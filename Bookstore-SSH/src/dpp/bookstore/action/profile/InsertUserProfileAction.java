package dpp.bookstore.action.profile;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.service.UserProfileService;

public class InsertUserProfileAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	
	public HttpServletRequest request;
	
	private UserProfileService userProfileService;
	
	private String username;
	
	public void setUsername(String s) {
		username = s;
	}
	
	public String execute() {
		request = ServletActionContext.getRequest();
		//String name = request.getParameter("username");
		
		try {
			userProfileService = new UserProfileService();
			userProfileService.insertUserProfile(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.setRequest(request);
		return RETURN;
	}
}