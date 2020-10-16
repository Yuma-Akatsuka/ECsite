<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String error1 = (String)request.getAttribute("error1"); %>
    <% String error2 = (String)request.getAttribute("error2"); %>
  	<%if(error1!= null){ %>
  	<%= error1 %>
  	<% } %>
    <%if(error2!= null){%>
    <%= error2 %>
    <% } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>

</head>



<form action = "/ECsite/login" method ="POST">
<h1>ログイン</h1>
<p>名前</p><input type="text" name="name">
<p>パスワード</p><input type="password" name="password"><br>
<input type ="submit" value ="LOGIN">
</form>
<form action ="/view/Cart.jsp" method ="GET">
	<input type ="submit" value = アカウント作成>
	</form>
</body>
</html>