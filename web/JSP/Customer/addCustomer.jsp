<%--
  Created by IntelliJ IDEA.
  User: craig
  Date: 30/10/2017
  Time: 14:51
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
</nav>

<div class="container">
    <div class="jumbotron">
        <div class="container" img="pallets.jpg">
        <h2>DE Stores</h2>
        <h3>Store Stock Management</h3>
        <h2>Create a new customer profile</h2>
    </div>
</div>
<br>
<div class="container">
 <form action="/customer" method="post" role="form" data-toggle="validator">
     <input type="hidden" id="action" name="action" value="addCustomer">
     <h1>Add New Customer</h1>
     <div class="form-group">
         <label class="control-label">Firstname</label>
         <input type="text" name="firstNameYo" id="firstNameYo" class="form-control" required="true">
         <br>
         <label class="control-label">Surname</label>
         <input type="text" name="surnameYo" id="surnameYo" class="form-control" required="true">
         <br>
         <label class="control-label">Email</label>
         <input type="text" name="emailYo" id="emailYo" class="form-control" required="true">
         <br>
         <label class="control-label">Credit Limit</label>
         <input type="text" name="creditYo" id="creditYo" class="form-control" required="true">
         <br>
         <br>
         <button type="submit" class="btn btn-primary btn-md">Add</button>
     </div>
 </form>
</div>
</body>
</html>
