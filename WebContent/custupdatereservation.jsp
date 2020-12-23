<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">

    <title>Reservation</title>

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
                <a href="index.jsp"><img src="assets/images/logo nurhomestay6.png"></a>
              </div>
              <div class="kemana-kita">
                <a href="afterindex.jsp">Home</a>
                <a href="custprofile.jsp">Profile</a>
                <a href="reservation.jsp">Reservation</a>
                <a href="afteraboutjsp">About Us</a>
                <a href="index.jsp">Logout</a>
              </div>
            </header>

            <section class="forms">
              <div class="simple-ni">
                <h2>Reservation</h2><a href="#"><img class="useme" src="assets/images/trash-1.png"></a><br/><br/>
                    <div><img class="rounded-circle" src="assets/images/main-banner.jpg"></div>
                    <table>
                        <tr>
                            <td class="labelsize"><label>Reservation ID</label></td>
                            <td class="double-dot">:</td>
                            <td>2pcx3456</td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Branch</label></td>
                            <td class="double-dot">:</td>
                            <td>Taman Pandan Murni</td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Total Payment</label></td>
                            <td class="double-dot">:</td>
                            <td>RM 500.00</td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Check In</label></td>
                            <td class="double-dot">:</td>
                            <td><input type="date" name="checkin"></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Check Out</label></td>
                            <td class="double-dot">:</td>
                            <td><input type="date" name="checkout"></td> 
                        </tr>
                      </table>
                      <p><a href="#"><button>Update</button></a></p>
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
