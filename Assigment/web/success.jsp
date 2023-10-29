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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<<<<<<< HEAD
        <h1>Chúc Mừng chú</h1>
=======
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
            
>>>>>>> 54393f68c438b9b0a3cfc0a995ac126ec9a9d20e
    </body>
</html>
