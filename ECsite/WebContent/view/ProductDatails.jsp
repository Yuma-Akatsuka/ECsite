<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.ProductBean"
  	import = "model.ProductBean" import = " java.text.NumberFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
</head>
<body>
<form action ="/ECsite/logout" method ="POST">
	<input type ="submit" value = ログアウト>
	</form>

<% ProductBean apb=(ProductBean)request.getAttribute("productlist"); %>
<% String catname = (String)request.getAttribute("catname");%>
<% ProductBean probe = new ProductBean(); %>
<img src="<%= apb.getImg() %>">
<%NumberFormat nfCur = NumberFormat.getCurrencyInstance();%>
<table border="1" style="border-collapse: collapse">
<tr><th>商品名</th>	<td><%=apb.getName() %></td></tr>
<tr><th>カテゴリー</th> <td><%=catname %></td></tr>
<tr><th>価格</th> <td><%=nfCur.format(apb.getPrice()) %></td></tr>
<tr><th>在庫</th> <td><%=apb.getStock() %></td></tr>
<tr><th>商品説明</th> <td><%=apb.getMsg() %></td></tr>
</table>
<form action = "/ECsite/productDetails" method ="POST">
<input type = "hidden" name ="name" value =<%=apb.getName() %>>
<input type = "hidden" name ="price" value =<%=apb.getPrice() %>>
<input type = "hidden" name ="procd" value =<%=apb.getCd() %>>
<input type = "hidden" name ="stock" value =<%=apb.getStock() %>>
<p>個数</p><select name="count">
<% for(int i=0;i<=apb.getStock();i++) { %>
<option value="<%= i %>"><%= i %></option>
<% } %>
</select>
<input type ="submit" value = カートへ>
</form>
<form action ="/ECsite/back" method ="POST">
<input type ="submit" value = 戻る >
</form>
</body>

</html>