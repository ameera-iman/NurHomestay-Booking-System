package nurhomestay.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nurhomestay.dao.ReservationDAO;
import nurhomestay.dao.HomestayDAO;
import nurhomestay.dao.PaymentDAO;
import nurhomestay.model.Homestay;
import nurhomestay.model.Reservation;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDAO daoReservation;
	private PaymentDAO daoPayment;
	private HomestayDAO daoHomestay;
	String forward="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
        super();
        daoReservation = new ReservationDAO();
        daoHomestay = new HomestayDAO();
        daoPayment = new PaymentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listreservation")) {
			int cid= Integer.parseInt(request.getParameter("id"));
			
			System.out.println("dpt id cust"+cid);
			forward = "reservation.jsp";
			request.setAttribute("reserves", daoReservation.getAllReservation(cid));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    Date date = new Date();
		    String now = dateFormat.format(date);
		    
		    Date datenow = null;
			try {
				datenow = dateFormat.parse(now);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("date skrg :"+datenow);
			request.setAttribute("datenow", datenow);
			

			RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
			
		} else if (action.equalsIgnoreCase("updateReservation2")) {
			int resid = Integer.parseInt(request.getParameter("resid"));
			
			forward = "custupdatereservation.jsp";
			Reservation res = new Reservation();
			res = daoReservation.getAllReservationByRes(resid);
			Date checkin = res.getCheckindate();
			Date checkout = res.getCheckoutdate();

		    long difference = checkout.getTime() - checkin.getTime();
		    float dayBetween = (difference/ (1000*60*60*24));
		    int daybetweenCinCout = (int) dayBetween;
		    
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    String Scheckin = sdf.format(res.getCheckindate()); //FARA TGK NI AIN ASSIGN VALUE MASUK DH VARIABLE
		    System.out.println("String check in date:"+Scheckin);
		    String Scheckout = sdf.format(res.getCheckoutdate());
		    
		    request.setAttribute("checkin", Scheckin); // THEN BUAT MCM NI UTK SEND KE FILE JSP
		    request.setAttribute("checkout", Scheckout);
		    request.setAttribute("daybetweenCinCout", daybetweenCinCout);
			request.setAttribute("reserves", res);
			request.setAttribute("payment", daoPayment.getPaymentByResId(resid));
			

			RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	        
		} else if (action.equalsIgnoreCase("insertaddReservation")) {
			String Scid = request.getParameter("id");
			System.out.println("dpt"+Scid);
			int cid = 0;
			
			if (Scid.equalsIgnoreCase("null")) {
				forward = "login.jsp";
			}
			
			else {
				cid= Integer.parseInt(request.getParameter("id"));
				System.out.println("dpt "+cid);
				int home_id= Integer.parseInt(request.getParameter("home_id"));
				System.out.println("dpt "+home_id);
				int days = Integer.parseInt(request.getParameter("days"));
				String cin = request.getParameter("checkin");
				String cout = request.getParameter("checkout");
				
				forward = "custafterreservation.jsp";
				
				Homestay homestay = new Homestay();
				
				homestay = daoHomestay.getAvailableHomestay(home_id, cin, cout);
				
				request.setAttribute("days", days);
	        	request.setAttribute("checkindate", cin);
	        	request.setAttribute("checkoutdate", cout);
	        	request.setAttribute("homestay", homestay);
	        	
			}
			
    		RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
				
		} else if (action.equalsIgnoreCase("viewReservation")) {
			int resid = Integer.parseInt(request.getParameter("resid"));
			
			forward = "custviewreservation.jsp";
			request.setAttribute("reserves", daoReservation.getAllReservationByRes(resid));
			request.setAttribute("payment", daoPayment.getPaymentByResId(resid));
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
			
		} else if (action.equalsIgnoreCase("staffviewcustReservation")) {
			int resid = Integer.parseInt(request.getParameter("resid"));
			
			forward = "staffviewcustreservation.jsp";
			request.setAttribute("reserves", daoReservation.getAllReservationByRes(resid));
			request.setAttribute("payment", daoPayment.getPaymentByResId(resid));
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
			
		}else if (action.equalsIgnoreCase("deleteReservation")) {
			int cid = Integer.parseInt(request.getParameter("id"));
			int reserveid= Integer.parseInt(request.getParameter("resid"));
			int day = Integer.parseInt(request.getParameter("day"));
			//int paymentid = Integer.parseInt(request.getParameter("payid"));
			
			if (day > 14 ) {
				daoReservation.deleteReservationBfr2week(reserveid);
			}
			else if (day > 0  && day <= 14) {
				daoReservation.deleteReservationWithin2week(reserveid);
			}

			forward = "reservation.jsp";
			request.setAttribute("reserves", daoReservation.getAllReservation(cid)); 
			

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    Date date = new Date();
		    String now = dateFormat.format(date);
		    
		    Date datenow = null;
			try {
				datenow = dateFormat.parse(now);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("date skrg :"+datenow);
			request.setAttribute("datenow", datenow);
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	        
		} // farahain staff view reservation 
		else if (action.equalsIgnoreCase("staffViewReservation")) {

			forward = "staffviewschedulehomestay.jsp";
			request.setAttribute("reserves", daoReservation.getAllReservationOrderBy());
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
		} 
		else if (action.equalsIgnoreCase("viewStatusPayment")) {

			forward = "staffrefund.jsp";
			request.setAttribute("reserves", daoReservation.getAllReservationProcessRefund());
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("updateReservation")) {
			String checkin = request.getParameter("checkin");
			String checkout = request.getParameter("checkout");
			int cid = Integer.parseInt(request.getParameter("id"));
			int resid = Integer.parseInt(request.getParameter("reserveid"));
			int home_id = Integer.parseInt(request.getParameter("home_id"));
			
			
			Homestay homestay = new Homestay();
			homestay = daoHomestay.getAvailableHomestay(home_id, checkin, checkout);
			
			if (homestay.getHomestayId() != 0) {
				System.out.println("update id" + homestay.getHomestayId());
				daoReservation.updateReservation(checkin, checkout, resid);
				request.setAttribute("reserves", daoReservation.getAllReservation(cid)); 
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			    Date date = new Date();
			    String now = dateFormat.format(date);
			    
			    Date datenow = null;
				try {
					datenow = dateFormat.parse(now);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("date skrg :"+datenow);
				request.setAttribute("datenow", datenow);
				
				forward = "reservation.jsp";
			}
			else {
				System.out.println("not success");
				request.setAttribute("Status", "Not Successful");
			}
			
		} else if (action.equalsIgnoreCase("addReservation")) {
			String Scid = request.getParameter("id");
			System.out.println("dpt"+Scid);
			String Shid = request.getParameter("home_id");
			System.out.println("dpt"+Shid);
			String cin = request.getParameter("checkin");
			String cout = request.getParameter("checkout");
			
			int cid = 0;
			
			if (Scid.equalsIgnoreCase("null")) {
				request.setAttribute("checkindate", cin);
	        	request.setAttribute("checkoutdate", cout);
				forward = "login.jsp";
			}
			
			else {
				cid= Integer.parseInt(request.getParameter("id"));
				System.out.println("dpt cust"+cid);
				int home_id= Integer.parseInt(request.getParameter("home_id"));
				System.out.println("dpt home"+home_id);
				//int days = Integer.parseInt(request.getParameter("days"));
				
				
				//number of days tk dpt lg
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    
			    Date datecin = null, datecout = null;
				try {
					datecin = dateFormat.parse(cin);
					datecout = dateFormat.parse(cout);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    long difference = datecout.getTime() - datecin.getTime();
			    float dayBetween = (difference/ (1000*60*60*24));
			    int day = (int) dayBetween;
			    System.out.println("Number of days :"+day);
				
				Homestay homestay = new Homestay();
				
				homestay = daoHomestay.getAvailableHomestay(home_id, cin, cout);
				
				
				double totprice = homestay.getHome_deposit()+(homestay.getHome_price() * day);
				
				//make price into 2 decimal point
				DecimalFormat priceFormatter = new DecimalFormat("0.00");
	        	String home_price2 = priceFormatter.format(homestay.getHome_price());
	        	String home_deposit2 = priceFormatter.format(homestay.getHome_deposit());
	        	String totprice2 = priceFormatter.format(totprice);
				
				//request.setAttribute("days", days);
	        	request.setAttribute("checkindate", cin);
	        	request.setAttribute("checkoutdate", cout);
	        	request.setAttribute("homestay", homestay);
	        	request.setAttribute("day", day);
	        	request.setAttribute("totprice", totprice2);
	        	request.setAttribute("home_deposit2", home_deposit2);
	        	request.setAttribute("home_price2", home_price2);
	        	forward = "custafterreservation.jsp";
			}
            
		} 
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

}
