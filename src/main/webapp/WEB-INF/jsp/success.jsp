<%--
  Created by IntelliJ IDEA.
  User: pyj
  Date: 2022/6/29
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>
<body>
    <h1>${success}</h1>
    <form method="post" name="表单" action="${pageContext.request.contextPath}/user/save5">
        <input type="submit" name="点我">
    </form>
</body>
</html>
