<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>    
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
    
    <script type="text/javascript">
    function answer() {
    	var resid = document.forms["cancelbooking"]["resid"].value;
    	var action = document.forms["cancelbooking"]["action"].value;
    	var id = document.forms["cancelbooking"]["id"].value;
    	var day = document.forms["cancelbooking"]["day"].value;
    	var r = confirm("Are you sure to cancel booking?\n\nTake not, once cancelling:-\n1. Before two week of check-in, payment exclude deposit will be refund only. \n2. Within two weeks before check-in, payment will be burn.\n\nWe will process your refund within two weeks after cancel the booking.");
    
    	if (r == true) {
    		location.replace('ReservationController?action=' + action + '&id=' + id + '&resid=' + resid + '&day' + day);
    	}
    	else {
    		return false;
    	}
    }
    
    </script>

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

       
            <!-- list reservation -->
            <input type="hidden" name="id" value="<%= session.getAttribute("id")%>"/>
            <section class="tables">
                <div class="container-fluid">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="section-heading">
                        <h2>Reservation</h2>
                      </div>
                      <div class="default-table">
                        <table>
                          <thead>
                            <tr>
                              <th>Reservation ID:</th>
                              <th>Check-in</th>
                              <th>Check-out</th>
                              <th>Homestay</th>
                              <th style="width:10%;">Update</th>
                              <th style="width:20%;">Cancel</th>
                            </tr>
                          </thead>
                          <thead>
                            <tr>
                              <th></th>
                              <th></th>
                              <th></th>
                              <th></th>
                              <td style="color:red;">Only applicable two weeks before check-in date</td>
                              <td style="color:red;">Only applicable before check-in date</td>
                            </tr>
                          </thead>
                          <c:forEach items="${reserves}" var="res">
                            <tr>
                              <td><a href="ReservationController?action=viewReservation&id=<%= session.getAttribute("id")%>&resid=<c:out value="${res.reserveid}" />"><c:out value="${res.reserveid}" /></a></td>
                              <td><c:out value="${res.checkindate}" /></td>
                              <td><c:out value="${res.checkoutdate}" /></td>
                              <td><c:out value="${res.homestayid}" /></td>
                              
                              <!-- calculate day -->
                              <c:set var="difference" value="${res.checkindate.getTime() - datenow.getTime()}" />
                              <c:set var="dayBetween" value="${difference/(1000*60*60*24)}" />
                              <fmt:parseNumber var = "day" integerOnly = "true" type = "number" value = "${dayBetween}" />
                              
                            <c:choose>
                      		<c:when test="${day > 14}">
                              	<td><a href="ReservationController?action=updateReservation2&id=<%= session.getAttribute("id")%>&resid=<c:out value="${res.reserveid}" />"><button>Update</button></a></td>
							</c:when>
							<c:otherwise>
                              <td></td>
                            </c:otherwise>
                            </c:choose>
							  
                            <c:choose>
                      		<c:when test="${day > 0}">
                      		<td>
                      			<form name="cancelbooking" onsubmit="return answer()">
                      				<input type="hidden" name="resid" value="<c:out value="${res.reserveid}" />">
                      				<input type="hidden" name="action" value="deleteReservation">
                      				<input type="hidden" name="id" value="<%=session.getAttribute("id")%>">
                      				<input type="hidden" name="day" value="${day}">
                              		<button type="submit" class="button">Cancel Booking</button>
                              	</form>
                             </td>
                            </c:when>
                        	<c:otherwise>
                              <td></td>
                            </c:otherwise>
                            </c:choose>
                            </tr>
                           </c:forEach>
                          </tbody>
                        </table>
                        <!-- boleh pakai klau nak
                            <ul class="table-pagination">
                          <li><a href="#">Previous</a></li>
                          <li><a href="#">1</a></li>
                          <li class="active"><a href="#">2</a></li>
                          <li><a href="#">...</a></li>
                          <li><a href="#">8</a></li>
                          <li><a href="#">9</a></li>
                          <li><a href="#">Next</a></li>
                        </ul> -->
                      </div>
                    </div>
                  </div>
                </div>
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
