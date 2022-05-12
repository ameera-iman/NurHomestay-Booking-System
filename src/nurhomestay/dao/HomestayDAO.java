package nurhomestay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nurhomestay.connection.ConnectionManager;
import nurhomestay.model.Homestay;


public class HomestayDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int homeid;
	static String home_name, home_address, home_desc;
	static double home_price, home_deposit;
	
	public Homestay getHomestay(Homestay homestay) {
		homeid = homestay.getHomestayId();

        String searchQuery = "select * from homestay where homestayid='" + homeid + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if homestay exists set the isValid variable to true
            if (more) {
                homestay.setValid(true);
           	}
           
            else if (!more) {            	
            	homestay.setValid(false);
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

        return homestay;
	}
	
	public List<Homestay> getAllHomestay() {
		List<Homestay> homestays = new ArrayList<Homestay>();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from homestay";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          Homestay homestay = new Homestay();		          
		          
		          homestay.setHomestayId(rs.getInt("homestayId"));
		          homestay.setHome_name(rs.getString("home_name"));
		          homestay.setHome_address(rs.getString("home_address"));
		          homestay.setHome_desc(rs.getString("home_desc"));
		          homestay.setHome_price(rs.getDouble("home_price"));
		          homestay.setHome_deposit(rs.getDouble("home_deposit"));
		          System.out.println("muncul"+rs.getString("home_name"));
		          homestays.add(homestay);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return homestays;
	}
	
	public Homestay getHomestayById(int id) {

		Homestay home = new Homestay();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from homestay where homestayid=?");

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				home.setHomestayId(rs.getInt("homestayId"));
				System.out.println("kahkah"+rs.getInt("homestayId"));
				home.setHome_name(rs.getString("home_name"));
				home.setHome_address(rs.getString("home_address"));
				home.setHome_desc(rs.getString("home_desc"));
				home.setHome_price(rs.getDouble("home_price"));
				home.setHome_deposit(rs.getDouble("home_deposit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return home;
	}
	
	public void addNewBranch(Homestay homestay) {
		//homeid = homestay.getHomestayId();
		home_name = homestay.getHome_name() ;
		home_address = homestay.getHome_address();
		home_desc = homestay.getHome_desc() ;
		home_price = homestay.getHome_price();
		home_deposit = homestay.getHome_deposit();
      
       
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into homestay (home_name, home_address, home_desc, home_price, home_deposit)values(?,?,?,?,?)");
    		
    		//ps.setInt(1, homeid);
    		ps.setString(1,home_name);
    		ps.setString(2,home_address);
    		ps.setString(3, home_desc);
    		ps.setDouble(4,home_price);
    		ps.setDouble(5, home_deposit);
    		ps.executeUpdate();
    	
    		//System.out.println("Homestay id name is " + homeid);
    		System.out.println("Homestay name is " + home_name);
    		System.out.println("Homestay address is " +home_address);
			System.out.println("Homestay description is " + home_desc);
			System.out.println("Homestay price is " + home_price);
			System.out.println("Homestay price is " + home_deposit);
    		
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

	public void deleteHomestay(int homestayId)
	{
		String searchQuery1 = "delete from homestayImg where homestayId = " + " ' " + homestayId + "'";
		String searchQuery = "delete from homestay where homestayId=" + "'" + homestayId + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery1);
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public void updateBranch(Homestay homestay, int homeid) {

		//homeid = homestay.getHomestayId();
		home_name=homestay.getHome_name();
		home_address = homestay.getHome_address();	       
		home_desc = homestay.getHome_desc();
		home_price = homestay.getHome_price();
		home_deposit = homestay.getHome_deposit();	

		String searchQuery = "UPDATE homestay SET home_name='" +home_name  + "' , home_address='" +home_address + "',home_desc='" + home_desc + "' ,home_price= '" + home_price + "' ,home_deposit= '" + home_deposit + "' WHERE homestayId= '" + homeid + "'";
		System.out.println(searchQuery);
		
		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public Homestay getAvailableHomestay(int home_id, String dateCin, String dateCout) {
		Homestay home = new Homestay();

		try {
			currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  	
		 
		  	String q = "Select * from homestay where homestayid = " + home_id + " AND (select homestayid from reservation where checkindate < to_date('" + dateCout + "') AND checkoutdate > to_date('" + dateCin + "') AND homestayid = '" + home_id + "') is null";
		  	
		  	System.out.println(q);
		    ResultSet rs = stmt.executeQuery(q);

		    if (rs.next()) {
		    	System.out.println("ResultSet not empty in Java"); 
		    	
	            home.setHomestayId(rs.getInt("homestayid"));
	            System.out.println("muncul"+rs.getInt("homestayid"));
	            
	            home.setHome_name(rs.getString("home_name"));
	            System.out.println("muncul"+rs.getString("home_name"));
	            
	            home.setHome_price(rs.getDouble("home_price"));
	            System.out.println("muncul"+rs.getDouble("home_price"));
	            
	            home.setHome_address(rs.getString("home_address"));
	            System.out.println("muncul"+rs.getString("home_address"));
	            
	            home.setHome_desc(rs.getString("home_desc"));
	            System.out.println("muncul"+rs.getString("home_desc"));
	            
	            home.setHome_deposit(rs.getDouble("home_deposit"));
	            System.out.println("muncul"+rs.getDouble("home_deposit"));

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
	
	public List<Homestay> getAllAvailableHomestay(String dateCin, String dateCout) {
		List<Homestay> homestays = new ArrayList<Homestay>();

		try {
			currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  	
		 
		  	String q = "Select * from homestay where homestayid not in (select homestayid from reservation where checkindate < to_date('" + dateCout + "') AND checkoutdate > to_date('" + dateCin + "'))";
		  	
		  	System.out.println(q);
		    ResultSet rs = stmt.executeQuery(q);

		    while (rs.next()) {
		    	Homestay home = new Homestay();
		    	
		    	System.out.println("ResultSet not empty in Java"); 
		    	
	            home.setHomestayId(rs.getInt("homestayid"));
	            System.out.println("muncul"+rs.getInt("homestayid"));
	            
	            home.setHome_name(rs.getString("home_name"));
	            System.out.println("muncul"+rs.getString("home_name"));
	            
	            home.setHome_price(rs.getDouble("home_price"));
	            System.out.println("muncul"+rs.getDouble("home_price"));
	            
	            home.setHome_address(rs.getString("home_address"));
	            System.out.println("muncul"+rs.getString("home_address"));
	            
	            home.setHome_desc(rs.getString("home_desc"));
	            System.out.println("muncul"+rs.getString("home_desc"));
	            
	            home.setHome_deposit(rs.getDouble("home_deposit"));
	            System.out.println("muncul"+rs.getDouble("home_deposit"));
	            
	            homestays.add(home);
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return homestays;
	}
	public boolean checkAvailableForUpdate(int home_id, String dateCin, String dateCout) {
		boolean st = false;

		try {
			currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  	
		  	String q = "Select * from homestay where homestayid = " + home_id + " AND (select homestayid from reservation where checkindate < to_date('" + dateCout + "', 'yyyy-MM-DD') AND checkoutdate > to_date('" + dateCin + "', 'yyyy-MM-DD') AND homestayid = '" + home_id + "') is null";
		  	
		  	System.out.println(q);
		    ResultSet rs = stmt.executeQuery(q);
		    st = rs.next();
		    
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return st;
	}

}
		