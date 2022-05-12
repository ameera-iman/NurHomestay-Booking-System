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

            <!-- <c:forEach items="${homestayImages}" var="homestayImg">
                 	<img  src="<c:out value="${homestayImg.home_image}" />"/></div>
                   </c:forEach> -->
                   
            <section class="forms">
            <h2>NurHomestay Branch</h2>
              <div class="simple-ni">
               
               <c:set var="home_price2" value="${priceFormatter.format(homestay.home_price)}" />
               <c:set var="home_deposit2" value="${priceFormatter.format(homestay.home_deposit)}" />
                  	
              <input type="hidden" name="homestay" value="<%= session.getAttribute("homestay")%>"/>
              <c:forEach items="${homestayImages}" var="homestayImg">
                 	<img  src="<c:out value="${homestayImg.home_image}" />" width="25%"/>
                   </c:forEach>
                <table>
                    <tr>
                        <td class="labelsize"><label>Branch ID</label></td>
                        <td><c:out value="${homestay.homestayId}" /></td>
                    </tr>
                    <tr>
                        <td class="labelsize"><label>Branch Name</label></td>
                        <td><c:out value="${homestay.home_name}" /></td>
                    </tr>
                    <tr>
                        <td class="labelsize"><label>Address</label></td>
                        <td><c:out value="${homestay.home_address}" /></td>
                    </tr>
                    <tr>
                        <td class="labelsize"><label>Description</label></td>
                        <td><c:out value="${homestay.home_desc}" /></td> 
                    </tr>
                    <tr>
                        <td class="labelsize"><label>Deposit</label></td>
                        <td>RM<c:out value="${home_price2}" /></td>
                    </tr>
                    <tr>
                        <td class="labelsize"><label>Price</label></td>
                        <td>RM<c:out value="${home_deposit2}" /></td>
                    </tr>
                </table>
             
              </div>
              <br/><br/>
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
