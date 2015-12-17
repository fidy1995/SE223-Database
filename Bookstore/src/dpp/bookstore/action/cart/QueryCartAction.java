package dpp.bookstore.action.cart;

import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.Action;
import dpp.bookstore.pojo.Order;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for query cart.
 * 
 ****************************************************************/
public class QueryCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (request.getSession().getAttribute("cart") == null
				|| request.getSession().getAttribute("cart").equals("")) {
			Vector<Order> orders = new Vector<Order>();
			request.setAttribute("orders", orders);
			return "/cartorder/cart.jsp";
		}
		String rawOrder = String.valueOf(request.getSession().getAttribute("cart"));
		Vector<Order> orders = new Vector<Order>();
		Vector<String> rawOrders = new Vector<String>();
		// split the cart first
		rawOrders.addAll(Arrays.asList(rawOrder.split(";")));
		
		// split isbn and quantity and add to vector
		for (int i = 0; i < rawOrders.size(); i++) {
			Order order = new Order();
			String[] raw = rawOrders.get(i).split("\\|");
			order.setIsbn(raw[0]);
			order.setQuantity(Integer.parseInt(raw[1]));
			orders.add(order);
		}
		
		request.getSession().setAttribute("cart", rawOrder);
		request.setAttribute("orders", orders);
		return "/cartorder/cart.jsp";
	}

}
