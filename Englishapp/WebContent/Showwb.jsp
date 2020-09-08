<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Word" %>
<%
Word myword = (Word)session.getAttribute("myword");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Englishapp/css/showwb.css">
<title>Your word book page</title>
</head>
<body>

<h4><c:out value="${username}"/>さんの英単語帳</h4><br>


<a href="http://localhost:8080/Englishapp/WordBookServlet" class="btn-flat-logo">
  <span>単語を追加</span>
</a>
<a href="http://localhost:8080/Englishapp/DeletewbServlet" class="btn-flat-logo">
  <span>単語の削除</span>
</a>

<table class="tbl-r02">
<tbody>
 <c:forEach var="myword" items="${myword}">
<tr>
<th>${myword.word}</th>
<td>${myword.meaning}</td>
</tr>
</c:forEach>  
</table>


</body>
</html>