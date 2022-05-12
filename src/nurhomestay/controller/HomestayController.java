package nurhomestay.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nurhomestay.dao.HomestayDAO;
import nurhomestay.dao.HomestayImgDAO;
import nurhomestay.dao.PaymentDAO;
import nurhomestay.dao.ReservationDAO;
import nurhomestay.model.Homestay;
import nurhomestay.model.Reservation;

/**
 * Servlet implementation class HomestayController
 */
@WebServlet("/HomestayController")
public class HomestayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomestayDAO daoHomestay;
	private PaymentDAO daoPayment;
	private ReservationDAO daoReservation;
	private HomestayImgDAO daoHomestayImg;
	String forward="";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomestayController() {
        super();
        daoHomestay = new HomestayDAO();
        daoReservation = new ReservationDAO();
        daoPayment = new PaymentDAO();
        daoHomestayImg = new HomestayImgDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listallhomestay")) {
			forward = "index.jsp";
			request.setAttribute("homestays", daoHomestay.getAllHomestay());
		
		} else if (action.equalsIgnoreCase("viewBranch")) {
        	
        	int homestayId=  Integer.parseInt(request.getParameter("homestayId"));
        	
        	Homestay homestay= new Homestay();
        	homestay = daoHomestay.getHomestayById(homestayId);        	
        	
        	DecimalFormat priceFormatter = new DecimalFormat("0.00");
        	request.setAttribute("priceFormatter", priceFormatter); 
        	
        	request.setAttribute("homestayImages", daoHomestayImg.getAllHomestayImgByHomestayId(homestayId));
            request.setAttribute("homestay", homestay); 
            
            forward ="adminviewbranch.jsp";
      
		} else if (action.equalsIgnoreCase("addImage")) {
        	
        	int homestayId = Integer.parseInt(request.getParameter("homestayId"));
        	
        	Homestay homestay= new Homestay();
        	homestay = daoHomestay.getHomestayById(homestayId);        	
        	
        	forward ="adminaddimage.jsp";       		
            request.setAttribute("homestay", homestay); 
			request.setAttribute("homestayImg", daoHomestayImg.getAllHomestayImgByHomeid(homestayId));
      
		} else if (action.equalsIgnoreCase("viewBranch2")) {
        	
        	int homestayId=  Integer.parseInt(request.getParameter("homestayId"));
        	
        	Homestay homestay= new Homestay();
        	homestay = daoHomestay.getHomestayById(homestayId);
        	
        	DecimalFormat priceFormatter = new DecimalFormat("0.00");
        	
        	forward ="custviewbranch.jsp";       		
            request.setAttribute("homestay", homestay);
            request.setAttribute("homestayImages", daoHomestayImg.getAllHomestayImgByHomestayId(homestayId));
            request.setAttribute("priceFormatter", priceFormatter);
      
		} else if (action.equalsIgnoreCase("listHomestay")) {
 			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = new Date();
		    String now = dateFormat.format(date);
		    
		    Date datenow = null;
			try {
				datenow = dateFormat.parse(now);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("now", datenow);
            request.setAttribute("homestay", daoHomestay.getAllHomestay());
            request.setAttribute("homestayImg", daoHomestayImg.getAllHomestayImg());
            DecimalFormat priceFormatter = new DecimalFormat("0.00");
        	request.setAttribute("priceFormatter", priceFormatter); 
            forward = "adminlistbranch.jsp";
          
					
		} else if (action.equalsIgnoreCase("deleteBranch")) {

   		 int homestayId=  Integer.parseInt(request.getParameter("homestayId"));
			
			
   		 daoHomestay.deleteHomestay(homestayId);

			forward = "adminlistbranch.jsp";
			request.setAttribute("homestay", daoHomestay.getAllHomestay()); 
			DecimalFormat priceFormatter = new DecimalFormat("0.00");
        	request.setAttribute("priceFormatter", priceFormatter); 
			
        } else if (action.equalsIgnoreCase("updateBranch")) {	
         	
   		    int homestayId=  Integer.parseInt(request.getParameter("homestayId"));

   		    Homestay homestay= new Homestay();
        	homestay = daoHomestay.getHomestayById(homestayId);
        	
        	DecimalFormat priceFormatter = new DecimalFormat("0.00");
         	String home_price2 = priceFormatter.format(homestay.getHome_price());
         	String home_deposit2 = priceFormatter.format(homestay.getHome_deposit());
        	 
        	forward = "adminupdatebranch.jsp";
            request.setAttribute("homestay", homestay); 
            request.setAttribute("home_price2", home_price2);
            request.setAttribute("home_deposit2", home_deposit2);
	
        }
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
	    
		if (action.equalsIgnoreCase("addBranch")) {
			String home_name = request.getParameter("home_name");
			String home_address = request.getParameter("home_address");
			String home_desc = request.getParameter("home_desc");
			//int homestayId = Integer.parseInt(request.getParameter("homestayId"));
			double home_price = Double.parseDouble(request.getParameter("home_price"));
			double home_deposit = Double.parseDouble(request.getParameter("home_deposit"));
			
			Homestay homestay = new Homestay(home_name, home_address, home_desc, home_price, home_deposit);							
			
			homestay= daoHomestay.getHomestay(homestay);
		
			if(!homestay.isValid()){		
				System.out.println("add new branch");
	        	daoHomestay.addNewBranch(homestay);
	        	RequestDispatcher view = request.getRequestDispatcher("adminlistbranch.jsp");
				//request.setAttribute("homestay", homestay);
	        	 request.setAttribute("homestay", daoHomestay.getAllHomestay());
	        	 DecimalFormat priceFormatter = new DecimalFormat("0.00");
	         	request.setAttribute("priceFormatter", priceFormatter); 
				view.forward(request, response);
	        } 
		}
		else if (action.equalsIgnoreCase("updateBranch")) { 
			String home_name = request.getParameter("home_name");
			String home_address = request.getParameter("home_address");
			String home_desc = request.getParameter("home_desc");
			int homestayId = Integer.parseInt(request.getParameter("homestayId"));
			double home_price = Double.parseDouble(request.getParameter("home_price"));
			double home_deposit = Double.parseDouble(request.getParameter("home_deposit"));

			Homestay homestay = new Homestay(home_name, home_address, home_desc, home_price, home_deposit);							
			
			homestay= daoHomestay.getHomestay(homestay);
			
			daoHomestay.updateBranch(homestay, homestayId);
			
			System.out.println("update customer");
			request.setAttribute("homestay", daoHomestay.getHomestayById(homestayId));
			System.out.println(homestay.getHome_price());
			
			request.setAttribute("homestay", daoHomestay.getAllHomestay());
	        request.setAttribute("homestayImg", daoHomestayImg.getAllHomestayImg());
	        DecimalFormat priceFormatter = new DecimalFormat("0.00");
        	request.setAttribute("priceFormatter", priceFormatter); 
	        forward = "adminlistbranch.jsp";
	        
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
			
		} else if (action.equalsIgnoreCase("checkAvailable")) {
			String cin = request.getParameter("checkindate");
			String cout = request.getParameter("checkoutdate");
			System.out.println("Check available"+ cin);
			

			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
			Date dateCin = null;
			try {
				dateCin = formatter1.parse(cin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			Date dateCout = null;
			try {
				dateCout = formatter1.parse(cout);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    String Scheckin = sdf.format(dateCin);
		    System.out.println("String check in date:"+Scheckin);
		    String Scheckout = sdf.format(dateCout);
        	
		    DecimalFormat priceFormatter = new DecimalFormat("0.00");
		    
        	List<Homestay> homestays = daoHomestay.getAllAvailableHomestay(Scheckin, Scheckout);
        	request.setAttribute("homestays", homestays);
        	request.setAttribute("checkindate", Scheckin);
        	request.setAttribute("checkoutdate", Scheckout);
        	request.setAttribute("priceFormatter", priceFormatter);
			
			forward = "checkavailable.jsp";
			RequestDispatcher view = request.getRequestDispatcher(forward);
		    view.forward(request, response);
		} 
		else if (action.equalsIgnoreCase("checkAvailable2")) {
			String cin = request.getParameter("checkindate");
			System.out.println("Check-in"+cin);
			String cout = request.getParameter("checkoutdate");
			int resid = Integer.parseInt(request.getParameter("resid"));
			int home_id = Integer.parseInt(request.getParameter("home_id"));
			int daybetweenCinCout = Integer.parseInt(request.getParameter("daybetweenCinCout"));
			System.out.println("Check available"+ cin);
			
	
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
			Date dateCin = null;
			try {
				dateCin = formatter1.parse(cin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			Date dateCout = null;
			try {
				dateCout = formatter1.parse(cout);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			//calculate hari between selection check in and check out

		    long difference = dateCout.getTime() - dateCin.getTime();
		    float dayBetween = (difference/ (1000*60*60*24));
		    int daybetweenCinCoutSelection = (int) dayBetween;
		    System.out.println("Day selection"+daybetweenCinCoutSelection);
		    
		    if (daybetweenCinCoutSelection <= daybetweenCinCout) {
		    	if(daoHomestay.checkAvailableForUpdate(home_id, cin, cout)) {
		    		forward = "custupdatereservation2.jsp"; // custupdatereservation2 utk update
		    		
					Reservation res = new Reservation();
					res = daoReservation.getAllReservationByRes(resid);
				    
				    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				    String Scheckin = sdf.format(dateCin);
				    System.out.println("String check in date:"+Scheckin);
				    String Scheckout = sdf.format(dateCout);
				    
				    request.setAttribute("checkin", Scheckin);
				    request.setAttribute("checkout", Scheckout);
					request.setAttribute("reserves", res);
					request.setAttribute("payment", daoPayment.getPaymentByResId(resid));
		    	}
		    	else {
		    		request.setAttribute("checkavailable", "N"); //not available
			    	forward = "custupdatereservation2.jsp";
		    	}
		    }
		    else {
		    	System.out.println("Total day choose more than previous booking day");
		    	forward = "custupdatereservation2.jsp";
		    	request.setAttribute("checkavailable", "M"); //selection day more than the total day reserve
		    }
		    RequestDispatcher view = request.getRequestDispatcher(forward);
		    view.forward(request, response);
			
		} 
	}

}
