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
        <title>Tables - FCourse Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="assets/css/stylesAdmin.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/button-37.css"/>
    </head>
    <body class="sb-nav-fixed">
        <%@include file="component/navbarAdmin.jsp" %>
        <%@include file="component/Sivenav_left.jsp" %>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Type</h1>
                    <div class="row">
                        <div class="col-md-5">
                            <form action="courseType" method="POST">                                
                                <div class="form-group mt-3">
                                    <h6>Add New Type</h6>
                                    <input type="text" name="type" class="form-control"  placeholder="Enter Type name " required>                      
                                </div>
                                <div class="form-group mt-3">
                                    <h6>Description </h6>
                                    <textarea class="form-control"  name="description" rows="5" placeholder="Please fill in the description of this course (~50 words)" required></textarea>                       
                                </div>
                                <div  style="color:red"> ${msg} </div>
                                <div class="text-center form-group mt-3"><button type="submit" class="button-37">ADD TYPE</button></div>
                            </form>
                            <h1>Update</h1>
                            <form action="updateType" method="POST">                                
                                <div class="form-group mt-3">
                                    <h6>Update Type</h6>
                                    <input type="text" name="type" class="form-control" value="${type.getType_name()}" placeholder="Update Type name " required>                      
                                </div>
                                <div class="form-group mt-3">
                                    <h6>Update Description </h6>
                                    <textarea class="form-control"  name="description" rows="5" value="${type.getDescription()}" placeholder="Please fill in the description of this course (~50 words)" required></textarea>                       
                                </div>
                                <input type="hidden" name="id" value="${type.getTypeID()}" />
                                <div class="text-center form-group mt-3"><button type="submit" class="button-37">Update</button></div>                     
                            </form>

                        </div>
                        <div class="col-7">
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-table me-1"></i>
                                    Type 
                                </div>
                                <form action="updateType" method="">
                                    <div class="card-body">
                                        <table id="datatablesSimple">
                                            <thead>
                                                <tr>
                                                    <th>Course type name</th>
                                                    <th>Creation date</th>
                                                    <th>Modification date </th>   
                                                    <th>Action</th> 
                                                </tr>
                                            </thead>
                                            <tbody>                                           
                                                <c:forEach var="i" items="${listType}">
                                                    <tr> 
                                                        <td>${i.getType_name()}</td>
                                                        <td>${i.getCreated_date()}</td>
                                                        <td>${i.getModified_date()}</td>
                                                        <td>
                                                            <c:if test="${i.getStatus() == 1}">
                                                                <a style="color:white ; text-decoration:none" href="change?id=${i.getTypeID()}" ><button class="btn btn-success" type="button" >Un Display</button></a>
                                                            </c:if>
                                                            <c:if test="${i.getStatus() == 0}">
                                                                <a style="color:white ; text-decoration:none" href="change?id=${i.getTypeID()}" ><button class="btn btn-danger" type="button" >Display</button></a>
                                                            </c:if>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </form>
                            </div>
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