<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Test</title>

</head>
<body>
<p>ContextPath : ${pageContext.request.contextPath}</p>
<p>Request : ${pageContext.request}</p>
<p>ServletPath : ${pageContext.request.servletPath}</p>
<p>Protocol : ${pageContext.request.protocol}</p>
<p>PathInfo : ${pageContext.request.pathInfo}</p>

<table>
    <thead>
    <tr>
        <th>
            Department Id
        </th>
        <th>
            Name
        </th>
        <th>
            City
        </th>
        <th>
            Building
        </th>
        <th>
            Street
        </th>
        <th>
            Index
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>${department.depId}</td>
            <td>${department.depName}</td>
            <td>${department.depCity}</td>
            <td>${department.depBuilding}</td>
            <td>${department.depStreet}</td>
            <td>${department.depIndex}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
