<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Courses</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <link href="assets/css/style.css" rel="stylesheet">
    </head>

    <body>

        <!-- ======= Header ======= -->
        <%@include file="component/navbar.jsp" %>
        <!-- End Header -->

        <main id="main" data-aos="fade-in">

            <!-- ======= Breadcrumbs ======= -->
            <div class="breadcrumbs">
                <div class="container">
                    <h2>Courses</h2>
                    <p>Welcome to our online course page! Here, we are proud to bring you a diverse and high-quality range of courses, to help you develop personally and seize the opportunity to succeed in life and work. </p>
                </div>
            </div><!-- End Breadcrumbs -->

            <!-- ======= Courses Section ======= -->
            <section id="courses" class="courses">
                <div class="container" data-aos="fade-up">
                    <div class="row" data-aos="zoom-in" data-aos-delay="100">
                        <!-- List courses -->
                        <div class="col-lg-3 col-md-3 d-flex align-items-stretch">
                            <div class="course-item">
                                <img src="assets/img/course-1.jpg" class="img-fluid" alt="...">
                                <div class="course-content">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4>Web Development</h4>
                                        <p class="price">$169</p>
                                    </div>

                                    <h3><a href="course_detail.jsp">Website Design</a></h3>
                                    <p>Et architecto provident deleniti facere repellat nobis iste. Id facere quia quae dolores dolorem tempore.</p>
                                    <div class="trainer d-flex justify-content-between align-items-center">
                                        <div class="trainer-profile d-flex align-items-center">
                                            <img src="assets/img/trainers/trainer-1.jpg" class="img-fluid" alt="">
                                            <span>Antonio</span>
                                        </div>
                                        <div class="trainer-rank d-flex align-items-center">
                                            <i class="bx bx-user"></i>&nbsp;50
                                            &nbsp;&nbsp;
                                            <i class="bx bx-heart"></i>&nbsp;65
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End List Course-->
                    </div>

                </div>
            </section><!-- End Courses Section -->

        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
        <%@include file="component/footer.jsp" %>
        <!-- End Footer -->

        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>

    </body>

</html>