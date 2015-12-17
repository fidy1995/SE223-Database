package dpp.bookstore.action.cart;

import java.util.Arrays;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateCartAction extends ActionSupport {
	public static final long serialVersionUID = 1L;
	public static final String RETURN = "return";
	
	public HttpServletRequest request;
	
	private String bookname;
	private String quantity;
	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String execute() {
		request = ServletActionContext.getRequest();
		String rawOrder = null;
		// if there is no cart
		if (request.getSession().getAttribute("cart") == null
				|| request.getSession().getAttribute("cart").equals("")) {
			rawOrder = new String(bookname + "|" + quantity + ";"); // bookisbn|quantity
		}
		else {
			rawOrder = String.valueOf(request.getSession().getAttribute("cart"));
			Vector<String> rawOrders = new Vector<String>();
			rawOrders.addAll(Arrays.asList(rawOrder.split(";"))); // split out the cart
			rawOrder = "";
			boolean judge = false;
			for (int i = 0; i < rawOrders.size(); i++) { // to see whether is insert or update
				String[] raw = rawOrders.get(i).split("\\|"); // split isbn and quantity
				// if the isbn already exists
				if (raw[0].equals(bookname)) {
					// just update the quantity
					raw[1] = String.valueOf(Integer.parseInt(raw[1]) 
							+ Integer.parseInt(quantity)); 
					judge = true;
				}
				rawOrder = rawOrder + raw[0] + "|" + raw[1] + ";";
			}
			if (judge == false) {
				// if isbn doesn't exist, then 
				rawOrder = rawOrder + bookname + "|" + quantity + ";";
			}
			rawOrder = rawOrder.substring(0, rawOrder.length() - 1);
		}
		request.getSession().setAttribute("cart", rawOrder);
		
		ServletActionContext.setRequest(request);
		return RETURN;
	}
}