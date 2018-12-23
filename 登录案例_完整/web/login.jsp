<%--
  Created by IntelliJ IDEA.
  User: WuQi
  Date: 2018/11/9
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<script>window.onload=function () {
    document.getElementById("img").onclick=function () {
        this.src="/checkCodeServlet?time"+new Date().getTime();

    }

}</script>
<body>
<form action="/loginServlet" method="post">
    <table>
        <tr><td>用户名</td><td><input type="text" name="username"></td></tr>
        <tr><td>密码</td><td><input type="text" name="password"></td></tr>
        <tr><td>验证码</td><td><input type="text" name="checkCode"></td></tr>
        <tr><td colspan="2"><img src="/checkCodeServlet" alt="验证码" id="img"></td></tr>
        <tr><td colspan="2"><input type="submit" value="登录"></td></tr>
    </table>
</form>
<%=request.getAttribute("msg")==null ? "" : request.getAttribute("msg")%>

</body>
</html>
