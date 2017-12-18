<%-- 
    Document   : login
    Created on : Dec 14, 2017, 4:56:26 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>" type="text/javascript"></script>
        <link  href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">
    </head>
    <body>
        <jsp:include page="head.jsp"/>  
        <div class="container">
            <div class="form-horizontal">
                <b>${message}</b>
                <div class="container">
                    <h1 style="text-align: center">SIGN IN</h1><hr>

                    <form:form action="${pageContext.request.contextPath}/login/check" modelAttribute="loginBean" method="POST">
                        <table class="table-condensed" style="margin: 0 auto">
                            <tr>
                                <td>
                                    <form:label path="userName">Username</form:label>
                                </td>
                                <td>
                                    <form:input path="userName" class="form-control" required="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="password">Password</form:label>
                                </td>
                                <td>
                                    <form:password path="password" class="form-control" required="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: right">
                                    <form:button name="submitButton" value="Submit">Submit</form:button>
                                    <input type="reset" name="reset" value="Reset">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">Buat akun..? 
                                    <a href="${pageContext.request.contextPath}/registration">Registrasi disini..!</a>.
                                </td>
                            </tr>
                        </table> 
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>
