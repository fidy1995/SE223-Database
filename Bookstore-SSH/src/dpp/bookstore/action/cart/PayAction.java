package dpp.bookstore.action.cart;

import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.Order;
import dpp.bookstore.service.OrderService;

public class PayAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	public static final String QUERY = "query";
	
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
		
		if (request.getSession().getAttribute("cart") == null
				|| request.getSession().getAttribute("cart").equals("")) {
			return QUERY;
		}
		
		String rawOrder = String.valueOf(request.getSession().getAttribute("cart"));
		try {
			String username = String.valueOf(request.getSession().getAttribute("username"));
			Vector<String> rawOrders = new Vector<String>();
			rawOrders.addAll(Arrays.asList(rawOrder.split(";")));
			
			// pay for everything
			for (int i = 0; i < rawOrders.size(); i++) {
				String[] raw = rawOrders.get(i).split("\\|");
				Order order = new Order();
				order.setUsername(username);
				order.setIsbn(raw[0]);
				order.setAmount(Integer.parseInt(raw[1]));
				order.setPaytime(new Date());
				orderService.pay(order);
			}
			
			request.getSession().setAttribute("cart", "");
			request.getSession().setAttribute("username", username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.setRequest(request);
		return RETURN;
	}
}