
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action='<%=response.encodeURL("/cookie/ls") %>' method="post">
    用户名：<input type="text" name="name"/><br/><%--超链接的url中的？后面的参数和参数值以及
    表单标签中的name和value值相当于requese.setParameter(设置参数)--%>
    <input type="password" name="psw">
    <input type="submit" value="提交">

</form>
</body>
</html>
