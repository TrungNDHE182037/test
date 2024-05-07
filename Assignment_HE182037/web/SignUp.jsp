<%-- 
    Document   : SignUp
    Created on : Mar 4, 2024, 5:07:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                    <h3 class="login-heading mb-4">Sign Up</h3>

                                    <!-- Sign Up Form -->
                                    <form action="signup" method="post">
                                        <div class="form-floating mb-3">
                                            <input required type="text" class="form-control" id="floatingInput" placeholder="User Name" name="username" value="">
                                            <label for="floatingInput">User Name</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input required type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pass" value="">
                                            <label for="floatingPassword">Password</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input required type="password" class="form-control" id="floatingPassword" placeholder="Repeat Password" name="repass" value="">
                                            <label for="floatingPassword">Repeat Password</label>
                                        </div>
                                        <p style="color: red">
                                        <%
                                        if(request.getAttribute("err")!=null){
                                        String err = (String) request.getAttribute("err");
                                        out.println(err);
                                        }
                                        %>
                                        </p>
                                        <div class="d-grid">
                                            <button class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2" type="submit">Sign Up</button>
                                        </div>
                                        <div class="form-check mb-3">
                                            <input class="form-check-input" type="checkbox" value="ON" name="rem" id="rememberPasswordCheck">
                                            <label class="form-check-label">
                                                Remember password
                                            </label>

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
