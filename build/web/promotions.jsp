<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Promotion</title>
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
        <%@include file="component/navbar.jsp" %>

        <main id="main">

            <!-- ======= Breadcrumbs ======= -->
            <div class="breadcrumbs" data-aos="fade-in">
                <div class="container">
                    <h2>News</h2>
                    <p>Est dolorum ut non facere possimus quibusdam eligendi voluptatem. Quia id aut similique quia voluptas sit quaerat debitis. Rerum omnis ipsam aperiam consequatur laboriosam nemo harum praesentium. </p>
                </div>
            </div><!-- End Breadcrumbs -->

            <!-- ======= Events Section ======= -->
            <section id="events" class="events">
                <div class="container" data-aos="fade-up">
                    <div class="section-title">
                        <h2>News</h2>
                        <p>Latest news</p>
                    </div>
                </div>
                <div class="container" data-aos="fade-up">
                    <div class="row">
                        <c:forEach var="news" items="${news}">
                            <div class="col-md-6 d-flex align-items-stretch">
                                <a href="new/${news.getURL()}">
                                    <div class="card">
                                        <div class="card-img">
                                            <img style="width: 650px ; height: 300px" src="${news.getImage()}" alt="...">
                                        </div>
                                        <div class="card-body">
                                            <h5 class="card-title"></h5>
                                            <p class="fst-italic text-center">${news.getCreated_date()}</p>
                                            <p class="fst-italic text-center">Author: ${news.getCreate_by()}</p>
                                            <p class="card-text"></p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section><!-- End Events Section -->
            <section id="events" class="events">
                <div class="container" data-aos="fade-up">
                    <div class="section-title">
                        <h2>News</h2>
                        <p>Latest news</p>
                    </div>
                </div>
                <div class="container" data-aos="fade-up">
                    <div class="row">
                        <c:forEach var="news" items="${newsRandom}">
                            <div class="col-md-4 d-flex align-items-stretch">
                                <div class="card">
                                    <div class="card-img">
                                        <img style="width: 650px ; height: 300px" src="${news.getImage()}" alt="...">
                                    </div>
                                    <div class="card-body">
                                        <h6 class="card-title"><a href="new/${news.getURL()}">${news.getTitle()}</a></h6>
                                        <p class="fst-italic text-center">${news.getCreated_date()}</p>
                                        <p class="fst-italic text-center">Author: ${news.getCreate_by()}</p>
                                        <p class="card-text"></p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section><!-- End Events Section -->


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