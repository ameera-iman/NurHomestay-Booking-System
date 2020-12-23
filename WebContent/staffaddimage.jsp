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

    <title>Update Homestay Image</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">

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

      <br><br>
      <section class="main-banner">
        <div class="container-fluid">
      		<div class="row">
        		<div class="column-1">
            <h2> Update Homestay Image</h2><br/><br/>
            <table>
                <tr>
                    <td class="labelsize"><label>Add Image</label></td>
                    <td class="double-dot">:</td>
                    <td><input name="homestayimg" type="file" class="form-control"></td>
                    <td><a href="#"><button>Add</button></a></td>
                </tr>
              </table>
              <table>
                <thead>
                  <tr>
                    <th colspan="2">Image</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>#1011</td>
                    <td><a href="#"><img class="useme" src="assets/images/trash-1.png"></a></td>
                  </tr>
                </tbody>
              </table>
            <br><br>
      			<center><a href="stafflisthomestay.jsp"><button>Done</button></a></center>
			</div>
        </div>
      </div>
      </section>

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
