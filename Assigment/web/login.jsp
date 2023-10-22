<%-- 
    Document   : login
    Created on : Oct 20, 2023, 3:13:46 PM
    Author     : oteee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/Header.jsp" %>

<!DOCTYPE html>
<section>
    <div class="signup">
        <h1 class="signup-heading">Sign up</h1>
        <button class="signup-social">
            <i class="fa fa-google signup-social-icon"></i>
            <span class="signup-social-text">Sign up with google</span>
        </button>
        <div class="signup-or"><span>Or</span></div>
        <form action="login" method="post" method="post" class="signup-form" autocomplete="off">
            <label for="email" class="signup-label">Email</label>
            <input type="text" id="email" class="signup-input" placeholder="Eg: johndoe@email.com">

            <label for="password" class="signup-label">Password</label>
            <input type="password" id="password" class="signup-input" placeholder="Enter your password">

            <label for="role" class="signup-label">Select a role</label>
            <select id="role" class="signup-input">
                <option value="Owner">Owner</option>
                <option value="Customer">Customer</option>
                <option value="Shipper">Shipper</option>
            </select>
        </form>
        <p class="signup-already">
            <span>Don't have an account?</span>
            <a href="#" class="signup-login-link">signup</a>
        </p>
    </div>

</section>
