package dpp.bookstore.action.cart;

import java.util.Arrays;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.Order;

public class QueryCartAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	
	public HttpServletRequest request;
	
	public String execute() {
		request = ServletActionContext.getRequest();
		Vector<Order> orders = new Vector<Order>();
		if (request.getSession().getAttribute("cart") == null
				|| request.getSession().getAttribute("cart").equals("")) {
			request.setAttribute("orders", orders);
			ServletActionContext.setRequest(request);
			return RETURN;
		}
		String rawOrder = String.valueOf(request.getSession().getAttribute("cart"));
		Vector<String> rawOrders = new Vector<String>();
		// split the cart first
		rawOrders.addAll(Arrays.asList(rawOrder.split(";")));
		
		// split isbn and quantity and add to vector
		for (int i = 0; i < rawOrders.size(); i++) {
			Order order = new Order();
			String[] raw = rawOrders.get(i).split("\\|");
			order.setIsbn(raw[0]);
			order.setAmount(Integer.parseInt(raw[1]));
			orders.add(order);
		}
		
		request.getSession().setAttribute("cart", rawOrder);
		request.setAttribute("orders", orders);
		ServletActionContext.setRequest(request);
		return RETURN;
	}
}