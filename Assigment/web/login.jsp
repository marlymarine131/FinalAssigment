<%-- 
    Document   : login
    Created on : Oct 20, 2023, 3:13:46 PM
    Author     : oteee
--%>

<%@include file="includes/head.jsp" %>>
<%@include file="includes/Header.jsp" %>>
<!DOCTYPE html>
<section>
    <div class="signup">
        <h1 class="signup-heading">Sign in</h1>
<<<<<<< HEAD
=======
        <button class="signup-social">
            <i class="fa fa-google signup-social-icon"></i>
            <span class="signup-social-text">Sign up with google</span>
        </button>
>>>>>>> 54393f68c438b9b0a3cfc0a995ac126ec9a9d20e
        <div class="signup-or"><span>Or</span></div>
        <form action="login" method="post" class="signup-form" autocomplete="off">
            <label for="email" class="signup-label">Email</label>
            <input type="text" name="email" id="email" class="signup-input" placeholder="Eg: johndoe@email.com">

            <label for="password" class="signup-label">Password</label>
            <input type="password" name="password" id="password" class="signup-input" placeholder="Enter your password">

            <label for="role" class="signup-label">Select a role</label>
            <select id="role" name="role" class="signup-input">
                <option value="Owner">Owner</option>
                <option value="Customer">Customer</option>
                <option value="Shipper">Shipper</option>
            </select>
            <button type="submit">Sign in</button>
        </form>
        <c:if test="${not empty errorMessage}">
            <p style="color: red;">${"email or password or role wrong"}</p>
        </c:if>
        <p class="signup-already">
            <span>Don't have an account?</span>
            <a href="addNewAccout.jsp" class="signup-login-link">signup</a>
        </p>
    </div>

</section>

<%@include file="includes/Footer.jsp" %>>
