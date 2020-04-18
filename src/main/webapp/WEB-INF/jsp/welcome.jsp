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


<c:choose>
    <c:when test="${mode=='MODE_HOME' }">
        <div class="container" id="homediv">
            <div class="jumbotron text-center">
                <h1>Welcome to The Store</h1>
            </div>
        </div>

    </c:when>

    <c:when test="${mode=='MODE_REGISTER' }">
        <div role="navigation">
            <div class="navbar navbar-inverse">
                <a href="/welcome" class="navbar-brand">SP Store</a>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/login">Login</a></li>
                        <li><a href="/register">New Registration</a></li>
                        <li><a href="/show-users">All Users</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="container text-center">
            <h3>New Registration</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="addCustomer">
                <input type="hidden" name="id" value="${user.id }"/>
                <div class="form-group">
                    <label class="control-label col-md-3">Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="name"
                               value="${user.name }"/>
                    </div>
                </div>
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
                <div class="form-group">
                    <label class="control-label col-md-3">Address </label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" name="address"
                               value="${user.address }"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Payment Type</label>
                    <div class="col-md-7">
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
                        <th>Buy</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="stockItem" items="${Items }">
                        <tr>
                            <td>${stockItem.title }</td>
                            <td>${stockItem.manufacturer }</td>
                            <td>${stockItem.category }</td>
                            <td> <img src=${stockItem.image }.jpg > </td>
                            <td>${stockItem.price }</td>
                            <td><a href="/buy-item?id=${stockItem.id }"><span>
                                <input type="submit" class="btn btn-primary" value="Buy"/>></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>

</c:choose>

</body>
</html>