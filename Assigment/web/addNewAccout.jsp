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
        <form action="AddAccountServlet" method="post" class="signup-form" autocomplete="off">
            <label for="email" class="signup-label">Email</label>
            <input type="text" name="email" id="email" class="signup-input" placeholder="Eg: johndoe@email.com" required>

            <label for="password" class="signup-label">Password</label>
            <input type="password" name="password" id="password" class="signup-input" placeholder="Enter your password" required>

            <label for="password" class="signup-label">Password</label>
            <input type="password" name="conPassword" id="password" class="signup-input" placeholder="conferm password" required>

            <label for="role" class="signup-label">Select a role</label>
            <select name="role" id="role" class="signup-input" onchange="showFieldsForRole()">
                <option value="Owner">Owner</option>
                <option value="Customer">Customer</option>
                <option value="Shipper">Shipper</option>
            </select>

            <!-- Các trường mới cho Owner -->
            <div id="ownerFields" style="display: none;">
                <label for="ownerName" class="signup-label">Owner Name</label>
                <input type="text" name="ownerName" id="ownerName" class="signup-input" placeholder="Enter owner name" required>
                <!-- Thêm các trường mới cho Owner tại đây -->
            </div>

            <!-- Các trường mới cho Customer -->
            <div id="customerFields" style="display: none;">
                <label for="customerField1" class="signup-label">Customer Field 1</label>
                <input type="text" name="customerField1" id="customerField1" class="signup-input" placeholder="Enter customer field 1" required>
                <!-- Thêm các trường mới cho Customer tại đây -->
            </div>

            <!-- Các trường mới cho Shipper -->
            <div id="shipperFields" style="display: none;">
                <label for="shipperField1" class="signup-label">Shipper Field 1</label>
                <input type="text" name="shipperField1" id="shipperField1" class="signup-input" placeholder="Enter shipper field 1" required>
                <!-- Thêm các trường mới cho Shipper tại đây -->
            </div>
            <button type="submit" class="signup-btn">Sign Up</button>
        </form>
        <p class="signup-already">
            <span>Already have an account?</span>
            <a href="login.jsp" class="signup-login-link">Login</a>
        </p>
    </div>

</section>
