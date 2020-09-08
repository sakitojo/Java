<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>
<%
Account account = (Account)session.getAttribute("account");
%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>EnglishApp CofirmRegister</title>
</head>
<body>
<p>以下の内容でよろしいでしょうか。</p>
<%= account.getName() %><br>
<%= account.getUserName() %><br>
<%= account.getPass() %><br>
<%= account.getGender() %><br>
<%= account.getTel() %><br>
<%= account.getEmail() %><br>
<%= account.getAge() %><br>

<form action="http://localhost:8080/Englishapp/RegisterActionServlet" method="post">
<input type="hidden" name="name" value="<%= account.getName() %>">
<input type="hidden" name="username" value="<%= account.getUserName() %>">
<input type="hidden" name="pass" value="<%= account.getPass() %>">
<input type="hidden" name="gender" value="<%= account.getGender() %>">
<input type="hidden" name="tel" value="<%= account.getTel() %>">
<input type="hidden" name="email" value="<%= account.getEmail() %>">
<input type="hidden" name="birthday" value="<%= account.getAge()%>">
<input type="submit" value="登録する">
</form>
<a href="Register.jsp">入力画面に戻る</a>
</body>
</html>

