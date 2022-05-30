<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Souvenir</title>
</head>
<body>
<h3>Edit Souvenir</h3>
<a href="listSouvenir">List Souvenir</a>
<a href="home">back to home</a>

<jsp:useBean id="souvenir" scope="request" type="com.example.demo2.entities.Souvenir"/>
<c:if test="${not empty souvenir}">
    <form method="POST" action="editSouvenir">
        <input type="hidden" name="id" value="${souvenir.id}" />
        <table border="0">
            <tr>
                <td>id</td>
                <td style="color:red;">${souvenir.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${souvenir.name}" /></td>
            </tr>
            <tr>
                <td>Date of production</td>
                <td><input type="text" name="dateOfProduction" value="${souvenir.dateOfProduction}" /></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" value="${souvenir.price}" /></td>
            </tr>
            <tr>
                <td>Factory id</td>
                <td><input type="text" name="idFactory" value="${souvenir.factory.id}" /></td>
            </tr>
            <tr>
                <td>Factory name</td>
                <td><input type="text" name="nameFactory" value="${souvenir.factory.name}" /></td>
            </tr>
            <tr>
                <td>Factory country</td>
                <td><input type="text" name="countryFactory" value="${souvenir.factory.country}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="listSouvenir">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>
