package nurhomestay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

import nurhomestay.connection.ConnectionManager;
import nurhomestay.model.Onlinepayment;


/**
 * Servlet implementation class OnlinePaymentDAO
 */
@WebServlet("/OnlinePaymentDAO")
public class OnlinePaymentDAO{
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int paymentid;
	static String accname, bankname;
	
	public void addOnlinePayment(int paymentid, String bankName, String accnumber) {
		
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into onlinepayment (payment_id, accname, bankname)values(?,?,?)");
    		ps.setInt(1, paymentid);
    		ps.setString(2, accnumber);
    		ps.setString(3, bankName);
    		ps.executeUpdate();
    	
    		System.out.println("Succesful add!!!");
            
    	}

    	catch (Exception ex) {
    		System.out.println("failed: An Exception has occurred! " + ex);
    	}

    	finally {
    		if (ps != null) {
    			try {
    				ps.close();
    			} catch (Exception e) {
    			}
    			ps = null;
    		}
    		
    		if (currentCon != null) {
    			try {
    				currentCon.close();
    			} catch (Exception e) {
    			}
    			currentCon = null;
    		}
    	}
	}
	
	
	public Onlinepayment getOnlinePaymentByPaymentId(int payment_id) {
		Onlinepayment paid = new Onlinepayment();
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			String q = "select * from onlinepayment where payment_id = " + payment_id;
		    ResultSet rs = stmt.executeQuery(q);
		    System.out.println(q);
		    
		    if (rs.next()) {          
		          
		          paid.setAccName(rs.getString("accname"));
		          System.out.println("muncul"+rs.getString("accname"));
		          paid.setBankName(rs.getString("bankname"));
		          System.out.println("muncul"+rs.getString("bankname"));
		          
		      }
    	}
		catch (Exception ex) {
    		System.out.println("failed: An Exception has occurred! " + ex);
    	}

    	finally {
    		if (ps != null) {
    			try {
    				ps.close();
    			} catch (Exception e) {
    			}
    			ps = null;
    		}
    		
    		if (currentCon != null) {
    			try {
    				currentCon.close();
    			} catch (Exception e) {
    			}
    			currentCon = null;
    		}
    	}
		return paid;
	}
}
