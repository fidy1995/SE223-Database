package dpp.bookstore.action.cart;

import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.Action;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for add and update cart.
 * 
 ****************************************************************/
public class UpdateCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String rawOrder = null;
		// if there is no cart
		if (request.getSession().getAttribute("cart") == null
				|| request.getSession().getAttribute("cart").equals("")) {
			String name = request.getParameter("bookname");
			String quantity = request.getParameter("quantity");
			rawOrder = new String(name + "|" + quantity); // bookisbn|quantity
		}
		else {
			rawOrder = String.valueOf(request.getSession().getAttribute("cart"));
			Vector<String> rawOrders = new Vector<String>();
			rawOrders.addAll(Arrays.asList(rawOrder.split(";"))); // split out the cart
			rawOrder = "";
			boolean judge = false;
			for (int i = 0; i < rawOrders.size(); i++) { // to see whether is insert or update
				String[] raw = rawOrders.get(i).split("\\|"); // split isbn and quantity
				// if the isbn already exists
				if (raw[0].equals(request.getParameter("bookname"))) {
					// just update the quantity
					raw[1] = String.valueOf(Integer.parseInt(raw[1]) 
							+ Integer.parseInt(request.getParameter("quantity"))); 
					judge = true;
				}
				rawOrder = rawOrder + raw[0] + "|" + raw[1] + ";";
			}
			if (judge == false) {
				// if isbn doesn't exist, then 
				rawOrder = rawOrder + request.getParameter("bookname") + "|"
						+ request.getParameter("quantity") + ";";
			}
			rawOrder = rawOrder.substring(0, rawOrder.length() - 1);
		}
		request.getSession().setAttribute("cart", rawOrder);
		
		return "cart?action=query";
	}

}
