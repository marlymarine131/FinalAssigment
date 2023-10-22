<%-- 
    Document   : Header
    Created on : Oct 20, 2023, 3:29:45 PM
    Author     : oteee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <meta charset="utf-8">
        <title>Trường ĐẠI HỌC FPT </title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="styles/stylesCSS.css">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
        <script>
        function handleRoleChange() {
            var roleSelect = document.getElementById("role");
            var ownerFields = document.getElementById("ownerFields");
            var customerFields = document.getElementById("customerFields");
            var shipperFields = document.getElementById("shipperFields");

            // Ẩn tất cả các trường điều chỉnh
            ownerFields.style.display = "none";
            customerFields.style.display = "none";
            shipperFields.style.display = "none";

            // Hiển thị trường tương ứng với lựa chọn "Role"
            if (roleSelect.value === "Owner") {
                ownerFields.style.display = "block";
            } else if (roleSelect.value === "Customer") {
                customerFields.style.display = "block";
            } else if (roleSelect.value === "Shipper") {
                shipperFields.style.display = "block";
            }
        }
    </script>
    </head>
    <% request.setCharacterEncoding("UTF-8");%>
    <body>

        <header>
            <img src="images/logo.jpg" 
                 alt="Trường Đại học FPT" width="243" height="85" >
            <h1>FPT University</h1>
            <h2>Trường Đại học FPT - Cơ sở Đà Nẵng</h2>
        </header>
        <nav id="nav_bar">
            <ul>
                <li><a href="searching.jsp">
                        Searching</a></li>
                <li><a href="staff.jsp">
                        Staff</a></li>
                <li><a href="">
                        News</a></li>
            </ul>
            <%= request.getServletContext().getInitParameter("semester")%>
        </nav>
