package dpp.bookstore.action.stats;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.Order;
import dpp.bookstore.service.OrderService;

public class TimeStatsAction extends ActionSupport {
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
	
	private String time;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String execute() {
		request = ServletActionContext.getRequest();
		String name = String.valueOf(request.getSession().getAttribute("username"));
		String returnPath = null;			
		try {
			Vector<Order> orders = null;
			// admin can see all stats
			if (name.equals("admin")) {
				orders = orderService.queryAll();
				returnPath = RETURN;
			}
			else if (name != "" && name != null) {
				orders = orderService.queryByUsername(name);
				returnPath = RETURN;
			}
			else {
				request.setAttribute("status", "Fatal: you haven't log in!");
				ServletActionContext.setRequest(request);
				return INDEX;
			}
		
			// create map
			HashMap<String, Integer> stats = new HashMap<String, Integer>();
			SimpleDateFormat sdf;
			// format date
			switch (time) {
			case "d":
				sdf = new SimpleDateFormat("YYYY-MM-DD");
				break;
			case "m":
				sdf = new SimpleDateFormat("YYYY-MM");
				break;
			case "y":
				sdf = new SimpleDateFormat("YYYY");
				break;
			default:
				sdf = new SimpleDateFormat("YYYY-MM-DD"); // and you know never this line
			}
			
			// iterate every order
			for (int i = 0; i < orders.size(); i++) {
				// format date
				String date = sdf.format(orders.get(i).getPaytime());
				int quantity = orders.get(i).getAmount();
				// insert map
				if (stats.containsKey(date)) {
					int newValue = stats.get(date) + quantity;
					stats.remove(date);
					stats.put(date, newValue);
				}
				else {
					stats.put(date, quantity);
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