<%-- 
    Document   : updatecake
    Created on : Oct 8, 2020, 10:27:23 AM
    Author     : baoph
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
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
        <title>Update Cake Page</title>
    </head>
    <body class="goto-here">
    <c:if test="${sessionScope.ADMIN == null}">
        <c:if test="${empty sessionScope.ADMIN}">
            <c:redirect url="Home"/>
        </c:if>
    </c:if>
        <jsp:include page="header.jsp"/>
        <form onsubmit="return confirm('Bạn có chắc muốn cập nhập cái bánh này không?')" action="Update" enctype="multipart/form-data" method="POST">
            <c:forEach var="cake" items="${requestScope.LIST_ID}">
                <section class="ftco-section">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 mb-5 ftco-animate">
                                <a href="data:image/jpg;base64,${cake.getImgBase64()}" class="image-popup"><img src="data:image/jpg;base64,${cake.getImgBase64()}" class="img-fluid" alt="Colorlib Template"></a>
                            </div>
                            <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                                <h3><input style="border: 0" type="text" name="txtCakeName" value="${cake.getName()}" required="true"/></h3>

                                <div class="rating d-flex">
                                    <p class="text-left mr-4">
                                        <a href="#" class="mr-2">5.0</a>
                                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                                    </p>
                                    <p class="text-left mr-4">
                                        <a href="#" class="mr-2" style="color: #000;">100 <span style="color: #bbb;">Rating</span></a>
                                    </p>
                                    <p class="text-left">
                                        <a href="#" class="mr-2" style="color: #000;">500 <span style="color: #bbb;">Sold</span></a>
                                    </p>
                                </div>
                                <p class="price"><span><input style="border: 0" name="txtPrice" type="text" value="${cake.getPrice()}" required="true"/></span></p>
                                <p><input style="border: 0" type="text" name="txtDescription" value="${cake.getDescription()}" required="true"/></p>
                                <div class="row mt-4">
                                    <div class="col-md-6">
                                        <div class="form-group d-flex">
                                            <div class="select-wrap">
                                                <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                <select name="txtCategory" class="form-control">
                                                    <option class="hidden"  selected disabled required="true">Category</option>
                                                    <option>Thập cẩm</option>
                                                    <option>Đậu xanh</option>
                                                    <option>Khoai môn</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="input-group col-md-6 d-flex mb-3">
                                        <span class="input-group-btn mr-2">
                                            <button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
                                                <i class="ion-ios-remove"></i>
                                            </button>
                                        </span>
                                        <input type="text" id="quantity" name="txtQuantity" class="form-control input-number" value="${cake.getQuantity()}" min="1" max="100" required="true">
                                        <span class="input-group-btn ml-2">
                                            <button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
                                                <i class="ion-ios-add"></i>
                                            </button>
                                        </span>
                                        <!--<input type="number"/>-->
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="col-md-6">
                                        <div class="form-group d-flex">
                                            <div class="select-wrap">
                                                <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                <select name="txtStatus" class="form-control">
                                                    <option class="hidden"  selected disabled required="true">Status</option>
                                                    <option>True</option>
                                                    <option>False</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="col-md-12">
                                        Create Date: <input type="date" name="txtCreateDate" value="${cake.getFormatCreateDate()}" required="true"/><br>
                                        Expired Date: <input type="date" name="txtExDate" value="${cake.getFormatExpirationDate()}" required="true"/>
                                    </div>
                                    <div class="w-100"></div>
                                    <input style="margin: 15px" type="file" name="photo" required="true"/>
                                </div>
                                    <p><input type="submit" class="btn btn-black py-3 px-5" value="Update"/></p>
                                
                                <input type="hidden" name="txtID" value="${cake.getId()}"/>
                                <p><a onclick="return confirm('Bạn có chắc muốn xóa cái bánh này không?')" href="Delete?txtID=${cake.getId()}" class="btn btn-black2 py-3 px-5">Delete</a></p>
                            </div>
                        </div>
                    </div>
                </section>
            </c:forEach>
        </form>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center mb-3 pb-3">
                    <div class="col-md-12 heading-section text-center ftco-animate">
                        <span class="subheading">Cakes</span>
                        <h2 class="mb-4">Related Cakes</h2>
                        <!--<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>-->
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <c:forEach var="cakeCate" items="${requestScope.LIST_CATEGORY}">
                        <div class="col-md-6 col-lg-3 ftco-animate">
                            <div class="product">
                                <a href="#" class="img-prod"><img class="img-fluid" src="data:image/jpg;base64,${cakeCate.getImgBase64()}" alt="Colorlib Template">
                                    <div class="overlay"></div>
                                </a>
                                <div class="text py-3 pb-4 px-3 text-center">
                                    <h3 style="font-weight: bold"><a href="">${cakeCate.getName()}</a></h3>
                                    <p style="font-style: italic">${cakeCate.getDescription()}</p>
                                    <p style="color: #589be4">Loại: ${cakeCate.getCategory()}</p>
                                    <p style="color: #f55353">${cakeCate.getCreateDate()} đến ${cakeCate.getExpirationDate()}</p>
                                    <div class="d-flex">
                                        <div class="pricing">
                                            <p class="price"><span>${cakeCate.getPrice()} VND</span></p>

                                        </div>
                                    </div>
                                    <!--<form action="Detail" method="POST">-->
                                    <div class="bottom-area d-flex px-3">
                                        <div class="m-auto d-flex">

                                            <!--<input type="hidden" name="txtID" value=""/>-->
                                            <!--<input type="hidden" name="txtCategory" value=""/>-->
                                            <a href="Detail?txtID=${cakeCate.getId()}&txtCategory=${cakeCate.getCategory()}" class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                                <span><i class="ion-ios-menu"></i></span>
                                            </a>
                                            <a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
                                                <span><i class="ion-ios-cart"></i></span>
                                            </a>
                                            <a href="#" class="heart d-flex justify-content-center align-items-center ">
                                                <span><i class="ion-ios-heart"></i></span>
                                            </a>
                                        </div>
                                    </div>
                                    <!--</form>-->
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </section>



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>



        <script>
            $(document).ready(function () {

                var quantitiy = 0;
                $('.quantity-right-plus').click(function (e) {

                    // Stop acting like a button
                    e.preventDefault();
                    // Get the field name
                    var quantity = parseInt($('#quantity').val());

                    // If is not undefined

                    $('#quantity').val(quantity + 1);


                    // Increment

                });

                $('.quantity-left-minus').click(function (e) {
                    // Stop acting like a button
                    e.preventDefault();
                    // Get the field name
                    var quantity = parseInt($('#quantity').val());

                    // If is not undefined

                    // Increment
                    if (quantity > 0) {
                        $('#quantity').val(quantity - 1);
                    }
                });

            });
        </script>
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
