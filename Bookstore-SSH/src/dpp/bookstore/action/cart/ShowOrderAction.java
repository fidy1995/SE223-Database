package dpp.bookstore.action.cart;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.Order;
import dpp.bookstore.service.OrderService;

public class ShowOrderAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	public static final String ADMIN = "admin";
	
	public HttpServletRequest request;
	
	private OrderService orderService;
	
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String execute() {
		request = ServletActionContext.getRequest();
		String returnPath = null;
		String name = String.valueOf(request.getSession().getAttribute("username"));
		Vector<Order> orders = new Vector<Order>();
		
		try {
			if (name.equals("admin")) { // admin can see all orders
				orders = orderService.queryAll();
				request.setAttribute("orders", orders);
				returnPath = ADMIN;
			}
			else { // while users can only see himself
				orders = orderService.queryByUsername(name);
				request.setAttribute("orders", orders);
				returnPath = RETURN;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		request.getSession().setAttribute("username", name);

		ServletActionContext.setRequest(request);
		return returnPath;
	}
}