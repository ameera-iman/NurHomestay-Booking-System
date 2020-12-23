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

    <title>Add Branch</title>

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

              <section class="main-banner">
                <div class="container-fluid">
              <div class="row">
                  <div class="column">
                      <div class="card">
                          <!--nak buh gambaq ka??
                          <img src="img.jpg" alt="John" style="width:100%"> 
                          -->
                          <h1>Add new branch?</h1>
                          <!-- <p class="title">CEO & Founder, Example  TUKAQQQQQQQ</p>
                          <p>Harvard University  TUKAQQQQQQQ</p> -->
                          <p><a href="adminlistbranch.jsp"><button>Confirm</button></a></p>
                        </div>
                  </div>
                  <div class="column-1">
                      <h2>Add Branch</h2><br/><br/>
                      <form>
                      <table>
                          <!-- <tr>
                              <td class="labelsize"><label>Customer ID</label></td>
                              <td class="double-dot">:</td>
                              <td>TUKAQQQQQQQ</td>
                          </tr> -->
                          <tr>
                              <td class="labelsize"><label>Branch Name</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="username" type="text" class="form-control" id="name" placeholder="Branch" required=""></td>
                          </tr>
                          <tr>
                              <td class="labelsize"><label>Address</label></td>
                              <td class="double-dot">:</td>
                              <td><textarea name="branch_address" id="demo-message" placeholder="Address" rows="6"></textarea></td>
                          </tr>
                          <tr>
                            <td class="labelsize"><label>Description</label></td>
                            <td class="double-dot">:</td>
                            <td><textarea name="description" id="demo-message" placeholder="description" rows="6"></textarea></td>
                        </tr>
                          <tr>
                              <td class="labelsize"><label>Price</label></td>
                              <td class="double-dot">:</td>
                              <td><input name="Price" type="text" class="form-control" id="Price" placeholder="Price" required=""></td>
                          </tr>
                      </table>
                      <br><br>
                      <center><a href="adminaddimage.jsp"><button>Add</button></a></center>
                    </form>
                  </div>
                </div></section>
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