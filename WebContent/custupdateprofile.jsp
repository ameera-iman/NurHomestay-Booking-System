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
  
              <section class="main-banner">
              <div class="container-fluid">
              <div class="row">
                  <div class="column">
                    <div class="card">
                      <!--nak buh gambaq ka??
                      <img src="img.jpg" alt="John" style="width:100%"> 
                      -->
                      <h1>FishEye</h1>
                      <!-- <p class="title">CEO &#38; Founder, Example  TUKAQQQQQQQ</p>
                      <p>Harvard University  TUKAQQQQQQQ</p> -->
                      <p><a href="custprofile.jsp"><button>View</button></a></p>
                    </div>
                  </div>
                  <div class="column-1">
                      <h2>Profile user</h2><br/><br/>
                      <form>
                      <table>
                          <!-- <tr>
                              <td class="labelsize"><label>Customer ID</label></td>
                              <td class="double-dot">:</td>
                              <td>TUKAQQQQQQQ</td>
                          </tr> -->
                          <tr>
                              <td class="labelsize"><label>Username</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="username" type="text" class="form-control" id="name" placeholder="FishEye" required></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Name</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="cust_name" type="text" class="form-control" id="name" placeholder="Name" required></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Phone No</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="cust_email" type="text" class="form-control" id="email" placeholder="Email" required></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Address</label></td>
                              <td class="double-dot">:</td>
                              <td><textarea name="cust_address" id="demo-message" placeholder="Address" rows="6"></textarea></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Email</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="cust_email" type="text" class="form-control" id="email" placeholder="Email" required></td>
                          </tr>
                          <tr>
                            <td class="labelsize"><label>Current Password</label></td>
                            <td class="double-dot">:</td>
                            <td><input name="password" type="password" class="form-control" id="name" placeholder="Password" required></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>New Password</label></td>
                            <td class="double-dot">:</td>
                            <td><input name="password" type="password" class="form-control" id="name" placeholder="Password" required></td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Confirm Password</label></td>
                            <td class="double-dot">:</td>
                            <td><input name="password" type="password" class="form-control" id="name" placeholder="Password" required></td>
                        </tr>
                      </table>
                      <br><br>
                      <center><button>Update</button></center>
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