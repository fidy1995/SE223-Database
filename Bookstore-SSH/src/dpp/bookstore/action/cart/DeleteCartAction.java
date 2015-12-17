package dpp.bookstore.action.cart;

import java.util.Arrays;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	
	public HttpServletRequest request;
	
	private String isbn;
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String execute() {
		request = ServletActionContext.getRequest();
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
		ServletActionContext.setRequest(request);
		return RETURN;
	}
}