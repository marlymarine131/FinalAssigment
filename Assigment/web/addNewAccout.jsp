<%-- 
    Document   : addNewAccout
    Created on : Oct 21, 2023, 3:03:34 PM
    Author     : oteee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<section>
    <div class="signup">
        <h1 class="signup-heading">Sign up</h1>
        <form action="addNew" method="post" class="signup-form" autocomplete="off">
            <label for="email" class="signup-label">Email</label>
            <input type="text" name="email" id="email" class="signup-input" placeholder="Eg: johndoe@email.com" >

            <label for="password" class="signup-label">Password</label>
            <input type="password" name="password" id="password" class="signup-input" placeholder="Enter your password" >

            <label for="password" class="signup-label">Password</label>
            <input type="password" name="conPassword" id="password" class="signup-input" placeholder="confirm password" >

            <label for="role" class="signup-label">Select a role</label>
            <select name="role" id="role" class="signup-input" onchange="showFieldsForRole()">
                <option value="Owner">Owner</option>
                <option value="Customer">Customer</option>
                <option value="Shipper">Shipper</option>
            </select>
            <button type="submit" class="signup-btn">Sign Up</button>
        </form>
        <%
            String errorMessage = (String) request.getAttribute("error");
            if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
        <c:if test="${not empty errorMessage}">
            <div class="error-message">
                <%=errorMessage%>
            </div>
        </c:if>
        <%
            }
        %>
        <p class="signup-already">
            <span>Already have an account?</span>
            <a href="login.jsp" class="signup-login-link">Login</a>
        </p>
    </div>

</section>
