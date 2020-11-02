<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.10.20
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
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
<p>
    Hello world!
</p>
</body>
</html>
