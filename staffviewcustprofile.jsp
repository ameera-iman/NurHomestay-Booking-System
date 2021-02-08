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

    <title>Schedule Homestay</title>

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
        	if(session.getAttribute("adminid") != null) {
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
      <header id="header" style="margin-top: 0px;">
        <span style="font-size:36px;cursor:pointer; margin-left: 20px;margin-top: 30px;" onclick="openNav()">&#9776;</span>
        <div class="logo">
          <img src="assets/images/logo nurhomestay6.png">
        </div>
        <div class="kemana-kita">
          <a href="index.jsp">Home</a>
       	  <a href="rumahinfo.jsp">Gallery</a>
          <a href="about.jsp">About Us</a>
          <a href="StaffController?action=logout">Log Out</a>
        </div>
      </header>

            <section class="main-banner">
            <div class="container-fluid">
              <div class="row">
              
                <div class="column">
                    <div class="card">
                        <p><img class="" src=""></p>
                        <p><a href="ReservationController?action=staffviewreservation&id=<%= session.getAttribute("id")%>"><button>Back</button></a></p>
                      </div>
                </div>
                <div class="column-1">
                    <h2>Profile User</h2><br/><br/>
                    <table>
                        <tr>
                            <td class="labelsize"><label>Username</label></td>
                            <td class="double-dot">:</td>
                            <td><c:out value="${cust.username}" /></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Name</label></td>
                            <td class="double-dot">:</td>
                            <td><c:out value="${cust.cust_name}"/></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Phone No</label></td>
                            <td class="double-dot">:</td>
                            <td><c:out value="${cust.cust_phoneNo}"/></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Address</label></td>
                            <td class="double-dot">:</td>
                            <td><c:out value="${cust.address}" /></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Email</label></td>
                            <td class="double-dot">:</td>
                            <td><c:out value="${cust.cust_email}" /></td> 
                            
                        </tr>
                    </table>
                </div>
                
              </div>
            </div>
            </section>
        
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
        
         <div class="footer">
          Instagram<br><br>
          Facebook<br><br>
          <br><br><br>
          © 2020 Pilot. All rights reserved
      </div>
    </body>
  
  </html>