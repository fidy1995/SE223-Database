package dpp.bookstore.action.stats;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
 * Provides action for look stats by year.
 * 
 * Method: Use a string to int map to store selling stats for
 *         books. First get the orders, if the key exists,
 *         update map.getkey(category), else insert into map.
 * 
 * P.S. It is the same as day.
 * 
 ****************************************************************/
public class UserYearStatsAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String name = String.valueOf(request.getSession().getAttribute("username"));
		try {
			Vector<Order> orders = null;
			if (name.equals("admin")) {
				orders = DaoFactory.getOrderDao().queryAll();
			}
			else {
				orders = DaoFactory.getOrderDao().queryByUsername(name);
			}
			HashMap<String, Integer> stats = new HashMap<String, Integer>();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
			
			for (int i = 0; i < orders.size(); i++) {
				String date = sdf.format(orders.get(i).getPaiddate());
				int quantity = orders.get(i).getQuantity();
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
		return "/stats/stats.jsp";
	}

}
