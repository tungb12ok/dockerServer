<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.*"%>
<%@page import="dal.*"%>
<%@page import="java.util.List"%>

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

    <body class="sb-nav-fixed">
        <%@include file="component/navbar.jsp" %>
        <div class="container">
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Create new flash card list</h1>
                        <form action="AddFlashcards" method="POST" role="form" class="php-email-form">
                            <div class="form-group mt-3">
                                <div class="form-group mt-3 col-5">
                                    <h5>TITLE</h5>
                                    <input type="text" name="title" class="form-control" id="title" placeholder="Enter a title, for example Biology - Chapter 22: Evolution" required>
                                </div>
                                <div class="form-group mt-3" id="question">
                                    <h5>Flashcards</h5>
                                    <div class="row">
                                        <h6>1</h6>
                                        <div>
                                            <textarea type="text" name="question1" value="" class="form-control" placeholder="Question 1" required></textarea>
                                        </div>
                                        <div>
                                            <textarea type="text" name="answer1" value="" class="form-control" placeholder="Answer 1" required></textarea>
                                        </div>
                                    </div>
                                    <hr>
                                </div>
                                <input type="button" onclick="addInput()" value="More Flashcards">


                            </div>
                            <div style="color:#5fcf80"><strong>${messSuccess}</strong></div>   
                            <div class="text-center form-group mt-3">
                                <input type="submit" value="ADD NEW FLASH CARD" class="btn-danger">
                            </div>
                        </form>

                    </div>
                </main>
            </div>
        </div>
        <%@include file="component/footer.jsp" %>
        <script>
            var counter = 2;

            function addInput() {
                var container = document.getElementById("question");

                var rowHtml = '<h6>' + counter + '</h6>' +
                        '<div class="row">' +
                        '<div>' +
                        '<textarea type="text" name="question' + counter + '" class="form-control" placeholder="Question ' + counter + '" required></textarea>' +
                        '</div>' +
                        '<div>' +
                        '<textarea type="text" name="answer' + counter + '" class="form-control" placeholder="Answer ' + counter + '" required></textarea>' +
                        '</div>' +
                        '</div>' +
                        '<hr>';

                var newDiv = document.createElement("div");
                newDiv.innerHTML = rowHtml;

                container.appendChild(newDiv);
                counter++;
            }
        </script>
        <script src="../assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="../assets/vendor/aos/aos.js"></script>
        <script src="../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="../assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="../assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="../assets/js/main.js"></script>
    </body>
</html>
