package nurhomestay.controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nurhomestay.dao.StaffDAO;

import nurhomestay.model.Staff;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")

public class StaffController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private StaffDAO daoStaff;
	String forward="";
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        daoStaff = new StaffDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String action = request.getParameter("action");
    	
    	if (action.equalsIgnoreCase("viewStaff")) {
        	
            int staffid = Integer.parseInt(request.getParameter("staffid"));
        	
        	Staff staff = new Staff();
        	staff = daoStaff.getStaffById(staffid);        	
        	
        	forward ="adminviewstaff.jsp";       		
            request.setAttribute("staff", staff);       	
      
		}  
        else if (action.equalsIgnoreCase("listStaff")) {
        	
        	request.setAttribute("staffs", daoStaff.getAllStaff());
			forward = "adminliststaff.jsp";
			String name = daoStaff.getManagerName();
			request.setAttribute("tukangpegang",name);
			//Staff staff = new Staff();
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        else if(action.equalsIgnoreCase("staffprofile"))
        {
        	int sid=Integer.parseInt(request.getParameter("staffid"));
        	Staff staff = new Staff();
        	staff = daoStaff.getStaffById(sid); 
        	System.out.println("adminid :"+staff.getManagerId());
        	Staff manager = daoStaff.getStaffById(staff.getManagerId());
        	request.setAttribute("staff", staff);
        	request.setAttribute("Manager2", manager);
        	System.out.println("email:"+staff.getSta_email());
        	System.out.println("name admin:"+manager.getSta_name());
        	
        	forward = "staffprofile.jsp";
        } 
        else if (action.equalsIgnoreCase("updatestaff")) {
			int sid= Integer.parseInt(request.getParameter("staffid"));
        	
			System.out.println("detecting staff"+sid);
        	
			Staff staff = new Staff();
			staff = daoStaff.getStaffById(sid);  	
        	
        	forward = "staffupdateprofile.jsp";
            request.setAttribute("staff", staff); 
        }
        else if (action.equalsIgnoreCase("logout")) {
			HttpSession session=request.getSession();  
            session.invalidate(); 
        	
			System.out.println("Successfully logout");
			forward = "index.jsp";
        }
        else if (action.equalsIgnoreCase("updateStaffPassword")) {
        	
			int sid= Integer.parseInt(request.getParameter("staffid"));
        	
			Staff staff = new Staff();
			staff = daoStaff.getStaffById(sid);    	
        	
        	forward = "staffupdatepassword.jsp";
        	request.setAttribute("staff", staff); 
        }
        else if (action.equalsIgnoreCase("deleteStaff")) {

      		 int staffId=  Integer.parseInt(request.getParameter("staffId"));
   			
   			
      		 daoStaff.deleteStaff(staffId);

   			request.setAttribute("staffs", daoStaff.getAllStaff());
			forward = "adminliststaff.jsp";
			String name = daoStaff.getManagerName();
			request.setAttribute("tukangpegang",name);
   			
           } 
    	RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("createStaff"))
		{
			String username = request.getParameter("username");
			String sta_name = request.getParameter("sta_name");
			String sta_phoneNo = request.getParameter("sta_phoneNo");
			String sta_email = request.getParameter("sta_email");
			String sta_address = request.getParameter("sta_address");
			String sta_password = request.getParameter("sta_password");
			int managerId = Integer.parseInt(request.getParameter("managerId")); //yg ni session tau!
			String role = request.getParameter("role");
			
			Staff staff = new Staff(username,sta_name,sta_phoneNo,sta_address,sta_email,sta_password, managerId,role);
			staff = daoStaff.getStaff(staff);
			
			if(!staff.isValid()){		
	        	
	        	daoStaff.add(staff);
	        	System.out.println("successfully add new staff!");
	        	RequestDispatcher view = request.getRequestDispatcher("adminliststaff.jsp");
	        	request.setAttribute("staffs", daoStaff.getAllStaff());
	        	String name = daoStaff.getManagerName();
				request.setAttribute("tukangpegang",name);
			   view.forward(request, response);
	        } 	
		}		
		else if (action.equalsIgnoreCase("updateStaff")) {
			
			int staffid = Integer.parseInt(request.getParameter("staffid"));
			String username = request.getParameter("username");
			String sta_name = request.getParameter("sta_name");
			String sta_phoneNo = request.getParameter("sta_phoneNo");
			String sta_email = request.getParameter("sta_email");
			String sta_address = request.getParameter("sta_address");
			//String role = request.getParameter("role");
			
			Staff staff = new Staff ();
			staff.setStaff(username, sta_name, sta_phoneNo, sta_email, sta_address);
			
			staff = daoStaff.getStaff(staff);
			
			daoStaff.updateStaff(staff, staffid);							
			
			System.out.println("inserting Staff");
			request.setAttribute("staff", daoStaff.getStaffById(staffid));
			Staff staff2 = new Staff ();
			staff2 = daoStaff.getStaffById(staffid); 
        	Staff admin = daoStaff.getStaffById(staff2.getManagerId());
        	request.setAttribute("Manager2", admin);
			
			forward = "staffprofile.jsp";	
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
		else if (action.equalsIgnoreCase("updateStaffPassword")) {
			
			int staffid = Integer.parseInt(request.getParameter("staffid"));
			String sta_password = request.getParameter("new_password");
							
			daoStaff.updateStaffPassword(sta_password, staffid);							
			
			System.out.println("update staff");
			request.setAttribute("staff", daoStaff.getStaffById(staffid));
			
			Staff staff2 = new Staff ();
			staff2 = daoStaff.getStaffById(staffid); 
        	Staff admin = daoStaff.getStaffById(staff2.getManagerId());
        	request.setAttribute("Admin2", admin);
			
			forward = "staffprofile.jsp";	
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
		else if (action.equalsIgnoreCase("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("sta_password");
			
			if(daoStaff.checkUser(username, password))
	        {	
	        	int id = daoStaff.getStaffId(username, password);
	        	
	        	
	        	if(daoStaff.checkStaffisanAdmin(id)) {
	        		System.out.println("Admin ke?"+id);
	        		HttpSession session = request.getSession();
	        		System.out.println("masuk check admin");
	        		
					session.setAttribute("staffid", id);
					session.setAttribute("managerid", id);
					session.setAttribute("StaffManager", id);
					session.setAttribute("StaffBiasa", id);
				
					Staff staff = new Staff();
		        	staff = daoStaff.getStaffById(id);
		        	Staff manager2 = daoStaff.getStaffById(staff.getManagerId());
		        	request.setAttribute("Manager2", manager2);
		        	System.out.println("managerid :"+staff.getManagerId());
		        	String managerid = ""+staff.getManagerId();
		        	Staff manager = daoStaff.getManagerById(managerid);
		        	String staffrole = ""+staff.getRole();
			        
		        	if(staffrole.equalsIgnoreCase("Manager"))
		        	{
		        		request.setAttribute("StaffManager", staffrole);
		        		System.out.println("masuk staff manager");
		        		
		        	}
		        	
		        	
		        	request.setAttribute("staff", staff);
		        	request.setAttribute("Manager", manager);
		        	System.out.println("email:"+staff.getSta_email());
		        	System.out.println("name admin:"+manager.getSta_name());
		        	forward = "staffprofile.jsp";
		        	
		        	
		        	RequestDispatcher view = request.getRequestDispatcher(forward);
		            view.forward(request, response);
	        	}
	        	else {
	        		System.out.println("masuk else");
	        		System.out.println("Admin ke?"+daoStaff.checkStaffisanAdmin(id));
	        		HttpSession session = request.getSession();
		        	
					session.setAttribute("staffid", id);
					
					Staff staff = new Staff();
		        	staff = daoStaff.getStaffById(id);
		        	request.setAttribute("staff", staff);
		        	
		        	//String staffrole1 = ""+staff.getRole();
			        
		        	//if(staffrole1.equalsIgnoreCase("Staff"))
		        	//{
		        	//	request.setAttribute("StaffBiasa", staffrole1);
		        		//System.out.println("masuk staff biasa");
		        		//System.out.println("value :"+staffrole1);
		        		
		        	//}
		        	
		        	Staff manager2 = daoStaff.getStaffById(staff.getManagerId());
		        	request.setAttribute("Manager2", manager2);
		        	System.out.println(staff.getSta_email());
		        	forward = "staffprofile.jsp";
		        	
		        	
		        	RequestDispatcher view = request.getRequestDispatcher(forward);
		            view.forward(request, response);
	        	}
	        }
	        else
	        {
	           System.out.println("Username or Password incorrect");
	           RequestDispatcher rs = request.getRequestDispatcher("stafflogin.jsp");
	           rs.include(request, response);
	        }
		}
	}
	
}