<%-- 
    Document   : successregistration
    Created on : Dec 14, 2017, 2:17:57 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>" type="text/javascript"></script>
        <link  href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">
    </head>
    <body>
        <jsp:include page="head.jsp"/>
        <div class="container">
            <h1 style="text-align: center">Congratulations ${user.fullName}, you have successfully edited your profile!</h1>
        </div>
        </body>
        <hr>
        <img src="<c:url value="/resources/footer.jpg"/>" alt="Gorilla" width="100%" style=" bottom:0">
</html>
