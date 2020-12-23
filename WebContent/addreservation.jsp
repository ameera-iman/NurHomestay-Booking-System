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

    <title>Add Reservation</title>

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
                <a href="index.jsp">Home</a>
                <a href="rumahinfo.jsp">Gallery</a>
                <a href="about.jsp">About Us</a>
                <a href="login.jsp">Log In/Sign Up</a>
              </div>
            </header>


            <section class="forms">
              <div align="center">
              <h2>Reservation</h2>
                </div>
            </section>
            
            <section class="main-banner">
              <div class="container-fluid">
                <form id="form-book" action="#">
                    <div class=" nak-row-gak">
                      Homestay<br>
                      <select class="bolehla" name="homestay">
                        <option value="">Choose Homestay</option>
                        <option value="Taman Pokok Manga 1">Taman Pokok Manga 1</option>
                        <option value="Taman Pokok Manga 2">Taman Pokok Manga 2</option>
                        <option value="Taman Pandan Murni">Taman Pandan Murni</option>
                        <option value="Taman Pandan Indah">Taman Pandan Indah</option>
                      </select>
                    </div>
                    <div class="nak-row-gak">
                      Day</br>
                        <input class="bolehla" type="number" name="days" min="1" max="30" placeholder="1">
                    </div>
                    <div class=" nak-row-gak">
                      Check-in<br>
                      <input class="bolehla"  type="date" name="checkindate" placeholder="1" />
                    </div>
                    <div class=" nak-row-gak">
                      Check-out<br>
                      <input class="bolehla"  type="date" name="checkindate" placeholder="1" />
                    </div>
                    <div class="nak-row-gak" align="center" style="width:300px; margin: auto">
                    <button type="submit" name="check">Check Avalibility</button>
                    </div>
                </form>
                <br><br><br><br>
                <div class="row">
                  <div class="column">
                      <p>Taman Pokok Mangga</p>
                  </div>
                  <div class="column-1">
                    Available.
                    <p>No. 4, Jalan PM 1B,Taman Pokok Mangga,75250 Melaka</p>
                    <p>RM 500 = 1 night</p>
                    <br><p align='right'><a href="custafterreservation.jsp"><button>Reserve</button></a></p>  <!--link customer kalau dia cust, kalau staff link ke staff. button reserve tak kan mucul klau tak available ye yop-->
                      </div>
              </div>
            </section>
            </div>
          </div>
        </div>
    </div>

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
