<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:set var="uri" value="${requestScope['javax.servlet.forward.request_uri']}"></c:set>
<c:set var="edit" value="/myapp/department/edit"></c:set>
<c:set var="create" value="/myapp/department/create"></c:set>

    <c:if test="${uri eq edit}">
        <form action="${pageContext.request.contextPath}/department/edit" method="post">
    </c:if>

    <c:if test="${uri eq create}">
        <form action="${pageContext.request.contextPath}/department/create" method="post">
    </c:if>

        <input type="text" id="id" name="id" value="${currentDepartment.depId}" hidden>
        <p>
            <label for="departmentName">Name</label>

            <c:if test="${uri eq edit}"><input type="text" id="departmentName" name="name"
                                                  value="${currentDepartment.depName}"></c:if>
            <c:if test="${uri eq create}"><input type="text" id="departmentName" name="name"></c:if>
        </p>
        <p>
            <label for="departmentCity">City</label>

            <c:if test="${uri eq edit}"><input type="text" id="departmentCity" name="city"
                                                  value="${currentDepartment.depCity}"></c:if>
            <c:if test="${uri eq create}"><input type="text" id="departmentCity" name="city"></c:if>
        </p>
        <p>
            <label for="departmentBuilding">Building</label>

            <c:if test="${uri eq edit}"><input type="text" id="departmentBuilding" name="building"
                                                  value="${currentDepartment.depBuilding}"></c:if>
            <c:if test="${uri eq create}"><input type="text" id="departmentBuilding" name="building"></c:if>
        </p>
        <p>
            <label for="departmentStreet">Street</label>

            <c:if test="${uri eq edit}"><input type="text" id="departmentStreet" name="street"
                                                  value="${currentDepartment.depStreet}"></c:if>
            <c:if test="${uri eq create}"><input type="text" id="departmentStreet" name="street"></c:if>
        </p>
        <p>
            <label for="departmentIndex">Index</label>

            <c:if test="${uri eq edit}"> <input type="text" id="departmentIndex" name="index"
                                                   value="${currentDepartment.depIndex}"></c:if>
            <c:if test="${uri eq create}"><input type="text" id="departmentIndex" name="index"></c:if>
        </p>

        <c:if test="${uri eq edit}">
            <button type="submit">Save</button>

        </c:if>

        <c:if test="${uri eq create}">
        <button type="submit">Create department</button>
        </c:if>
    </form>

</body>
</html>