<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : createcake
    Created on : Oct 6, 2020, 2:54:45 PM
    Author     : baoph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="design/css/createcake.css">
        <title>Create Cake Page</title>
    </head>
    <body>
    <c:if test="${sessionScope.ADMIN == null}">
        <c:if test="${empty sessionScope.ADMIN}">
            <c:redirect url="Home"/>
        </c:if>
    </c:if>
        <jsp:include page="header.jsp"/>
        <form action="CreateCake" enctype="multipart/form-data" method="POST">
            <div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="design/images/product-1.jpg" alt="" />
                        <h3>Welcome</h3>
                    </div>
                    <div class="col-md-9 register-right">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Create a new cake</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" name="txtName"  class="form-control" placeholder="Name *" required="true" maxlength="50" title="Enter name here" />
                                        </div>
                                        <div class="form-group">
                                            <input type="textarea" name="txtDescription"  class="form-control" placeholder="Description *" required="true" maxlength="1000" title="Enter name here" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="txtPrice" class="form-control" placeholder="Price *" maxlength="6" required="true" title="Enter price here"  />
                                        </div>
                                        <div class="form-group">
                                            <input type="number" name="txtQuantity" class="form-control" placeholder="Quantity *" maxlength="6" required="true" title="Enter quantity here"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="date" name="txtCreateDate" class="form-control" required="true" title="Enter create date here" />
                                        </div>
                                        <div class="form-group">
                                            <input type="date" name="txtExpirationDate" class="form-control" title="Enter expiration date here" />
                                        </div>
                                        <div class="form-group">
                                            <select name="txtCategory" class="form-control">
                                                <option class="hidden"  selected disabled>Category</option>
                                                <option>Thập cẩm</option>
                                                <option>Đậu xanh</option>
                                                <option>Khoai môn</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="file" name="photo" class="form-control" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input type="submit" class="btnCreate" value="Create" />
                </div>
            </div>
        </form>
    </body>
</html>
