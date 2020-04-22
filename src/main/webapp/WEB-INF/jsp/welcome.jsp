<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
    <title>Store | home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/show-stock">Health Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/login">Login</a>
            <a class="nav-item nav-link" href="/register">Register</a>
            <a class="nav-item nav-link " href="/show-stock">View Store</a>
            <a class="nav-item nav-link " href="/add-stock">Add New Product</a>


        </div>
    </div>
</nav>

<c:choose>
    <c:when test="${mode=='MODE_HOME' }">
        <div class="container" id="homediv">
            <div class="jumbotron text-center">
                <h1>Welcome to The Store</h1>
            </div>
        </div>

    </c:when>


    <c:when test="${mode=='MODE_ADD_Product' }">


        <div class="container text-center">
            <h3>Add Product</h3>
            <hr>
            <form method="POST" action="/add-stock">
                <input type="hidden" name="id" value="${stockItem.id }"/>
                <div class="form-group">
                    <label class="control-label col-md-3">Title</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control" name="Title"
                               value="${stockItem.title }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Manufacturer</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control" name="manufacturer"
                               value="${stockItem.manufacturer }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-12">Category</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control" name="category"
                               value="${stockItem.category }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">image </label>
                    <div class="col-md-12">
                        <input type="text" class="form-control" name="image"
                               value="${stockItem.image }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Price</label>
                    <div class="col-md-12">
                        <input type="number" class="form-control" name="price"
                               value="${stockItem.price }"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">Quantity</label>
                        <div class="col-md-12">
                            <input type="number" class="form-control" name="quantity"
                                   value="${stockItem.quantity }"/>
                        </div>
                    </div>

                </div>
                <div class="form-group ">
                    <input type="submit" class="btn btn-primary" value="Add Product"/>
                </div>
            </form>
        </div>

    </c:when>


    <c:when test="${mode=='MODE_REGISTER' }">

        <div class="container text-center">
            <h3>Register</h3>
            <hr>
            <form method="POST" action="/addCustomer">
                <input type="hidden" name="id" value="${user.id }"/>
                <div class="form-group">
                    <label class="control-label col-md-3">Name</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control" name="name"
                               value="${user.name }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Username</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control" name="username"
                               value="${user.username }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-12">Password</label>
                    <div class="col-md-12">
                        <input type="password" class="form-control" name="password"
                               value="${user.password }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Address </label>
                    <div class="col-md-12">
                        <input type="text" class="form-control" name="address"
                               value="${user.address }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Payment Type</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control" name="payment"
                               value="${user.payment }"/>
                    </div>
                </div>


        <div class="form-group ">
            <input type="submit" class="btn btn-primary" value="Register"/>
        </div>
        </form>
        </div>

    </c:when>


    <c:when test="${mode=='MODE_LOGIN' }">
        <div class="container text-center">
            <h3>User Login</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="/login-user">
                <c:if test="${not empty error }">
                    <div class="alert alert-danger">
                        <c:out value="${error }"></c:out>
                    </div>
                </c:if>
                <div class="form-group">
                    <label class="control-label col-md-3">Username</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="username"
                               value="${user.username }" th:text="${user.username }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Password</label>
                    <div class="col-md-7">
                        <input type="password" class="form-control" name="password"
                               value="${user.password }"/>
                    </div>
                </div>
                <div class="form-group ">
                    <input type="submit" class="btn btn-primary" value="Login"/>
                </div>
            </form>
        </div>
    </c:when>



    <c:when test="${mode=='MODE_EDIT' }">
        <div align="center">
            <h1>Edit Product</h1>
            <br />
            <form method="get" action="/stockItem/${id}" >
                <p>

                    <table border="0" cellpadding="10">
                        <tr>
                            <td>Product ID:</td>
                            <td>
                                <input type="text" th:field="{item.id }" />
                            </td>
                        </tr>
                        <tr>
                            <td>Product Name:</td>
                            <td>
                                <input type="text" th:field="*{item.title }" th:text="{stockItem.title }" />
                            </td>
                        </tr>
                        <tr>
                            <td>Manufacturer:</td>
                            <td><input type="text" th:field="{item.manufacturer }" /></td>
                        </tr>
                        <tr>
                            <td>Category:</td>
                            <td><input type="text" th:field="*{item.category }" /></td>
                        </tr>
                        <tr>
                            <td>Image:</td>
                            <td><input type="text" th:field="*{item.image }" /></td>
                        </tr>
                        <tr>
                            <td>Price:</td>
                            <td><input type="text" th:field="*{item.price }" /></td>
                        </tr>
                        <tr>
                            <td>Quantity:</td>
                            <td><input type="text" th:field="*{item.quantity}" /></td>
                        </tr>
                        <tr>
                            <td colspan="2"><button type="submit">Save</button> </td>
                        </tr>
                    </table>

                </p>

            </form>
        </div>
    </c:when>





    <c:when test="${mode=='STORE_ITEMS' }">
        <div class="container text-center" id="tasksDiv" action="/show-stock">
            <h3>Stock</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Manufacturer</th>
                        <th>Category</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Quantity</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="stockItem" items="${Items }">
                        <tr>
                            <td>${stockItem.title }</td>
                            <td>${stockItem.manufacturer }</td>
                            <td>${stockItem.category }</td>
                            <td><img src=${stockItem.image } width="50" > </td>
                            <td>${stockItem.price }</td>
                            <td>${stockItem.quantity }</td>
                            <td><a href="/cart/buy/${stockItem.id }"><span>
                                <input type="submit" class="btn btn-primary" value="Add To Cart"/></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>


    <c:when test="${mode=='STORE_ITEMS_SEARCH' }">
        <div class="container text-center" id="tasksDiv" action="/show-stock-searched/{title}">
            <h3>Stock</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Manufacturer</th>
                        <th>Category</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Quantity</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="stockItem" items="${Items }">
                        <tr>
                            <td>${stockItem.title }</td>
                            <td>${stockItem.manufacturer }</td>
                            <td>${stockItem.category }</td>
                            <td><img src=${stockItem.image } width="50" > </td>
                            <td>${stockItem.price }</td>
                            <td>${stockItem.quantity }</td>
                            <td><a href="/cart/buy/${stockItem.id }"><span>
                                <input type="submit" class="btn btn-primary" value="Add To Cart"/></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>



    <c:when test="${mode=='STORE_CART' }">
        <h3>Cart Page</h3>
        <table class="table table-striped table-bordered">
            <tr>
                <th>Option</th>
                <th>Name</th>
                <th>Photo</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Sub Total</th>
            </tr>
            <c:set var="total" value="0"></c:set>
            <c:forEach var="item" items="${sessionScope.cart }">
                <c:set var="total"
                       value="${total + item.stockItem.price * item.quantity }"></c:set>
                <tr>


                    <td align="center"><a href="/cart/remove/${item.stockItem.id }"
                                          onclick="return confirm('Are you sure?')"> <img alt="Qries"
                                                                                          src="data:image/png;base64,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"
                                                                                          width=70" height="70"></a>
                    </td>

                    <td>${item.stockItem.title }</td>
                    <td><img src="${pageContext.request.contextPath }/resources/images/${item.stockItem.image }"
                             width="50"></td>
                    <td>${item.stockItem.price }</td>
                    <td>${item.quantity }</td>
                    <td>${item.stockItem.price * item.quantity }</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6" align="right">Cart Total</td>
                <td>${total }</td>
            </tr>
        </table>
        <br>
        <a href="${pageContext.request.contextPath }/show-stock">Continue
            Shopping </a>

        <a href="${pageContext.request.contextPath }/show-stock">Checkout </a>
    </c:when>

</c:choose>

</body>
</html>