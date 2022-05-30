<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello in Souvenir store!" %>
</h1>
<br/>
<a href="listFactory">List Factory</a>
<a href="listSouvenir">List Souvenir</a>
<form method="POST" action="listSouvenir">
    <table>
        <tr>
            <td>Вывести информацию о сувенирах заданного производителя.</td>
            <td><input type="text" name="nameFactory" value="" /></td>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
<form method="POST" action="listSouvenir">
    <table>
        <tr>
            <td>Вывести информацию о сувенирах, произведенных в заданной стране.</td>
            <td><input type="text" name="nameCountry" value="" /></td>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
<form method="POST" action="listFactory">
    <table>
        <tr>
            <td>Вывести информацию о производителях, чьи цены на сувениры меньше заданной.</td>
            <td><input type="text" name="price" value="" /></td>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
<form method="POST" action="listFactory">
    <table>
        <tr>
            <td>Вывести информацию о производителях заданного сувенира, произведенного в заданном году.</td>
            <td><input type="text" name="nameSouvenir" value="" /></td>
            <td><input type="text" name="year" value="" /></td>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>