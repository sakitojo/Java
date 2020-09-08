<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"/>
   <title>English Learning</title>
   <link rel="stylesheet" type="text/css" href="/Englishapp/css/stylesheet.css">
</head>
<body>
    <header class="topNavigation">
    <p>ようこそ<c:out value="${username}"/>さん</p>
    
  <ul class="topnav">
	<li><a class="active" href="#home">Home</a></li>
	<li><a href="#news">News</a></li>
	<li><a href="#contact">Contact</a></li>
	<li class="right"><a href=http://localhost:8080/Englishapp/DisplayAnswerServlet>マイページ</a></li>
	<li class="right"><a href=/Englishapp/Logout>ログアウト</a></li>
</ul>  
    </header>

<div class="content">

<h1>Welcome to English Learning!!</h1>
<h2>無料学習コンテンツで英単語学習してみよう!</h2>

<table class="menu">
    <tr>
      <td><a href="wordcontroller"><img src="/Englishapp/Saved%20Pictures/azarashi.png"></a></td>
      <td><a href="SelectwbServlet"><img src="/Englishapp/Saved%20Pictures/shika.png"></a></td>
      <td><a href="block2_inline.html"><img src="/Englishapp/Saved%20Pictures/lion.png"></a></td>
    </tr>
    <tr>
      <td>Begginer Class</td>
      <td>Middle Class</td>
      <td>Advanced Class</td>
    </tr>
  </table>


</div>
    
</body>
>