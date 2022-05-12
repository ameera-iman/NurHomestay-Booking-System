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

    <title>Update Reservation</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">
    
    <script type="text/javascript">
    
    	var checkavailable = '${checkavailable}';
    	
    	if (checkavailable == 'N') {
    		alert ('Cannot update as the chosen date are not available');
    		location.replace("ReservationController?action=listreservation&id=<%= session.getAttribute("id")%>");
    	}
    	else if (checkavailable == 'M') {
    		alert ('Please make sure date you choose does not exceed the total day you booking');
    		location.replace("ReservationController?action=listreservation&id=<%= session.getAttribute("id")%>");
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

            <section class="main-banner">
            <div class="container-fluid">
              <div class="row">
              
                <div class="column">
                    <div class="card">
                        <p><img class="" src=""></p>
                        <p><a href="ReservationController?action=listreservation&id=<%= session.getAttribute("id")%>"><button>Back</button></a></p>
                      </div>
                </div>
                <div class="column-1">
                    <h2>Update Reservation</h2><br/><br/>
                    <form name="update" action="ReservationController?action=updateReservation&id=<%= session.getAttribute("id")%>&resid=<c:out value="${reserves.reserveid}" />" method="post">
                    <p style="color: red">You can only be able to update check-in and check-out, 2 weeks before check-in date.</p>
                    
                    <table>
                        <tr>
                            <td class="labelsize"><label>Reservation ID</label></td>
                            <td class="double-dot">:</td>
                            <td><input type="hidden" name="reserveid" value="<c:out value="${reserves.reserveid}" />"><c:out value="${reserves.reserveid}" /></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Homestay Name</label></td>
                            <td class="double-dot">:</td>
                            <td><input type="hidden" name="home_id" value="<c:out value="${reserves.homestayid}" />"><c:out value="${reserves.home_name}" /></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Total Payment (RM)</label></td>
                            <td class="double-dot">:</td>
                            <td>${payment.paymentAmount}</td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>From Check in</label></td>
                            <td class="double-dot">:</td>
                            <td><c:out value="${reserves.checkindate}" /></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>From Check Out</label></td>
                            <td class="double-dot">:</td>
                            <td><c:out value="${reserves.checkoutdate}" /></td> 
                        </tr>
                        <tr>
                            <td class="labelsize"><label>New check-in date:</label></td>
                            <td class="double-dot">:</td>
                            <td><input type="text" name="checkin" value="<c:out value="${checkin}" />" readonly></td> 
                        </tr>
                        <tr>
                            <td class="labelsize"><label>New check-out date:</label></td>
                            <td class="double-dot">:</td>
                            <td><input type="text" name="checkout" value="<c:out value="${checkout}" />" readonly></td>
                        </tr>
                      </table>
                      <center><button type="submit">Update</button></center>
                      </form>
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
</body>

</html>
