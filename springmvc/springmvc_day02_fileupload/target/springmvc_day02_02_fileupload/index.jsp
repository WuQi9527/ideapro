<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>跨服务器上传</h2>
<form action="/user/fileupload1" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="uploda"/></br>
<input type="submit" value="上传"/>
</form>
</body>
</html>
