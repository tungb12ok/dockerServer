<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Course Details - Mentor Bootstrap Template</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="../assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

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
        <!-- Font Awesome -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
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
        <%@include file="/component/navbar.jsp" %>

        <main id="main">

            <!-- ======= Breadcrumbs ======= -->

            <c:if test="${course.getStatus() == 0}">
                <div class="breadcrumbs" data-aos="fade-in">
                    <div class="container">
                        <h2>Course Not Found</h2>
                    </div>
                </div><!-- End Breadcrumbs -->
            </c:if>
            <c:if test="${course.getStatus() == 1}">
                <div class="breadcrumbs" data-aos="fade-in">
                    <div class="container">
                        <h2>${course.getCourse_name()}</h2>
                    </div>
                </div><!-- End Breadcrumbs -->
                <!-- ======= Cource Details Section ======= -->
                <section id="course-details" class="course-details">
                    <div class="container" data-aos="fade-up">

                        <div class="row">
                            <div class="col-lg-8">
                                <img src="../${course.getImage()}" class="img-fluid" alt="" style="width: 879.99px; height: 250px">
                                <h3>${course.getCourse_name()}</h3>
                                ${course.getDescription()}
                            </div>
                            <div class="col-lg-4">
                                <div class="course-info d-flex justify-content-between align-items-center">
                                    <h5>Type</h5>
                                    <p>${course.getType_name()}</p>
                                </div>
                                <div class="course-info d-flex justify-content-between align-items-center">
                                    <h5>Trainer</h5>
                                    <p><a href="#">${course.getMentor_name()}</a></p>
                                </div>

                                <div class="course-info d-flex justify-content-between align-items-center">
                                    <h5>Course Fee</h5>
                                    <p>${course.getPrice()} VND</p>
                                </div>

                                <div class="course-info d-flex justify-content-between align-items-center">
                                    <h5>Public Date</h5>
                                    <p>${course.getPublic_date()}</p>
                                </div>
                                <c:if test="${account == null}">
                                    <a style="color:white" href="${pageContext.request.contextPath}/login" ><button class="btn btn-success" type="button" >Login to Enroll this course</button></a>
                                </c:if>
                                <c:if test="${account != null}">
                                    <c:if test="${orderBuy == null}">
                                        <button type="button" class="button-37" data-toggle="modal" data-target="#payModal">Enroll this course</button>
                                    </c:if>
                                    <c:if test="${orderBuy != null}">
                                        <c:if test="${orderBuy == null}">
                                            <button type="button" class="button-37" data-toggle="modal" data-target="#payModal">Enroll this course</button>
                                        </c:if>
                                        <c:if test="${orderBuy != null}">
                                            <c:if test="${orderBuy.getStatusOrder() == 1}">
                                                <button type="button" class="button-37"  id="go-to-course-btn" >Go to course</button>
                                                <!-- go to course When user click -->
                                                <script>
                                                    document.getElementById("go-to-course-btn").addEventListener("click", function () {
                                                        // Scroll to the cource-details-tabs section
                                                        document.getElementById("cource-details-tabs").scrollIntoView({behavior: "smooth"});
                                                    });
                                                </script>
                                            </c:if>
                                            <c:if test="${orderBuy.getStatusOrder() == 0}">
                                                <p class="button-37">Processing....</p>
                                            </c:if>                                   
                                        </c:if>                                  
                                    </c:if>
                                </c:if>
                            </div>
                        </div>

                    </div>
                </section><!-- End Cource Details Section -->



                <div class="modal fade" id="payModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg"> <!-- Thay đổi modal-sm thành modal-lg -->
                        <div class="modal-content rounded-0">
                            <div class="modal-body p-6 px-10 d-flex justify-content-center"> 
                                <div class="col-6">
                                    <form action="${pageContext.request.contextPath}/vnpay/ajaxvnpay" method="get">
                                        <button type="submit" value="VNPAYQR" id="VNPAYQR" name="paymethod" class="btn btn-secondary btn-lg bg-success">
                                            <div class="row row-6 align-items-center">
                                                <input type="text" name="amount" value="${course.getPrice()}" hidden >
                                                <input type="text" name="courseID" value="${course.getID()}" hidden >
                                                <div class="col">
                                                    <div class="title h5 text-white">
                                                        Ứng dụng thanh toán hỗ trợ
                                                        <span class="vnpay-logo b">
                                                            <span class="vnpay-red">VN</span><span class="vnpay-blue">PAY</span>
                                                            <sup class="vnpay-red">QR</sup>
                                                        </span>
                                                    </div>
                                                </div>
                                                <div class="col-auto">
                                                    <div class="icon">
                                                        <img src="https://vidientu.vnpay.vn/imgs/Logo.png" alt="" style="width: 65px; height: 65px;">
                                                    </div>
                                                </div>
                                            </div>
                                        </button>
                                    </form>
                                    <button data-toggle="modal" data-target="#exampleModalCenter1" class="btn btn-secondary btn-lg bg-success">
                                        <div class="row row-12 align-items-center">
                                            <div class="col">
                                                <div class="title h5 text-white">
                                                    Thanh toán qua ngân hàng nội địa
                                                </div>
                                            </div>
                                            <div class="col-auto">
                                                <div class="icon">
                                                    <img src="https://th.bing.com/th/id/OIP.t-7Vvbqwe17y_8MIMgIPtgHaHa?pid=ImgDet&rs=1" alt="" style="width: 65px; height: 65px;">
                                                </div>
                                            </div>
                                        </div>
                                    </button>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>





                <!-- Modal -->
                <div class="modal fade" id="exampleModalCenter1" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-xl">
                        <div class="modal-content rounded-0">
                            <div class="modal-body p-4 px-5">
                                <div class="col-12">
                                    <form action="${pageContext.request.contextPath}/enroll" method="post">
                                        <div class="row">
                                            <div class="left col-lg-4">
                                                <h5 style="color: green">Waiting for payment</h5>
                                                <div id="countdown">5:00</div>     
                                                <hr>
                                                <div class="course-info d-flex justify-content-between align-items-center">
                                                    <h5>Course Name</h5>
                                                    <p>${course.getCourse_name()}</p>
                                                    <input type="text" name="courseID" value="${course.getID()}" style="display: none">
                                                    <input type="text" name="URL" value="${course.getURL()}" style="display: none">
                                                    <input type="text" name="amount" value="${course.getPrice()}" style="display: none">
                                                    <input type="text" name="billCode" value="${BillCode}" style="display: none">
                                                </div>
                                                <div class="course-info d-flex justify-content-between align-items-center">
                                                    <h5>Payment code</h5>
                                                    <p>${BillCode}</p>
                                                </div>
                                                <hr>
                                                <h5 style="color: green">Payment details</h5>
                                                <div class="course-info d-flex justify-content-between align-items-center">
                                                    <h5>Price</h5>
                                                    <p>${course.getPrice()} VND</p>
                                                </div>
                                            </div>
                                            <div class="right col-lg-8">
                                                <h5 style="color: green">Transfer by QR</h5>
                                                <div class="image-info-container">
                                                    <img src="../assets/img/qr_thanhtoan.jpg" style="width: 120px; height: 120px" class="img-fluid" alt="">
                                                    <ul class="image-info-list">
                                                        <li>Step 1: Open the banking app or Momo and scan the QR code.</li>
                                                        <li>Step 2: Make sure the transfer content is ${BillCode}.</li>
                                                        <li>Step 3: Make payment.</li>
                                                    </ul>
                                                </div>
                                                <hr>
                                                <div>
                                                    <h5 style="color: green">Manual transfer</h5>
                                                    <div class="course-info d-flex justify-content-between align-items-center">
                                                        <h6>Bank account number</h6>
                                                        <p>0394 4772 041</p>
                                                    </div>
                                                    <div class="course-info d-flex justify-content-between align-items-center">
                                                        <h6>Bank account holder name</h6>
                                                        <p>Le Thi Huong Huyen</p>
                                                    </div>
                                                    <div class="course-info d-flex justify-content-between align-items-center">
                                                        <h6>Bank</h6>
                                                        <p>MB bank</p>
                                                    </div>
                                                    <div class="course-info d-flex justify-content-between align-items-center">
                                                        <h6>Content</h6>
                                                        <p>${BillCode}</p>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div>
                                                    <p>Up to 5 minutes after the transfer time, if the system does not respond, please contact F8 support immediately.</p>
                                                    <p>039.477.2041</p>
                                                    <p>contact@fullstack.edu.vn</p>
                                                    <p>No. 26 Duong Dinh Nghe, Yen Hoa Ward, Cau Giay District, City. Hanoi</p>
                                                </div>
                                            </div>
                                        </div>
                                        <button type="submit" class="button-37">Đã Thanh Toán</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <c:if test="${account == null}">
                    <section id="cource-details-tabs" class="cource-details-tabs">
                        <div class="container" data-aos="fade-up">
                            <hr>
                            <p>Please <a href="${pageContext.request.contextPath}/login">Login</a> To see the course Detail</p>
                        </div>
                    </section>
                </c:if>
                <c:if test="${account != null}">
                    <section id="cource-details-tabs" class="cource-details-tabs">
                        <div class="container" data-aos="fade-up">
                            <h2>Syllabus</h2>                         
                            <div class="row">
                                <div class="col-lg-5">
                                    <ul class="nav nav-tabs flex-column">
                                        <c:set var="tt" value="0"/>
                                        <c:forEach var="module" items="${module}">
                                            <c:set var="tt" value="${tt+1}"/>
                                            <li class="nav-item">
                                                <a class="nav-link" data-bs-toggle="tab" href="#tab-${tt}">${module.getModuleName()}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div class="col-lg-7 mt-4 mt-lg-0">
                                    <div class="tab-content">

                                        <c:set var="tt" value="0"/>
                                        <c:forEach var="module" items="${module}">
                                            <c:set var="tt" value="${tt+1}"/>
                                            <div class="tab-pane" id="tab-${tt}">
                                                <div class="row">
                                                    <div class="col-lg-8 details order-2 order-lg-1">

                                                        <c:if test="${orderBuy.getStatusOrder() == 1}">
                                                            <iframe style="width: 756px; height: 425px; left: 0px; top: 0px;" src="${module.getLink()}"></iframe>
                                                            </c:if>
                                                            <c:if test="${orderBuy.getStatusOrder() != 1}">
                                                            <div class="course-info d-flex justify-content-between align-items-center">
                                                                <h4 class="text-success">Enroll this course to watch this module </h4>
                                                            </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </section>
                </c:if>
            </c:if>

        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
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
        <script src="../modal/js/jquery-3.3.1.min.js"></script>
        <script src="../modal/js/popper.min.js"></script>
        <script src="../modal/js/bootstrap.min.js"></script>
        <script src="../modal/js/main.js"></script>
        <script>
                                                $(document).ready(function () {
                                                    var modal = $('#exampleModalCenter');
                                                    var countdownElement = document.getElementById('countdown');
                                                    var countdownInterval;

                                                    // Hàm hiển thị thời gian đếm ngược
                                                    function showCountdown(minutes, seconds) {
                                                        countdownElement.innerHTML = minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
                                                    }

                                                    // Hàm bắt đầu đếm ngược và tự đóng modal sau 5 phút
                                                    function startCountdown() {
                                                        var totalSeconds = 5 * 60;
                                                        var remainingSeconds = totalSeconds;

                                                        showCountdown(Math.floor(remainingSeconds / 60), remainingSeconds % 60);

                                                        countdownInterval = setInterval(function () {
                                                            remainingSeconds--;

                                                            if (remainingSeconds < 0) {
                                                                clearInterval(countdownInterval);
                                                                modal.modal('hide');
                                                            } else {
                                                                showCountdown(Math.floor(remainingSeconds / 60), remainingSeconds % 60);
                                                            }
                                                        }, 1000);
                                                    }

                                                    // Sự kiện khi modal được mở
                                                    modal.on('shown.bs.modal', function () {
                                                        startCountdown();
                                                    });

                                                    // Sự kiện khi modal được đóng
                                                    modal.on('hidden.bs.modal', function () {
                                                        clearInterval(countdownInterval);
                                                        countdownElement.innerHTML = "5:00";
                                                    });
                                                });

        </script>






    </body>

</html>