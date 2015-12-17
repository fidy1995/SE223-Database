package dpp.bookstore.action.cart;

import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.Action;
import dpp.bookstore.factory.DaoFactory;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for pay.
 * 
 ****************************************************************/
public class PayForAllAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String path = new String(); 
		
		if (request.getSession().getAttribute("cart") == null
				|| request.getSession().getAttribute("cart").equals("")) {
			return "book?action=query";
		}
		
		String rawOrder = String.valueOf(request.getSession().getAttribute("cart"));
		try {
			String username = String.valueOf(request.getSession().getAttribute("username"));
			Vector<String> rawOrders = new Vector<String>();
			rawOrders.addAll(Arrays.asList(rawOrder.split(";")));
			
			// pay for everything
			for (int i = 0; i < rawOrders.size(); i++) {
				String[] raw = rawOrders.get(i).split("\\|");
				DaoFactory.getOrderDao().pay(username, raw[0], Integer.parseInt(raw[1]));
			}
			
			request.getSession().setAttribute("cart", "");
			request.getSession().setAttribute("username", username);
			path = "order?action=query";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
