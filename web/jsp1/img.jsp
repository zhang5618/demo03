<%--
  Created by IntelliJ IDEA.
  User: 宙哥哥
  Date: 2019/1/9
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--src 是img的属性  搜索访问的位置  是get请求--%>
<img src="/cookie/js" alt="图形验证码" id="img"><%--改变src属性，触发onchange事件（重新发送请求）   get请求--%>
<%--超链接的形式执行js函数  改变img标签的src属性  达到点击就更换图片--%>
<a href="javascript:changeImgSrc()">看不清，换一张</a>

</body>
<script type="text/javascript">
    function changeImgSrc() {
        /*在路径后面加上一个每时每刻都在变化的变量  才能保证函数是变化的  才能触发onchange事件  后面也可以加上Math.random().toString(32)  保证是变化的*/
        document.getElementById("img").src="/cookie/js?"+Math.random().toString(32);
    }

</script>
</html>
