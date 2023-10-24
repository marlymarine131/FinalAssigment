<%-- 
    Document   : success
    Created on : Oct 23, 2023, 9:33:54 PM
    Author     : Hung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getAttribute("signupSuccess") != null && (boolean)request.getAttribute("signupSuccess")){
            %>
            <div class="notification success">
                <p>Sign up successful!</p>
            </div>
            <%
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
                %>
                <%
            }
            %>
            
            <h1>Success Page</h1>
            
    </body>
</html>
