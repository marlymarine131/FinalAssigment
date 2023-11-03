<%-- 
    Document   : Header
    Created on : Oct 20, 2023, 3:29:45 PM
    Author     : oteee
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file="head.jsp" %>

<!--<header class="section page-header">

    <div class="rd-navbar-wrap rd-navbar-modern-wrap">
        <nav class="rd-navbar rd-navbar-modern" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fixed" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-fixed" data-xl-layout="rd-navbar-static" data-xl-device-layout="rd-navbar-static" data-xxl-layout="rd-navbar-static" data-xxl-device-layout="rd-navbar-static" data-lg-stick-up-offset="46px" data-xl-stick-up-offset="46px" data-xxl-stick-up-offset="70px" data-lg-stick-up="true" data-xl-stick-up="true" data-xxl-stick-up="true">
            <div class="rd-navbar-main-outer">
                <div class="rd-navbar-main">

                    <div class="rd-navbar-panel">

                        <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>

                        <div class="rd-navbar-brand"><a class="brand" href="index.jsp"><img src="images/logo-default-196x47.png" alt="" width="196" height="47"/></a></div>
                    </div>
                    <div class="rd-navbar-main-element">
                        <div class="rd-navbar-nav-wrap">
                             RD Navbar Basket                           
                            <div class="rd-navbar-basket-wrap">
                                <button class="rd-navbar-basket fl-bigmug-line-shopping198" data-rd-navbar-toggle=".cart-inline"><span>2</span></button>
                                <div class="cart-inline">
                                    <div class="cart-inline-header">
                                        <h5 class="cart-inline-title">In cart:<span> 2</span> Products</h5>
                                        <h6 class="cart-inline-title">Total price:<span> $800</span></h6>
                                    </div>
                                    <div class="cart-inline-body">
                                        <div class="cart-inline-item">
                                            <div class="unit align-items-center">
                                                <div class="unit-left"><a class="cart-inline-figure" href="#"><img src="images/product-mini-1-108x100.png" alt="" width="108" height="100"/></a></div>
                                                <div class="unit-body">
                                                    <h6 class="cart-inline-name"><a href="#">Blueberries</a></h6>
                                                    <div>
                                                        <div class="group-xs group-inline-middle">
                                                            <div class="table-cart-stepper">
                                                                <input class="form-input" type="number" data-zeros="true" value="1" min="1" max="1000">
                                                            </div>
                                                            <h6 class="cart-inline-title">$550</h6>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cart-inline-item">
                                            <div class="unit align-items-center">
                                                <div class="unit-left"><a class="cart-inline-figure" href="#"><img src="images/product-mini-2-108x100.png" alt="" width="108" height="100"/></a></div>
                                                <div class="unit-body">
                                                    <h6 class="cart-inline-name"><a href="#">Avocados</a></h6>
                                                    <div>
                                                        <div class="group-xs group-inline-middle">
                                                            <div class="table-cart-stepper">
                                                                <input class="form-input" type="number" data-zeros="true" value="1" min="1" max="1000">
                                                            </div>
                                                            <h6 class="cart-inline-title">$250</h6>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="cart-inline-footer">
                                        <div class="group-sm"><a class="button button-md button-default-outline-2 button-wapasha" href="#">Go to cart</a><a class="button button-md button-primary button-pipaluk" href="#">Checkout</a></div>
                                    </div>
                                </div>
                            </div><a class="rd-navbar-basket rd-navbar-basket-mobile fl-bigmug-line-shopping198" href="#"><span>2</span></a>
                             RD Navbar Search
                            <div class="rd-navbar-search">
                                <button class="rd-navbar-search-toggle" data-rd-navbar-toggle=".rd-navbar-search"><span></span></button>
                                <form class="rd-search" action="#">
                                    <div class="form-wrap">
                                        <label class="form-label" for="rd-navbar-search-form-input">Search...</label>
                                        <input class="rd-navbar-search-form-input form-input" id="rd-navbar-search-form-input" type="text" name="search">
                                        <button class="rd-search-form-submit fl-bigmug-line-search74" type="submit"></button>
                                    </div>
                                </form>
                            </div>
                             RD Navbar Nav
                            <ul class="rd-navbar-nav">                              


<c:if test="${not empty sessionScope.owner}">
    <li>class="rd-nav-item"><a class="rd-nav-link" href="listAllShop">manage shop</a>                                  
    </li>
</c:if>

<li>class="rd-nav-item"><a class="rd-nav-link" href="Cart.jsp">Cart</a>                                  
</li>
</ul>
</div>
<div class="rd-navbar-project-hamburger" data-multitoggle=".rd-navbar-main" data-multitoggle-blur=".rd-navbar-wrap" data-multitoggle-isolate>
<div class="project-hamburger"><span class="project-hamburger-arrow-top"></span><span class="project-hamburger-arrow-center"></span><span class="project-hamburger-arrow-bottom"></span></div>
<div class="project-hamburger-2"><span class="project-hamburger-arrow"></span><span class="project-hamburger-arrow"></span><span class="project-hamburger-arrow"></span>
</div>
<div class="project-close"><span></span><span></span></div>
</div>
</div>
<div class="rd-navbar-project rd-navbar-modern-project">
<div class="rd-navbar-project-modern-header">
<h4 class="rd-navbar-project-modern-title">Get in Touch</h4>
<div class="rd-navbar-project-hamburger" data-multitoggle=".rd-navbar-main" data-multitoggle-blur=".rd-navbar-wrap" data-multitoggle-isolate>
<div class="project-close"><span></span><span></span></div>
</div>
</div>
<div class="rd-navbar-project-content rd-navbar-modern-project-content">
<div>


<c:if test="${not empty sessionScope.owner}">
    <div class="heading-6 subtitle">Our Contacts</div>
    <c:set var="base64Banner" value="${Base64.getEncoder().encodeToString(sessionScope.owner.banner)}" />
    <div class="row row-10 gutters-10">
        <div class="col-12"><img src="data:image/jpeg;base64,${base64Banner}" alt="" width="394" height="255"/>
        </div>
    </div>
    <div class="user-info">
        <p>Welcome, ${sessionScope.owner.ownerName}!</p>
    </div>
</c:if>
<c:choose>
    <c:when test="${not empty sessionScope}">
        <li class="rd-nav-item"><a class="rd-nav-link" href="logOut">logout</a></li>
    </c:when>
    <c:otherwise>
    <li class="rd-nav-item"><a class="rd-nav-link" href="login.jsp">login</a></li>
    </c:otherwise>
</c:choose>
<li class="rd-nav-item"><a class="rd-nav-link" href="addNewAccout.jsp">sign up</a>
</li>
<ul class="rd-navbar-modern-contacts">
<li>
    <div class="unit unit-spacing-sm">
        <div class="unit-left"><span class="icon fa fa-phone"></span></div>
        <div class="unit-body"><a class="link-phone" href="tel:#">+1 323-913-4688</a></div>
    </div>
</li>
<li>
    <div class="unit unit-spacing-sm">
        <div class="unit-left"><span class="icon fa fa-location-arrow"></span></div>
        <div class="unit-body"><a class="link-location" href="#">4730 Crystal Springs Dr, Los Angeles, CA 90027</a></div>
    </div>
</li>
<li>
    <div class="unit unit-spacing-sm">
        <div class="unit-left"><span class="icon fa fa-envelope"></span></div>
        <div class="unit-body"><a class="link-email" href="mailto:#">mail@demolink.org</a></div>
    </div>
</li>
</ul>
<ul class="list-inline rd-navbar-modern-list-social">
<li><a class="icon fa fa-facebook" href="#"></a></li>
<li><a class="icon fa fa-twitter" href="#"></a></li>
<li><a class="icon fa fa-google-plus" href="#"></a></li>
<li><a class="icon fa fa-instagram" href="#"></a></li>
<li><a class="icon fa fa-pinterest" href="#"></a></li>
</ul>
</div>
</div>
</div>
</div>
</div>
</nav>
</div>
</header>-->

<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Humberger Begin -->
<div class="humberger__menu__overlay"></div>
<div class="humberger__menu__wrapper">
    <div class="humberger__menu__logo">
        <a href="#"><img src="img/logo.png" alt=""></a>
    </div>
    <div class="humberger__menu__cart">
        <ul>
            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
        </ul>
        <div class="header__cart__price">item: <span>$150.00</span></div>
    </div>
    <div class="humberger__menu__widget">
        <div class="header__top__right__language">
            <img src="img/language.png" alt="">
            <div>English</div>
            <span class="arrow_carrot-down"></span>
            <ul>
                <li><a href="#">Spanis</a></li>
                <li><a href="#">English</a></li>
            </ul>
        </div>
        <div class="header__top__right__auth">
            <a href="2"><i class="fa fa-user"></i> Login</a>
        </div>
    </div>
    <nav class="humberger__menu__nav mobile-menu">
        <ul>
            <li class="active"><a href="./index.jsp">Home</a></li>
            <li><a href="./shop-grid.jsp">Shop</a></li>
            <li><a href="#">Pages</a>
                <ul class="header__menu__dropdown">
                    <li><a href="./shop-details.jsp">Shop Details</a></li>
                    <li><a href="./shoping-cart.jsp">Shoping Cart</a></li>
                    <li><a href="./checkout.jsp">Check Out</a></li>
                    <li><a href="./blog-details.jsp">Blog Details</a></li>
                </ul>
            </li>
            <li><a href="./blog.jsp">Blog</a></li>
            <li><a href="./contact.jsp">Contact</a></li>
        </ul>
    </nav>
    <div id="mobile-menu-wrap"></div>
    <div class="header__top__right__social">
        <a href="#"><i class="fa fa-facebook"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
        <a href="#"><i class="fa fa-linkedin"></i></a>
        <a href="#"><i class="fa fa-pinterest-p"></i></a>
    </div>
    <div class="humberger__menu__contact">
        <ul>
            <li><i class="fa fa-envelope"></i> hello${sessionScope.owner.ownerName}</li>

        </ul>
    </div>
</div>
<!-- Humberger End -->

<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__left">
                        <ul>
                            <c:choose>
                                <c:when test="${not empty sessionScope}">
                                   <li><i class="fa fa-envelope"></i> sessionScope.owner.ownerName</li>
                                    </c:when>
                                    <c:otherwise>
                                                                   
                                    </c:otherwise>
                                </c:choose>
                            
                            
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__right">
                        <div class="header__top__right__auth">
                            <c:if test="${not empty sessionScope.owner}">
                                <div class="heading-6 subtitle">Our Contacts</div>
                                <c:set var="base64Banner" value="${Base64.getEncoder().encodeToString(sessionScope.owner.banner)}" />
                                <div class="row row-10 gutters-10">
                                    <div class="col-12"><img src="data:image/jpeg;base64,${base64Banner}" alt="" width="394" height="255"/>
                                    </div>
                                </div>
                                <div class="user-info">
                                    <p>Welcome, ${sessionScope.owner.ownerName}!</p>
                                </div>
                            </c:if>



                            <c:choose>
                                <c:when test="${not empty sessionScope}">
                                    <a href="logOut"><i class="fa fa-user"></i> logOut</a>
                                    </c:when>
                                    <c:otherwise>
                                    <a href="login"><i class="fa fa-user"></i> Login</a>                                 
                                    </c:otherwise>
                                </c:choose>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="./index.jsp"><img src="img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6">
                <nav class="header__menu">
                    <ul>
                        <li class="active"><a href="./index.jsp">Home</a></li>
                        <li><a href="browsing">Shop</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="header__menu__dropdown">
                                <li><a href="./shop-details.jsp">Shop Details</a></li>
                                <li><a href="./shoping-cart.jsp">Shoping Cart</a></li>
                                <li><a href="./checkout.jsp">Check Out</a></li>
                                <li><a href="./blog-details.jsp">Blog Details</a></li>
                            </ul>
                        </li>
                        <li><a href="./blog.jsp">Blog</a></li>
                        <li><a href="./contact.jsp">Contact</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__cart">
                    <ul>
                        <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                        <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                    </ul>
                    <div class="header__cart__price">item: <span>$150.00</span></div>
                </div>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>


