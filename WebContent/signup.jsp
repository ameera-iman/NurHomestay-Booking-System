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

    <title>Sign Up</title>

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
            
            <!-- Forms -->
            <section class="forms">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-12">
                    <div class="section-heading">
                      <p><a href="login.jsp">Back</a></p>
                    <h2>Sign Up</h2>
                    </div>
                    <form id="contact" action="" method="post">
                      <div class="row">
                        <div class="col-md-6">
                          <fieldset>
                            <input name="username" type="text" class="form-control" id="name" placeholder="Username" required="">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>
                            <input name="cust_name" type="text" class="form-control" id="name" placeholder="Name" required="">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>
                            <input name="cust_email" type="text" class="form-control" id="email" placeholder="Email" required="">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>
                            <input name="password" type="password" class="form-control" id="name" placeholder="Password" required="">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>
                            <input name="cust_phoneNo" type="text" class="form-control" id="name" placeholder="Phone Number" required="">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>
                            <input name="confirm_password" type="text" class="form-control" id="name" placeholder="Confirm Password" required="">
                          </fieldset>
                        </div>
                        <div class="col-12">
                          <textarea name="cust_address" id="demo-message" placeholder="Address"></textarea>
                        </div>
                        <div class="col-md-12">
                          <button type="submit" id="form-submit" class="button">Sign Up</button>
                        </div>
                      </div>
                    </form>
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
</body>


</html>
