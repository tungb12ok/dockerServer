<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>FCourse</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="../assets/img/favicon.png" rel="icon">
        <link href="../assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">
        <!-- Vendor CSS Files -->
        <link href="../assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="../assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="../assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="../assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="../assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <link href="../assets/css/style.css" rel="stylesheet">
        <style>
            .image-info-container {
                display: flex;
                align-items: center;
            }

            .image-info-list {
                margin-left: 10px; /* Tuỳ chỉnh khoảng cách giữa ảnh và danh sách */
                list-style-type: none;
                padding: 0;
            }

            .image-info-list li {
                margin-bottom: 5px; /* Tuỳ chỉnh khoảng cách giữa các mục trong danh sách */
            }
        </style>
    </head>

    <body>
        <%@include file="component/navbar.jsp" %>
        <div class="breadcrumbs">
            <div class="container">
                <h2>Courses</h2>
                <p>Welcome to our online course page! Here, we are proud to bring you a diverse and high-quality range of courses, to help you develop personally and seize the opportunity to succeed in life and work. </p>
            </div>
        </div><!-- End Breadcrumbs -->
        <main id="main"> 
            <div class="row">      
                <section id="popular-courses" class="courses">
                    <div class="container" data-aos="fade-up">
                        <div class="section-title">
                            <h4>Course of ${mentor.getFull_name()}</h4>
                        </div>
                        <div class="course-item" style="border: 2px">
                            <div class="image-info-container">
                                <img src="../${mentor.getAvatar()}" style="width: 250px; height: 250px" class="img-fluid" alt="...">
                                <ul class="image-info-list">
                                    <li>Name  : ${mentor.getFull_name()}.</li>
                                    <hr>
                                    <li>Job   : ${mentor.getJob()}.</li>
                                    <hr>
                                    <li>Skill : ${mentor.getSkill()}.</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <div class="row">      
                <section id="popular-courses" class="courses">
                    <div class="container" data-aos="fade-up">
                        <div class="section-title">
                            <h4>Course of ${mentor.getFull_name()}</h4>
                        </div>
                        <div class="row" data-aos="zoom-in" data-aos-delay="100">
                            <c:forEach var="course" items="${Course}">
                                <div class="col-lg-3 col-md-4 d-flex align-items-stretch">
                                    <div class="course-item">
                                        <img src="../${course.getImage()}" style="width: 500px; height: 250px" class="img-fluid" alt="...">
                                        <div class="course-content">
                                            <div class="d-flex justify-content-between align-items-center mb-3">
                                                <h4>${course.getType_name()}</h4>
                                                <p class="price">$${course.getPrice()}</p>
                                            </div>
                                            <h3><a href="http://localhost:9999/SWP391/course/${course.getURL()}"> ${course.getCourse_name()}</a></h3>
                                            <p>${course.getDescription().substring(0,100)}...</p>
                                            <div class="trainer d-flex justify-content-between align-items-center">
                                                <div class="trainer-profile d-flex align-items-center">
                                                    <img src="assets/img/trainers/trainer-1.jpg" class="img-fluid" alt="">
                                                    <span>${mentor.getFull_name()}</span>
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
            </div>

        </main>
        <%@include file="component/footer.jsp" %>

        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
                class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="../assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="../assets/vendor/aos/aos.js"></script>
        <script src="../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="../assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="../assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="../assets/js/main.js"></script>

    </body>

</html>