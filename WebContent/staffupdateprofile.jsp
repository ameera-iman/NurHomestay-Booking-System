<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html lang="en">

    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">
      <link rel="preconnect" href="https://fonts.gstatic.com">
      <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
  
      <title>Update Profile</title>
  
      <!-- Bootstrap core CSS -->
      <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
      <!-- Additional CSS Files -->
      <link rel="stylesheet" href="assets/css/fontawesome.css">
      <link rel="stylesheet" href="assets/css/templatemo-style.css">
  
    </head>
  
    <body class="is-preload">
  
      <!-- Wrapper -->
      <div id="wrapper">
  
        <!-- Main -->
          <div id="main">
            <div class="inner">
 
	<!-- Side nav -->
	<%
       if(session.getAttribute("staffid") != null) {
    %>
	<div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <%
        	if(session.getAttribute("managerid") != null) {
        %>
        <a href="StaffController?action=staffprofile&staffid=<%= session.getAttribute("staffid")%>">PROFILE</a>
        <button class="dropdown-btn">RESERVATION 
    	<i class="fa fa-caret-down"></i>
  		</button>
  		<div class="dropdown-container">
		    <a href="ReservationController?action=viewStatusPayment">REFUND</a>
  		</div>
  		<button class="dropdown-btn">BRANCH 
    	<i class="fa fa-caret-down"></i>
  		</button>
  		<div class="dropdown-container">
		    <a href="adminaddbranch.jsp">ADD BRANCH</a>
		    <a href="HomestayController?action=listHomestay">LIST BRANCH</a>
  		</div>
  		<button class="dropdown-btn">STAFF 
    	<i class="fa fa-caret-down"></i>
  		</button>
  		<div class="dropdown-container">
		    <a href="admincreatestaff.jsp">ADD STAFF</a>
		    <a href="StaffController?action=listStaff">LIST STAFF</a>
  		</div>
        <a href="adminsalereport.jsp">SALES REPORT</a>
  		<%
            } else {
        %>
  		<a href="StaffController?action=staffprofile&staffid=<%= session.getAttribute("staffid")%>">PROFILE</a>
        <button class="dropdown-btn">RESERVATION 
    	<i class="fa fa-caret-down"></i>
  		</button>
  		<div class="dropdown-container">
		    <a href="ReservationController?action=staffViewReservation">SCHEDULE</a>
		    <a href="ReservationController?action=viewStatusPayment">REFUND</a>
  		</div>
  		<button class="dropdown-btn">BRANCH 
    	<i class="fa fa-caret-down"></i>
  		</button>
  		<div class="dropdown-container">
		    <a href="adminaddbranch.jsp">ADD BRANCH</a>
		    <a href="HomestayController?action=listHomestay">LIST BRANCH</a>
  		</div>
         <%
           }
         %>
      </div>
      <%
         }
      %>
 
  
              <!-- Header -->
            <header id="header">
              <div class="logo">
                <a href="index.jsp"><img src="assets/images/logo nurhomestay6.png"></a>
              </div>
              <div class="kemana-kita">
                	<a href="StaffController?action=logout">Log Out</a>
              </div>
            </header>
            
            
              <section class="main-banner">
              <div class="container-fluid">
              <div class="row">
                  <div class="column">
                    <div class="card">
                      <!--nak buh gambaq ka??
                      <img src="img.jpg" alt="John" style="width:100%"> 
                      -->
                      <h1><c:out value="${staff.username}"/></h1>
                      <p><a href="StaffController?action=staffprofile&staffid=<%= session.getAttribute("staffid")%>"><button>Back</button></a></p>
                    </div>
                  </div>
                  <div class="column-1">
                      <h2>Update Staff Profile</h2><br/><br/>
                      <form name="updatestaff" method="post" action="StaffController?action=updatestaff">
                      <input type="hidden" name="staffid" value="<%= session.getAttribute("staffid")%>"/>
                      <input type="hidden" name="managerId" value="<%= session.getAttribute("Manager2")%>"/>
                      <table>
                          <tr>
                              <td class="labelsize"><label>Username</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="username" type="text" class="form-control"  placeholder="Username" value="<c:out value="${staff.username}" />" required/></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Name</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="sta_name" type="text" class="form-control" placeholder="Name" value="<c:out value="${staff.sta_name}" />" required></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Phone No</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="sta_phoneNo" type="text" class="form-control" placeholder="Email" value="<c:out value="${staff.sta_phoneNo}" />" required></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Address</label></td>
                              <td class="double-dot">:</td>
                              <td><textarea name="sta_address"  placeholder="Address" rows="6"><c:out value="${staff.sta_address}" /></textarea></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Email</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="sta_email" type="text" class="form-control"  placeholder="Email" value="<c:out value="${staff.sta_email}" />" required></td>
                          </tr>
                       
                          
                      </table>
                      
                      <br/><br/><br/><br/>
                      <center><button type="submit">Update</button></center>
                    </form>
                  </div></div></div>
                  </section>
                </div>
            </div>
          </div>
  
      <div class="footer">
          Instagram<br><br>
          Facebook<br><br>
          <br><br><br>
          &#169; 2020 Pilot. All rights reserved
      </div>
  
    <!-- Scripts -->
    
      <script>
        function openNav() {
          document.getElementById("mySidenav").style.width = "250px";
        }
        
        function closeNav() {
          document.getElementById("mySidenav").style.width = "0";
        }
        
        /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
        var dropdown = document.getElementsByClassName("dropdown-btn");
        var i;

        for (i = 0; i < dropdown.length; i++) {
          dropdown[i].addEventListener("click", function() {
          this.classList.toggle("active");
          var dropdownContent = this.nextElementSibling;
          if (dropdownContent.style.display === "block") {
          dropdownContent.style.display = "none";
          } else {
          dropdownContent.style.display = "block";
          }
          });
        }
        </script>    
    
    <!-- Bootstrap core JavaScript -->
      <script src="vendor/jquery/jquery.min.js"></script>
      <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="assets/js/browser.min.js"></script>
      <script src="assets/js/breakpoints.min.js"></script>
      <script src="assets/js/transition.js"></script>
      <script src="assets/js/custom.js"></script>
  </body>
</html>