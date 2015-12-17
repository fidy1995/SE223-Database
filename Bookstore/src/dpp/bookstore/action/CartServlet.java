package dpp.bookstore.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.cart.*;

/****************************************************************
 * 
 * The cart servlet.
 * Deal with cart add, update, query, delete, and pay.
 * cartFormat == isbn1|quantity1;isbn2|quantity2;...isbnn|quantityn
 * Cart is stored in session.
 * 
 ****************************************************************/
@WebServlet(
		name = "CartServlet",
		urlPatterns = { "/cart" }
)
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		String action = request.getParameter("action");
		Action readyAction = null;
		
		try {
			if (action.equals("query")) {
				readyAction = new QueryCartAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("delete")) {
				readyAction = new DeleteCartAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("add")) {
				readyAction = new UpdateCartAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("pay")) {
				readyAction = new PayForAllAction();
				path = readyAction.execute(request, response);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
