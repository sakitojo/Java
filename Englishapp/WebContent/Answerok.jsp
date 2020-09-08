<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="model.Word" %>
  <%
  String word = (String)session.getAttribute("wordcheck");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Englishapp/css/Answerok.css">
<title>Englishapp</title>
</head>
<body>
<h2><span><i class="fas fa-star"></i></span>Congratulations!正解!</h2>

<a href ="https://ejje.weblio.jp/content/<%= word %>">Weblio辞典へ</a>
<a href ="/Englishapp/wordcontroller">次の問題へ</a>



</body>
</html>