<!doctype html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <title>Book Library</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/transitions.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/color.css">
        <link rel="stylesheet" href="css/responsive.css">
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>

        <div id="tg-wrapper" class="tg-wrapper tg-haslayout">
            <!--************************************
                            Header Start
            *************************************-->
            <header id="tg-header" class="tg-header tg-haslayout">
                <div class="tg-topbar">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <ul class="tg-addnav">
                                    <li>
                                        <a href="javascript:void(0);">
                                            <i class="icon-envelope"></i>
                                            <em>Contact</em>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0);">
                                            <i class="icon-question-circle"></i>
                                            <em>Help</em>
                                        </a>
                                    </li>
                                </ul>
                                <div class="dropdown tg-userlogin">
                                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Account
                                    </a>

                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                        <a class="dropdown-item" href="account">Edit profile</a><br>
                                        <a class="dropdown-item" href="logout">Log out</a><br>
                                        <c:if test="${sessionScope.user.role==1}"><a class="dropdown-item" href="manage">Manage</a></c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tg-middlecontainer">
                        <div class="container">
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <strong class="tg-logo"><a href="index-2.html"><img src="images/logo.png" alt="company name here"></a></strong>
                                    <div class="tg-wishlistandcart">
                                    <c:set var="cookie" value="${pageContext.request.cookies}"/>
                                    <jsp:useBean id="list" class="model.Cart"/>
                                    <div class="dropdown tg-themedropdown tg-minicartdropdown">
                                        <a href="javascript:void(0);" id="tg-minicart" class="tg-btnthemedropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <span class="tg-themebadge">${list.getCart(cookie.cart.value).size()}</span>
                                            <i class="icon-cart"></i>

                                        </a>
                                        <div class="dropdown-menu tg-themedropdownmenu" aria-labelledby="tg-minicart">

                                            <c:forEach items="${list.getCart(cookie.cart.value)}" var="i">
                                                <div class="tg-minicartbody">
                                                    <div class="tg-minicarproduct">
                                                        <figure>
                                                            <img style="width: 70px" src="${i.img}" alt="image description">
                                                        </figure>
                                                        <div class="tg-minicarproductdata">
                                                            <h5><a href="detail?title=${i.title}">${i.title}</a></h5>
                                                            <h6><a href="javascript:void(0);">$${i.price}</a></h6>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                            <div class="tg-minicartfoot">
                                                <a class="tg-btnemptycart" href="cart?action=clear">
                                                    <i class="fa fa-trash-o"></i>
                                                    <span>Clear Your Cart</span>
                                                </a>

                                                <div class="tg-btns">
                                                    <a class="tg-btn tg-active" href="javascript:void(0);">View Cart</a>
                                                    <a class="tg-btn" href="cart?action=checkout">Checkout</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tg-searchbox">
                                    <form class="tg-formtheme tg-formsearch" action="search" method="post">
                                        <fieldset>
                                            <input type="text" name="title" class="typeahead form-control" placeholder="Search by title">
                                            <button type="submit"><i class="icon-magnifier"></i></button>
                                        </fieldset>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tg-navigationarea">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <nav id="tg-nav" class="tg-nav">
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#tg-navigation" aria-expanded="false">
                                            <span class="sr-only">Toggle navigation</span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                        </button>
                                    </div>
                                    <div id="tg-navigation" class="collapse navbar-collapse tg-navigation">
                                        <ul>
                                            <li class="menu-item-has-children menu-item-has-mega-menu">
                                                <a href="javascript:void(0);">All Categories</a>
                                                <div class="mega-menu">
                                                    <ul class="tg-themetabnav" role="tablist"> 
                                                        <c:forEach var="c" items="${requestScope.categories}">
                                                            <li role="presentation">
                                                                <a href="sort?category=${c.cateName}" aria-controls="fantasyhorror" role="tab" >${c.cateName}</a>
                                                            </li>
                                                        </c:forEach>
                                                    </ul>

                                                </div>
                                            </li>
                                            <li><a href="home">Home</a></li>

                                            <li><a href="list">All Products</a></li>
                                            <li><a href="account">Account Info</a></li>
                                        </ul>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!--************************************
                            Header End
            *************************************-->
            <!--************************************
                            Inner Banner Start
            *************************************-->
            <div class="tg-innerbanner tg-haslayout tg-parallax tg-bginnerbanner" data-z-index="-100" data-appear-top-offset="600" data-parallax="scroll" data-image-src="images/parallax/bgparallax-07.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <div class="tg-innerbannercontent">
                                <h1>All Products</h1>
                                <ol class="tg-breadcrumb">
                                    <li><a href="javascript:void(0);">home</a></li>
                                    <li><a href="javascript:void(0);">Products</a></li>
                                    <li class="tg-active">${requestScope.data.title}</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--************************************
                            Inner Banner End
            *************************************-->
            <!--************************************
                            Main Start
            *************************************-->
            <main id="tg-main" class="tg-main tg-haslayout">
                <!--************************************
                                News Grid Start
                *************************************-->
                <div class="tg-sectionspace tg-haslayout">
                    <div class="container">
                        <div class="row">
                            <div id="tg-twocolumns" class="tg-twocolumns">
                                <div class="col-xs-12 col-sm-8 col-md-8 col-lg-9 pull-right">
                                    <div id="tg-content" class="tg-content">
                                        <div class="tg-productdetail">
                                            <c:set var="b" value="${requestScope.data}"/>
                                            <div class="row">
                                                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                                                    <div class="tg-postbook">
                                                        <figure class="tg-featureimg"><img src="${b.img}"></figure>
                                                        <div class="tg-postbookcontent">
                                                            <span class="tg-bookprice">
                                                                <ins>$${b.price}</ins>
                                                            </span>
                                                            <ul class="tg-delevrystock">
                                                                <li><i class="icon-rocket"></i><span>Free delivery worldwide</span></li>
                                                                <li><i class="icon-checkmark-circle"></i><span>Dispatch from the USA in 2 working days </span></li>
                                                            </ul>
                                                            
                                                            <a class="tg-btn tg-active tg-btn-lg" href="cart?id=${b.id}&title=${b.title}&action=add">Add To Basket</a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
                                                    <div class="tg-productcontent">
                                                        <ul class="tg-bookscategories">
                                                            <li><a href="javascript:void(0);">${b.category}</a></li>
                                                        </ul>
                                                        <div class="tg-booktitle">
                                                            <h3>${b.title}</h3>
                                                        </div>
                                                        <span class="tg-bookwriter">By: <a href="javascript:void(0);">${b.author}</a></span>


                                                        <div class="tg-description">
                                                            <span>${b.des}</span>.
                                                        </div>
                                                        <div class="tg-sectionhead">
                                                            <h2>Product Details</h2>
                                                        </div>
                                                        <ul class="tg-productinfo">
                                                            <li><span>Pages:</span><span>${b.numPage} pages</span></li>
                                                            <li><span>Publication Date:</span><span>${b.pubDate}</span></li>
                                                            <li><span>Publisher:</span><span>${b.pubName}</span></li>
                                                            <li><span>Language:</span><span>${b.lang}</span></li>
                                                            <li><span>ISBN13:</span><span>${b.isbn}</span></li>
                                                            <li><span>Stock</span><span>${b.quantity}</span></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-4 col-md-4 col-lg-3 pull-left">
                                    <aside id="tg-sidebar" class="tg-sidebar">
                                        <div class="tg-widget tg-widgetsearch">
                                            <form class="tg-formtheme tg-formsearch">
                                                <div class="form-group">
                                                    <button type="submit"><i class="icon-magnifier"></i></button>
                                                    <input type="search" name="search" class="form-group" placeholder="Search by title, author, key...">
                                                </div>
                                            </form>
                                        </div>
                                        <div class="tg-widget tg-catagories">
                                            <div class="tg-widgettitle">
                                                <h3>Categories</h3>
                                            </div>
                                            <div class="tg-widgetcontent">
                                                <ul>
                                                    <c:forEach var="c" items="${requestScope.categories}">
                                                        <li><a href="sort?category=${c.cateName}"><span>${c.cateName}</span></a></li>
                                                                </c:forEach> 
                                                </ul>
                                            </div>
                                        </div>

                                    </aside>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--************************************
                                News Grid End
                *************************************-->
            </main>
            <!--************************************
                            Main End
            *************************************-->
            <!--************************************
                            Footer Start
            *************************************-->
            <footer id="tg-footer" class="tg-footer tg-haslayout">
                <div class="tg-footerarea">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <ul class="tg-clientservices">
                                    <li class="tg-devlivery">
                                        <span class="tg-clientserviceicon"><i class="icon-rocket"></i></span>
                                        <div class="tg-titlesubtitle">
                                            <h3>Fast Delivery</h3>
                                            <p>Shipping Worldwide</p>
                                        </div>
                                    </li>
                                    <li class="tg-discount">
                                        <span class="tg-clientserviceicon"><i class="icon-tag"></i></span>
                                        <div class="tg-titlesubtitle">
                                            <h3>Open Discount</h3>
                                            <p>Offering Open Discount</p>
                                        </div>
                                    </li>
                                    <li class="tg-quality">
                                        <span class="tg-clientserviceicon"><i class="icon-leaf"></i></span>
                                        <div class="tg-titlesubtitle">
                                            <h3>Eyes On Quality</h3>
                                            <p>Publishing Quality Work</p>
                                        </div>
                                    </li>
                                    <li class="tg-support">
                                        <span class="tg-clientserviceicon"><i class="icon-heart"></i></span>
                                        <div class="tg-titlesubtitle">
                                            <h3>24/7 Support</h3>
                                            <p>Serving Every Moments</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="tg-threecolumns">
                                <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                                    <div class="tg-footercol">
                                        <strong class="tg-logo"><a href="javascript:void(0);"><img src="images/flogo.png" alt="image description"></a></strong>
                                        <ul class="tg-contactinfo">
                                            <li>
                                                <i class="icon-apartment"></i>
                                                <address>Suit # 07, Rose world Building, Street # 02, AT246T Manchester</address>
                                            </li>
                                            <li>
                                                <i class="icon-phone-handset"></i>
                                                <span>
                                                    <em>0800 12345 - 678 - 89</em>
                                                    <em>+4 1234 - 4567 - 67</em>
                                                </span>
                                            </li>
                                            <li>
                                                <i class="icon-clock"></i>
                                                <span>Serving 7 Days A Week From 9am - 5pm</span>
                                            </li>
                                            <li>
                                                <i class="icon-envelope"></i>
                                                <span>
                                                    <em><a href="mailto:support@domain.com">support@domain.com</a></em>
                                                    <em><a href="mailto:info@domain.com">info@domain.com</a></em>
                                                </span>
                                            </li>
                                        </ul>
                                        <ul class="tg-socialicons">
                                            <li class="tg-facebook"><a href="javascript:void(0);"><i class="fa fa-facebook"></i></a></li>
                                            <li class="tg-twitter"><a href="javascript:void(0);"><i class="fa fa-twitter"></i></a></li>
                                            <li class="tg-linkedin"><a href="javascript:void(0);"><i class="fa fa-linkedin"></i></a></li>
                                            <li class="tg-googleplus"><a href="javascript:void(0);"><i class="fa fa-google-plus"></i></a></li>
                                            <li class="tg-rss"><a href="javascript:void(0);"><i class="fa fa-rss"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                                    <div class="tg-footercol tg-widget tg-widgetnavigation">
                                        <div class="tg-widgettitle">
                                            <h3>Shipping And Help Information</h3>
                                        </div>
                                        <div class="tg-widgetcontent">
                                            <ul>
                                                <li><a href="javascript:void(0);">Terms of Use</a></li>
                                                <li><a href="javascript:void(0);">Terms of Sale</a></li>
                                                <li><a href="javascript:void(0);">Returns</a></li>
                                                <li><a href="javascript:void(0);">Privacy</a></li>
                                                <li><a href="javascript:void(0);">Cookies</a></li>
                                                <li><a href="javascript:void(0);">Contact Us</a></li>
                                                <li><a href="javascript:void(0);">Our Affiliates</a></li>
                                                <li><a href="javascript:void(0);">Vision &amp; Aim</a></li>
                                            </ul>
                                            <ul>
                                                <li><a href="javascript:void(0);">Our Story</a></li>
                                                <li><a href="javascript:void(0);">Meet Our Team</a></li>
                                                <li><a href="javascript:void(0);">FAQ</a></li>
                                                <li><a href="javascript:void(0);">Testimonials</a></li>
                                                <li><a href="javascript:void(0);">Join Our Team</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tg-footerbar">
                    <a id="tg-btnbacktotop" class="tg-btnbacktotop" href="javascript:void(0);"><i class="icon-chevron-up"></i></a>
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <span class="tg-paymenttype"><img src="images/paymenticon.png" alt="image description"></span>
                                <span class="tg-copyright">2017 All Rights Reserved By &copy; Book Library</span>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <!--************************************
                            Footer End
            *************************************-->
        </div>
        <!--************************************
                        Wrapper End
        *************************************-->
        <script src="js/vendor/jquery-library.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="https://maps.google.com/maps/api/js?key=AIzaSyCR-KEWAVCn52mSdeVeTqZjtqbmVJyfSus&amp;language=en"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.vide.min.js"></script>
        <script src="js/countdown.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/parallax.js"></script>
        <script src="js/countTo.js"></script>
        <script src="js/appear.js"></script>
        <script src="js/gmap3.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>