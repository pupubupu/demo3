<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/6/30
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form border="1" action="${pageContext.request.contextPath}/user/save9" method="post"
          style="width: 50%; margin-left: 25%">
        <fieldset>
            <legend align="center">登录</legend>
            <table border="0" cellspacing="" cellpadding="" align="center">
                <tr>
                    <td><label>用户名：</label></td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td><label>密码：</label></td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><label>日期</label></td>
                    <td><input type="date" name="date"/></td>
                </tr>
            </table>
            <p align="center"><input type="submit" value="提交"/></p>
        </fieldset>

    </form>
</body>
</html>
