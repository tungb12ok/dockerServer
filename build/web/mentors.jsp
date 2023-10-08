<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Trainers - Mentor Bootstrap Template</title>
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

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">

        <!-- =======================================================
        * Template Name: Mentor
        * Updated: Mar 10 2023 with Bootstrap v5.2.3
        * Template URL: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>

    <body>
        <%@include file="component/navbar.jsp" %>
        <main id="main" data-aos="fade-in">
            <!-- ======= Breadcrumbs ======= -->
            <div class="breadcrumbs">
                <div class="container">
                    <h2>Trainers</h2>
                    <p>Mentor is an individual with in-depth knowledge, skills, and experience in a particular field. The role of a mentor is to guide, support and share knowledge with others (called mentees) to help them grow and succeed in their respective fields. Mentors often have more experience and a better understanding of the challenges and opportunities in their industry, and they use that knowledge to advise, guide, and impart skills to mentees. </p>
                </div>
            </div><!-- End Breadcrumbs -->

            <!-- ======= Trainers Section ======= -->
            <section id="trainers" class="trainers">
                <div class="container" data-aos="fade-up">

                    <div class="row" data-aos="zoom-in" data-aos-delay="100">
                        <c:forEach var="mentor" items="${mentorList}">
                            <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                                <div class="member">
                                    <c:if test="${mentor.getAvatar() == null}">
                                        <img src="https://st2.depositphotos.com/1104517/11967/v/950/depositphotos_119675554-stock-illustration-male-avatar-profile-picture-vector.jpg" style="width: 334px; height: 334px;" class="img-fluid" alt="">

                                    </c:if>
                                    <c:if test="${mentor.getAvatar() != null}">
                                        <img src="${mentor.getAvatar()}" style="width: 334px; height: 334px;" class="img-fluid" alt="">
                                    </c:if>
                                    <div class="member-content">

                                        <h4>
                                            <a href="mentorPage/${mentor.getFull_name().replace("\\s","")}">${mentor.getFull_name()}</a>
                                        </h4>
                                        <span>${mentor.getJob()}</span>
                                        <p>${mentor.getSkill()}</p>
                                        <div class="social">
                                            <a href="#"><i class="bi bi-twitter"></i></a>
                                            <a href="#"><i class="bi bi-facebook"></i></a>
                                            <a href="#"><i class="bi bi-instagram"></i></a>
                                            <a href="#"><i class="bi bi-linkedin"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>

                </div>
            </section><!-- End Trainers Section -->

        </main><!-- End #main -->

        <%@include file="component/footer.jsp" %>

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