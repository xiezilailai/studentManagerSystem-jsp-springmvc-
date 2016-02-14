<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<jsp:include page="islogin.jsp"></jsp:include>
main
<a href="/input">录入学生信息</a><br>
<a href="/display">查看学生信息</a><br>
<a href="/modify">修改学生信息</a><br>
<a href="/delete">删除学生信息</a><br>
<a href="/exit" target="_top">退出</a><br>
</body>
</html>