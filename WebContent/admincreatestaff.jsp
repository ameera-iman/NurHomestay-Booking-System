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
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">

    <title>Create Staff Profile</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">

  </head>

<body class="is-preload">

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
        <!--  <a href="adminsalereport.jsp">SALES REPORT</a>-->
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
      <header id="header" style="margin-top: 0px;">
        <span style="font-size:36px;cursor:pointer; margin-left: 20px;margin-top: 30px;" onclick="openNav()">&#9776;</span>
        <div class="logo">
          <img src="assets/images/logo nurhomestay6.png" width="280">
        </div>
        <div class="kemana-kita">
          <a href="StaffController?action=logout">Log Out</a>
        </div>
      </header>

      <br><br>
      <section class="main-banner">
        <div class="container-fluid">
      <div class="row">
        <div class="column">
        	<!-- 
            <div class="card">
                
              </div> -->
        </div>
        <div class="column-1">
        <form id="createstaff" name="createStaff" action="StaffController?action=createStaff" method="post">
            <h2>Create Staff Profile</h2><br/><br/>
            <table>
                <tr>
                    <td class="labelsize"><label>Username</label></td>
                    <td class="double-dot">:</td>
                    <td><input name="username" type="text" class="form-control" id="username" placeholder="username" required></td>
                </tr>
                <tr>
                    <td class="labelsize"><label>Staff Name</label></td>
                    <td class="double-dot">:</td>
                    <td><input name="sta_name" type="text" class="form-control" id="sta_name" placeholder="Name" required></td>
                </tr>
                <tr>
                    <td class="labelsize"><label>Staff Phone </label></td>
                    <td class="double-dot">:</td>
                    <td><input name="sta_phoneNo" type="number" class="form-control" id="sta_phoneNo" placeholder="Phone No" required></td>
                </tr>
                <tr>
                    <td class="labelsize"><label>Staff Email</label></td>
                    <td class="double-dot">:</td>
                    <td><input name="sta_email" type="email" class="form-control" id="sta_email" placeholder="Email" required></td>
                </tr>
                <tr>
                    <td class="labelsize"><label>Staff Address</label></td>
                    <td class="double-dot">:</td>
                    <td><textarea name="sta_address" id="sta_address" placeholder="Address" class="form-control" required></textarea></td>
                </tr>
                <tr>
                    <td class="labelsize"><label>Staff Password</label></td>
                    <td class="double-dot">:</td>
                    <td><input name="sta_password" type="password" class="form-control" id="sta_password" placeholder="Password" required></td>
                </tr>
                  <tr>
                    <td class="labelsize"><label>Position</label></td>
                    <td class="double-dot">:</td>
                    <td><select name="role" class="form-control" required>
					 				<option value="Staff">Staff</option>
					 				<option vaue="Manager">Manager</option>
					 	</select>
					 </td>
                </tr>
            </table>
            <input type="hidden" name="managerId" value="<%= session.getAttribute("staffid")%>"/>
            <br><br>
            <center><button type="submit" value="Submit">Submit</button></center>
            </form>
			</div>
        </div>
      </div></section>

      <div class="footer">
        Instagram<br><br>
        Facebook<br><br>
        <br><br><br>
        &#169; 2020 Pilot. All rights reserved
    </div>
    
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
  </body>

</html>
