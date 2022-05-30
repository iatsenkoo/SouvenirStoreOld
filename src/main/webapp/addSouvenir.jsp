<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding Souvenir</title>
</head>
<body>
<a href="listSouvenir">List Souvenir</a>
<a href="home">back to home</a>
<form method="post">
    <label>Id:
        <input type="text" name="id"><br />
    </label>
    <label>Name:
        <input type="text" name="name"><br />
    </label>

    <label>Prodaction date:
        <input type="text" name="dateOfProduction"><br />
    </label>

    <label>Price:
        <input type="text" name="price"><br />
    </label>
    <label>Factory id:
        <input type="text" name="idFactory"><br />
    </label>
    <label>Factory name:
        <input type="text" name="nameFactory"><br />
    </label>
    <label>Factory country:
        <input type="text" name="countryFactory"><br />
    </label>
    <button type="submit">Submit</button>
</form>
</body>
</html>
