<%--
  Created by IntelliJ IDEA.
  User: WuQi
  Date: 2018/11/10
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <div>${user.name},欢迎您!</div>
 <div style="text-align: center;font-size: 25px" >

  <a href="${pageContext.request.contextPath}/userListServlet">查询所有用户信息!</a>
 </div>
  </body>
</html>
