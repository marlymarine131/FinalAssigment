<%@ page import="java.util.Base64" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import="model.Owner" %>
<%@ page import="model.OwnerDatabase" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Ch? s? h?u</title>
</head>
<body>

<h2></h2>

<c:forEach var="owner" items="${ownerList}">
    <div>
        <p> ${owner.ownerName}</p>
        <p> ${owner.addressHead}</p>
        
        <c:set var="base64Banner" value="${Base64.getEncoder().encodeToString(owner.banner)}" />
        

        <c:if test="${not empty base64Banner}">
            <img src="data:image/jpeg;base64,${base64Banner}" alt="Banner" />
        </c:if>
        

    </div>
    <hr/>
</c:forEach>

</body>
</html>
