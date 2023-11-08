<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>


<%@include file="includes/head.jsp" %>
<%@include file="includes/Header.jsp" %>
<section>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Manage <b>shop</b></h2>

                    </div>
                    <div class="col-sm-6">
                        <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
                    </div>
                </div>
            </div>
            <form action="updateShipper" enctype="multipart/form-data" method="post">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>address</th>
                            <th>phone</th>
                            <th>status</th>
                            <th>Price</th>
                            <th>shipperID</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${orderList}" var="ol" varStatus="status">
                            <tr>
                                <td>
                                    ${ol.address}
                                </td>
                                <td>
                                    ${ol.phone}
                                </td>
                                <td>${ol.status}</td>
                                <td>${ol.shopOrderPrice}</td>
                                <td><select name="shipperID${status.index}" id="shipperID" onchange="handleRoleChange()">                                     
                                        <c:forEach items="${shiperList}" var="sl">
                                            <option value="${sl.shipperID}"<c:if test="${sl.shipperID eq ol.shipperID}"> selected</c:if>>${sl.name}</option>
                                        </c:forEach>
                                    </select></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button type="submit">update order</button>
            </form>


<!--            <form action="updateShipper" method="post">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__table">
                            <table>
                                <thead>
                                    <tr>
                                        <th>address</th>
                                        <th>phone</th>
                                        <th>status</th>
                                        <th>Price</th>
                                        <th>shipperID</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orderList}" var="ol" varStatus="status">
                                        <tr>
                                            <td>
                                                ${ol.address}
                                            </td>
                                            <td>
                                                ${ol.phone}
                                            </td>
                                            <td>${ol.status}</td>
                                            <td>${ol.shopOrderPrice}</td>
                                            <td><select name="shipperID${status.index}" id="shipperID" onchange="handleRoleChange()">                                     
                                                    <c:forEach items="${shiperList}" var="sl">
                                                        <option value="${sl.shipperID}"<c:if test="${sl.shipperID eq ol.shipperID}"> selected</c:if>>${sl.name}</option>
                                                    </c:forEach>
                                                </select></td>
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
                            <button type="submit" class="primary-btn">update shipper</button>
                        </div>
                    </div>
                </div>
            </form>-->
        </div>


    </div>
    <!-- Edit Modal HTML -->
    <div id="addEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">

                </div>
            </div>
        </div>
    </div>
</section>


<%@include file="includes/Footer.jsp" %>
