<%--
  Created by IntelliJ IDEA.
  User: 宙哥哥
  Date: 2019/1/7
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册窗口</title>
</head>
<body>
<h1>注册页面</h1>
<form action="/cookie/es" method="post">
    用户名：<input type="text" name="username"/><br/>
    验证码：<input type="text" name="code" size="3"/>
    密　码：<input type="password" name="password"/><br/>
    <img id="vCode" src="/js"/>
    <a href="javascript:changeImgSrc()">看不清，换一张</a>
    <br/>
    <input type="submit" value="注册"/>

</form>
</body>
<script type="text/javascript">
    function changeImgSrc() {
        document.getElementById("vCode").src="/js?"+new Date().toString();
    }
</script>
</html>
