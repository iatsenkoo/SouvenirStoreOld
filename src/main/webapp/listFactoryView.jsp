<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.demo2.entities.Factory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Factory list</title>
</head>
<body>
<h3>Factory list</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Country</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Souvenirs</th>

    </tr>

    <c:forEach items="${factoryList}" var="factories" >
        <tr>
            <td>${factories.id}</td>
            <td>${factories.name}</td>
            <td>${factories.country}</td>
            <td>
                <a href="editFactory?id=${factories.id}">Edit</a>
            </td>
            <td>
                <a href="deleteFactory?id=${factories.id}">Delete</a>
            </td>
            <td>
                <a href="listSouvenir?idFactory=${factories.id}">Souvenirs</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="addFactory">add factory</a>
<a href="home">back to home</a>

</body>
</html>
