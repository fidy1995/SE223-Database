package dpp.bookstore.action.stats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dpp.bookstore.pojo.Order;
import dpp.bookstore.service.BookService;
import dpp.bookstore.service.OrderService;

public class CategoryStatsAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	public static final String ADMIN = "admin";
	public static final String INDEX = "index";
	
	public HttpServletRequest request;
	
	private BookService bookService;
	private OrderService orderService;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public String execute() {
		request = ServletActionContext.getRequest();
		String name = String.valueOf(request.getSession().getAttribute("username"));
		String returnPath = null;
		
		try {
			Vector<Order> orders = null;
			// admin can see all stats
			if (name.equals("admin")) {
				orders = orderService.queryAll();
				returnPath = RETURN;
			}
			else if (name != "" && name != null) {
				orders = orderService.queryByUsername(name);
				returnPath = RETURN;
			}
			else {
				request.setAttribute("status", "Fatal: you haven't log in!");
				ServletActionContext.setRequest(request);
				return INDEX;
			}
			
			// the map for data
			HashMap<String, Integer> stats = new HashMap<String, Integer>();
			
			// iterate every order
			for (int i = 0; i < orders.size(); i++) {
				// get categories
				String categories = bookService
						.queryByIsbn(orders.get(i).getIsbn()).getCategory();
				String[] category = categories.split(";");
				Vector<String> cat = new Vector<String>();
				cat.addAll(Arrays.asList(category));
				
				// get selling stats
				int quantity = orders.get(i).getAmount();
				
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
		
		ServletActionContext.setRequest(request);
		return returnPath;
	}
}