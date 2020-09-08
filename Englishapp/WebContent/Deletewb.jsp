<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Word" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Englishapp/css/Deletewb.css">
<title>Delete word of my wordbook</title>
</head>
<body>

<form id="contact" action="http://localhost:8080/Englishapp/DeletewbServlet" method="post">
  <div class="container">
    <div class="head">
      <h2>単語帳から削除したい単語を記入してね</h2>
    </div>
    <input  type="text" name="word" placeholder="英単語" /><br />
    <input type="hidden" name="username" value="${username}">
    <div class="message">Message Sent</div>
    <div class="text-center my-5">
    <button id="submit" type="submit">
      削除する
    </button>
    </div>
  </div>
</form>

</body>
</html>