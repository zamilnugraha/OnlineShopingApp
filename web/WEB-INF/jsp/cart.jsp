<%-- 
    Document   : cart
    Created on : Dec 15, 2017, 9:16:57 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Cart</title>
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>" type="text/javascript"></script>
        <link  href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">

    </head>
    <body>
        <jsp:include page="head.jsp"/>
        <div class="container panel panel-body">
            <h1>Daftar keranjang</h1><hr>
            <table class="table table-striped">
                <tr>
                    <th>Nama Produk</th>
                    <th>Harga Product</th>
                    <th>Aksi</th>
                </tr>
                <c:forEach var="x" items="${cartBean.cartList}">
                    <tr>
                        <td>${x.value.productName}</td>
                        <td>
                            Rp. ${x.value.productPrice}

                        </td>
                        <td>
                            <a href="/WebProject/product/remove/${x.key}">
                                <button class="btn btn-danger btn-sm">
                                    <span class="glyphicon glyphicon-trash"></span> REMOVE
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                <tfoot>
                <td>
                    <a href="/WebProject/product/checkout"><button class="btn btn-primary"> CHECK OUT </button></a>                        
                </td>

                <td>
                    <c:if test="${not empty sessionScope.cartBean.cartList}">
                        <h2>Total : Rp. ${hargaTotal}</h2>
                    </c:if>                        
                </td>
                </tfoot>
            </table>
            <c:if test="${empty sessionScope.cartBean.cartList}">
                <h2>Keranjang kosong.</h2>
            </c:if>
        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br>
        <hr>
        <img src="<c:url value="/resources/footer.jpg"/>" alt="Gorilla" width="100%" style="position: initial; bottom: 0">
    </body>
</html>
