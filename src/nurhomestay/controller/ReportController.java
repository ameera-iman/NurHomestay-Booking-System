package nurhomestay.controller;

import java.io.IOException;
import java.text.DecimalFormat;

//import java.text.DecimalFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nurhomestay.dao.PaymentDAO;
//import nurhomestay.dao.PaymentDAO;

//import nurhomestay.model.Payment;

/**
 * Servlet implementation class HomestayController
 */
@WebServlet("/ReportController")

public class ReportController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	private PaymentDAO daoPayment;
	String forward="";
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController() {
        super();
        daoPayment = new PaymentDAO();
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("viewreport"))
		{   
			String tahun = request.getParameter("year");
			System.out.println(tahun);
			if(tahun !=null)
			{
				
				Double tot = daoPayment.calcTotal(tahun);
				request.setAttribute("tot",tot);
				DecimalFormat priceFormatter = new DecimalFormat("0.00");
				request.setAttribute("priceFormatter", priceFormatter); 
				RequestDispatcher rd=request.getRequestDispatcher("/adminsalereport.jsp");
			    rd.forward(request,response);
			    System.out.println(tot);
			}
			
		}
		//RequestDispatcher view = request.getRequestDispatcher(forward);
        //view.forward(request, response);
	}
}
