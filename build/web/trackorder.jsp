<%-- 
    Document   : trackorder
    Created on : Oct 12, 2020, 7:38:52 PM
    Author     : baoph
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Track Order Page</title>
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
    <link rel="stylesheet" href="design/css/trackorder.css">
</head>
<body>
<c:if test="${sessionScope.MEMBER == null}">
    <c:if test="${empty sessionScope.MEMBER}">
        <c:redirect url="Home"/>
    </c:if>
</c:if>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-10 mb-5 text-center">
            <ul>
                <form action="Order" method="POST" class="form-inline md-form mr-auto mb-4">
                    <input class="form-control mr-sm-2" type="text" name="txtOrderID" placeholder="Search"
                           aria-label="Search" value="${param.txtOrderID}"/>
                    <button class="btn aqua-gradient btn-rounded btn-sm my-0" type="submit">Search</button>
                </form>
            </ul>
            <h3>Your order ID: </h3>
            <ul class="list-inline">
                <c:forEach var="orderID" items="${requestScope.ID_ORDER}">
                    <li class="list-inline-item">${orderID.getOrderID()}</li>
                </c:forEach>
            </ul>
        </div>
    </div>


    <c:if test="${requestScope.DETAIL_ORDER != null}">
        <c:if test="${not empty requestScope.DETAIL_ORDER}">

            <article class="card">
                <header class="card-header"> My Orders / Tracking</header>
                <div class="card-body">
                    <c:forEach var="orderdetail" items="${requestScope.DETAIL_ORDER}">
                        <h6>Order ID: ${orderdetail.getOrderID()}</h6>
                        <article class="card">
                            <div class="card-body row">
                                <div class="col"><strong>OrderID:</strong> <br> ${orderdetail.getOrderID()} | <i
                                        class="fa fa-phone"></i> ${sessionScope.MEMBER.name}
                                </div>
                                <div class="col"><strong>OrderDate:</strong> <br>${orderdetail.getOrderDate()}</div>
                                <div class="col"><strong>Payment Status:</strong> <br> ${orderdetail.isPaymentStatus()}
                                </div>
                                <div class="col"><strong>Payment method:</strong> <br> ${orderdetail.getPaymentMethod()}
                                </div>
                                <div class="col"><strong>Address</strong> <br> ${orderdetail.getAddress()}</div>
                            </div>
                        </article>
                    </c:forEach>
                    <div class="track">
                        <div class="step active"><span class="icon"> <i class="fa fa-check"></i> </span> <span
                                class="text">Order confirmed</span></div>
                        <div class="step"><span class="icon"> <i class="fa fa-user"></i> </span> <span
                                class="text"> Picked by courier</span></div>
                        <div class="step"><span class="icon"> <i class="fa fa-truck"></i> </span> <span
                                class="text"> On the way </span></div>
                        <div class="step"><span class="icon"> <i class="fa fa-box"></i> </span> <span class="text">Ready for pickup</span>
                        </div>
                    </div>

                    <hr>
                    <ul class="row">
                        <c:forEach var="cake" items="${requestScope.DETAIL_CAKE}">
                            <li class="col-md-4">
                                <figure class="itemside mb-3">
                                    <div class="aside"><img src="data:image/jpg;base64,${cake.getImgBase64()}"
                                                            class="img-sm border"></div>
                                    <figcaption class="info align-self-center">
                                        <p class="title">${cake.getName()}</p>
                                        <span
                                                class="text-muted">${cake.getPrice()}
                                        </span>
                                    </figcaption>
                                </figure>
                            </li>
                        </c:forEach>
                    </ul>
                    <hr>
                    <a href="Home" class="btn btn-warning" data-abc="true"> <i class="fa fa-chevron-left"></i> Back to
                        homepage</a>
                </div>
            </article>
        </c:if>
    </c:if>
</div>
</body>
</html>
