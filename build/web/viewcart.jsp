<%-- 
    Document   : viewcart1
    Created on : Oct 11, 2020, 8:30:23 PM
    Author     : baoph
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Cart Page</title>
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
<c:if test="${sessionScope.MEMBER == null}">
    <c:if test="${empty sessionScope.MEMBER}">
        <c:redirect url="Home"/>
    </c:if>
</c:if>
<jsp:include page="header.jsp"/>
<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                            <th>Cake name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="cart" value="${sessionScope.CART}"/>
                        <c:if test="${not empty cart}">
                            <c:forEach var="cake" items="${cart.getCart().values()}">
                                <tr class="text-center">
                                    <td class="product-remove"><a
                                            onclick="return confirm('Are you sure to delete this cake?')"
                                            href="DeleteCart?txtID=${cake.getId()}"><span class="ion-ios-close"></span></a>
                                    </td>

                                    <td class="image-prod">
                                        <div class="img"
                                             style="background-image:url(data:image/jpg;base64,${cake.getImgBase64()});"></div>
                                    </td>

                                    <td class="product-name">
                                        <h3>${cake.getName()}</h3>
                                        <p>${cake.getDescription()}</p>
                                    </td>

                                    <td class="price">${cake.getPrice()}</td>
                                    <form action="UpdateCart" method="POST">
                                        <td class="quantity">
                                            <div class="input-group mb-3">
                                                <input type="number" name="txtCartQuantity"
                                                       class="quantity form-control input-number"
                                                       value="${cake.getCartQuantity()}" min="1" max="100">
                                            </div>
                                        </td>

                                        <td class="total">${cake.getTotalCost()}</td>
                                        <td>

                                            <input type="hidden" name="txtID" value="${cake.getId()}"/>
                                            <p><input type="submit" class="btn btn-black py-3 px-5" value="Update"/></p>

                                        </td>
                                    </form>
                                </tr>
                                <!-- END TR-->

                            </c:forEach>
                        </c:if>
                        <c:if test="${empty cart}">
                            <h1>There is nothing in cart</h1>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <form action="CheckOut" method="POST">
            <div class="row justify-content-end">
                <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                    <div class="cart-detail p-3 p-md-4">
                        <h3 class="billing-heading mb-4">Payment Method</h3>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="radio">
                                    <label><input type="radio" value="Direct Bank Tranfer" name="optradio" class="mr-2"
                                                  required="true"> Direct Bank Tranfer</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="radio">
                                    <label><input type="radio" value="COD" name="optradio" class="mr-2" required="true"
                                                  checked>COD</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 mt-5 cart-wrap ftco-animate">

                    <div class="cart-total mb-3">
                        <h3>Estimate shipping and tax</h3>
                        <p>Enter your shipping information</p>
                        <form action="#" class="info">
                            <c:if test="${sessionScope.MEMBER == null}">
                                <c:if test="${empty sessionScope.MEMBER}">
                                    <div class="form-group">
                                        <label for="">Phone number</label>
                                        <input type="text" name="txtPhoneNumber" class="form-control text-left px-3"
                                               required="true">
                                    </div>
                                    <div class="form-group">
                                        <label for="country">Name</label>
                                        <input type="text" name="txtName" class="form-control text-left px-3"
                                               required="true">
                                    </div>
                                </c:if>
                            </c:if>
                            <div class="form-group">
                                <label for="country">Address</label>
                                <input type="text" name="txtAddress" class="form-control text-left px-3"
                                       required="true">
                            </div>
                        </form>
                    </div>

                </div>

                <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                    <div class="cart-total mb-3">
                        <h3>Cart Totals</h3>
                        <p class="d-flex">
                            <span>Subtotal</span>
                            <span id="total"><c:out value="${sessionScope.TOTAL}"/></span>
                        </p>
                        <p class="d-flex">
                            <span>Delivery</span>
                            <span>$0.00</span>
                        </p>
                        <p class="d-flex">
                            <span>Discount</span>
                            <span>$0.00</span>
                        </p>
                        <hr>
                        <p class="d-flex total-price">
                            <span>Total</span>
                            <span><c:out value="${sessionScope.TOTAL}"/></span>
                        </p>
                    </div>
                    <p>
                        <button class="btn btn-primary py-3 px-4">Place An Order</button>
                    </p>
                    <div id="paypal-button"></div>
                </div>
            </div>
            <c:forEach var="cakehidden" items="${cart.getCart().values()}">
                <input type="hidden" name="txtcakeID" value="${cakehidden.getId()}"/>
                <input type="hidden" name="txtTrueQuantity" value="${cakehidden.getCartQuantity()}"/>
            </c:forEach>
        </form>
    </div>
</section>
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
<script
        src="https://www.paypal.com/sdk/js?client-id=Ach5dF-actCrzrWTSRmZo4ZkZonlxCJtiqST0Grw303jqo4f0gcXxOLYfR85SMTovk8dMa3dW-087W-0"> // Required. Replace SB_CLIENT_ID with your sandbox client ID.
</script>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>
<script>
    paypal.Button.render({
        // Configure environment
        env: 'sandbox',
        client: {
            sandbox: 'demo_sandbox_client_id',
            production: 'demo_production_client_id'
        },
        // Customize button (optional)
        locale: 'en_US',
        style: {
            size: 'small',
            color: 'gold',
            shape: 'pill'
        },

        // Enable Pay Now checkout flow (optional)
        commit: true,

        // Set up a payment
        payment: function (data, actions) {
            return actions.payment.create({
                transactions: [{
                    amount: {
                        total: document.getElementById("total"),
                        currency: 'USD'
                    }
                }]
            });
        },
        // Execute the payment
        onAuthorize: function (data, actions) {
            return actions.payment.execute().then(function () {
                // Show a confirmation message to the buyer
                window.alert('Thank you for your purchase!');
            });
        }
    }, '#paypal-button');

</script>
</body>
</html>
