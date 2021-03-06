<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Male-Fashion | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <script>
        window.speechSynthesis.cancel();
        var keys = [];
        function on_key_down() {
            keys[event.keyCode] = true;
            if (keys[72] && keys[16] && keys[17]) { //H
                location.replace('/templates/index');
            } else if (keys[83] && keys[16] && keys[17]) { //s
                location.replace('/templates/shop');
            } else if (keys[66] && keys[16] && keys[17]) { //B
                location.replace('/templates/blog');
            }
        }
        function on_key_up() {
            keys[event.keyCode] = false;
        }
    </script>
</head>

<body onkeydown='on_key_down()', onkeyup='on_key_up()'>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
    <div class="offcanvas__option">
        <div class="offcanvas__links">
            <a href="/templates/sign_in">Sign in</a>
        </div>
    </div>
    <div class="offcanvas__nav__option">
        <a href="#" class="search-switch"><img src="/img/icon/search.png" alt=""></a>
        <a href="#"><img src="/img/icon/heart.png" alt=""></a>
        <a href="#"><img src="/img/icon/cart.png" alt=""> <span>0</span></a>
        <div class="price">$0.00</div>
    </div>
    <div id="mobile-menu-wrap"></div>
</div>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7"></div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <div class="header__top__links">
                            <%
                                if(SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
                            %>
                            <a href="/templates/sign_in">Sign in</a>
                            <%} else {%>
                            <form action="/logout" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <input type="submit" value="Sign Out">
                            </form>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <a href="index"><img src="/img/logo.png" style="height: 30px" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <li class="active"><a href="index">Home</a></li>
                        <li><a href="shop">Shop</a></li>
                        <li><a href="blog">Blog</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="canvas__open"><i class="fa fa-bars"></i></div>
    </div>
</header>
<!-- Header Section End -->
<!-- Checkout Section Begin -->
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">
            <form action="/post_insert?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-lg-12 col-md-8">
                        <div class="col-lg-6">
                            <label for="formFile" class="form-label">Image File</label>
                            <input name="file" multiple="multiple" class="form-control" type="file" id="formFile">
                        </div>
                        <br>
                        <div class="col-lg-12">
                            <div class="checkout__input">
                                <p>Title<span>*</span></p>
                                <input name="postTitle" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="checkout__input">
                                <p>Content<span>*</span></p>
                                <textarea name="postContent" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="col-lg-12">
                            <div class="checkout__input">
                            <input type="submit" value="??????" style="background-color: #7abaff; color: white">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<!-- Checkout Section End -->
<!-- Contact Section End -->
<!-- Header Section End -->
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>
<script src="/js/jquery.nicescroll.min.js"></script>
<script src="/js/jquery.magnific-popup.min.js"></script>
<script src="/js/jquery.countdown.min.js"></script>
<script src="/js/jquery.slicknav.js"></script>
<script src="/js/mixitup.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/main.js"></script>
</body>
</html>