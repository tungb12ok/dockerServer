<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Sivenav_left
    Created on : May 17, 2023, 7:53:37 PM
    Author     : msi
--%>
<%
    User account = (User) session.getAttribute("account");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Start layout Sidenav -->
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <c:if test="${account.roleID == 1}">                             
                                <a class="nav-link" href="admin">
                                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                    Dashboard
                                </a>
                            </c:if>
                            <c:if test="${account.roleID == 2}">                             
                                <a class="nav-link" href="mentor">
                                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                    Dashboard
                                </a>
                            </c:if>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                NEWS Manager
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="addNews">ADD NEWS</a>
                                    <a class="nav-link" href="news">List NEWS</a>
                                    <c:if test="${account.roleID == 1}">
                                        <a class="nav-link" href="newsType">News Type</a>
                                    </c:if>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                User/Course Manager
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <c:if test="${account.roleID == 1}">
                                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                            User
                                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                        </a>
                                        <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                            <nav class="sb-sidenav-menu-nested nav">
                                                <a class="nav-link" href="#">Mentor</a>
                                                <a class="nav-link" href="#">Customer</a>
                                            </nav>
                                        </div>
                                    </c:if>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Course
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="#">List Courses</a>
                                            <c:if test="${account.roleID == 1}">                             
                                                <a class="nav-link" href="courseType">Course Type</a>
                                            </c:if>
                                            <c:if test="${account.roleID == 2}">                             
                                                <a class="nav-link" href="addCourse">Add Course</a>
                                            </c:if>

                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <c:if test="${account.roleID == 1}">
                                <div class="sb-sidenav-menu-heading">Addons</div>
                                <a class="nav-link" href="OrderList">
                                    <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                    Order List
                                </a>
                                <a class="nav-link" href="courseType">
                                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                    Course Type List
                                </a>
                            </c:if>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer  bg-success">
                        <c:if test="${account.roleID == 1}">
                            <div class="small">Logged in as: ${account.full_name} (ADMIN) </div>
                        </c:if>
                        <c:if test="${account.roleID == 2}">
                            <div class="small">Logged in as: ${account.full_name} (MENTOR)</div>
                        </c:if>
                        <!-- Admin name-->
                    </div>
                </nav>
            </div>
            <!-- End layout Sidenav -->
    </body>
</html>
