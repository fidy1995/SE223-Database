package dpp.bookstore.action.stats;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.Action;
import dpp.bookstore.factory.*;
import dpp.bookstore.pojo.Order;

import java.util.Vector;
import java.util.HashMap;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for look stats by user.
 * 
 * Method: Use a string to int map to store selling stats for
 *         books. First get the orders, if the key exists,
 *         update map.getkey(category), else insert into map.
 * 
 ****************************************************************/
public class UserStatsAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String path = null;
		String name = String.valueOf(request.getSession().getAttribute("username"));
		
		try {
			Vector<Order> orders = null;
			// admin can see all stats
			if (name.equals("admin")) {
				orders = DaoFactory.getOrderDao().queryAll();
			}
			else {
				orders = DaoFactory.getOrderDao().queryByUsername(name);
			}
			
			// create map
			HashMap<String, Integer> stats = new HashMap<String, Integer>();
			
			// iterate every order
			for (int i = 0; i < orders.size(); i++) {
				String username = orders.get(i).getUsername();
				int quantity = orders.get(i).getQuantity();
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
			path = "/stats/stats.jsp";	

		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}
