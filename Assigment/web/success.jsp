<%-- 
    Document   : success
<<<<<<< HEAD
    Created on : Oct 24, 2023, 9:11:24 PM
    Author     : oteee
=======
    Created on : Oct 23, 2023, 9:33:54 PM
    Author     : Hung Nguyen
>>>>>>> 54393f68c438b9b0a3cfc0a995ac126ec9a9d20e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>1</p>
        <c:forEach var="food1" items="${listFoods}">
            <p>1</p>
        <tr>
            <td>${food1.foodID}</td>
            <td>${food1.cartID}</td>
            <td>${food1.cusID} $</td> 
        </tr>
    </c:forEach>
</body>
</html>
