<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">

    <title>Search Homestay</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">
    <link rel="stylesheet" href="assets/css/owl.css">

  </head>

<body class="is-preload">
    <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="staffprofile.jsp">Profile</a>
        <a href="stafflisthomestay.jsp">Homestay</a>
        <a href="stafflistreservation.jsp">Reservation</a>
      </div>

      <!-- Header -->
      <header id="header" style="margin-top: 0px;">
        <span style="font-size:36px;cursor:pointer; margin-left: 20px;margin-top: 25px;" onclick="openNav()">&#9776;</span>
        <div class="logo">
          <img src="assets/images/logo nurhomestay6.png">
        </div>
        <div class="kemana-kita">
          <a href="index.jsp">Log Out</a>
        </div>
      </header>
      
            <section>
              <div style="margin-top: 30px">
                <form id="form-book" action="addreservation.jsp">
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
                    Day<br>
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

  <script>
    function openNav() {
      document.getElementById("mySidenav").style.width = "250px";
    }
    
    function closeNav() {
      document.getElementById("mySidenav").style.width = "0";
    }
    </script>
</body>

</html>
