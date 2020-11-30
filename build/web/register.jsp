<%-- 
    Document   : register
    Created on : Oct 5, 2020, 2:35:34 PM
    Author     : baoph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="design/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="design/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="design/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="design/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="design/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="design/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="design/css/util.css">
        <link rel="stylesheet" type="text/css" href="design/css/main.css">
        <!--===============================================================================================-->
        <title>Register Page</title>
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="register-pic js-tilt" data-tilt>
                        <img src="design/images/img-01.png" alt="IMG">
                    </div>

                    <form action="Register" method="POST" class="login100-form">
                        <span class="login100-form-title">
                            Register
                        </span>

                        <!--<form action="MainController" method="POST">-->
                        <div class="wrap-input100">
                            <input class="input100" type="text" name="txtEmail" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Email format(abc@gmail.com)">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="error-input">
                            ${requestScope.ERROR_USER.getErrorEmail()}
                        </div>

                        <div class="wrap-input100">
                            <input class="input100" type="text" name="txtName" placeholder="Name">

                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-address-card" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="error-input">
                            ${requestScope.ERROR_USER.getErrorName()}
                        </div>

                        <div class="wrap-input100">
                            <input class="input100" type="password" name="txtPassword" placeholder="Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                        </div>

                        <div class="wrap-input100">
                            <input class="input100" type="password" name="txtRePassword" placeholder="RePassword">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="error-input">
                            ${requestScope.ERROR_USER.getErrorPassword()}
                        </div>
                        <div class="container-register-form-btn">
                            <input class="register-form-btn" type="submit" name="btnAction" value="Register"/>
                        </div>
                        <div class="container-register-form-btn">
                            <input class="reset-form-btn" type="reset" value="Reset"/>
                        </div>
                        <!--<input type="reset" value="Reset"/><br>-->
                        <div class="text-center p-t-136">
                            <a class="txt2" href="login.html">
                                Already have an account? LOGIN
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a>
                        </div>
                    </form>
                    <!--</form>-->
                </div>
            </div>
        </div>
        <!--===============================================================================================-->	
        <script src="design/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="design/vendor/bootstrap/js/popper.js"></script>
        <script src="design/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="design/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="design/vendor/tilt/tilt.jquery.min.js"></script>
        <script >
            $('.js-tilt').tilt({
                scale: 1.1
            })
        </script>
        <!--===============================================================================================-->
        <script src="design/js/main.js"></script>
    </body>
</html>
