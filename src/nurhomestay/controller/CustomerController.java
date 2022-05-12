package nurhomestay.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nurhomestay.dao.CustomerDAO;
import nurhomestay.model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO daoCustomer;
	String forward="";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        daoCustomer = new CustomerDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("viewCustomer")) {
			String cid= ""+request.getParameter("id");
        	
			
			System.out.println("detecting customer"+cid);
        	Customer cust = new Customer();
        	cust = daoCustomer.getCustomerById(cid);       
        	request.setAttribute("cust", cust);
        	forward = "custprofile.jsp";
			
		}
		else if (action.equalsIgnoreCase("staffviewCustomer")) {
			String cid= ""+request.getParameter("id");
        	
			
			System.out.println("detecting customer"+cid);
        	Customer cust = new Customer();
        	cust = daoCustomer.getCustomerById(cid);       
        	request.setAttribute("cust", cust);
        	forward = "staffviewcustprofile.jsp";
			
		}
		else if (action.equalsIgnoreCase("updatecustomer")) {
			String cid= ""+request.getParameter("id");
        	
			System.out.println("detecting customer"+cid);
        	
        	Customer cust = new Customer();
        	cust = daoCustomer.getCustomerById(cid);  	
        	
        	forward = "custupdateprofile.jsp";
            request.setAttribute("cust", cust); 
        }
		else if (action.equalsIgnoreCase("updatePassword")) {
			String cid= ""+request.getParameter("id");
        	
			System.out.println("detecting customer"+cid);
        	
        	Customer cust = new Customer();
        	cust = daoCustomer.getCustomerById(cid);  	
        	
        	forward = "custupdatepassword.jsp";
            request.setAttribute("cust", cust); 
        }
		else if (action.equalsIgnoreCase("logout")) {
			HttpSession session=request.getSession();  
            session.invalidate(); 
        	
			System.out.println("Successfully logout");
			forward = "index.jsp";
        }
		
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		
		if (action.equalsIgnoreCase("signup")) {
			String username = request.getParameter("username");
			String cust_name = request.getParameter("cust_name");
			String cust_phoneNo = request.getParameter("cust_phoneNo");
			String cust_email = request.getParameter("cust_email");
			String address = request.getParameter("address");
			String password = request.getParameter("password");
			
			Customer customer = new Customer(username, cust_name, cust_phoneNo, cust_email, address, password);				
			
			customer = daoCustomer.getCustomer(customer);
		
			if(!customer.isValid()){			
				System.out.println("inserting customer");
	        	daoCustomer.add(customer);
	        	forward= "login.jsp?action=login";
	        	RequestDispatcher view = request.getRequestDispatcher(forward);
	            view.forward(request, response);
	        }
		}
		
		else if (action.equalsIgnoreCase("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(daoCustomer.checkUser(username, password))
	        {	
	        	int id = daoCustomer.getCustomerId(username, password);
	        	HttpSession session = request.getSession();
	        	
				session.setAttribute("id", id);
				
				String cid= ""+id;
	        	
	        	Customer cust = new Customer();
	        	cust = daoCustomer.getCustomerById(cid);
	        	request.setAttribute("cust", cust);
	        	System.out.println(cust.getCust_email());
	        	forward = "index.jsp";
	        	
	        	RequestDispatcher view = request.getRequestDispatcher(forward);
	            view.forward(request, response);
	            
	        }
	        else
	        {
	           System.out.println("Username or Password incorrect");
	           RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
	           rs.include(request, response);
	        }
		}
		else if (action.equalsIgnoreCase("updatecustomer")) {
			
			String custid = request.getParameter("id");
			String username = request.getParameter("username");
			String cust_name = request.getParameter("cust_name");
			String cust_phoneNo = request.getParameter("cust_phoneNo");
			String cust_email = request.getParameter("cust_email");
			String address = request.getParameter("address");
							
			
			daoCustomer.updateCustomer(username, cust_name, cust_phoneNo, cust_email, address, custid);							
			
			System.out.println("update customer");
			request.setAttribute("cust", daoCustomer.getCustomerById(custid));
			forward = "custprofile.jsp";	
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
		else if (action.equalsIgnoreCase("updateCustomerPassword")) {
			
			String custid = request.getParameter("id");
			String password = request.getParameter("new_password");
							
			
			daoCustomer.updateCustomerPassword(password, custid);							
			
			System.out.println("update customer");
			request.setAttribute("cust", daoCustomer.getCustomerById(custid));
			forward = "custprofile.jsp";	
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
	}
	
}
