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
    </head>

    <body class="sb-nav-fixed">
        <%@include file="component/navbarAdmin.jsp" %>
        <%@include file="component/Sivenav_left.jsp" %>
        <div id="layoutSidenav_content">
            <main>
                <c:if test="${news.getTitle() == null}">
                </c:if>
                <c:if test="${news.getTitle() != null}">
                    <div class="container-fluid px-4">
                        <div class="row">
                            <h3 class="mt-4">${news.getTitle()}</h3>
                            <p>Author: ${news.getCreate_by()}</p>
                            <p>Public Date: ${news.getCreated_date()}</p>
                            <div>${news.getContent()}</div>
                        </div>
                    </div>
                </c:if>
                <hr>
                <h5 class="mt-4">Other News</h5>
                <c:forEach var="n" items="${listNewsInternal}" varStatus="status">
                    <c:if test="${status.index < 10}">
                        <li>${n.getCreated_date()}:   <a href="internalNews?id=${n.getNewsID()}">  ${n.getTitle()}</a></li>
                        </c:if>
                    </c:forEach>
            </main>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="assets/js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
    <script src="assets/js/datatables-simple-demo.js"></script>
</body>
</html>
