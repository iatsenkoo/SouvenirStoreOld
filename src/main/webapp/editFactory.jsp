<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Factory</title>
</head>
<body>
<h3>Edit Factory</h3>
<a href="listFactory">List Factory</a>
<a href="home">back to home</a>

<c:if test="${not empty factory}">
    <form method="POST" action="editFactory">
        <input type="hidden" name="id" value="${factory.id}" />
        <table border="0">
            <tr>
                <td>id</td>
                <td style="color:red;">${factory.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${factory.name}" /></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" name="country" value="${factory.country}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="listFactory">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>
