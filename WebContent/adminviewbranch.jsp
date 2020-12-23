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

    <title>View Branch</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">

  </head>

<body class="is-preload">
    <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="adminliststaff.jsp">Staff</a>
        <a href="adminviewbranch.jsp">Branch</a>
        <a href="adminsalereport.jsp">Sales Report</a>
      </div>

      <!-- Header -->
      <header id="header" style="margin-top: 0px;">
        <span style="font-size:36px;cursor:pointer; margin-left: 20px;margin-top: 30px;" onclick="openNav()">&#9776;</span>
        <div class="logo">
          <img src="assets/images/logo nurhomestay6.png">
        </div>
        <div class="kemana-kita">
          <a href="index.jsp">Log Out</a>
        </div>
      </header>
            

            <section class="forms">
            <h2>Branch</h2>
              <div class="simple-ni">
                <h2>Branch ID: TPM1</h2>
                <a href="#"><img class="useme" src="assets/images/trash-1.png"></a><a href="adminupdatebranch.jsp"><img class="useme" src="assets/images/edit-1.png"></a>
                <table>
                        <!-- <div width="50px" height="60px"><img class="rounded-circle" src="assets/images/main-banner.jpg"></div> -->
                    <tr>
                        <td class="labelsize"><label>Branch</label></td>
                        <td>Taman Pandan Murni</td>
                    </tr>
                    <tr>
                        <td class="labelsize"><label>Address></label></td>
                        <td>No 13, Jalan Murni 3, Taman Pandan Murni</td>
                    </tr>
                    <tr>
                        <td class="labelsize"><label>Description</label></td>
                        <td>3 Aircond 5 Kipas 3 Bilik Air 4 Bilik</td> 
                    </tr>
                    <tr>
                        <td class="labelsize"><label>Price</label></td>
                        <td>RM 100.00</td>
                    </tr>
                </table>
              </div>
              <br/><br/>
                  <!-- second row -->
              <div class="simple-ni">
                <h2>Branch ID: TM1</h2>
                <a href="#"><img class="useme" src="assets/images/trash-1.png"></a><a href="#"><img class="useme" src="assets/images/edit-1.png"></a>
                <table>
                        <!-- <div width="50px" height="60px"><img class="rounded-circle" src="assets/images/main-banner.jpg"></div> -->
                        <tr>
                            <td class="labelsize"><label>Branch</label></td>
                            <td>Taman Mangga</td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Address></label></td>
                            <td>No 45, Jalan Mangga 8, Taman Mangga</td>
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Description</label></td>
                            <td>3 Aircond 5 Kipas 3 Bilik Air 4 Bilik</td> 
                        </tr>
                        <tr>
                            <td class="labelsize"><label>Price</label></td>
                            <td>RM 150.00</td>
                        </tr>
                </table>
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
