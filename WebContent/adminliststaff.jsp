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

    <title>NurHomestay Staff</title>

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
        <!-- <a href="adminsalereport.jsp">SALES REPORT</a> -->
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
          <a href="StaffController?action=logout">Log Out</a>
        </div>
      </header>
            
		<section class="tables">
          <div class="container-fluid">
            <div class="row">
              <div class="col-md-12">
                <div class="section-heading">
            <h2>NurHomestay Staff List</h2>
             <div>
              <input type="hidden" name="staff" value="<%= session.getAttribute("staff")%>"/>
                <table>
                	<tr>
        				<th>Staff Id</th>
            			<th>Staff Name</th>
           				<th>Staff Phone No</th>
           				<th>Staff Email</th>
           				<th>Staff Address</th>
           				<th>Username</th>
           				<th>Manager Id</th>
           				<!-- <th>Manager Name</th> -->
           				<th>Position</th>
           				<th>Generate</th>
           			</tr>
        		  	<c:forEach items="${staffs}" var="staff">
        	           <tr>
            					<td><c:out value="${staff.staffId}" /></td>         
                				<td><c:out value="${staff.sta_name}" /></td>
              				    <td><c:out value="${staff.sta_phoneNo}" /></td>
              				    <td><c:out value="${staff.sta_email}" /></td>
              				    <td><c:out value="${staff.sta_address}" /></td>
              				    <td><c:out value="${staff.username}" /></td>
              				    <td><c:out value="${staff.managerId}" /></td>
              				    <!-- <td><% String userlabel=(String)request.getAttribute("tukangpegang"); %><%=userlabel%></td> -->
              				    <td><c:out value="${staff.role}" /></td>
              				    <td><a onclick="return confirm('Are you sure?')" href="StaffController?action=deleteStaff&staffId=<c:out value="${staff.staffId}" />"><img class="useme" src="assets/images/trash-1.png"></a></td>
              		  </tr>
              		</c:forEach>
                </table>
             </div>
             </div>
            </div>
           </div>
          </div>
         </section>
             

    <div class="footer">
        Instagram<br><br>
        Facebook<br><br>
        <br><br><br>
        © 2020 Pilot. All rights reserved
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
