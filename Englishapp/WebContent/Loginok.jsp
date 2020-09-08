<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.DisplayAnswer" %>
<%
DisplayAnswer disp = (DisplayAnswer)session.getAttribute("disp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Englishapp</title>
<link rel="stylesheet" type="text/css" href="/Englishapp/css/Loginok.css">
</head>
<body>

<div class="ribbon3">
  <h3><c:out value="${username}"/>さんのマイページ</h3>
</div><br>


<h4><c:out value="${username}"/>さんの英単語学習回答履歴</h4><br>

<table>
  <tr>
      <th>問題内容</th>
      <th><c:out value="${username}"/>さんの回答</th>
      <th>問題の答え</th>
      <th>回答日時</th>
  </tr>
 <c:forEach var="disp" items="${disp}"> 
  <tr>
    <td>${disp.meaning }</td>
    <td>${disp.answer}</td>
    <td>${disp.word}</td>
    <td>${disp.date}</td>
  </tr>
</c:forEach>  
</table>


<br/>

<a href="/Englishapp/index.jsp"  class="btn btn--orange">TOPへ</a><br>

<a href="ChangeServlet"  class="btn btn--orange">ユーザー内容変更</a><br>

</body>
</html>