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

    <title>Sales Report</title>

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
        <a href="adminlistbranch.jsp">Branch</a>
        <a href="adminsalereport.jsp">Sales Report</a>
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


        <section class="forms">
          <div align="center">
          <h2>Sales Report</h2>
            </div>
        </section>

            <section class="forms">
              <div class="simple-ni">
                <table>
                    <tr>
                      <th><center>Year</center></th>
                      <th><center>Prepared by</center></th>
                      <th><center>Generate</center></th>
                    </tr>
                    <tr>
                      <td><center>2020</center></td>
                      <td><center>Maria Anders</center></td>
                      <td><center><button>View</button><button>Print</button></center></td>
                    </tr>
                    <tr>
                      <td><center>2019</center></td>
                      <td><center>Francisco Chang</center></td>
                      <td><center><button>View</button><button>Print</button></center></td>
                    </tr>
                    <tr>
                      <td><center>2018</center></td>
                      <td><center>Roland Mendel</center></td>
                      <td><center><button>View</button><button>Print</button></center></td>
                    </tr>
                    <tr>
                      <td><center>2017</center></td>
                      <td><center>Helen Bennett</center></td>
                      <td><center><button>View</button><button>Print</button></center></td>
                    </tr>
                  </table>
              </div>
              <br/><br/>
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
