package nurhomestay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import nurhomestay.connection.ConnectionManager;
import nurhomestay.model.Payment;


public class PaymentDAO{
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static Statement stmt2=null;	
	static int payment_id;
	static Date payment_date;
	static double paymentAmount;
	static String paymentDesc, year;
	static double total=00.00;
	
	public Payment getPayment(Payment payment) {
		payment_id = payment.getPayment_id();

        String searchQuery = "select * from payment where payment_id='" + payment_id + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if customer exists set the isValid variable to true
            if (more) {
            	payment.setValid(true);
           	}
           
            else if (!more) {            	
            	payment.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return payment;
	}
	
	public void addpaymentforCust(Double totalpay, int reserveid) {
		
		try {
    		currentCon = ConnectionManager.getConnection();
    		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    		 Date date = new Date();  
    		 System.out.println(formatter.format(date));  
    		
    		ps=currentCon.prepareStatement("insert into payment (paymentAmount, reserveid, payment_status) values(?,?,?)");
    		System.out.println(ps);
    		
    		ps.setDouble(1,totalpay);
    		ps.setInt(2,reserveid);
    		ps.setString(3,"received");
    		ps.executeUpdate();
    		System.out.println("Success add!");
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
	
	public Payment getPaymentByResId(int reserveid) {
		Payment paid = new Payment();
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			String q = "select * from payment where reserveid = " + reserveid;
		    ResultSet rs = stmt.executeQuery(q);
		    System.out.println(q);
		    
		    if (rs.next()) {          
		          
		    	  paid.setPayment_id(rs.getInt("payment_id"));
		          System.out.println("muncul"+rs.getInt("payment_id"));
		          paid.setPayment_date(rs.getDate("payment_date"));
		          System.out.println("muncul"+rs.getDate("payment_date"));
		          paid.setPaymentAmount(rs.getDouble("paymentAmount"));
		          System.out.println("muncul"+rs.getDouble("paymentAmount"));
		          paid.setStatus(rs.getString("payment_status"));
		          System.out.println("muncul"+rs.getString("payment_status"));
		          
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
	public void updatePaymentAfterRefund(double paymentReceived, int paymentid, int reserveid, int staffid) {
		
		String searchQuery1 = "Update payment SET payment_status = 'refund', reserveid = null, paymentamount = " + paymentReceived + ",  staffid = " + staffid + " WHERE payment_id = " + paymentid;
		System.out.println(searchQuery1);
		String searchQuery2 = "delete from reservation where reserveid=" + reserveid;
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery1);
			
			stmt2 = currentCon.createStatement();
			stmt2.executeUpdate(searchQuery2);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Double calcTotal(String year)
	{
		
		String searchQuery = "select sum(paymentamount) from payment where to_char(payment_date,'YYYY')= '"+year+"'";
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			while(rs.next())
			{
				total = rs.getDouble(1);
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
		return total;

	}
}
