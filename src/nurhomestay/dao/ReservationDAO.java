package nurhomestay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nurhomestay.connection.ConnectionManager;
import nurhomestay.model.Payment;
import nurhomestay.model.Reservation;


public class ReservationDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static Statement stmt2=null;
	static int reserveId, custId, homestayId;
	static Date reservedate, checkindate, checkoutdate;
	static String StaffId;
	private PaymentDAO daoPayment;
	
	public Reservation getReservation (Reservation res) {
		reserveId = res.getReserveid();
		
		String searchQuery = "Select * from reservation where reserveid ='" + reserveId + "'";
		
		try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if customer exists set the isValid variable to true
            if (more) {
                res.setValid(true);
           	}
           
            else if (!more) {            	
            	res.setValid(false);
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

        return res;
	}
	
	
	
	public List<Reservation> getAllReservation(int cid) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		  
		  try {
			  
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			String q = "select * from reservation r join payment p on r.reserveid = p.reserveid where payment_status != 'process refund' and custid = " + cid;
		    ResultSet rs = stmt.executeQuery(q);

		      
		      while (rs.next()) {
		          Reservation res = new Reservation();		          
		          
		          res.setReserveid(rs.getInt("reserveid"));
		          System.out.println("muncul"+rs.getInt("reserveid"));
		          res.setReservedate(rs.getDate("reservedate"));
		          System.out.println("muncul"+rs.getDate("reservedate"));
		          res.setCheckindate(rs.getDate("checkindate"));
		          System.out.println("muncul"+rs.getDate("checkindate"));
		          res.setCheckoutdate(rs.getDate("checkoutdate"));
		          System.out.println("muncul"+rs.getDate("checkoutdate"));
		          res.setHomestayid(rs.getInt("homestayid"));
		          System.out.println("muncul"+rs.getInt("homestayid"));
		          
		          reservations.add(res);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return reservations;
	}
	
	 public Reservation getAllReservationByRes(int rid) {
			Reservation res = new Reservation();
			  
			  try {
				  
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				
				String q = "select * from reservation r join homestay h on r.homestayid = h.homestayid where reserveid = " + rid;
			    ResultSet rs = stmt.executeQuery(q);

			      
			      if (rs.next()) {          
			          
			          res.setReserveid(rs.getInt("reserveid"));
			          System.out.println("muncul"+rs.getInt("reserveid"));
			          res.setReservedate(rs.getDate("reservedate"));
			          System.out.println("muncul"+rs.getDate("reservedate"));
			          res.setCheckindate(rs.getDate("checkindate"));
			          System.out.println("muncul"+rs.getDate("checkindate"));
			          res.setCheckoutdate(rs.getDate("checkoutdate"));
			          System.out.println("muncul"+rs.getDate("checkoutdate"));
			          res.setHomestayid(rs.getInt("homestayid"));
			          System.out.println("muncul"+rs.getInt("homestayid"));
			          res.setHome_name(rs.getString("home_name"));
			          System.out.println("muncul"+rs.getString("home_name"));
			          
			          
			      }
			  }catch (SQLException e) {
			      e.printStackTrace();
			  }

			  return res;
		} 
	 	
	 	public void addReservation(int cid, int home_id, String checkin, String checkout) {
			
			try {
	    		currentCon = ConnectionManager.getConnection();
	    		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    		 Date date = new Date();  
	    		 System.out.println(formatter.format(date));  
	    		
	    		ps=currentCon.prepareStatement("insert into reservation (reservedate, checkindate, checkoutdate, custid, homestayid) values(?, TO_DATE(?), TO_DATE(?),?,?)");
	    		
	    		ps.setString(1,formatter.format(date));
	    		ps.setString(2,checkin);
	    		ps.setString(3, checkout);
	    		ps.setInt(4, cid);
	    		ps.setInt(5,home_id);
	    		ps.executeUpdate();
	    		System.out.println("Success add!");
	            
			} catch (Exception ex) {
	    		System.out.println("failed: An Exception has occurred! " + ex);
	    	}

	    	finally {
	    		if (ps != null) {
	    			try {
	    				ps.close();
	    			} catch (Exception e) {}
	    			ps = null;
	    		}
	    		
	    		if (currentCon != null) {
	    			try {
	    				currentCon.close();
	    			} catch (Exception e) {}
	    			currentCon = null;
	    		}
	    	}
	 	}
			
		//payment	
	 	public Reservation getReservationByCustId(int cid, int home_id, String checkin, String checkout) {
		 		Reservation res = new Reservation();
		 		
				try {				
				
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				
				String q = "select * from reservation where custid = " + cid + " AND homestayid =" + home_id + " AND checkindate = to_date('" + checkin + "') AND checkoutdate = to_date('" + checkout + "')";
			    System.out.println(q);
				ResultSet rs = stmt.executeQuery(q);

			      
			      if (rs.next()) {          
			          
			          res.setReserveid(rs.getInt("reserveid"));
			          System.out.println("muncul"+rs.getInt("reserveid"));
			          res.setReservedate(rs.getDate("reservedate"));
			          System.out.println("muncul"+rs.getDate("reservedate"));
			          res.setCheckindate(rs.getDate("checkindate"));
			          System.out.println("muncul"+rs.getDate("checkindate"));
			          res.setCheckoutdate(rs.getDate("checkoutdate"));
			          System.out.println("muncul"+rs.getDate("checkoutdate"));
			          res.setHomestayid(rs.getInt("homestayid"));
			          System.out.println("muncul"+rs.getInt("homestayid"));
			          
			      }
			  }catch (SQLException e) {
			      e.printStackTrace();
			  }

			  return res;
		 }
			
			public void updateReservation(String checkin, String checkout, int reserveid) {
				
				
				String searchQuery = "UPDATE reservation SET checkindate = to_date ('" 
						+ checkin + "','DD,MM,YYYY')" + ", checkoutdate = to_date ('" + checkout 
						+ "','DD,MM,YYYY') WHERE reserveid = " + reserveid;
				System.out.println(searchQuery);
				
				try {
		    		currentCon = ConnectionManager.getConnection();
		    		stmt = currentCon.createStatement();
					stmt.executeUpdate(searchQuery);
		            
				} catch (Exception ex) {
		    		System.out.println("failed: An Exception has occurred! " + ex);
		    	}
		    	
			}
			
			public void deleteReservationBfr2week(int reserveid) {
				//take note: once delete, no refund of the payment and the reserveid
				//in payment table will change into null
				daoPayment = new PaymentDAO();
				
				Payment paid = new Payment();
				paid = daoPayment.getPaymentByResId(reserveid);
				int paymentid = paid.getPayment_id();
				System.out.println("Dpt payment id tak? "+paymentid);
				
				String searchQuery1 = "Update payment SET payment_status = 'process refund' WHERE payment_id = " + paymentid;
				
				try {

					currentCon = ConnectionManager.getConnection();
					stmt = currentCon.createStatement();
					stmt.executeUpdate(searchQuery1);
					

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			public void deleteReservationWithin2week(int reserveid) {
				//take note: once delete, no refund of the payment and the reserveid
				//in payment table will change into null
				daoPayment = new PaymentDAO();
				
				Payment paid = new Payment();
				paid = daoPayment.getPaymentByResId(reserveid);
				int paymentid = paid.getPayment_id();
				System.out.println("Dpt payment id tak? "+paymentid);
				
				String searchQuery1 = "Update payment SET payment_status = 'burned', reserveid = null WHERE payment_id = " + paymentid;
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
			
			public List<Reservation> getAllReservationOrderBy() {
				List<Reservation> reservations = new ArrayList<Reservation>();
				  
				  try {
					  
					currentCon = ConnectionManager.getConnection();
					stmt = currentCon.createStatement();
					
					String q = "select * from reservation r join homestay h on r.homestayid = h.homestayid join customer c on r.custid = c.custid where checkindate > SYSDATE order by checkindate";
				    ResultSet rs = stmt.executeQuery(q);

				      
				    while (rs.next()) {
				          Reservation res = new Reservation();	       
				          
				          res.setReserveid(rs.getInt("reserveid"));
				          System.out.println("muncul res id"+rs.getInt("reserveid"));
				          res.setReservedate(rs.getDate("reservedate"));
				          System.out.println("muncul"+rs.getDate("reservedate"));
				          res.setCheckindate(rs.getDate("checkindate"));
				          System.out.println("muncul"+rs.getDate("checkindate"));
				          res.setCheckoutdate(rs.getDate("checkoutdate"));
				          System.out.println("muncul"+rs.getDate("checkoutdate"));
				          res.setHomestayid(rs.getInt("homestayid"));
				          System.out.println("muncul"+rs.getInt("homestayid"));
				          res.setCustid(rs.getInt("custid"));
				          System.out.println("muncul"+rs.getInt("custid"));
				          res.setHome_name(rs.getString("home_name"));
				          System.out.println("muncul home name"+rs.getString("home_name"));
				          res.setCustname(rs.getString("cust_name"));
				          reservations.add(res);
				      }
				  } catch (SQLException e) {
				      e.printStackTrace();
				  }

				  return reservations;
			} 
			
			public List<Reservation> getAllReservationProcessRefund() {
				List<Reservation> reservations = new ArrayList<Reservation>();
				  
				  try {
					  
					currentCon = ConnectionManager.getConnection();
					stmt = currentCon.createStatement();
					
					String q = "select * from payment p join reservation r on p.reserveid = r.reserveid join customer c on r.custid = c.custid where payment_status = 'process refund'";
				    ResultSet rs = stmt.executeQuery(q);

				      
				    while (rs.next()) {
				          Reservation res = new Reservation();	       
				          
				          res.setReserveid(rs.getInt("reserveid"));
				          System.out.println("muncul res id"+rs.getInt("reserveid"));
				          res.setReservedate(rs.getDate("reservedate"));
				          System.out.println("muncul"+rs.getDate("reservedate"));
				          res.setCheckindate(rs.getDate("checkindate"));
				          System.out.println("muncul"+rs.getDate("checkindate"));
				          res.setCheckoutdate(rs.getDate("checkoutdate"));
				          System.out.println("muncul"+rs.getDate("checkoutdate"));
				          res.setHomestayid(rs.getInt("homestayid"));
				          System.out.println("muncul"+rs.getInt("homestayid"));
				          res.setCustid(rs.getInt("custid"));
				          System.out.println("muncul"+rs.getInt("custid"));
				          res.setCustname(rs.getString("cust_name"));
				          reservations.add(res);
				      }
				  } catch (SQLException e) {
				      e.printStackTrace();
				  }

				  return reservations;
			} 
			
			public Reservation getHomestayDepositandPrice(int resid) {
				Reservation home = new Reservation();
				
				try {
					currentCon = ConnectionManager.getConnection();
					stmt = currentCon.createStatement();
					
					String q = "select home_deposit, home_price from reservation r join homestay h on r.homestayid = h.homestayid where reserveid = " + resid;
				    ResultSet rs = stmt.executeQuery(q);
				    
				    if (rs.next()) {    
				    	home.setHome_deposit(rs.getDouble("home_deposit"));
				    	home.setHome_price(rs.getDouble("home_price"));
				    }
				    // checking if ResultSet is empty 
				    else if (rs.next() == false) { 
				    	System.out.println("ResultSet in empty in Java"); 
				    }
				} catch (SQLException e) {
					System.out.println("failed: An Exception has occurred! " + e);
				}
					return home;
			}
}
			
		

