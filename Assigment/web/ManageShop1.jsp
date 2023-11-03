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
                        <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                        <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>
                            <span class="custom-checkbox">
                                <input type="checkbox" id="selectAll">
                                <label for="selectAll"></label>
                            </span>
                        </th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listFoods}" var="food">
                        <tr>
                            <td>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="checkbox1" name="options[]" value="${food.foodID}">
                                    <label for="checkbox1"></label>
                                </span>
                            </td>
                            <td>${food.foodID}</td>
                            <td>${food.foodName}</td>
                            <c:set var="base64Banner" value="${Base64.getEncoder().encodeToString(food.imagine)}" />
                            <td>
                                <img src="data:image/jpeg;base64,${base64Banner}" alt="" width="394" height="255"/>
                            </td>
                            <td>${food.price} $</td>
                            <td>
                                <a href="loadFood?foodID=${food.foodID}" class="edit" data-toggle="modal">
                                    <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                                </a>
                                <a href="deleteFood?foodID=${food.foodID}" class="delete" data-toggle="modal">
                                    <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                    <c:forEach var="cartItem" items="${listFoods}">
                        <tr>
                            <td>${cartItem.foodID}</td>
                            <td>${cartItem.cartID}</td>
                            <td>${cartItem.cusID} $</td> 
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

    </div>
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
            <form action="addFood" enctype="multipart/form-data" method="post">
                <div class="modal-header">						
                    <h4 class="modal-title">Add Food</h4>                       
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Food Name</label>
                        <input name="foodName" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input name="description" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input name="price" type="text" clas    s="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Imagine</label>
                        <div class="image-container">
                            <label for="imagine" class="signup-label">image</label>
                            <input type="file" name="imagine" id="banner" accept="image/*" onchange="displayImage(this)">
                            <div class="custom-upload" onclick="document.getElementById('banner').click()">
                                Choose the image
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