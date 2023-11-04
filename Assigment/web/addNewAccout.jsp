<%@include file="includes/head.jsp" %>
<%@include file="includes/Header.jsp" %>
<!DOCTYPE html>
<section>
    <div class="signup">
        <h1 class="signup-heading">Sign up</h1>
        <form action="addNew" method="post" autocomplete="off" class="signup-form" enctype="multipart/form-data">

            <label for="email" class="signup-label">Email</label>
            <input type="text" name="email" id="email" class="signup-input" placeholder="Eg: johndoe@email.com" >

            <label for="password" class="signup-label">Password</label>
            <input type="password" name="password" id="password" class="signup-input" placeholder="Enter your password" >

            <label for="password" class="signup-label">Password</label>
            <input type="password" name="conPassword" id="password" class="signup-input" placeholder="confirm password" >

            <label for="role" class="signup-label">Select a role</label>
            <select name="role" id="role" class="signup-input" onchange="handleRoleChange()">
                <option value="Owner">Owner</option>
                <option value="Customer">Customer</option>
                <option value="Shipper">Shipper</option>
            </select>
            <div id="ownerFields" style="display: none;">
                <label for="ownerName" class="signup-label">Owner Name</label>
                <input type="text" name="ownerName" id="ownerName" class="signup-input" placeholder="Enter owner name">

                <label for="taxNumber" class="signup-label">Tax Number</label>
                <input type="text" name="taxNumber" id="taxNumber" class="signup-input" placeholder="Enter tax number">

                <label for="areaServe" class="signup-label">Area Served</label>
                <input type="text" name="areaServe" id="areaServe" class="signup-input" placeholder="Enter area served">

                <label for="description" class="signup-label">Description</label>
                <textarea name="description" id="description" class="signup-input" placeholder="Enter description"></textarea>

                <label for="addressHead" class="signup-label">Head Address</label>
                <input type="text" name="addressHead" id="addressHead" class="signup-input" placeholder="Enter head address">

                <label for="phone" class="signup-label">Phone</label>
                <input type="text" name="phoneOwner" id="phone" class="signup-input" placeholder="Enter phone number">

                <div class="image-container">
                    <label for="banner" class="signup-label">Banner</label>
                    <input type="file" name="banner" id="banner" accept="image/*" onchange="displayImage(this)">
                    <div class="custom-upload" onclick="document.getElementById('banner').click()">
                        Choose Image
                    </div>
                    <img id="previewImage" src="#" alt="Preview" style="display: none;">
                </div>


            </div>

            <div id="customerFields" style="display: none;">
                <label for="address" class="signup-label">Address</label>
                <input type="text" name="address" id="address" class="signup-input" placeholder="Enter address">

                <label for="phone" class="signup-label">Phone</label>
                <input type="text" name="phoneCustomer" id="phone" class="signup-input" placeholder="Enter phone number">

                <label for="name" class="signup-label">Name</label>
                <input type="text" name="name" id="name" class="signup-input" placeholder="Enter name">

                
            </div>
            <div id="shipperFields" style="display: none;">
                <label for="shipperField1" class="signup-label">Shipper Field 1</label>
                <input type="text" name="shipperField1" id="shipperField1" class="signup-input" placeholder="Enter shipper field 1">
            </div>

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

<%@include file="includes/Footer.jsp" %>>