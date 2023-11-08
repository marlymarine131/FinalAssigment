<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/Header.jsp" %>

<section class="shoping-cart spad">
    <div class="container">
        <form action="addOrder" method="post">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Subtotal</th>
                                    <th>image</th>
                                    <th>action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cartItem" items="${listFoods}" varStatus="status">
                                    <tr>
                                        <td>${cartItem.foodName}</td>
                                        <td data-price="${cartItem.price}">${cartItem.price} $</td>
                                        <td>
                                            <div class="quantity">
                                                <input type="number" name="quantity${status.index}"class="quantity-input" data-index="${status.index}" value="0" min="1" />
                                            </div>
                                        </td>
                                        <td class="subtotal" data-subtotal="${status.index}">${cartItem.price} $</td>
                                        <td>
                                            <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(cartItem.imagine)}" alt="" width="394" height="255"/>
                                        </td>

                                    </tr>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>               
                        <ul>
                            <li>Total <span id="total">$0.00</span></li>
                        </ul>
                        <button type="submit" class="primary-btn">PROCEED TO CHECKOUT</button>
                    </div>
                </div>
            </div>
        </form>

    </div>
</section>
<script>
    $(document).ready(function () {
        // S? ki?n khi s? l??ng thay ??i
        $('.quantity-input').on('input', function () {
            updateSubtotal($(this));
            updateCart(); // G?i hàm updateCart sau khi s? l??ng thay ??i
        });

        // S? ki?n khi ?n nút "Update Cart"
        $('.cart-btn-right').on('click', function () {
            updateCart();
        });

        // G?i hàm updateCart khi trang web ???c t?i
        updateCart();
    });

    function updateSubtotal(input) {
        var quantity = parseInt(input.val());
        var price = parseFloat(input.closest('tr').find('td[data-price]').data('price'));
        var subtotal = quantity * price;

        input.closest('tr').find('.subtotal').text(subtotal.toFixed(2) + ' $');
    }

    function updateCart() {
        var total = 0;

        // Tính toán t?ng s? ti?n
        $('.quantity-input').each(function () {
            var quantity = parseInt($(this).val());
            var price = parseFloat($(this).closest('tr').find('td[data-price]').data('price'));
            var subtotal = quantity * price;

            $(this).closest('tr').find('.subtotal-value').text(subtotal.toFixed(2));
            total += subtotal;
        });

        // C?p nh?t t?ng ti?n
        $('#total').text(total.toFixed(2) + ' $');
    }

    function applyCoupon() {
        // Add logic to apply coupon code if needed
    }
</script>

<%@include file="includes/Footer.jsp" %>
