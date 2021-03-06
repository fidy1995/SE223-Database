package dpp.bookstore.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.book.*;

/****************************************************************
 * 
 * The book servlet.
 * Deal with book add, update, query and delete.
 * 
 ****************************************************************/
@WebServlet(
		name = "BookServlet",
		urlPatterns = { "/book" }
)
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BookServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = new String();
		String action = request.getParameter("action");
		Action readyAction = null; // the Action ready to be executed
		
		try {
			if (action.equals("query")) {
				readyAction = new QueryBookAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("delete")) {
				readyAction = new DeleteBookAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("update")) {
				readyAction = new UpdateBookAction();
				path = readyAction.execute(request, response);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
