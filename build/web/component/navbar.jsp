<%-- 
    Document   : navbar
    Created on : May 17, 2023, 9:07:07 AM
    Author     : msi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.*"%>
<%@page import="dal.*"%>
<%@page import="java.util.List"%>
<%
    User account = (User) session.getAttribute("account");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function searchTextChanged() {
                var searchText = document.getElementById("title").value;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("searchSuggestions").innerHTML = this.responseText;
                        document.getElementById("searchSuggestions").style.display = "block";
                    }
                };
                xhttp.open("POST", "search", true);
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhttp.send("searchText=" + searchText);
            }

            function selectCourse(URL) {
                window.location.href = "course/" + URL;
            }

            function handleKeyPress(event) {
                if (event.keyCode === 13) {
                    event.preventDefault();
                    var searchText = document.getElementById("title").value;
                    var currentPath = window.location.pathname;
                    var redirectURL = "";
                    var currentURL = window.location.href;

                    if (currentPath.includes("/")) {
                        var regex = /http:\/\/localhost:9999\/SWP391\/.*/; // Matches "/course/" followed by any non-slash characters at the end
                        var redirectURL = currentURL.replace(regex, "http://localhost:9999/SWP391") + "/coursePart?searchText=" + searchText;
                    } else {
                        redirectURL = "coursePart?searchText=" + searchText;
                    }

                    window.location.href = redirectURL;
                }
            }

        </script>



        <style>
            .search-suggestions {
                position: absolute;
                width: 30%;
                background-color: #f9f9f9;
                border: 1px solid #ddd;
                max-height: 150px;
                overflow-y: auto;
                z-index: 1;
                display: none;
                padding: 0;
                margin-top: 5px;
                border-top: none;
            }

            .search-suggestion {
                padding: 8px 12px;
                cursor: pointer;
                font-size: 14px;
                color: #333;
            }

            .search-suggestion:hover {
                background-color: #e9e9e9;
            }
        </style>


    </style>
</head>
<body>
    <header id="header" class="fixed-top">
        <div class="container d-flex align-items-center">

            <h1 class="logo me-auto"><a href="${pageContext.request.contextPath}/home">FCourse</a></h1>
            <div style="width: 25%">
                <form action="search" method="POST">
                    <input type="search" name="searchText" class="form-control" id="title" placeholder="Search" required oninput="searchTextChanged()" onkeypress="handleKeyPress(event)">
                    <div id="searchSuggestions" class="search-suggestions"></div>
                </form>
            </div>

            <nav id="navbar" class="navbar order-last order-lg-0">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/about.jsp">About</a></li> <!-- about.jsp -->
                    <li><a href="${pageContext.request.contextPath}/course">Courses</a></li> <!-- courses.jsp -->
                    <li class="dropdown"><a href="#" onclick="return false;">Flash Card</a>
                        <c:if test="${account == null}"> 
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/FlashCard/Cards">Flash Card</a></li>
                            </ul>
                        </c:if>
                        <c:if test="${account != null}"> 
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/AddFlashcards">Add Flash Card</a></li>
                                <li><a href="${pageContext.request.contextPath}/FlashCard/Cards">Flash Card</a></li>
                            </ul>
                        </c:if>

                    <li><a href="${pageContext.request.contextPath}/mentorList">Mentors</a></li><!-- mentors.jsp -->
                    <li><a href="${pageContext.request.contextPath}/newsPage">Promotions</a></li><!-- promotion.jsp -->
                    <li><a href="${pageContext.request.contextPath}/contact.jsp">Contact</a></li>
                </ul>
                <i class="bi bi-list mobile-nav-toggle"></i>
            </nav><!-- .navbar -->
            <c:if test="${account == null}">
                <a href="${pageContext.request.contextPath}/login" class="get-started-btn">Login</a>
            </c:if>
            <c:if test="${account != null}">
                
                <nav id="navbar" class="navbar order-last order-lg-0">
                    <ul>
                        <li class="dropdown"><span class="get-started-btn"><div class="">${account.getFull_name()}</div></span> 
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>

                                <li><a href="${pageContext.request.contextPath}/signout">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav><!-- .navbar -->
            </c:if>


        </div>
    </header><!-- End Header -->

</body>
</html>
