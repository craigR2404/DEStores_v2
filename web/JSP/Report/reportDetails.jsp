<%--
  Created by IntelliJ IDEA.
  User: craig
  Date: 17/11/2017
  Time: 11:47
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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js">
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
                background: #000 url("../../pallets.jpg") center center;
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
        <h3 class="panel-title">Current Reports</h3>
    </div>
    <div class="panel-body">
    </div>
<div class="col-md-6" style="height: 500px">
<div class="chartContainer">
<script type="text/javascript">
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light1", // "light2", "dark1", "dark2"
            animationEnabled: false, // change to true
            title:{
                text: "Current Stock Levels"
            },
            data: [
                {
                    // Change type to "bar", "area", "spline", "pie",etc.
                    type: "spline",
                    dataPoints: [
                        { label: "Mk Logic Sockets",  y: 200  },
                        { label: "Crabtree 17th Edition Fuseboard", y: 150  },
                        { label: "Box of Screws", y: 500  },
                        { label: "2.5mm T+E Cable",  y: 200  },
                        { label: "1.5mm T+E Cable",  y: 150  }
                    ]
                }
            ]
        });
        chart.render();

    }
</script>


<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"> </script>
</div>
</div>
    <div class="col-md-6">
        <form action="/product" method="post" id="productForm" role="form">
            <input type="hidden" id="idProduct" name="idProduct">
            <input type="hidden" id="action" name="action">
            <c:choose>
                <c:when test="${not empty productList}">
                    <table class="table table-striped table-hover">
                        <thread>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Stock</th>
                                <th>Price</th>
                                <th>Promotion</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thread>
                        <c:forEach var="product" items="${productList}">
                            <c:set var="classSuccess" value=""/>
                            <c:if test="${idProduct == product.id}">
                                <c:set var="classSuccess" value="info"/>
                            </c:if>
                            <tr class="${classSuccess}">
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.stockLevel}</td>
                                <td>${product.price}</td>
                                <td>${product.promotion}</td>
                                <td><a href="/product?idProduct=${product.id}&searchAction=editProduct">Edit</a></td>
                                <td></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <br/>
                    <br/>
                    <div class="alert alert-info">
                        No Products match your search
                    </div>
                </c:otherwise>
            </c:choose>
        </form>
    </div>

    </div>
</div>
</body>
</html>
