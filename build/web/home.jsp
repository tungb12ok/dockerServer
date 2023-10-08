<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>FCourse</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">
        <!-- Vendor CSS Files -->
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">
        <%@include file="component/GGAnalytics.jsp" %>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>

        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex justify-content-center align-items-center">
            <div class="container position-relative" data-aos="zoom-in" data-aos-delay="100">
                <h1>Teaching Today,<br>Shaping Tomorrow</h1>
                <h2>Our team comprises dedicated professionals who are deeply committed to nurturing FPT University students' educational and personal growth. 
                    With a rich tapestry of expertise and experiences, we are unwavering in creating an exceptional learning environment and providing dedicated support so as to help students achieve their milestones along their academic journey.</h2>
                <a href="" class="btn-get-started">Get Started</a>
            </div>
        </section><!-- End Hero -->

        <main id="main">
            <%@include file="component/aboutSection.jsp" %>
            <section id="why-us" class="why-us">
                <div class="container" data-aos="fade-up">

                    <div class="row">
                        <div class="col-lg-4 d-flex align-items-stretch">
                            <div class="content">
                                <h3>Why Choose Mentor?</h3>
                                <p>
                                    We take great pride in our team of mentors and our selection is based on a number of important factors.
                                    Here are the reasons why we trust our mentors
                                </p>
                                <div class="text-center">
                                    <a href="#" class="more-btn">Learn More <i class="bx bx-chevron-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8 d-flex align-items-stretch" data-aos="zoom-in" data-aos-delay="100">
                            <div class="icon-boxes d-flex flex-column justify-content-center">
                                <div class="row">
                                    <div class="col-xl-4 d-flex align-items-stretch">
                                        <div class="icon-box mt-4 mt-xl-0">
                                            <i class="bx bx-receipt"></i>
                                            <h4>Knowledge and experience</h4>
                                            <p>Mentors are selected based on their extensive expertise and practical experience in their field.</p>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 d-flex align-items-stretch">
                                        <div class="icon-box mt-4 mt-xl-0">
                                            <i class="bx bx-cube-alt"></i>
                                            <h4>Interaction and commitment</h4>
                                            <p>Our Mentor is not only a teacher, but also a guide and companion in the learning process. They facilitate interaction, feedback and personal support, helping students to have the ability to apply knowledge in practice.</p>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 d-flex align-items-stretch">
                                        <div class="icon-box mt-4 mt-xl-0">
                                            <i class="bx bx-images"></i>
                                            <h4>Diversity of expertise</h4>
                                            <p>We provide mentors with different specialties. This helps us to serve the diverse learning and development needs of our students, while providing a broader perspective.</p>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- End .content-->
                        </div>
                    </div>

                </div>
            </section><!-- End Why Us Section -->

            <!-- ======= Course Type Section (List All Course Types) ======= -->
            <section id="features" class="features">
                <div class="container" data-aos="fade-up">
                    <div class="row" data-aos="zoom-in" data-aos-delay="100">
                        <c:forEach var="c" items="${CourseType}">
                            <div class="col-lg-3 col-md-4">
                                <div class="icon-box">
                                    <i class="ri-store-line" style="color: #ffbb2c;"></i>
                                    <h3><a href="courseByType/${c.getType_name()}">${c.getType_name()}</a></h3> 
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
            <!-- ======= Popular Courses Section (the list of 3 courses with the most learners) ======= -->
            <section id="popular-courses" class="courses">
                <div class="container" data-aos="fade-up">
                    <div class="section-title">
                        <h2>Courses</h2>
                        <p>Popular Courses</p>
                    </div>
                    <div class="row" data-aos="zoom-in" data-aos-delay="100">
                        <c:forEach var="course" items="${Course}">
                            <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                                <div class="course-item">
                                    <img src="${course.getImage()}" style="width: 500px; height: 250px" class="img-fluid" alt="...">
                                    <div class="course-content">
                                        <div class="d-flex justify-content-between align-items-center mb-3">
                                            <h4>${course.getType_name()}</h4>
                                            <p class="price">${course.getPrice()} VND</p>
                                        </div>
                                        <h3><a href="course/${course.getURL()}">${course.getCourse_name()}</a></h3>
                                       
                                        <p>${course.getDescription(1)}...</p>

                                        <div class="trainer d-flex justify-content-between align-items-center">
                                            <div class="trainer-profile d-flex align-items-center">
                                                <img src="assets/img/trainers/trainer-1.jpg" class="img-fluid" alt="">
                                                <span>${course.getMentor_name()}</span>
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
                        </c:forEach>
                    </div>
                </div>
            </section>

            <!-- ======= Mentor  Section (list of 3 mentors with the most courses ) ======= -->
            <section id="trainers" class="trainers">
                <div class="container" data-aos="fade-up">
                    <div class="section-title">
                        <h2>Mentor</h2>
                        <p>Top 3 mentors with the most courses</p>
                    </div>
                    <div class="row" data-aos="zoom-in" data-aos-delay="100">
                        <c:forEach var="mentor" items="${mentor}">
                            <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                                <div class="member">
                                    <img src="${mentor.getAvatar()}" style="width: 334px; height: 334px; "class="img-fluid" alt="">
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

        <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>
        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
        <!--Start of Tawk.to Script-->

        <!--End of Tawk.to Script-->
    </body>

</html>