<%--
  Created by IntelliJ IDEA.
  User: WuQi
  Date: 2018/12/15
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        <%--$(function () {--%>
        <%--${"#btn"}.--%>
        <%--click(function () {--%>
            <%--$.ajax({--%>
                <%--url: "user/testAjax",--%>
                <%--contentType: "application/json;charset=UTF-8",--%>
                <%--data: '{"username":"hehe","password":"123","age":30}',--%>
                <%--dataType: "json",--%>
                <%--Type: "post",--%>
                <%--success: function (data) {--%>
                    <%--alert(data)--%>
                    <%--alert(data.username)--%>
                    <%--alert(data.password)--%>
                    <%--alert(data.age)--%>
                <%--}--%>
            <%--});--%>
        <%--});--%>

    <%--});--%>
        $(function(){
            $("#btn").click(function(){
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });

            });
        });
    </script>
</head>
<body>
<a href="user/testString">testString</a><br>
<a href="user/testVoid">testVoid</a><br>
<a href="user/testModelAndView">testModelAndView</a><br>
<a href="user/testForwardOrRedirect">testForWardOrRedirect</a><br>
<button id="btn">发送ajax请求</button>
</body>
</html>
