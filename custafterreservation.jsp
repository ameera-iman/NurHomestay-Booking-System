<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">

    <title>Reservation</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">

	<!-- 
    <script type="text/Javascript">
     function redirect() {
    	 var home_id = document.getElementById("home_id").value;
    	 var home_name = document.getElementById("home_name").value;
    	 var totalpay = document.getElementById("totalpay").value;
    	 var checkin = document.getElementById("checkin").value;
    	 var checkout = document.getElementById("checkout").value;
    	 var checkAgree = document.getElementById("checkAgree").value;
    	 var status = document.getElementById("status").value;
    	 
      	 var myWindow = window.open("payment.jsp, "", "width=400,height=600");
     }
    </script>
    -->
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
              <h2>Reservation</h2>
                </div>
            </section>
            
            <!-- onsubmit="return"-->
            
            <form name="addreservation" action="PaymentController?action=payReservation&id=<%= session.getAttribute("id")%>" method="post">
            <!--  <form name="addreservation" onsubmit="return redirect()">-->
            <section class="main-banner">
              <div class="container-fluid">
                <div class="row">
                  <div class="column">
                    <h2><c:out value="${homestay.home_name}" /></h2>
                  </div>
                  <div class="column-1">
                  <input type="hidden" name="cid" id="cid" value="<%= session.getAttribute("id")%>">
                  <input type="hidden" name="home_id" id="home_id" value="<c:out value="${homestay.homestayId}" />">
                    <table>
                      <tr>
                          <td class="labelsize"><label>Branch</label></td>
                          <td class="double-dot">:</td>
                          <td><input type="hidden" name="home_name" id="home_name" value="<c:out value="${homestay.home_name}" />"><c:out value="${homestay.home_name}" /></td>
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Check In</label></td>
                          <td class="double-dot">:</td>
                          <td><input type="hidden" name="checkin" id="checkin" value="<c:out value="${checkindate}" />"><c:out value="${checkindate}" /></td>
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Check Out</label></td>
                          <td class="double-dot">:</td>
                          <td><input type="hidden" name="checkout" id="checkout" value="<c:out value="${checkoutdate}" />"><c:out value="${checkoutdate}" /></td> 
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Day</label></td>
                          <td class="double-dot">:</td>
                          <td><input type="hidden" name="day" id="day" value="<c:out value="${day}" />"><c:out value="${day}" /> day(s)</td>
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Deposit (RM)</label></td>
                          <td class="double-dot">:</td>
                          <td><input type="hidden" name="home_deposit" id="home_deposit" value="<c:out value="${homestay.home_deposit}" />"><c:out value="${home_deposit2}" /></td>
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Homestay's price per day (RM)</label></td>
                          <td class="double-dot">:</td>
                          <td><input type="hidden" name="home_price" id="home_price" value="<c:out value="${homestay.home_price}" />"><c:out value="${home_price2}" /></td>
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Total Payment (RM)</label></td>
                          <td class="double-dot">:</td>
                          <td><input type="hidden" name="totalpay" id="totalpay" value="<c:out value="${totprice}" />">
                          		RM <c:out value="${home_deposit2}" /> + (RM <c:out value="${home_price2}" /> * <c:out value="${day}" />)<br/>
                          		= RM <c:out value="${totprice}" />
                          </td>
                      </tr>
                      <tr align="center">
                          <td colspan="3" align="left">
                          	<a href="ribbib.pdf" target="_blank">View Term and Condition</a><br>
                            <p><input type="checkbox" name="checkAgree" id="checkAgree" value="Agree" required/>Agree to the term and conditions</p>
                            <input type="hidden" name="status" id="status" value="not paid"/>
                          </td>
                      </tr>
                      
                  </table><br>
                <a href="#"><button type="submit">Pay</button></a><a href="HomestayController?action=listallhomestay"><button>Cancel</button></a>
                 <!-- onclick="redirect(); -->
                  </div>
              </div></div></section></form>
    
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
