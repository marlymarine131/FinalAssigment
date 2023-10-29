<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>


<%@include file="includes/head.jsp" %>


<body>
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
                        <th>Image</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${productList}" var="o">
                        <tr>
                            <!-- Your existing table rows -->
                            <td>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                    <label for="checkbox1"></label>
                                </span>
                            </td>
                            <td>${o.shopID}</td>
                            <td>${o.shopName}</td>
                            <c:set var="base64Banner" value="${Base64.getEncoder().encodeToString(o.banner)}" />
                    <div class="row row-10 gutters-10">
                        <div class="col-12"><img src="data:image/jpeg;base64,${base64Banner}" alt="" width="394" height="255"/>
                        </div>
                    </div>
                    <td>${o.price} $</td>
                    <td>
                        <a href="loadProduct?pid=${o.shopID}" class="edit" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                        </a>
                        <a href="delete?pid=${o.shopID}" class="delete" data-toggle="modal">
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
        <a href="#"><button type="button" class="btn btn-primary">Back to home</button>
            <form action="addShopServlet" method="post">
                <div class="modal-header">						
                    <h4 class="modal-title">add shop</h4>                       
                </div>
                <div class="modal-body">					
                    <div class="form-group">
                        ${sessionScope.owner.ownerName}
                        <label>Name</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Banner</label>
                        <div class="image-container">
                            <label for="banner" class="signup-label">Banner</label>
                            <input type="file" name="banner" id="banner" accept="image/*" onchange="displayImage(this)">
                            <div class="custom-upload" onclick="document.getElementById('banner').click()">
                                chose the banner
                            </div>
                            <img id="previewImage" src="#" alt="Preview" style="display: none;">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input name="price" type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>

    </div>
    <!-- Edit Modal HTML -->
    <div id="addEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">

            </div>
        </div>
    </div>



</body>
</html>