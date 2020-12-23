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

    <script type="text/Javascript">
     function redirect() {
      var myWindow = window.open("payment.jsp", "", "width=400,height=600");
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

            <section class="forms">
              <div align="center">
              <h2>Reservation</h2>
                </div>
            </section>
            
            <form onsubmit="return">
            <section class="main-banner">
              <div class="container-fluid">
                <div class="row">
                  <div class="column">
                    <img class="rounded-circle" src="assets/images/main-banner.jpg">
                  </div>
                  <div class="column-1">
                    <table>
                      <tr>
                          <td class="labelsize"><label>Reservation</label></td>
                          <td class="double-dot">:</td>
                          <td>25 December 2020</td>
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Branch</label></td>
                          <td class="double-dot">:</td>
                          <td><select name="homestay">
                            <option value="">Choose Homestay</option>
                            <option value="Taman Pokok Manga 1">Taman Pokok Manga 1</option>
                            <option value="Taman Pokok Manga 2">Taman Pokok Manga 2</option>
                            <option value="Taman Pandan Murni">Taman Pandan Murni</option>
                            <option value="Taman Pandan Indah">Taman Pandan Indah</option>
                          </select></td>
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Total Payment</label></td>
                          <td class="double-dot">:</td>
                          <td>RM 500.00</td>
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Check In</label></td>
                          <td class="double-dot">:</td>
                          <td><input type="datetime-local" name="checkin"></td>
                      </tr>
                      <tr>
                          <td class="labelsize"><label>Check Out</label></td>
                          <td class="double-dot">:</td>
                          <td><input type="datetime-local" name="checkout"></td> 
                      </tr>
                      <tr align="center">
                          <td colspan="3" align="left"><blockquote>Kaklong angah adik kakak semua makan kuih raya Kaklong angah adik 
                            kakak semua makan kuih raya Kaklong angah adik kakak semua makan kuih raya
                            Kaklong angah adik kakak semua makan kuih raya
                            Kaklong angah adik kakak semua makan kuih raya
                            Kaklong angah adik kakak semua makan kuih raya
                            Kaklong angah adik kakak semua makan kuih raya
                            Kaklong angah adik kakak semua makan kuih raya
                            Kaklong angah adik kakak semua makan kuih raya
                            Kaklong angah adik kakak semua makan kuih raya
                            Kaklong angah adik kakak semua makan kuih raya
                          </blockquote><br>
                            <p><input type="checkbox" value="Agree">Agree to terms & condition</p></td>
                      </tr>
                  </table><br>
                <center><a href="#"><button>Pay</button></a><a href="#"><button>Cancel</button></a></center>
                 <!-- onclick="redirect(); -->
                  </div>
              </div></section></form>
    
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
