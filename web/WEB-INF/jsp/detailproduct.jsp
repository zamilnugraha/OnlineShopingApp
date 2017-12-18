<%-- 
    Document   : detailproduct
    Created on : Dec 15, 2017, 4:42:38 PM
    Author     : user
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primate Shop - ${product.productName}</title>
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>" type="text/javascript"></script>
        <link  href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">
    </head>
    <body>
        <jsp:include page="head.jsp"/>  
        <div class="container">
            <table class="table table-striped">
                <h1>Detail produk</h1>
                <tr>
                    <th>Nama Produk</th>
                    <th>Foto</th>
                    <th>Deskripsi Produk</th>
                    <th>Kategori</th>
                    <th>Harga Produk</th>
                    <th>Aksi</th>
                </tr>
                <tr>
                    <td>${product.productName}</td>
                    <td><img src="<c:url value="/resources/img/${product.imagePath}"/>" width="50%"></td>
                    <td>${product.productDescription}</td>
                    <td>${product.productCategory}</td>
                    <td>Rp. ${product.productPrice}</td>
                    <td>
                        <a href="addCart/${product.id}">
                            <button class="btn btn-info btn-lg"> 
                                <span class="glyphicon glyphicon-shopping-cart"></span> ADD TO CART
                            </button>
                        </a>                        
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
