<%-- 
    Document   : main
    Created on : May 17, 2023, 9:53:47 AM
    Author     : msi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section id="about" class="about">
            <div class="container" data-aos="fade-up">

                <div class="row">
                    <div class="col-lg-6 order-1 order-lg-2" data-aos="fade-left" data-aos-delay="100">
                        <img src="assets/img/about.jpg" class="img-fluid" alt="">
                    </div>
                    <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content">
                        <h3>F-Course - Paving the Way for Students' Success.</h3>
                        <p class="fst-italic">
                            Welcome to our website where you can find a wide range of quality online courses. 
                            With our vision, we want to bring learning and personal development opportunities to everyone in an easy and convenient way. 
                        </p>
                        <ul>
                            <li><i class="bi bi-check-circle"></i> An online course designed by qualified and experienced mentors</li>
                            <li><i class="bi bi-check-circle"></i> Courses are constantly updated according to trends.</li>
                            <li><i class="bi bi-check-circle"></i> As long as you have an Internet connection, you can study anywhere, anytime.</li>
                        </ul>
                        <p>
                            Explore now and start your learning and self-development journey with us!
                        </p>

                    </div>
                </div>

            </div>
        </section><!-- End About Section -->
        <!-- ======= Counts Section ======= -->
        <section id="counts" class="counts section-bg">
            <div class="container">

                <div class="row counters">

                    <div class="col-lg-3 col-6 text-center">
                        <span data-purecounter-start="0" data-purecounter-end="${numberStudent}" data-purecounter-duration="1"
                              class="purecounter"></span><!--Number of buyer -->
                        <p>Students</p>
                    </div>

                    <div class="col-lg-3 col-6 text-center">
                        <span data-purecounter-start="0" data-purecounter-end="${numberCourse}" data-purecounter-duration="1"
                              class="purecounter"></span><!--Number of Courses -->
                        <p>Courses</p>
                    </div>

                    <div class="col-lg-3 col-6 text-center">
                        <span data-purecounter-start="0" data-purecounter-end="${numberType}" data-purecounter-duration="1"
                              class="purecounter"></span><!--Number of Promotions -->
                        <p>Type Course</p>
                    </div>

                    <div class="col-lg-3 col-6 text-center">
                        <span data-purecounter-start="0" data-purecounter-end="${numberMentor}" data-purecounter-duration="1"
                              class="purecounter"></span> <!--Number of mentor -->
                        <p>Mentors</p>
                    </div>

                </div>

            </div>
        </section><!-- End Counts Section -->
    </body>
</html>
