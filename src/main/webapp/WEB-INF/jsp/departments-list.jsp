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
<p>Request URL : ${pageContext.request.getRequestURL()}</p>
<p>Request URI : ${pageContext.request.getRequestURI()}</p>
<p>Request URI : ${pageContext.request.getAttribute("javax.servlet.forward.request_uri")}</p>

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
            <td>
                <form action="${pageContext.request.contextPath}/department" method="post">
                    <input name="idToRemove" type="text" value="${department.depId}" hidden>
                    <button type="submit">Remove</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/department/edit" method="get">
                    <input name="idToEdit" type="text" value="${department.depId}" hidden>
                    <button type="submit">Edit</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/department/create" method="get">
                <button type="submit">Create department</button>
            </form>
<%--            <a href="${pageContext.request.contextPath}/department/create">Create department</a>--%>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
