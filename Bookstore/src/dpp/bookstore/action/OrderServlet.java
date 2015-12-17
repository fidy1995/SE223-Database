package dpp.bookstore.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.pojo.Order;
import dpp.bookstore.factory.*;

import java.util.Vector;

/****************************************************************
 * 
 * The order servlet.
 * Deal with order add and query.
 * 
 ****************************************************************/
@WebServlet(
		name = "OrderServlet",
		urlPatterns = { "/order" }
)
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		String name = String.valueOf(request.getSession().getAttribute("username"));
		Vector<Order> orders = new Vector<Order>();
		
		try {
			if (name.equals("admin")) { // admin can see all orders
				orders = DaoFactory.getOrderDao().queryAll();
				request.setAttribute("orders", orders);
				path = "/admin/order/order.jsp";
			}
			else { // while users can only see himself
				orders = DaoFactory.getOrderDao().queryByUsername(name);
				request.setAttribute("orders", orders);
				path = "/cartorder/orderform.jsp";
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		request.getSession().setAttribute("username", name);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
