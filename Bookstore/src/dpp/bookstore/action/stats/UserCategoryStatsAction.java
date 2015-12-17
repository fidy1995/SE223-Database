package dpp.bookstore.action.stats;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.Action;
import dpp.bookstore.factory.DaoFactory;
import dpp.bookstore.pojo.Order;

/****************************************************************
 * 
 * The implement of action.
 * Provides action for look stats by category.
 * 
 * Method: Use a string to int map to store selling stats for
 *         books. First get the orders, if the key exists,
 *         update map.getkey(category), else insert into map.
 * 
 ****************************************************************/
public class UserCategoryStatsAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String name = String.valueOf(request.getSession().getAttribute("username"));
		try {
			Vector<Order> orders = null;
			
			// administrator can see all stats, user can only see himself
			if (name.equals("admin")) {
				orders = DaoFactory.getOrderDao().queryAll();
			}
			else {
				orders = DaoFactory.getOrderDao().queryByUsername(name);
			}
			
			// the map for data
			HashMap<String, Integer> stats = new HashMap<String, Integer>();
			
			// iterate every order
			for (int i = 0; i < orders.size(); i++) {
				// get categories
				String categories = DaoFactory.getBookDao()
						.queryByIsbn(orders.get(i).getIsbn()).getCategory();
				String[] category = categories.split(";");
				Vector<String> cat = new Vector<String>();
				cat.addAll(Arrays.asList(category));
				
				// get selling stats
				int quantity = orders.get(i).getQuantity();
				
				// add for each category
				for (int j = 0; j < cat.size(); j++) {
					if (stats.containsKey(cat.get(j))) {
						int newValue = stats.get(cat.get(j)) + quantity;
						stats.remove(cat.get(j));
						stats.put(cat.get(j), newValue);
					}
					else {
						stats.put(cat.get(j), quantity);
					}
				}
			}
			
			request.getSession().setAttribute("username", name);
			request.setAttribute("statsmap", stats);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/stats/stats.jsp";
	}

}
