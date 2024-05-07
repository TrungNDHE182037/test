

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <title>Edit Book</title>
        <link rel="stylesheet" href="style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container light-style flex-grow-1 container-p-y">
            <h4 class="font-weight-bold py-3 mb-4">
                Edit Book
            </h4>
            <div class="card overflow-hidden">
                <div class="row no-gutters row-bordered row-border-light">
                    <div class="col-md-9" style="padding-left: 30px">
                        <form action="editbook" method="post">
                            <input type="hidden" class="form-control mb-1" value="${requestScope.bookdata.id}" name="id">
                            <label class="form-label">Title</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.title}" name="title">
                            <label class="form-label">Author</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.author}" name="author">
                            <label class="form-label">Isbn13</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.isbn}" name="isbn">
                            <label class="form-label">Language</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.lang}" name="lang">
                            <label class="form-label">Number of pages</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.numPage}" name="pagenum">
                            <label class="form-label">Publisher</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.pubName}" name="pubname">
                            <label class="form-label">Publication date</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.pubDate}" name="pubdate">
                            <label class="form-label">Stock</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.quantity}" name="quantity">
                            <label class="form-label">Category</label>
                            <select class="custom-select" name="category">
                                <option selected value="lightnovel">lightnovel</option>
                                <option value="fantasy">fantasy</option>
                                <option value="horror">horror</option>
                                <option value="fiction">fiction</option>
                                <option value="detective">detective</option>
                                <option value="literary">literary</option>
                                <option value="romance">romance</option>
                            </select>
                            <label class="form-label">Price</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.price}"  name="price">
                            <label class="form-label">Img URL</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.img}"  name="img">
                            <label class="form-label">Description</label>
                            <input type="text" class="form-control mb-1" value="${requestScope.bookdata.des}"  name="des">
                            <div class="text-right mt-3">
                                <button type="submit" class="btn btn-primary">Save change</button>&nbsp;
                                <button type="button" >Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">
            
        </script>
    </body>

</html>