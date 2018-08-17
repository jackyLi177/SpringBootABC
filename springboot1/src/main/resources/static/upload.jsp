<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<div class="file_Upload">
    <form action="upload" enctype="multipart/form-data" method="post">
        <input type="file" value="选择文件"/><br/>
        <input type="submit"/>
    </form>
</div>
</body>
</html>
