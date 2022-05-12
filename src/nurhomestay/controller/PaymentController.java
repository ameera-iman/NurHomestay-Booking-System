package nurhomestay.controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nurhomestay.dao.OnlinePaymentDAO;
import nurhomestay.dao.PaymentDAO;
import nurhomestay.dao.ReservationDAO;
import nurhomestay.model.Onlinepayment;
import nurhomestay.model.Payment;
import nurhomestay.model.Reservation;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaymentDAO daoPayment;
	private ReservationDAO daoReservation;
	private OnlinePaymentDAO daoOnlinePayment;
	
	String forward="";	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
        super();
        daoPayment = new PaymentDAO();
        daoReservation = new ReservationDAO();
        daoOnlinePayment = new OnlinePaymentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String action = request.getParameter("action");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action = request.getParameter("action");
		
		 if (action.equalsIgnoreCase("makePayment")) {
				int cid = Integer.parseInt(request.getParameter("id"));
				System.out.println("dpt ke??"+cid);
				
				String bankName = request.getParameter("methodpay");
				System.out.println("dpt ke??"+bankName);
				
				String accnumber = request.getParameter("accnumber");
				System.out.println("dpt ke??"+accnumber);
				
				int home_id= Integer.parseInt(request.getParameter("home_id"));
				System.out.println("dpt ke home id??"+request.getParameter("home_id"));
				
				System.out.println("dpt ke checkin??"+request.getParameter("checkin"));
				String checkin = request.getParameter("checkin");
				
				String checkout = request.getParameter("checkout");
				
				Double totalpay = Double.parseDouble(request.getParameter("totalpay"));
				
				daoReservation.addReservation(cid, home_id, checkin, checkout);
				Reservation res = new Reservation();

				res = daoReservation.getReservationByCustId(cid, home_id, checkin, checkout); //
				int reserveid = res.getReserveid();
				System.out.println("reserve id:"+reserveid);
				
				if(!res.isValid()) {
					daoPayment.addpaymentforCust(totalpay, reserveid);
					
					Payment paid = new Payment();
					paid = daoPayment.getPaymentByResId(reserveid);
					int paymentid = paid.getPayment_id();
					
					daoOnlinePayment.addOnlinePayment(paymentid, bankName, accnumber);
					
					Onlinepayment onlinepaid = new Onlinepayment();
					onlinepaid = daoOnlinePayment.getOnlinePaymentByPaymentId(paymentid);
					
					System.out.println("Thank you. Bayar!!");
					
					if(!response.isCommitted()) {
						forward = "SuccessReservation.jsp";
						request.setAttribute("paid", paid);
						request.setAttribute("onlinepaid", onlinepaid);
			            DecimalFormat priceFormatter = new DecimalFormat("0.00");
			        	request.setAttribute("priceFormatter", priceFormatter); 
						
					}
				}
				
				RequestDispatcher view = request.getRequestDispatcher(forward);
		        view.forward(request, response);
				
				
		} else if (action.equalsIgnoreCase("payReservation")) {
			System.out.println("Ok cuba"+request.getParameter("id"));
		 	int id = Integer.parseInt(request.getParameter("id"));
		 	
			System.out.println(request.getParameter("home_id"));
			int home_id= Integer.parseInt(request.getParameter("home_id"));
			
			String checkin = request.getParameter("checkin");
			
			String checkout = request.getParameter("checkout");
			
			System.out.println(request.getParameter("totalpay"));
			Double totalpay = Double.parseDouble(request.getParameter("totalpay"));
        	
			forward = "payment.jsp";
        	request.setAttribute("home_id", home_id);
        	request.setAttribute("checkin", checkin);
        	request.setAttribute("checkout", checkout);
        	request.setAttribute("totalpay", totalpay);
        	request.setAttribute("cid", id);
        	RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
        	
		}
		 else if (action.equalsIgnoreCase("payRefundCustomer")) {
				System.out.println("Ok cuba"+request.getParameter("resid"));
			 	int resid = Integer.parseInt(request.getParameter("resid"));
			 	
			 	int staffid = Integer.parseInt(request.getParameter("staffid"));
			 	
				Payment paid = daoPayment.getPaymentByResId(resid);
				Reservation home = daoReservation.getHomestayDepositandPrice(resid);
				
				double paymentAmount = paid.getPaymentAmount();
				double home_deposit = home.getHome_deposit();
				
				double paymentRefund = paymentAmount - home_deposit;
				double paymentReceived = paymentAmount - paymentRefund;
				
				daoPayment.updatePaymentAfterRefund(paymentReceived, paid.getPayment_id(), resid, staffid);
				
				forward = "staffrefund.jsp";
				request.setAttribute("reserves", daoReservation.getAllReservationProcessRefund());
	        	RequestDispatcher view = request.getRequestDispatcher(forward);
		        view.forward(request, response);
	        	
			}
		 	
		 
	}

}
