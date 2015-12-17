package dpp.bookstore.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dpp.bookstore.action.stats.*;

/******************************************************************
 * 
 * The stats servlet.
 * Deal with stats query(by user, by day/month/year, by categories.
 * 
 ******************************************************************/
@WebServlet(
		name = "StatisticsServlet",
		urlPatterns = { "/stats" }
)
public class StatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public StatisticsServlet() {
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
				readyAction = new UserStatsAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("category")) {
				readyAction = new UserCategoryStatsAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("day")) {
				readyAction = new UserDayStatsAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("month")) {
				readyAction = new UserMonthStatsAction();
				path = readyAction.execute(request, response);
			}
			else if (action.equals("year")) {
				readyAction = new UserYearStatsAction();
				path = readyAction.execute(request, response);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
