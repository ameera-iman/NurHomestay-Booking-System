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
                <a href="afterabout.jsp">About Us</a>
                <a href="index.jsp">Logout</a>
              </div>
            </header>

            <!-- list reservation -->
            <section class="tables">
                <div class="container-fluid">
                  <div class="row">
                    <div class="col-md-12">
                        <a href="index.jsp"><img class="useme" src="assets/images/plus.png" alt="add reservation"></a>
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
                              <th></th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>#1011</td>
                              <td>25 December 2020</td>
                              <td>30 December 2020</td>
                              <td>Taman Mawar Murni</td>
                              <td><a href="custafterreservation.jsp"><img class="useme" src="assets/images/edit-1.png"></a></td>
                            </tr>
                            <tr>
                              <td>#1012</td>
                              <td>14 December 2020</td>
                              <td>15 December 2020</td>
                              <td>Taman Mawar Murni</td>
                              <td><a href="#"><img class="useme" src="assets/images/edit-1.png"></a></td>
                            </tr>
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
