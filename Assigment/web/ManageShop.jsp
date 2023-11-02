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
                        <h2>Manage <b>Product</b></h2>
                        <c:if test="${not empty sessionScope.owner}">
                            <div class="user-info">
                                <p>Welcome, ${sessionScope.owner.ownerName}!</p>
                            </div>
                        </c:if>
                    </div>
                    <div class="col-sm-6">
                        <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                        <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th></th>

                        <th>Name</th>

                        <th>Location</th>
                        <th>banner</th>
                        <th>action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${shopList}" var="o">
                        <tr>
                            <td>${o.shopID}</td>
                            <td>${o.shopAddress}</td>

                            <td>${o.shopName}</td>
                            <td>
                                <c:set var="base64Banner" value="${Base64.getEncoder().encodeToString(o.banner)}" />
                                <div class="row row-10 gutters-10">
                                    <div class="col-12">
                                        <a href="listAllFod?shopID=${o.shopID}">
                                            <img src="data:image/jpeg;base64,${base64Banner}" alt="" width="394" height="255"/>
                                        </a>
                                    </div>
                                </div>
                            </td>
                            <td>

                                <a href="ManageFood.jsp?Shopid=${o.shopID}" class="edit">
                                    <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                                </a>
                                <a href="deleteShop?shopId=${o.shopID}" class="delete">
                                    <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
        <a href="url"><button type="button" class="btn btn-primary">Back to home</button></a>
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addNewShop" enctype="multipart/form-data" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Shop</h4>                       
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <input name="shopID" type="hidden" class="form-control" value="${sessionScope.owner.ownerID}">
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input name="Name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <input name="addressShop" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Banner</label>
                                <div class="image-container">
                                    <label for="banner" class="signup-label">Banner</label>
                                    <input type="file" name="bannerShop" id="banner" accept="image/*" onchange="displayImage(this)">
                                    <div class="custom-upload" onclick="document.getElementById('banner').click()">
                                        Choose the banner
                                    </div>
                                    <img id="previewImage" src="#" alt="Preview" style="display: none;">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>




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