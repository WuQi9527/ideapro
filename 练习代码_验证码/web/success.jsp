<%--
  Created by IntelliJ IDEA.
  User: WuQi
  Date: 2018/11/9
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("user")%>欢迎!</h1>
</body>
</html>
