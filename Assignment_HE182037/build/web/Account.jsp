
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Account setting</title>
        <link rel="stylesheet" href="style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container light-style flex-grow-1 container-p-y">
            <h4 class="font-weight-bold py-3 mb-4">
                Account settings
            </h4>
            <div class="card overflow-hidden">
                <div class="row no-gutters row-bordered row-border-light">
                    <div class="col-md-3 pt-0">
                        <div class="list-group list-group-flush account-settings-links">
                            <a class="list-group-item list-group-item-action active" data-toggle="list"
                               href="#account-general">General</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list"
                               href="#account-change-password">Change password</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list"
                               href="#account-order-history">Order History</a>
                            <a class="list-group-item list-group-item-action" 
                               href="home">Home</a>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="tab-content">
                            <div class="tab-pane fade active show" id="account-general">
                                <form action="editprofile" method="get">
                                    <hr class="border-light m-0">
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label class="form-label">Username</label>
                                            <input type="text" class="form-control mb-1" value="${sessionScope.user.userName}" name="username">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">First Name</label>
                                            <input type="text" class="form-control" value="${sessionScope.user.firstN}" name="fname">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Last Name</label>
                                            <input type="text" class="form-control" value="${sessionScope.user.lastN}" name="lname">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">E-mail</label>
                                            <input type="text" class="form-control mb-1" value="${sessionScope.user.email}" name="email">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Address</label>
                                            <input type="text" class="form-control mb-1" value="${sessionScope.user.address}" name="address">
                                        </div>
                                    </div>
                                    <div class="text-right mt-3" style="padding-bottom: 10px">
                                        <button type="submit" class="btn btn-primary">Save changes</button>&nbsp;
                                        <button type="reset" class="btn btn-default">Cancel</button>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="account-change-password">
                                <form action="editprofile" method="post">
                                    <div class="card-body pb-2">
                                        <div class="form-group">
                                            <label class="form-label">Current password</label>
                                            <input type="password" class="form-control" name="curpassword">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">New password</label>
                                            <input type="password" class="form-control" name="npassword">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Repeat new password</label>
                                            <input type="password" class="form-control" name="rnpassword">
                                        </div>
                                    </div>
                                    <p style="color: red">
                                        <%
                                        if(request.getAttribute("err")!=null){
                                        String err = (String) request.getAttribute("err");
                                        out.println(err);
                                        }
                                        %>
                                    </p>
                                    <p style="color: greenyellow">
                                        <%
                                        if(request.getAttribute("mess")!=null){
                                        String mess = (String) request.getAttribute("mess");
                                        out.println(mess);
                                            }
                                        %>
                                    </p>
                                    <div class="text-right mt-3" style="padding-bottom: 10px">
                                        <button type="submit" class="btn btn-primary">Save changes</button>&nbsp;
                                        <button type="reset" class="btn btn-default">Cancel</button>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="account-order-history">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">Order ID</th>
                                            <th scope="col">Date</th>
                                            <th scope="col">Select</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="o" items="${requestScope.orderl}">
                                            <tr>
                                                <td>${o.oid}</td>
                                                <td>${o.date}</td>
                                                <td><a data-toggle="list" href="#order-detail" onclick="doSelect('${o.oid}')" >Select</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">
            function doSelect(oid) {
                window.location = "orderdetail?orderid=" + oid;
            }
        </script>
    </body>

</html>