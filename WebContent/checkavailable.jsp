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

    <title>Check Availability</title>

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
              <h2>Reservation</h2>
                </div>
            </section>
            
            <section class="main-banner">
              <div class="container-fluid">
                <form id="form-book" action="HomestayController?action=checkAvailable" method="post">
                    <div class=" nak-row-gak">
                      Check-in<br>
                      <input class="bolehla"  type="date" name="checkindate" placeholder="1" value="<c:out value="${checkindate}" />" min="2021-01-20" required/>
                    </div>
                    <div class=" nak-row-gak">
                      Check-out<br>
                      <input class="bolehla"  type="date" name="checkoutdate" placeholder="1" value="<c:out value="${checkoutdate}" />" min="2021-01-20" required/>
                    </div>
                    <div class="nak-row-gak" align="center" style="width:300px; margin: auto">
                    <button type="submit" name="check">Check Availability</button>
                    </div>
                </form>
                <br><br><br><br>
               
             <c:choose>
               <c:when test="${homestay.homestayId == 0}">
               <div class="row">
               	<h4>Chosen date are not available. Please choose another date or homestay for your stay.</h4>
               </div>
               </c:when>
               
               <c:otherwise>
                <table>
                	<c:forEach items="${homestays}" var="home">
	        		<c:set var="home_price2" value="${priceFormatter.format(home.home_price)}" />
                  	<c:set var="home_deposit2" value="${priceFormatter.format(home.home_deposit)}" />
                	<tr>
                		<td>
		                	  <h4><c:out value="${home.home_name}" /></h4>
		                      <p><c:out value="${home.home_desc}" /></p>
		                      <p><c:out value="${home.home_address}" /></p>
		                      <p>RM<c:out value="${home_deposit2}" /> for booking deposit</p>
		                      <p>RM<c:out value="${home_price2}" /> for homestay's price per day </p>
		                      <p><a href="HomestayController?action=viewbranch2&homestayId=<c:out value="${home.homestayId}" />">View Homestay</a></p>
                		</td>
                		<td>
                			<p>Check-in:<c:out value="${checkindate}" /></p>
        					<p>Check-out:<c:out value="${checkoutdate}" /></p>
                		</td>
                		<td>
                			<form name="to_reserve" action="ReservationController?action=addReservation&id=<%= session.getAttribute("id")%>&home_id=<c:out value="${home.homestayId}" />" method="post">
                				<input type="hidden" name="checkin" value="<c:out value="${checkindate}" />" />
                				<input type="hidden" name="checkout" value="<c:out value="${checkoutdate}" />" />
                				<button type="submit">Reserve</button>
                			</form>
                		</td>
                	</tr>
                	</c:forEach>
                </table>
               </c:otherwise>
             </c:choose>
               </div></section>
               
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
