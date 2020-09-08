<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Word"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/Englishapp/css/MakeWordBook.css">
<title>Make My Word book</title>


</head>
<body>

	<form id="contact"
		action="http://localhost:8080/Englishapp/WordBookServlet"
		method="post">
		<div class="container">
			<div class="head">
				<h2>自分だけの単語帳を作成しよう！</h2>
			</div>
			<input type="text" name="word" placeholder="単語の意味" /><br /> <input
				type="text" name="meaning" placeholder="英単語" /><br /> <input
				type="hidden" name="username" value="${username}">
			<div class="message">Message Sent</div>
			<div class="text-center my-5">
				<button id="submit" type="submit">登録する</button>
			</div>
		</div>
	</form>


</body>
</html>