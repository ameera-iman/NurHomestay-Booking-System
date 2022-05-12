package nurhomestay.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nurhomestay.connection.ConnectionManager;
import nurhomestay.model.Staff;


public class StaffDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int staffId, managerId;
	static String username,sta_name,sta_phoneNo,sta_email,sta_password,sta_address,role;
	
	public Staff getStaff(Staff staff) {
		username = staff.getUsername();
		sta_email = staff.getSta_email();
		sta_password = staff.getSta_password();

        String searchQuery = "select * from staff where username='" + username + "', sta_email = '" + sta_email+ "', sta_password = '" + sta_password + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if customer exists set the isValid variable to true
            if (more) {
                staff.setValid(true);
           	}
           
            else if (!more) {            	
            	staff.setValid(false);
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

        return staff;
	}
	
	
	
	public void add(Staff staff) {
		username = staff.getUsername();
        sta_name = staff.getSta_name();
        sta_phoneNo = staff.getSta_phoneNo();
        sta_email = staff.getSta_email();
        sta_password = staff.getSta_password();
        sta_address = staff.getSta_address();
        managerId = staff.getManagerId();
        role = staff.getRole();
       
    	try {
    		System.out.print("masuk?");
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into staff (username,sta_name,sta_phoneNo,sta_email,sta_password,sta_address, managerid,role)values(?,?,?,?,?,?,?,?)");
    		System.out.println(ps);
    		
    		ps.setString(1,username);
    		ps.setString(2,sta_name);
    		ps.setString(3,sta_phoneNo);
    		ps.setString(4,sta_email);
    		ps.setString(5,sta_password);
    		ps.setString(6, sta_address);
    		ps.setInt(7,managerId);
    		ps.setString(8, role);
    		ps.executeUpdate();
    	
    		
			System.out.println("Staff id is " + staffId);
    		System.out.println("Staff name is " + sta_name);
    		System.out.println("Staff phone number is " + sta_phoneNo);
			System.out.println("Staff email is " + sta_email);
			System.out.println("Staff address is " + sta_password);
    		System.out.println("Staff password is " + sta_address);
            
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

	public int getStaffId (String username, String password) {
	

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from staff where username=? and sta_password=? ");

			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
		        staffId = rs.getInt("staffId");
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return staffId;
	}
	
	
	public Staff getStaffById(int staffId) {

		Staff staff = new Staff();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from staff where staffId=?");

			ps.setInt(1, staffId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
		        staff.setStaffId(rs.getInt("staffId"));
	            staff.setSta_name(rs.getString("sta_name"));		          
	            staff.setSta_phoneNo(rs.getString("sta_phoneNo"));
	            staff.setSta_password(rs.getString("sta_password"));
	            staff.setSta_address(rs.getString("sta_address"));
	            staff.setSta_email(rs.getString("sta_email"));
	            staff.setUsername(rs.getString("username"));
	            staff.setManagerId(rs.getInt("managerId"));
	            staff.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return staff;
	}
	
	
	public Staff getManagerById(String managerId) {

		Staff staff = new Staff();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from staff where managerId=?");

			ps.setString(1, managerId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
		        staff.setStaffId(rs.getInt("staffId"));
	            staff.setSta_name(rs.getString("sta_name"));		          
	            staff.setSta_phoneNo(rs.getString("sta_phoneNo"));
	            staff.setSta_password(rs.getString("sta_password"));
	            staff.setSta_address(rs.getString("sta_address"));
	            staff.setSta_email(rs.getString("sta_email"));
	            staff.setManagerId(rs.getInt("managerId"));
	            staff.setRole(rs.getString("role"));
	            
	            
			}
	  } catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
		return staff;
	}
	
	//public String getRoleManager() {
         // String role ="";
		//try {
			
			//currentCon = ConnectionManager.getConnection();
			//ps=currentCon.prepareStatement("select role from staff where  role like '%Manager%' ");

			//ps.setInt(1, staffId);
			//ps.setString(2, role);
			//ResultSet rs = ps.executeQuery();

			//if (rs.next()) {
		    //    role = rs.getString("role");
		     //   System.out.println("betul tak role :"+role);
			//}
			
		//}catch (SQLException e) {
		//	System.out.println("failed: An Exception has occurred! " + e);
		//}
		//System.out.println("ROLLLE :"+role);
		//return role;
		
	//}

	public List<Staff> getAllStaff() {
		List<Staff> staffs = new ArrayList<Staff>();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from staff";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		          Staff staff = new Staff();	          
		          
		          staff.setStaffId(rs.getInt("staffId"));
		          staff.setSta_name(rs.getString("sta_name"));
		          staff.setSta_address(rs.getString("sta_address"));
		          staff.setSta_phoneNo(rs.getString("sta_phoneNo"));
		          staff.setSta_email(rs.getString("sta_email"));
		          staff.setSta_password(rs.getString("sta_password"));
		          staff.setUsername(rs.getString("username"));
		          staff.setManagerId(rs.getInt("managerId"));
		          staff.setRole(rs.getString("role"));
		          staffs.add(staff);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return staffs;
	}
	
	public void updateStaff(Staff staff, int sid) {
        
		staffId = sid; //send staff id from controller to dao
		System.out.println("hello"+staffId);
        username = staff.getUsername();
        sta_name = staff.getSta_name();
        sta_phoneNo = staff.getSta_phoneNo();
        sta_email = staff.getSta_email();
        sta_address = staff.getSta_address();
        sta_password = staff.getSta_password();
        //role = staff.getRole();

		String searchQuery = "UPDATE staff SET username='" + username  + "' , sta_name='" 
				+ sta_name + "', sta_phoneno='" + sta_phoneNo  + "' , sta_address='" 
				+ sta_address + "', sta_email='" + sta_email + "' WHERE staffid= '" + staffId + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}

	}
	
	public boolean checkStaffisanAdmin(int staffid) {
		boolean st =false;
        try {
        	//"select distinct manager.* from staff st join staff manager on st.managerId = manager.managerId where st.managerId = "+staffid;
        	//"SELECT * FROM staff WHERE (staffid = "+staffid +" or role = 'Manager' and staffid IN (SELECT managerid FROM staff))";
        	//"select distinct manager.* from staff st join staff manager on st.managerId = manager.managerId where and role = 'Manager' st.managerId = "+staffid;
            //creating connection with the database
            currentCon = ConnectionManager.getConnection();
            String searchQuery = "select * from staff where role = 'Manager' and staffid ="+staffid;
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            System.out.println(searchQuery);
            System.out.println("HAHHAH JAWAPAN DIA PA?:"+st);
            st = rs.next();

        }
        catch(Exception e) {
        	 e.printStackTrace();
        }
        return st;  
	}
	

	public boolean checkUser(String username,String password) 
    {
        boolean st =false;
        try {

            //creating connection with the database
            currentCon = ConnectionManager.getConnection();
            PreparedStatement ps = currentCon.prepareStatement("select * from staff where username=? and sta_password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
        	 e.printStackTrace();
        }
        return st;                 
    }  
	
	public String getManagerName()
	{
		String managerName=null;
		String searchQuery = "select  m.sta_name  from staff e join staff m on e.managerid = m.staffid";
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			while(rs.next())
			{
				 managerName= rs.getString(1);
			}

		}
		catch (Exception ex) {
            System.out.println("failed: An Exception has occurred! " + ex);
        }
		
	
	return managerName;
	}
	
	
	public void updateStaffPassword(String password, int sid) {
        
		String searchQuery = "UPDATE staff SET sta_password='" + password  + "'  WHERE staffid= '" + sid + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			System.out.println("failed: An Exception has occurred! " + e);
		}
	}
	
	public void deleteStaff(int staffId)
	{
		String searchQuery = "delete from staff where staffId=" + "'" + staffId + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
}
