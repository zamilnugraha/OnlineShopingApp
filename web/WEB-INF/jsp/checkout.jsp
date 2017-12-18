<%-- 
    Document   : checkout
    Created on : Dec 16, 2017, 4:08:45 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checking Out</title>
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>" type="text/javascript"></script>
        <link  href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">

    </head>
    <body>
        <div><jsp:include page="head.jsp"/></div>
        
        <div class="container">
        <c:if test="${not empty sessionScope.user}">
            <h1>Check out berhasil!</h1>
            <h3> Terimakasih telah belanja.</h3>
            <h3>Total yang harus dibayar : Rp. ${hargaan}</h3>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <h3>Silahkan klik...! <a href="/WebProject/login">login</a></h3>
        </c:if>
    </body>
</html>
