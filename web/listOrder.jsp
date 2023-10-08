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
                    <h1 class="mt-4">Order List</h1>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            Orders
                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>Customer</th>
                                        <th>Course</th>     
                                        <th>Date</th>     
                                        <th>Payment</th>     
                                        <th>Total</th>     
                                        <th>Code</th>     
                                        <th>Status</th>  
                                        <th>Action</th>  
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>                                     
                                        <th>Customer</th>
                                        <th>Course</th>     
                                        <th>Date</th>     
                                        <th>Payment</th>     
                                        <th>Total</th>     
                                        <th>Code</th>     
                                        <th>Status</th>     
                                        <th>Action</th>    
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach var="order" items="${list}">
                                        <tr>
                                            <td>${uDAO.getUserByCustomerID(order.getCustomerID()).getFull_name()}</td>
                                            <td>${cDAO.getCourseByID(order.getCourseID()).getCourse_name()}</td>
                                            <td>${order.getDate()}</td>
                                            <td>${order.getPaymentMethod()}</td>
                                            <td>${order.getTotalMoney()}</td>
                                            <td>${order.getOrderCode()}</td>
                                            <td>
                                                <c:if test="${order.statusOrder == 0}">
                                                    <p class="text-danger">Processing...</p>
                                                </c:if>
                                                <c:if test="${order.statusOrder == 1}">
                                                    <p class="text-success">Paid</p>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${order.statusOrder == 0}">
                                                    <a href="pOrder?id=${order.ID}&cID=${order.courseID}&total=${order.totalMoney}" class="text-warning">Accept</a>
                                                </c:if>
                                                <c:if test="${order.statusOrder == 1}">

                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
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
