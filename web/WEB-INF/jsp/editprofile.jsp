<%-- 
    Document   : registration
    Created on : Dec 14, 2017, 11:49:44 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>" type="text/javascript"></script>
        <link  href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">
    </head>
    <body>
        <jsp:include page="head.jsp"/>

        <div class="container">
            <h1 style="text-align: center">EDIT PROFILE</h1><hr>
        <form:form action="/WebProject/registration/edit/save" modelAttribute="registerBean" method="POST" class="form-group">
            <table style="margin: 0px auto" class="table-condensed">
                <tr>
                    <td>
                        <form:label path="fullName" class="col-md-12">Full Name</form:label >
                    </td>
                    <td><form:input path="fullName" class="form-control col-md-12" required="true"></form:input></td>                        
                </tr>
                <tr>
                    <td>
                    <form:label path="email" class="col-md-12">Email</form:label>
                    </td>
                    <td><form:input path="email" class="form-control" required="true"></form:input></td>
                </tr>
                <tr>
                    <td>
                    <form:label path="phoneNumber" class="col-md-12">Phone Number</form:label>
                    </td>
                    <td>
                    <form:input path="phoneNumber" class="form-control" required="true"></form:input>
                    </td>
                </tr>
                
                <tr>
                    <td>
                    <form:label path="passwordVerification" class="col-md-12">Old Password</form:label>
                    </td>
                    <td>
                    <form:input type="password" path="passwordVerification" class="form-control" required="true"></form:input>
                    </td>
                </tr>
                
                <tr>
                    <td>
                    <form:label path="password" class="col-md-12">New Password</form:label>
                    </td>
                    <td>
                    <form:input type="password" path="password" class="form-control" required="true"></form:input>
                    </td>
                </tr>
                

                
                <tr>
                    <td colspan="2"></br><form:button name="submitButton" value="Submit" class="btn-primary form-control">Edit Profile</form:button>${message}</td>
                
                </tr>
            </table>
        
        </form:form>
            </div>
                <hr>
        <img src="<c:url value="/resources/footer.jpg"/>" alt="Gorilla" width="100%" style=" bottom:0">
    </body>
</html>
