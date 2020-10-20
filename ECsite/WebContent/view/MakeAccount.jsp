<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String error1 = (String)request.getAttribute("error1"); %>
    <% String error2 = (String)request.getAttribute("error2"); %>
    <% String OK = (String)request.getAttribute("OK"); %>

  	<%if(error1!= null){ %>
  	<%= error1 %>
  	<% } %>
    <%if(error2!= null){%>
    <%= error2 %>
    <% } %>
	  <%if(OK != null){%>
    <%= OK %>
    <% } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント作成画面</title>
</head>
<body>
<h1>アカウント作成</h1>
<form action = "/ECsite/makeaccount" method ="POST">
<p>名前</p><input type="text" name="name">
<p>パスワード</p><input type="text" name="password"><br>
<input type ="submit" value = 登録する>
</form>
<form action = "/ECsite/login" method ="GET">
<input type ="submit" value =ログイン画面に戻る >
</form>

</body>
</html>