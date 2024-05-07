<%-- 
    Document   : login
    Created on : Mar 4, 2024, 5:03:47 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="css/login.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid ps-md-0">
            <div class="row g-0">
                <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
                <div class="col-md-8 col-lg-6">
                    <div class="login d-flex align-items-center py-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-9 col-lg-8 mx-auto">
                                    <h3 class="login-heading mb-4">Welcome back!</h3>

                                    <!-- Sign In Form -->
                                    <form action="signin" method="post">
                                        <c:set var="cookie" value="${pageContext.request.cookies}"/>
                                        <div class="form-floating mb-3">
                                            <input required type="text" class="form-control" id="floatingInput" placeholder="User Name" name="username" value="${cookie.cuser.value}">
                                            <label for="floatingInput">User Name</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input required type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pass" value="${cookie.cpass.value}">
                                            <label for="floatingPassword">Password</label>
                                        </div>

                                        <div class="form-check mb-3">
                                            <input class="form-check-input" type="checkbox" ${(cookie.crem!=null?'checked':'')} value="ON" name="rem" id="rememberPasswordCheck">
                                            <label class="form-check-label">
                                                Remember password
                                            </label>
                                        </div>
                                        <span>${requestScope.err}</span>
                                        <div class="d-grid">
                                            <button class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2" type="submit">Sign in</button>
                                            <div class="text-center">
                                                Don't have an account?
                                                <a class="small" href="SignUp.jsp">Sign Up</a>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
