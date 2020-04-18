<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <c:when test="${mode=='MODE_REGISTER' }">


        <div class="container text-center">
            <h3>New Registration</h3>
            <hr>
            <form method="POST" action="addCustomer">
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
                               value="${user.username }"/>
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
                            <td><img src=${stockItem.image }.jpg></td>
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
        <table cellpadding="2" cellspacing="2" border="1">
            <tr>
                <th>Option</th>
                <th>Id</th>
                <th>Name</th>
                <th>Photo</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Sub Total</th>
            </tr>
            <c:set var="total" value="0"></c:set>
            <c:forEach var="item" items="${cart }">
                <c:set var="total"
                       value="${total + item.stockItem.price * item.quantity }"></c:set>
                <tr>
                    <td align="center"><a
                            href="${pageContext.request.contextPath }/cart/remove/${item.stockItem.id }"
                            onclick="return confirm('Are you sure?')">Remove</a></td>
                    <td>${item.stockItem.id }</td>
                    <td>${item.stockItem.title }</td>
                    <td><img src="${pageContext.request.contextPath }/resources/images/${item.stockItem.image }"
                             width="50"></td>
                    <td>${item.stockItem.price }</td>
                    <td>${item.quantity }</td>
                    <td>${item.stockItem.price * item.quantity }</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6" align="right">Sum</td>
                <td>${total }</td>
            </tr>
        </table>
        <br>
        <a href="${pageContext.request.contextPath }/product">Continue
            Shopping</a>
    </c:when>

</c:choose>

</body>
</html>