<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/7/5
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        var userList = new Array()
        userList.push({username:"zhangsan",password:"01234",date:"2019-12-13"})
        userList.push({username:"lisi",password:"56789",date:"2020-14-15"})
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/save10",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
