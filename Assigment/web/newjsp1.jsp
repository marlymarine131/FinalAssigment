<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Increment/Decrement Input Value</title>
</head>
<body>

    <form>
        <% 
            // Lấy giá trị hiện tại của biến count từ session
            Integer count = (Integer) session.getAttribute("count");
            if (count == null) {
                count = 0;
            }
        %>

        <!-- Tạo ô nhập và hiển thị giá trị hiện tại -->
        <input type="text" id="countInput" name="countInput" value="<%= count %>" readonly>

        <!-- Tạo nút tăng giá trị và sử dụng JavaScript để thay đổi giá trị -->
        <input type="button" value="Tăng" onclick="changeValue(1)">

        <!-- Tạo nút giảm giá trị và sử dụng JavaScript để thay đổi giá trị -->
        <input type="button" value="Giảm" onclick="changeValue(-1)">

        <script>
            function changeValue(delta) {
                // Lấy giá trị hiện tại từ ô nhập
                var currentValue = parseInt(document.getElementById('countInput').value);

                // Thay đổi giá trị theo delta
                var newValue = currentValue + delta;

                // Đảm bảo giá trị không nhỏ hơn 0
                newValue = Math.max(newValue, 0);

                // Gán giá trị mới vào ô nhập
                document.getElementById('countInput').value = newValue;
            }
        </script>
    </form>

</body>
</html>
