package dpp.bookstore.action.stats;

import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.Order;
import dpp.bookstore.service.OrderService;

public class UserStatsAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	public static final String ADMIN = "admin";
	public static final String INDEX = "index";
	
	public HttpServletRequest request;
	
	private OrderService orderService;
	
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
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
		Object name = request.getSession().getAttribute("username");
		String returnPath = null;
		
		try {
			Vector<Order> orders = null;
			// admin can see all stats
			if (name != null && !name.equals("") && (name.equals("admin") || name.equals(username))) {
				returnPath = RETURN;
			}
			else {
				request.setAttribute("status", "Fatal: you're not doing the right thing!");
				ServletActionContext.setRequest(request);
				return INDEX;
			}
			
			if (username != null && username != "") {
				orders = orderService.queryByUsername(username);
			}
			else {
				orders = orderService.queryAll();
			}
			
			// create map
			HashMap<String, Integer> stats = new HashMap<String, Integer>();
			
			// iterate every order
			for (int i = 0; i < orders.size(); i++) {
				String username = orders.get(i).getUsername();
				int quantity = orders.get(i).getAmount();
				if (stats.containsKey(username)) {
					int newValue = stats.get(username) + quantity;
					stats.remove(username);
					stats.put(username, newValue);
				}
				else {
					stats.put(username, quantity);
				}
			}
			request.getSession().setAttribute("username", name);
			request.setAttribute("statsmap", stats);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ServletActionContext.setRequest(request);
		return returnPath;
	}
}