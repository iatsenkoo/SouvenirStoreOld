<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.demo2.entities.Souvenir" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Souvenir list</title>
</head>
<body>
<h3>Souvenir list</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>DateOfProduction</th>
        <th>Price</th>
        <th>Factory id</th>
        <th>Factory Name</th>
        <th>Factory Country</th>
        <th>Year</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <%
        List<Souvenir> souvenirs = (List<Souvenir>)request.getAttribute("souvenirList");
    if(souvenirs != null && !souvenirs.isEmpty()) {
    for (Souvenir s:souvenirs)

        {%>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getDateOfProduction() %></td>
        <td><%= s.getPrice() %></td>
        <td><%= s.getFactory().getId() %></td>
        <td><%= s.getFactory().getName() %></td>
        <td><%= s.getFactory().getCountry() %></td>
        <td>
            <a href="listSouvenir?year=<%= s.getDateOfProduction().getYear() %>"><%= s.getDateOfProduction().getYear() %></a>
        </td>
        <td>
            <a href="editSouvenir?id=<%= s.getId() %>">Edit</a>
        </td>
        <td>
            <a href="deleteSouvenir?id=<%= s.getId() %>">Delete</a>
        </td>
    </tr>
    <%}}%>

</table>

<a href="addSouvenir">add souvenir</a>
<a href="home">back to home</a>

</body>
</html>
