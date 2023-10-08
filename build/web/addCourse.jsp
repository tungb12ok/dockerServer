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
                    <h1 class="mt-4">Add Course</h1>
                    <form action="addCourse" method="POST" role="form" class="php-email-form" enctype="multipart/form-data">
                        <div class="form-group mt-3">
                            <h6>Course name</h6>
                            <input type="text" name="name" class="form-control"  placeholder="Course Name" required>
                        </div>
                        <div class="form-group mt-3">
                            <h6>Description</h6>
                            <textarea class="form-control" id="description" name="description" rows="5" placeholder="Description" required></textarea>
                        </div>
                        <div class="form-group mt-3">
                            <h6>Choose Type</h6>
                            <select name="typeID" class="form-control" required>
                                <option>Select type</option>
                                <c:forEach var="list" items="${requestScope.listType}">
                                    <option value="${list.getTypeID()}">${list.getType_name()}</option>
                                </c:forEach>
                            </select>
                            <div class="form-group mt-3">
                                <h6>Price</h6>
                                <input type="number" name="price" class="form-control" step="10000"  placeholder="Price" min="10000" max="5000000" required>
                            </div>
                            <div class="form-group mt-3">
                                <h6>Image</h6>
                                <input type="file" class="form-control" id="image" name="image" accept="image/png, image/gif, image/jpeg" required />                       
                            </div>
                            <div class="form-group mt-3" id="module">
                                <h6>Module</h6>
                                <div class="row">
                                    <div class="col-3">
                                        <input type="text" name="module1" class="form-control" placeholder="Module 1" required>
                                    </div>
                                    <div class="col-9">
                                        <input type="text" name="link1" class="form-control" placeholder="Link 1" oninput="checkLinkValidity(this)" required>
                                    </div>
                                    <div id="error-message" style="color: red;"></div>

                                    <script>
                                        function checkLinkValidity(input) {
                                            var linkValue = input.value;

                                            if (linkValue.startsWith('https://www.youtube.com/watch?v=')) {
                                                // Định dạng hợp lệ
                                                input.setCustomValidity(''); // Xóa thông báo lỗi (nếu có)
                                            } else {
                                                // Định dạng không hợp lệ
                                                input.setCustomValidity('Định dạng link không hợp lệ (https://www.youtube.com/watch?v=)');
                                            }
                                        }
                                    </script>

                                </div>
                            </div>
                            <a onclick="addInput()">More modules</a>
                        </div>
                        <div style="color:#5fcf80"><strong>${messSuccess}</strong></div>   

                        <div class="text-center form-group mt-3"><input type="submit" value="Add course" class="button-37" /></div>
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
    <script>
                                CKEDITOR.replace('description');
    </script>
    <script>
        var counter = 2;

        function addInput() {
            var container = document.getElementById("module");

            var rowHtml = '<div class="row">' +
                    '<div class="col-3">' +
                    '<input type="text" name="module' + counter + '" class="form-control" placeholder="Module ' + counter + '" required>' +
                    '</div>' +
                    '<div class="col-9">' +
                    '<input type="text" name="link' + counter + '" class="form-control" placeholder="Link ' + counter + '" oninput="checkLinkValidity(this)" required>' +
                    '</div>' +
                    '</div>';
            container.insertAdjacentHTML('beforeend', rowHtml);
            counter++;
        }
    </script>
</body>
</html>
