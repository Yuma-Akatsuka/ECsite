<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/ECsite/css/login.css" rel="stylesheet" type="text/css">
<title>ログイン画面</title>
</head>

<body>


<form action = "/ECsite/login" method ="POST">
<div class="body"></div>

        <div class="grad"></div>

        <div class="header">

            <div>Site<span>Random</span></div>

</div>
<div class="login">
<div class ="color">
  <% String error1 = (String)request.getAttribute("error1"); %>
  <% String error2 = (String)request.getAttribute("error2"); %>
  <%if(error1!= null){ %>
  <%= error1 %>
  <% } %>
  <%if(error2!= null){%>
  <%= error2 %>
  <% } %>
  </div>
<p>NAME</p><input type="text"placeholder = "username" name="name">
<p>PASSWORD</p><input type="password" placeholder = "password" name="password"><br>
<input type ="submit" value ="LOGIN">

</form>
<form action ="/ECsite/makeaccount" method ="GET">
<input type ="submit" value = MAKEACCOUNT>
</div>
</form>

</body>
</html>