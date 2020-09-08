<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>不正解です。</p>

<p>答えは、<c:out value="${sessionScope.wordcheck}" />
です。</p>

<a href="/Englishapp/wordcontroller">次の問題へ</a>

</body>
</html>