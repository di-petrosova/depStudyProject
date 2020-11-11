<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.11.20
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create department</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/department/create" method="post">
    <p>
        <label for="id">Id</label>
        <input type="text" id="id" name="id">
    </p>
    <p>
        <label for="departmentName">Name</label>
        <input type="text" id="departmentName" name="name">
    </p>
    <p>
        <label for="departmentCity">City</label>
        <input type="text" id="departmentCity" name="city">
    </p>
    <p>
        <label for="departmentBuilding">Building</label>
        <input type="text" id="departmentBuilding" name="building">
    </p>
    <p>
        <label for="departmentStreet">Street</label>
        <input type="text" id="departmentStreet" name="street">
    </p>
    <p>
        <label for="departmentIndex">Index</label>
        <input type="text" id="departmentIndex" name="index">
    </p>
    <button type="submit">Create department</button>
</form>

</body>
</html>
