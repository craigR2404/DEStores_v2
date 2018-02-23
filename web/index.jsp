<%--
  Created by IntelliJ IDEA.
  User: craig
  Date: 29/10/2017
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


  <title>$Title$</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/superhero/bootstrap.min.css" rel="stylesheet" integrity="sha384-Xqcy5ttufkC3rBa8EdiAyA1VgOGrmel2Y+wxm4K3kI3fcjTWlDWrlnxyD6hOi3PF" crossorigin="anonymous">
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="../../index.jsp">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="/customer">Customers</a></li>
        <li><a href="/product">Products</a></li>
          <li><a href="/order">Order</a> </li>
          <li><a href="/product?idProduct=999&searchAction=reportAction">Reports</a> </li>
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
</head>
<body>
<div class="container" img="pallets.jpg">
  <div class="jumbotron">
      <style>
          .jumbotron h1{
              color: white;
              align-items: center;
          }
          .jumbotron h3{
              color: white;
              align-items: center;

          }
          .jumbotron {
              position: relative;
              background: #000 url("pallets.jpg") center center;
              width: 100%;
              height: 30%;
              opacity: 30;
              background-size: cover;
              overflow: hidden;
          }
      </style>
    <br>
    <br>
    <h1>DE Stores</h1>
    <h3>Store Stock Management</h3>
  </div>
</div>

<br>
<br>
<div class="container">

    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">Please select an option from below</h3>
        </div>
  <div class="panel-body">
      <div class="col-md-3">
          <a href="/customer" style="float: left">
              <img src="customer4.png" alt="HTML tutorial" style="width:200px;height:200px;border:0;">
          </a>
      </div>
      <div class="col-md-3">
          <a href="/product" style="float: left">
              <img src="product.png" alt="HTML tutorial" style="width:200px;height:200px;border:0;">
          </a>
      </div>
      <div class="col-md-3">
              <a href="/order" style="float: left">
                  <img src="order.png" alt="HTML tutorial" style="width:200px;height:200px;border:0;">
              </a>
      </div>
      <div class="col-md-3">
          <a href="/product?idProduct=999&searchAction=reportAction" style="horiz-align: left">
              <img src="report.png" alt="HTML tutorial" style="width: 200px;height: 200px;border: 0;">
          </a>
      </div>
      </div>
  </div>
</div>
</body>
</html>
