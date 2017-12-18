<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OnlineShop</title>
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>" type="text/javascript"></script>
        <link  href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">

    </head>

    <body>
        <div><jsp:include page="head.jsp"/></div>                
        <div class="container">
            <div class="row">
                <c:forEach var="i" items="${products}">
                    <div class="col-md-3">
                        <div class="panel-primary">
                            <div class="row">
                                <div class="col-md-10">
                                    <a href="product/${i.id}"><img src="<c:url value="resources/img/${i.imagePath}"/>" width="100%" class="img-thumbnail"></a>
                                    <h2>${i.productName}</h2>
                                    <hr>    
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
=======
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
        <p><i>To display a different welcome page for this project, modify</i>
            <tt>index.jsp</tt> <i>, or create your own welcome page then change
                the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                welcome page and also update the welcome-file setting in</i>
            <tt>web.xml</tt>.</p>
>>>>>>> origin/master
    </body>
</html>
