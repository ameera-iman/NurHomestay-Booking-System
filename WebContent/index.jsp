<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Additional CSS Files -->
  	<link rel="stylesheet" href="assets/css/templatemo-style.css">
  	<link rel="stylesheet" href="assets/css/fontawesome.css">
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
                <a href="index.jsp" >Home</a>
                <a href="rumahinfo.jsp">Gallery</a>
                <a href="about.jsp">About Us</a>
                <a href="login.jsp">Log In/Sign Up</a>
              </div>
            </header>

            <!-- Banner -->
            <section class="main-banner">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-12">
                    <div class="banner-content">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="banner-caption">
                            <h4>Welcome to <em>NurHomestay</em></h4>
                            <span><b>Comfortable and Worth it!</b></span>
                            <p>Find homestay around <strong>Bandaraya Melaka</strong>. Here we 
                            provide wonderful home environment from the busy city life. We welcome 
                            you with warm friendly atmosphere and great service! Let Nur  Homestay 
                            always your first choice and create unforgettable moments!</p>
                            <!-- <div id=#book>
                              <a href="#"><button>BOOK NOW</button></a>
                            </div> -->
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
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
            
            <!--Services
            <section class="services">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-4">
                    <div class="service-item first-item">
                      <div class="icon"></div>
                      <h4>Room</h4>
                      <p>4 bedrooms with all air-conditioned</p><br>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="service-item second-item">
                      <div class="icon"></div>
                      <h4>Kitchen</h4>
                      <p>Provides the needs of a fully equipped kitchen.</p><br>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="service-item third-item">
                      <div class="icon"></div>
                      <h4>Astro</h4>
                      <p>LED TV with ASTRO Njoi and dvd set at the living room</p>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="service-item fourth-item">
                      <div class="icon"></div>
                      <h4>Garage</h4>
                      <p>Provides a lounge area in the garage</p><br>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="service-item fivth-item">
                      <div class="icon"></div>
                      <h4>Toilet</h4>
                      <p>All toilets complete with water-heater</p><br>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="service-item sixth-item">
                      <div class="icon"></div>
                      <h4>Check-in and check-out hour </h4>
                      <p>Check-in: 2.00pm and above<br>Check-out: before 12.00pm</p>
                    </div>
                  </div>
                </div>
              </div>
            </section> -->

            <!-- Top Image -->
            <section class="top-image">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-12">
                    <!-- <img src="assets/images/top-image.jpg" alt=""> -->
                    <div class="down-content">
                      <h4>Gallery</h4>
                      <p>Nur Homestay is a family business that prior our customer satisfaction for a vacation in Bandaraya Melaka. 
                        It is perfect for duo, or family vacation to create memories with a comfortable homestay to stay! 
                        Not only that, the homestay is near at Melaka's tourist attraction. You can come over anytime as long as the it is still open :)</p>
                      <div class="primary-button">
                        <a href="rumahinfo.jsp">Read More</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>

            <!-- Left Image -->
            <section class="left-image">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-6">
                    <img src="assets/images/left-image.jpg" alt="">
                  </div>
                  <div class="col-md-6">
                    <div class="right-content">
                      <h4>About Us</h4>
                      <p>At Nur homestay, our passion is to connect our guests to the very best of Melaka. 
                      From the heritage of melaka to our unique history and culture, our homestay offer 
                      guests extraordinary experiences, created by combining unique architecture and structure, 
                      expressive decor and artistry, and magnificent features. Add great service, and the 
                      result is an unforgettable guest experience.</p>
                      <div class="primary-button">
                        <a href="about.jsp">Read More</a>
                      </div>
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

</body>
</html>
