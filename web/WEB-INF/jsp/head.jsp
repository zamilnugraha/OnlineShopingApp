<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="modal-header">
        <div class="jumbotron">
            hasdhsj
        </div>
    </div>    
</div>

<div class="container">
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}">Online Shop</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Jenis Produk<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/WebProject/product/categories/Small">Makanan</a></li>
                        <li><a href="/WebProject/product/categories/Medium">Minuman</a></li>
                        <li><a href="/WebProject/product/categories/Large">Snack</a></li>
                        <li><a href="/WebProject/product/categories/Large">Kue</a></li>
                        <li><a href="/WebProject/product/categories/Large">Makanan Sehat</a></li>
                    </ul>
                </li>
            </ul>
                
            <ul class="nav navbar-nav">
                <li><a>Tentang</a></li>                    
            </ul>    
            <ul class="nav navbar-nav">
                <li><a>Kontak</a></li>                    
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/product/cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart <div class="badge">${iterator}</div></a></li>
                <c:if test="${empty sessionScope.user}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Account<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                            <li><a href="${pageContext.request.contextPath}/registration">Register</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Hello, ${user.fullName}  <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/registration/profile"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
                            <li><a href="${pageContext.request.contextPath}/registration/edit"><span class="glyphicon glyphicon-pencil"></span> Edit Profile</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
                        </ul>
                    </c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>         
</div>