<%--
  Created by IntelliJ IDEA.
  User: craig
  Date: 15/11/2017
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
            <li><a href="#">Help?</a></li>
        </ul>
    </div>
    </div>
    </nav>
    <title>New World Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/superhero/bootstrap.min.css" rel="stylesheet" integrity="sha384-Xqcy5ttufkC3rBa8EdiAyA1VgOGrmel2Y+wxm4K3kI3fcjTWlDWrlnxyD6hOi3PF" crossorigin="anonymous">
</head>
<body>


<div class="container">
    <div class="panel panel-success"></div>
    <div class="panel-heading">
        <h2 class="panel-title" style="background: darkorange">New Customer Order</h2>
    </div>
    <div class="panel-body">
    <form action="/order" method="post" role="form" data-toggle="validator">
        <input type="hidden" id="action" name="action" value="add">

        <h2>Create New Order</h2>
        <div class="container">
            <select name="customer" style="color: black">
            <c:forEach var="customer" items="${customerList}">
                <option value="${customer.id}">${customer.nameYo}</option>
            </c:forEach>
            </select>
            <br>
            <br>
            <select name="product" style="color: black">
                <c:forEach var="product" items="${proddyList}">
                    <option value="${product.id}">${product.name}</option>
                </c:forEach>
            </select>
            <br>
            <label class="control-label" style="float: left">Quantity</label>
            <input type="number" value="quantity" name="quantity" class="form-control" min="0">
            <br>
            <label for="freedelivery" class="control-label" style="float: left">Check box for free delivery</label>
            <p>
            <input type="checkbox"  name="freedelivery" id="freedelivery" value="freedelivery" checked="checked">
            </p>
            <br>
        </div>
        <button type="submit" class="btn btn-primary btn-md">Accept</button>
    </form>
</div>
</div>



</body>
</html>
