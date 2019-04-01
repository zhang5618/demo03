<%--
  Created by IntelliJ IDEA.
  User: 宙哥哥
  Date: 2019/1/8
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String user = (String)session.getAttribute("user1");%>
<h1><%=user %>,登陆成功,这是login2页面</h1>


</body>
</html>
