
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>商品列表</h1>
<a href="/goods?name=ThinkPad">ThinkPad</a><br/>
<a href="/goods?name=Lenovo">Lenovo</a><br/>
<a href="/goods?name=Apple">Apple</a><br/>
<a href="/goods?name=HP">HP</a><br/>
<a href="/goods?name=SONY">SONY</a><br/>
<a href="/goods?name=ACER">ACER</a><br/>
<a href="/goods?name=DELL">DELL</a><br/>
<hr/>
您浏览过的商品有：
<%--<%这里面可以写java代码%>--%>
<%
    Cookie[] cs = request.getCookies();
    if(cs != null) {
        for(Cookie c : cs) {
            if(c.getName().equals("goods")) {
                out.print(c.getValue());
            }
        }
    }
%>


</body>
</html>
