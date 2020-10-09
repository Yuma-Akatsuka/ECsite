<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,model.CategoryBean"
  	import = "model.ProductBean" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
<h1>検索</h1>
<% ArrayList<CategoryBean> acb=(ArrayList<CategoryBean>)request.getAttribute("categoryinfo"); %>
<% CategoryBean catbe = new CategoryBean(); %>

<form action = "/ECsite/search" method ="POST">
<select name= "category">
<option value="">すべて</option>
<% for(int i=0;i < acb.size();i++){
catbe = acb.get(i); %>
<option value="<%= catbe.getId()%>"><%= catbe.getCategory()%></option>
<%} %>
</select>


<input type="text" name="keyword">
<input type ="submit" value ="検索">

<% ArrayList<ProductBean> plist = (ArrayList<ProductBean>)request.getAttribute("pattern"); %>
<% ProductBean probe = new ProductBean(); %>
	<%if(plist == null){ %>
  	<%}else if(plist.size() == 0){ %>
  	<%="検索結果がありません"  %>
  	<% }else if(plist.size() != 0){%>
    <table  border="1" style="border-collapse: collapse">
    <tr><td>商品名</td>
    <td>価格</td>
    <td>在庫</td>
    </tr>
    <% for(int i=0;i < plist.size();i++){
    probe = plist.get(i); %>
	<tr><td><a href="/ECsite/search?pro_cd=<%=probe.getCd()%>"><%=probe.getName()%></a></td>
	<td><%=probe.getPrice()%></td>
	<td><%=probe.getStock()%></td>
	</tr>
    <% } %>
     </table>
	<% } %>

</form>
</body>
</html>