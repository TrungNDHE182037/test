
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Website: wwww.codingdung.com-->
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <title>Manage</title>
        <link rel="stylesheet" href="style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container light-style flex-grow-1 container-p-y">
            <h4 class="font-weight-bold py-3 mb-4">
                Library Managing
            </h4>
            <div class="card overflow-hidden">
                <div class="row no-gutters row-bordered row-border-light">
                    <div class="col-md-3 pt-0">
                        <div class="list-group list-group-flush account-settings-links">
                            <a class="list-group-item list-group-item-action active" data-toggle="list"
                               href="#book-list">Book List</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list"
                               href="#add-book">Add Book</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list"
                               href="#user-list">User List</a>
                            <a class="list-group-item list-group-item-action" 
                               href="home">Home</a>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="tab-content">
                            <div class="tab-pane fade active show" id="book-list">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">Img</th>
                                            <th scope="col">Title</th>
                                            <th scope="col">Author</th>
                                            <th scope="col">Stock</th>
                                            <th scope="col">Category</th>
                                            <th scope="col">Price</th>
                                            <th colspan="2">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="b" items="${requestScope.data}">
                                            <tr>  
                                                <td><div class="frontcover"><img src="${b.img}" alt="image description" width="80px"></div></td>
                                                <td>${b.title}</td>
                                                <td>${b.author}</td>
                                                <td>${b.quantity}</td>
                                                <td>${b.category}</td>
                                                <td>$${b.price}</td>
                                                <td><a data-toggle="list" href="#edit-book" onclick="doEdit('${b.title}')" >Edit</a></td>
                                                <td><a href="#" onclick="doDelete('${b.title}')">Delete</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane fade" id="add-book">
                                <form action="add" method="get">
                                    <label class="form-label">Title</label>
                                    <input type="text" class="form-control mb-1" name="title">
                                    <label class="form-label">Author</label>
                                    <input type="text" class="form-control mb-1" name="author">
                                    <label class="form-label">Isbn13</label>
                                    <input type="text" class="form-control mb-1" name="isbn">
                                    <label class="form-label">Language</label>
                                    <input type="text" class="form-control mb-1" name="lang">
                                    <label class="form-label">Number of pages</label>
                                    <input type="text" class="form-control mb-1" name="pagenum">
                                    <label class="form-label">Publisher</label>
                                    <input type="text" class="form-control mb-1" name="pubname">
                                    <label class="form-label">Publication date</label>
                                    <input type="text" class="form-control mb-1" name="pubdate">
                                    <label class="form-label">Stock</label>
                                    <input type="text" class="form-control mb-1" name="quantity">
                                    <label class="form-label">Category</label>
                                    <select class="custom-select" name="category">
                                        <option value="lightnovel" selected>lightnovel </option>
                                        <option value="fantasy" >fantasy </option>
                                        <option value="horror" >horror </option>
                                        <option value="fiction" >fiction </option>
                                        <option value="detective" >detective </option>
                                        <option value="literary" >literary </option>
                                        <option value="romance" >romance </option>
                                    </select>
                                    <label class="form-label">Price</label>
                                    <input type="text" class="form-control mb-1" name="price">
                                    <label class="form-label">Img URL</label>
                                    <input type="text" class="form-control mb-1" name="img">
                                    <label class="form-label">Description</label>
                                     <input type="text" class="form-control mb-1" name="des">
                                    <div class="text-right mt-3">
                                        <button type="submit" class="btn btn-primary">ADD</button>&nbsp;
                                        <button type="reset" >Reset</button>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="user-list">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">First Name</th>
                                            <th scope="col">Last Name</th>
                                            <th scope="col">User Name</th>
                                            <th scope="col">Password</th>
                                            <th scope="col">Role</th>

                                            <th scope="col">Address</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="u" items="${requestScope.data2}">
                                            <tr>  
                                                <td>${u.firstN}</td>
                                                <td>${u.lastN}</td>
                                                <td>${u.userName}</td>
                                                <td>${u.pass}</td>
                                                <td>${u.role}</td>
                                                <td>${u.address}</td>
                                                <td><a href="delete?username=${u.userName}">Delete</a></td>
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
            function doEdit(title) {
                window.location = "editbook?action=edit&title=" + title;
            }
            function doDelete(title) {
                window.location = "editbook?action=delete&title=" + title;
            }
        </script>
    </body>

</html>