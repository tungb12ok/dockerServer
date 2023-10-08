<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Course Details - Mentor Bootstrap Template</title>
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
        <!-- Template Main CSS File -->
        <link href="../assets/css/style.css" rel="stylesheet">
        <link href="../assets/css/button-37.css" rel="stylesheet">

    </head>

    <body>


        <%@include file="/component/navbar.jsp" %>

        <main id="main">

            <c:if test="${news.getStatus() == 0}">
                <div class="breadcrumbs" data-aos="fade-in">
                    <div class="container">
                        <h2>News Not Found</h2>
                    </div>
                </div>
            </c:if>
            <c:if test="${news.getStatus() == 1}">
                <div class="breadcrumbs" data-aos="fade-in">
                    <div class="container">
                        <h3>${news.getTitle()}</h3>
                    </div>
                </div>

                <section id="course-details" class="course-details">
                    <div class="container" data-aos="fade-up">

                        <div class="row">
                            <div class="col-lg-8">
                                <img src="${news.getImage()}" class="img-fluid" alt="">
                                <h3>${news.getTitle()}</h3>
                            </div>
                            <div class="col-lg-4">
                                <div class="course-info d-flex justify-content-between align-items-center">
                                    <h5>Author</h5>
                                    <p><a href="#">${news.getCreate_by()}</a></p>
                                </div>

                                <div class="course-info d-flex justify-content-between align-items-center">
                                    <h5>Public Date</h5>
                                    <p>${news.getCreated_date()}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="justify-content-around">${news.getContent()}</div>
                        </div>
                        
                    </div>
                </section><!-- End Cource Details Section -->

                <!-- ======= Cource Details Tabs Section ======= -->

            </c:if>

        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
        <%@include file="/component/footer.jsp" %>

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