<%--
  Created by IntelliJ IDEA.
  User: craig
  Date: 15/11/2017
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
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
        <h2>Create a new customer profile</h2>
    </div>
</div>

<div class="col-md-6">
    <div class="container">

<div class="container">
        <form action="/loyalty" method="post" role="form" data-toggle="validator">
            <input type="hidden" id="action" name="action" value="editLoyalty">
            <input type="hidden" id="idCard" name="idCard" value="${loyalty.cardnumber}">
            <h1>Edit Card</h1>
            <div class="form-group">
                <label class="control-label">Discount</label>
                <input type="text" name="discountYo" id="discountYo" value="${loyalty.extraDiscount}" class="form-control" required="true">
                <br>
                <div class="button">
                    <button type="submit" class="btn btn-primary btn-md">Edit</button>
                </div>

            </div>
        </form>
    </div>
</div>
</div>

</body>
</html>
