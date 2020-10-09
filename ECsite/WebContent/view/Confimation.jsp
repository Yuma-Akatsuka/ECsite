<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.CartBean"
    import = "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
</head>
<body>
<h1>購入してよろしいですか？？？</h1>
<% ArrayList<CartBean> cartlist = (ArrayList<CartBean>)session.getAttribute("productbean"); %>
<% CartBean cartbe = new CartBean(); %>
<table border="1" style="border-collapse: collapse">
  <tr><td>商品名</td>
    <td>単価</td>
    <td>数量</td>
    </tr>

	<%int price=0;%>
  	<% for(int i=0;i < cartlist.size();i++){
    cartbe = cartlist.get(i); %>
    <tr><td><%=cartbe.getName()%></td>
    <td><%=cartbe.getPrice()%></td>
    <td><%=cartbe.getCount()%></td></tr>
	<%price= price+cartbe.getPrice() * cartbe.getCount();%>
    <% } %>


  	<%int tax = 10;%>
  	<%int tax2 = Math.round((price * tax) / 100);%>
  	<%int total =price + tax2;   %>
  	 <tr><td colspan = "2">消費税</td>
  	 <td><%= tax2 %></td></tr>
 	 <tr><td colspan = "2">合計</td>
 	 <td><%=total%></td>

 	<form action = method ="POST">
	<input type ="submit" value = はい>
	</form>
	<form action ="/ECsite/back" method ="POST">
	<input type ="submit" value = いいえ>
	</form>


    </tr></table>


</body>
</html>