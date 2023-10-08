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
        <title>Tables - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="assets/css/stylesAdmin.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <%@include file="component/navbarAdmin.jsp" %>
        <%@include file="component/Sivenav_left.jsp" %>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Tables News</h1>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            NEWS
                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>Title</th>
                                        <th>Create Date</th>
                                        <th>Author</th>     
                                        <th>Action</th>  
                                        <th>Edit</th>  
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Title</th>
                                        <th>Create Date</th>
                                        <th>Type</th>    
                                        <th>Action</th>    
                                        <th>Edit</th>    
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:if test="${account.roleID == 1}">
                                        <c:forEach var="news" items="${requestScope.listNews}">
                                            <tr>
                                                <td>${news.getTitle()}</td>
                                                <td>${news.getCreated_date()}</td>
                                                <td>
                                                    <c:if test="${news.getType() == 1}">
                                                        <p>Internal news</p>
                                                    </c:if>
                                                    <c:if test="${news.getType() == 2}">
                                                        <p>Promotion news</p>
                                                    </c:if>
                                                </td>
                                                <td>
                                                    <c:if test="${news.getStatus() == 0}">
                                                        <a style="color:white ; text-decoration:none" href="changeNews?id=${news.getNewsID()}" ><button class="btn btn-success" type="button" >Un Display</button></a>

                                                    </c:if>
                                                    <c:if test="${news.getStatus() == 1}">
                                                        <a style="color:white ; text-decoration:none" href="changeNews?id=${news.getNewsID()}" ><button class="btn btn-danger" type="button" >Display</button></a>
                                                    </c:if>
                                                </td>
                                                <td>
                                                    <a style="color:white ; text-decoration:none" href="updateNews?id=${news.getNewsID()}" ><button class="btn btn-danger" type="button" >Update</button></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${account.roleID != 1}">
                                        <c:forEach var="news_2" items="${requestScope.listNewsByMentor}">
                                            <tr>
                                                <td>${news_2.getTitle()}</td>
                                                <td>${news_2.getCreated_date()}</td>
                                                <td>${news_2.getCreate_by()}</td>
                                                <td>
                                                    <i style="font-size:24px" class="fa">&#xf040;</i>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
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
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
    <script src="assets/js/datatables-simple-demo.js"></script>
</body>
</html>
