<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/superhero/bootstrap.min.css" rel="stylesheet" integrity="sha384-Xqcy5ttufkC3rBa8EdiAyA1VgOGrmel2Y+wxm4K3kI3fcjTWlDWrlnxyD6hOi3PF" crossorigin="anonymous">
<html>
<head>
    <title>NMT Customer Add</title>
</head>
<body>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
        <li class="active"><a href="../../index.jsp">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="/customer">Customers</a></li>
        <li><a href="/product">Products</a></li>
        <li><a href="/order">Order</a> </li>
        <li><a href="financeYo.jsp">Finance Portal</a> </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">More... <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
                <li class="divider"></li>
                <li><a href="#">One more separated link</a></li>
            </ul>
        </li>
    </ul>
    <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="https://stackoverflow.com">Help?</a></li>
    </ul>
</div>
</div>
<div class="container">
    <div class="jumbotron">
        <h2>DE Stores</h2>
        <h3>Store Stock Management</h3>
        <h2>Manage Stock Items</h2>
    </div>
</div>

<div class="container">


    <form action="/product" method="post" role="form" data-toggle="validator">
        <input type="hidden" id="action" name="action" value="editProductYo">
        <input type="hidden" id="idProduct" name="idProduct" value="${product.id}">
        <h1>Edit Product</h1>
        <div class="form-group">
            <label class="control-label">Product Name</label>
            <input type="text" name="name" id="name" value="${product.name}" class="form-control" required="true">
            <br>
            <label class="control-label">Stock Level</label>
            <input type="text" name="stockLevel" id="stockLevel" value="${product.stockLevel}" class="form-control" required="true">
            <br>
            <label class="control-label">Price</label>
            <input type="text" name="price" id="price" value="${product.price}" class="form-control" required="true">
            <br>
            <label class="control-label">Current Promotion</label>
            <!--<input type="text" name="promotion" id="promotion" value="${product.promotion}" class="form-control" required="true">-->
            <select name="promotion" id="promotion" style="color: black" required="true" class="form-select-button">
                <option value="none">None</option>
                <option value="freeDelivery">Free Delivery</option>
                <option value="3 for 2">3 for 2</option>
                <option value="Buy One Get One Free">Buy one get one free</option>
            </select>
            <br>
            <br>
            <button type="submit" class="btn btn-primary btn-md">Edit</button>
        </div>
    </form>
</div>
</div>
</body>
</html>