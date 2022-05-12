package nurhomestay.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nurhomestay.connection.ConnectionManager;
import nurhomestay.model.Customer;

public class CustomerDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int custId;
	static String username, cust_name, cust_phoneNo, cust_email, address, password;
	
	public Customer getCustomer(Customer customer) {
		username = customer.getUsername();

        String searchQuery = "select * from customer where username='" + username + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if customer exists set the isValid variable to true
            if (more) {
                customer.setValid(true);
           	}
           
            else if (!more) {            	
            	customer.setValid(false);
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

        return customer;
	}
	
	public void add(Customer customer) {
        username = customer.getUsername();
        cust_name = customer.getCust_name();
        cust_phoneNo = customer.getCust_phoneNo();
        cust_email = customer.getCust_email();
        address = customer.getAddress();
        password = customer.getPassword();
       
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into customer ( username, cust_name, cust_phoneno, cust_address, cust_email, cust_password)values(?,?,?,?,?,?)");
    		
    		ps.setString(1,username);
    		ps.setString(2,cust_name);
    		ps.setString(3,cust_phoneNo);
    		ps.setString(4, address);
    		ps.setString(5,cust_email);
    		ps.setString(6,password);
    		ps.executeUpdate();
    	
    		
			System.out.println("Username is " + username);
    		System.out.println("Customer name is " + cust_name);
    		System.out.println("Customer Phone Number is " + cust_phoneNo);
			System.out.println("Email is " + cust_email);
			System.out.println("Address is " + address);
    		System.out.println("Password is " + password);
            
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
	
	public boolean checkUser(String username,String password) 
    {
        boolean st =false;
        try {

            //creating connection with the database
            currentCon = ConnectionManager.getConnection();
            PreparedStatement ps = currentCon.prepareStatement("select * from customer where username=? and cust_password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
        	System.out.println("failed: An Exception has occurred! " + e);
        }
        return st;                 
    }  
	
	public int getCustomerId (String uname, String password) {
		int id = 0;

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from customer where username=? and cust_password=?");

			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
		        id = rs.getInt("custid");
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return id;
	}
	
	public Customer getCustomerById(String id) {

		Customer cust = new Customer();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from customer where custid=?");

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
		        cust.setCustId(rs.getInt("custid"));
	            cust.setUsername(rs.getString("username"));		          
	            cust.setCust_name(rs.getString("cust_name"));
	            cust.setCust_phoneNo(rs.getString("cust_phoneno"));
	            cust.setAddress(rs.getString("cust_address"));
	            cust.setCust_email(rs.getString("cust_email"));
	            cust.setPassword(rs.getString("cust_password"));
	            
	            
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return cust;
	}
	
	public void updateCustomer(String username, String cust_name, String cust_phoneNo, String cust_email, String address, String cid) {
        
		custId = Integer.parseInt(cid); //send cust id from controller to dao
		System.out.println("haha"+custId);

		String searchQuery = "UPDATE customer SET username='" + username  + "' , cust_name='" 
				+ cust_name + "', cust_phoneno='" + cust_phoneNo  + "' , cust_address='" 
				+ address + "', cust_email='" + cust_email + "'  WHERE custid= '" + custId + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}

	}
	
	public void updateCustomerPassword(String password, String cid) {
	        
			custId = Integer.parseInt(cid); 
	
			String searchQuery = "UPDATE customer SET cust_password='" + password  + "'  WHERE custid= '" + custId + "'";
	
			try {
	
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				stmt.executeUpdate(searchQuery);
	
			} catch (SQLException e) {
				System.out.println("failed: An Exception has occurred! " + e);
			}
	
		}
	
	
}
