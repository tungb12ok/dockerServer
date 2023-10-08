<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.*"%>
<%@page import="dal.*"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - FCourses Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="assets/css/stylesAdmin.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <link href="assets/css/button-37.css" rel="stylesheet">
        <script src="ckeditor/ckeditor.js"></script>

    </head>

    <body class="sb-nav-fixed">
        <%@include file="component/navbarAdmin.jsp" %>
        <%@include file="component/Sivenav_left.jsp" %>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Add News</h1>
                    <form action="addNews" method="POST" role="form" class="php-email-form" enctype="multipart/form-data">
                        <div class="form-group mt-3">
                            <h6>NEWS TITLE</h6>
                            <input type="text" name="title" class="form-control" id="title" placeholder="News Title" required>
                        </div>
                        <div class="form-group mt-3">
                            <h6>NEWS Content</h6>
                            <textarea class="form-control" id="description" name="description" rows="5" placeholder="Description" required></textarea>
                        </div>

                        <div class="form-group mt-3">
                            <h6>NEWS Banner</h6>
                            <input type="file" class="form-control" id="image" name="image" accept="image/png, image/gif, image/jpeg" />                       
                        </div>
                        <div class="form-group mt-3">
                            <h6>Choose Type</h6>
                            <select name="NewsType" class="form-control">
                                <c:if test="${account.roleID == 1}">             
                                    <c:forEach var="type" items="${newsType}">
                                        <option value="${type.getTypeID()}">${type.getTypeName()}</option>
                                    </c:forEach>

                                </c:if>
                                <c:if test="${account.roleID == 2}">                
                                    <option value="2">Promotion news</option>
                                </c:if>
                            </select>
                        </div>
                        <div style="color:#5fcf80"><strong>${messSuccess}</strong></div>   

                        <div class="text-center form-group mt-3"><input type="submit" value="Add news" class="button-37" /></div>
                    </form>
                </div>
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid px-4">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Your Website 2023</div>
                        <div>
                            <a href="#">Privacy Policy</a>
                            &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="assets/js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
    <script src="assets/js/datatables-simple-demo.js"></script>
    <!--<script src="//cdn.ckeditor.com/4.21.0/standard/ckeditor.js"></script>-->
    <script>
        CKEDITOR.replace('description');
    </script>
</body>
</html>
