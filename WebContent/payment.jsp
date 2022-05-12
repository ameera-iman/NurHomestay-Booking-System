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

    <title>Payment Gateway</title>

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
                	<a href="HomestayController?action=listallhomestay">Home</a>
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


            <section class="forms">
              <div align="center">
              <h2>Payment Gateway</h2>
                </div>
            </section>
            
            <section class="main-banner">
              <div class="container-fluid">
					<form name="payment" action="PaymentController?action=makePayment&id=<%= session.getAttribute("id")%>" method="post">
					    <table>
					    <tr>
					 		<td>Individual Account</td>
					 		<td>:</td>
					 		<td>
					 			<select name="methodpay">
					 				<option value="Bank Islam">Bank Islam</option>
					 				<option value="Bank Simpanan Nasional">Bank Simpanan Nasional</option>
					 				<option value="Affin Bank">Affin Bank</option>
					 				<option value="Maybank2u">Maybank2u</option>
					 			</select>
					 		</td>
					    </tr>
					    <tr>
					        <td>Account Number</td>
					        <td>:</td>
					        <td><input type="text" name="accnumber" /></td>
					    </tr>
					    </table>
					    <br><br>
					    <div align="center">
					    	<a href="receipt.pdf"><button type="submit" class="button">Pay</button></a>
					    </div>
					    <input type="hidden" name="home_id" value="${home_id}">
					    <input type="hidden" name="home_name" value="${home_name}">
					    <input type="hidden" name="totalpay" value="${totalpay}">
					    <input type="hidden" name="checkin" value="${checkin}">
					    <input type="hidden" name="checkout" value="${checkout}">
					</form>
               </div>
            </section>
               
           </div></div></div>
    

    <!-- footer -->
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
