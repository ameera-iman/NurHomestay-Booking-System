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

    <title>Homestay Information</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="assets/css/homeimage.css">

	<script src="assets/js/homeimage.js"></script>

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
              <h2>Homestay Information</h2>
                </div>
            </section>
            <br>
            
            <!-- Page Heading -->
            <div class="page-heading">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-12">
                    <center>
                    <div class="tab">
                     <button class="tablinks" onclick="openCity(event, 'PokokManga')">Taman Pokok Mangga </button>
                      <button class="tablinks" onclick="openCity(event, 'PandanMurni1')">Taman Pandan Murni 1</button>
                      <button class="tablinks" onclick="openCity(event, 'PandanMurni2')">Taman Pandan Murni 2</button>
                      <button class="tablinks" onclick="openCity(event, 'PandanIndah')">Taman Pandan Indah</button>
                    </div>
                    </center>
                  </div>
                </div>
              </div>
            </div>

            <section class="main-banner">
                  <div class="container-fluid">
                    <div class="row">

                      <p>Nur Homestay is a family business that prior our customer satisfaction for a vacation in Bandaraya Melaka. 
                      It is perfect for duo, or family vacation to create memories with a comfortable homestay to stay! 
                      Not only that, the homestay is near at Melaka's tourist attraction. You can come over anytime as long as the it is still open :)
                      </p>
                      <!-- Taman Pokok Manga 1-->
                  <div id="PokokManga" class="col-md-12 tabcontent">
                    <div class="slides fade">
                    	<div class="numbertext">1/3</div>
                    	<img src="assets/images/taman-mangga.jpeg"  style="width: 80%" alt="Taman Pokok Mangga">
                    </div>
                    <div class="slides fade">
                    	<div class="numbertext">2/3</div>
                    	<img src="assets/images/taman-mangga-bilik.jpg" style="width: 80%">
                    </div>
                    <div class="slides fade">
                    	<div class="numbertext">3/3</div>
                    	<img src="assets/images/taman-mangga-tangga.jpg" style="width: 80%">
                    </div>
                	<br>
					<div style="text-align:center">
  						<span class="dot" onclick="currentSlide(1)"></span> 
  						<span class="dot" onclick="currentSlide(2)"></span> 
  						<span class="dot" onclick="currentSlide(3)"></span> 
					</div>
                	<div class="down-content row">
                      <div class="col-md-6">
                      <p>
                        <ul>
                            <li><strong>Max:</strong></br>10 Persons</li>
                            <li><strong>Address:</strong></br>No. 4, Jalan PM 1B,Taman Pokok Mangga,75250 Melaka</li>
                        </ul>
                      </p>
                      <br><br>
                      </div>
                      <div class="col-md-6">
                      <p>
                        <ul>
                            <li><strong>Bathroom:</strong></br>2 Room</li>
                            <li><strong>Bed:</strong></br>2 Queen</br>3 King</br>2 Single</li>
                            <li><strong>Price:</strong></br>RM 500 = 1 night</li>
                        </ul>
                      </p>
                      </div>
                    </div>
                  </div>

                      <div id="PandanMurni1" class="col-md-12 tabcontent">
                     <div class="slides fade">
                    	<div class="numbertext">1/2</div>
                    	<img src="assets/images/tamanpandanmurni.jpg"  style="width: 80%">
                    </div>
                    <div class="slides fade">
                    	<div class="numbertext">2/2</div>
                    	<img src="assets/images/tamanpandanmurnidapur1.jpg" style="width: 80%">
                    </div>
                    <br>
					<div style="text-align:center">
  						<span class="dot" onclick="currentSlide(1)"></span> 
  						<span class="dot" onclick="currentSlide(2)"></span> 
					</div>
                    <div class="down-content row">
                      <div class="col-md-6">
                      <p>
                        <ul>
                            <li><strong>Max:</strong></br>8 Persons</li>
                            <li><strong>Address:</strong></br>No-5, Jln PM-1,Taman Pandan Murni, 75250 Melaka</li>
                        </ul>
                      </p>
                      <br><br>
                      </div>
                      <div class="col-md-6">
                      <p>
                        <ul>
                            <li><strong>Bathroom:</strong></br>2 Room</li>
                            <li><strong>Bed:</strong></br>2 Queen</br>2 King</br>2 Single</li>
                            <li><strong>Price:</strong></br>RM 500 = 1 night</li>
                        </ul>
                      </p>
                      </div>
                    </div>
                  </div>
    
                      <!-- Taman Pandan Indah -->
                  <div id="PandanIndah" class="col-md-12 tabcontent">
                    <div class="slides fade">
                    	<div class="numbertext">1/3</div>
                    	<img src="assets/images/tamanpandanindah.jpeg"  style="width: 80%">
                    </div>
                    <div class="slides fade">
                    	<div class="numbertext">2/3</div>
                    	<img src="assets/images/tamanpandanindah1.jpg" style="width: 80%">
                    </div>
                    <div class="slides fade">
                    	<div class="numbertext">3/3</div>
                    	<img src="assets/images/tamanpandanindahdapur.jpg" style="width: 80%">
                    </div>
                	<br>
					<div style="text-align:center">
  						<span class="dot" onclick="currentSlide(1)"></span> 
  						<span class="dot" onclick="currentSlide(2)"></span> 
  						<span class="dot" onclick="currentSlide(3)"></span> 
					</div>
                    <div class="down-content row">
                      <div class="col-md-6">
                      <p>
                        <ul>
                            <li><strong>Max:</strong></br>8 Persons</li>
                            <li><strong>Address:</strong></br>No. 127, Jalan LP13, Taman Pandan Indah, 75200 Melaka</li>
                        </ul>
                      </p>
                      <br><br>
                      </div>
                      <div class="col-md-6">
                      <p>
                        <ul>
                            <li><strong>Bathroom:</strong></br>2 Room</li>
                            <li><strong>Bed:</strong></br>2 Queen</br>3 King</br>2 Single</li>
                            <li><strong>Price:</strong></br>RM 500 = 1 night</li>
                        </ul>
                      </p>
                      </div>
                    </div>
                  </div>

                      <!-- Taman Pandan Murni 2 -->
                    <div id="PandanMurni2" class="col-md-12 tabcontent">
                     	<div class="slides fade">
                    		<div class="numbertext">1/2</div>
                    		<img src="assets/images/tamanpandanmurni.jpg"  style="width: 80%">
                    	</div>
                   		<div class="slides fade">
                    		<div class="numbertext">2/2</div>
                    		<img src="assets/images/tamanpandanmurnihall2.jpg" style="width: 80%">
                    	</div>
                		<br>
						<div style="text-align:center">
  							<span class="dot" onclick="currentSlide(1)"></span> 
  							<span class="dot" onclick="currentSlide(2)"></span> 
						</div>
                    	<div class="down-content row">
                     		<div class="col-md-6">
                      			<p>
                        		<ul>
                            		<li><strong>Max:</strong></br>9 Persons</li>
                            		<li><strong>Address:</strong></br>No-23, Jln PM-1,Taman Pandan Murni, 75250 Melaka</li>
                        		</ul>
                      			</p>
                      			<br><br>
                      		</div>
                     		<div class="col-md-6">
                      			<p>
                        		<ul>
                           			 <li><strong>Bathroom:</strong></br>2 Room</li>
                            		<li><strong>Bed:</strong></br>2 Queen</br>2 King</br>2 Single</li>
                            		<li><strong>Price:</strong></br>RM 500 = 1 night</li>
                        		</ul>
                      			</p>
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

    <script type="text/javascript">
      function openCity(evt, cityName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
          tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
          tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";
      }
    </script>
</body>


  </body>

</html>

