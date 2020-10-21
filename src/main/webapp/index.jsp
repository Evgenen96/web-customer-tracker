<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 14.10.2020
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% response.sendRedirect("customer/list"); %>--%>
<html>
<head>
    <title>cofeok.ru</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/style.css"/>
</head>
<body>
<h2>Web Customer Tracker</h2>
<hr>
<a href="${pageContext.request.contextPath}customer/list">Spring MVC view</a>
<hr>
<h3>REST API:</h3>
<ul>
    <li><a href="${pageContext.request.contextPath}/api/customers">customers list</a></li>
    <li>To retrieve a single customer append a customerId to previous address</li>
    <li>To add a single customer use POST method and provide appropriate JSON</li>
    <li>To update a single customer use PUT method and provide appropriate JSON</li>
    <li>To update a single customer use DELETE method and append customerId to /api/customers/</li>
</ul>
</body>
</html>
