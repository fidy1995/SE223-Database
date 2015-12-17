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
 * Provides action for delete cart.
 * 
 ****************************************************************/
public class DeleteCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String isbn = request.getParameter("isbn");
		String rawOrder = String.valueOf(request.getSession().getAttribute("cart"));
		Vector<String> rawOrders = new Vector<String>();
		rawOrders.addAll(Arrays.asList(rawOrder.split(";")));
		rawOrder = "";
		
		for (int i = 0; i < rawOrders.size(); i++) {
			String[] raw = rawOrders.get(i).split("\\|");
			if (!raw[0].equals(isbn)) {
				rawOrder = rawOrder + rawOrders.get(i) + ";";
			}
		}
		
		rawOrder.substring(0, rawOrder.length() - 1);
		request.getSession().setAttribute("cart", rawOrder);
		return "cart?action=query";
	}

}
