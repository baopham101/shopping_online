<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : updatelog
    Created on : Oct 14, 2020, 6:03:43 PM
    Author     : baoph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Log Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="design/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="design/css/animate.css">

    <link rel="stylesheet" href="design/css/owl.carousel.min.css">
    <link rel="stylesheet" href="design/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="design/css/magnific-popup.css">

    <link rel="stylesheet" href="design/css/aos.css">

    <link rel="stylesheet" href="design/css/ionicons.min.css">

    <link rel="stylesheet" href="design/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="design/css/jquery.timepicker.css">


    <link rel="stylesheet" href="design/css/flaticon.css">
    <link rel="stylesheet" href="design/css/icomoon.css">
    <link rel="stylesheet" href="design/css/style.css">
    <link rel="stylesheet" href="design/css/search.css">
</head>
<body>
<c:if test="${sessionScope.ADMIN == null}">
    <c:if test="${empty sessionScope.ADMIN}">
        <c:redirect url="Home"/>
    </c:if>
</c:if>
<jsp:include page="header.jsp"/>
<div style="margin-top: 50px" class="container">
    <div class="row justify-content-center">
        <div class="col-md-10 mb-5 text-center">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Log ID</th>
                    <th scope="col">User</th>
                    <th scope="col">Action</th>
                    <th scope="col">Date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="log" items="${requestScope.LOG}">
                <tr>
                    <td>${log.getLogID()}</td>
                    <td>${log.getEmail()}</td>
                    <td>${log.getAction()}</td>
                    <td>${log.getLogDate()}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>

<script src="design/js/jquery.min.js"></script>
<script src="design/js/jquery-migrate-3.0.1.min.js"></script>
<script src="design/js/popper.min.js"></script>
<script src="design/js/bootstrap.min.js"></script>
<script src="design/js/jquery.easing.1.3.js"></script>
<script src="design/js/jquery.waypoints.min.js"></script>
<script src="design/js/jquery.stellar.min.js"></script>
<script src="design/js/owl.carousel.min.js"></script>
<script src="design/js/jquery.magnific-popup.min.js"></script>
<script src="design/js/aos.js"></script>
<script src="design/js/jquery.animateNumber.min.js"></script>
<script src="design/js/bootstrap-datepicker.js"></script>
<script src="design/js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="design/js/google-map.js"></script>
<script src="design/js/main.js"></script>
</body>
</html>
