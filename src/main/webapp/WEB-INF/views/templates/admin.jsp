<%@ page import="com.example.reg.dto.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.example.reg.dto.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script>
        window.speechSynthesis.cancel();
        $(function() {
            $(document).on("click", "#modify", function(event) { //버튼을 클릭 했을시 popupOpen 함수 출력
                popupOpen($(this).val());
            });
        })
        function popupOpen(val) {
            let url = "${pageContext.request.contextPath}/main/modify?usersNo=" + val;
            let winWidth = 700;
            let winHeight = 600;
            let popupOption = "width=" + winWidth + ", height=" + winHeight; //팝업창 옵션(optoin)
            let myWindow = window.open(url, "회원 정보 수정", popupOption);
        }
    </script>
</head>

<body>
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

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-blog set-bg" data-setbg="/img/admin.jpeg">
    <div class="container">
        <div class="row">
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->
<div class="card-block table-border-style" style="margin: 0 100px">
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr>
                <th>No</th>
                <th>Id</th>
                <th>Name</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Users> users = (List<Users>) request.getAttribute("users");
                for(int i = 0; i < users.size(); i++) {
            %>
                <tr>
                    <th scope="row"><%=users.get(i).getUserNo()%></th>
                    <td><%=users.get(i).getUserId()%></td>
                    <td><%=users.get(i).getUserName()%></td>
                    <td><%=users.get(i).getRoleName()%></td>
                    <td>
                        <button class="btn btn-default" style="margin-right: 5px"
                                id="modify" value="<%=users.get(i).getUserNo()%>">수정</button>
                    </td>
                </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
<!-- Footer Section Begin -->
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__logo">
                        <a href="#"><img src="/img/footer-logo.png" alt=""></a>
                    </div>
                    <p>The customer is at the heart of our unique business model, which includes design.</p>
                    <a href="#"><img src="/img/payment.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
                <div class="footer__widget">
                    <h6>Shopping</h6>
                    <ul>
                        <li><a href="#">Clothing Store</a></li>
                        <li><a href="#">Trending Shoes</a></li>
                        <li><a href="#">Accessories</a></li>
                        <li><a href="#">Sale</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-6">
                <div class="footer__widget">
                    <h6>Shopping</h6>
                    <ul>
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Payment Methods</a></li>
                        <li><a href="#">Delivary</a></li>
                        <li><a href="#">Return & Exchanges</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
                <div class="footer__widget">
                    <h6>NewLetter</h6>
                    <div class="footer__newslatter">
                        <p>Be the first to know about new arrivals, look books, sales & promos!</p>
                        <form action="#">
                            <input type="text" placeholder="Your email">
                            <button type="submit"><span class="icon_mail_alt"></span></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="footer__copyright__text">
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    <p>Copyright ©
                        <script>
                            document.write(new Date().getFullYear());
                        </script>
                        2020
                        All rights reserved | This template is made with <i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i> by <a
                                href="https://colorlib.com" target="_blank">Colorlib</a>
                    </p>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->

<!-- Search Begin -->
<div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch">+</div>
        <form class="search-model-form">
            <input type="text" id="search-input" placeholder="Search here.....">
        </form>
    </div>
</div>
<!-- Search End -->

<!-- Js Plugins -->
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