<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.11.20
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit department</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/department/edit" method="post">
    <c:if test="${not empty currentDepartment}">

        <input type="text" id="id" name="id" value="${currentDepartment.depId}" hidden>

        <p>
            <label for="departmentName">Name</label>
            <input type="text" id="departmentName" name="name" value="${currentDepartment.depName}">
        </p>
        <p>
            <label for="departmentCity">City</label>
            <input type="text" id="departmentCity" name="city" value="${currentDepartment.depCity}">
        </p>
        <p>
            <label for="departmentBuilding">Building</label>
            <input type="text" id="departmentBuilding" name="building" value="${currentDepartment.depBuilding}">
        </p>
        <p>
            <label for="departmentStreet">Street</label>
            <input type="text" id="departmentStreet" name="street" value="${currentDepartment.depStreet}">
        </p>
        <p>
            <label for="departmentIndex">Index</label>
            <input type="text" id="departmentIndex" name="index" value="${currentDepartment.depIndex}">
        </p>
        <button type="submit">Save</button>

    </c:if>
    <c:if test="${empty currentDepartment}">
        <p>Unfortunately, we don't have such department</p>
    </c:if>

</form>
</body>
</html>
