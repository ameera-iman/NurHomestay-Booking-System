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
  
              <!-- Header -->
            <header id="header">
              <div class="logo">
                <a href="index.jsp"><img src="assets/images/logo nurhomestay6.png" width="280"></a>
              </div>
              <div class="kemana-kita">
                 <%
                	if(session.getAttribute("id") != null) {
                %>
                	<a href="index.jsp">Home</a>
                	<a href="CustomerController?action=viewCustomer&id=<%= session.getAttribute("id")%>">Profile</a>
                	<a href="ReservationController?action=listreservation&id=<%= session.getAttribute("id")%>">Reservation</a>
                	<a href="rumahinfo.jsp">Gallery</a>
                	<a href="about.jsp">About Us</a>
                	<a href="CustomerController?action=logout">Log Out</a>
                <%
               		 } else {
                %>
                	<a href="HomestayController?action=listallhomestay" >Home</a>
                	<a href="rumahinfo.jsp">Gallery</a>
                	<a href="about.jsp">About Us</a>
                	<a href="login.jsp?">Log In/Sign Up</a>
                <%
                }
                %>
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
                      <h1><c:out value="${cust.username}"/></h1>
                      <p><a href="CustomerController?action=viewCustomer&id=<%= session.getAttribute("id")%>"><button>View</button></a></p>
                    </div>
                  </div>
                  <div class="column-1">
                      <h2>Update Profile User</h2><br/><br/>
                      <form name="updatecustomer" method="post" action="CustomerController?action=updateCustomer">
                      <input type="hidden" name="id" value="<%= session.getAttribute("id")%>"/>
                      <table>
                          <tr>
                              <td class="labelsize"><label>Username</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="username" type="text" class="form-control"  placeholder="Username" value="<c:out value="${cust.username}" />" required/></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Name</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="cust_name" type="text" class="form-control" placeholder="Name" value="<c:out value="${cust.cust_name}" />" required></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Phone No</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="cust_phoneNo" type="number" class="form-control" placeholder="Phone Number" value="<c:out value="${cust.cust_phoneNo}" />" required></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Address</label></td>
                              <td class="double-dot">:</td>
                              <td><textarea name="address"  placeholder="Address" rows="6"><c:out value="${cust.address}" /></textarea></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Email</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="cust_email" type="email" class="form-control"  placeholder="Email" value="<c:out value="${cust.cust_email}" />" required></td>
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
    <!-- Bootstrap core JavaScript -->
      <script src="vendor/jquery/jquery.min.js"></script>
      <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="assets/js/browser.min.js"></script>
      <script src="assets/js/breakpoints.min.js"></script>
      <script src="assets/js/transition.js"></script>
      <script src="assets/js/custom.js"></script>
  </body>
</html>