<%-- 
    Document   : head
    Created on : Oct 24, 2023, 3:54:09 PM
    Author     : oteee
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Base64" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ogani | Template</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">

        <!-- Additional Stylesheets -->
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Poppins:300,400,500">
        <link rel="stylesheet" href="styles/stylesCSS.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="css1/bootstrap.css">
        <link rel="stylesheet" href="css1/fonts.css">
        <link rel="stylesheet" href="css1/style.css">
        <link rel="stylesheet" href="css1/stylesCSS.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

        <link href="css1/manager.css" rel="stylesheet" type="text/css"/>
        <link href="css1/style_1.css" rel="stylesheet" type="text/css"/>
        <script>
            $(document).ready(function () {
                // Sự kiện khi số lượng thay đổi
                $('.quantity-input').on('input', function () {
                    updateSubtotal($(this));
                });

                // Sự kiện khi ấn nút "Update Cart"
                $('.cart-btn-right').on('click', function () {
                    updateCart();
                });
            });

            function updateSubtotal(input) {
                var quantity = parseInt(input.val());
                var price = parseFloat(input.closest('tr').find('td[data-price]').data('price'));
                var subtotal = quantity * price;

                input.closest('tr').find('.subtotal').text(subtotal.toFixed(2) + ' $');
            }

            function updateCart() {
                var total = 0;

                // Tính toán tổng số tiền
                $('.quantity-input').each(function () {
                    var quantity = parseInt($(this).val());
                    var price = parseFloat($(this).closest('tr').find('td[data-price]').data('price'));
                    var subtotal = quantity * price;

                    $(this).closest('tr').find('.subtotal').text(subtotal.toFixed(2) + ' $');
                    total += subtotal;
                });

                // Cập nhật tổng tiền
                $('#subtotal span').text(total.toFixed(2) + ' $');
                $('#total').text(total.toFixed(2) + ' $');
            }

            function applyCoupon() {
                // Add logic to apply coupon code if needed
            }
        </script>

        <style>
            img {
                width: 200px;
                height: 120px;
            }
        </style>
    </head>


    <html class="wide wow-animation" lang="en">
        <body>
