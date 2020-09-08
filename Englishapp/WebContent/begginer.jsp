<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Word" %>
  <%
  String word = (String)session.getAttribute("wordcheck");
%>
<%
//リクエストスコープに保存された正解メッセージを取得
String Cong = (String) request.getAttribute("Cong");
//リクエストスコープに保存された間違いメッセージを取得
String Mistake = (String) request.getAttribute("Mistake");

String HINT = (String) request.getAttribute("Hint");
String Meaning = (String) request.getAttribute("Meaning");
String Kaitou = (String) request.getAttribute("Kaitou");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>初級クラス</title>
<link rel="stylesheet" type="text/css" href="/Englishapp/css/begginer.css">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/Sunny/jquery-ui.css">

<script type="text/javascript">

$(function() {
  $("#btn").click(function() {
    $("#dl").dialog({
      modal:true,
      title:"ヒントだよ！",
      buttons: {"もどる": function() {$(this).dialog("close");}}
    });
  });
  $("#btn2").click(function() {
	    $("#dl2").dialog({
	      modal:true,
	      title:"答えを表示します！",
	      buttons: {"もどる": function() {$(this).dialog("close");}}
	    });
	  });
});
</script>
    
</head>
<body>

 <br>
<div id="top">
<h2>つぎの意味に値する英単語を記入してください。</h2><br>
<h1><c:out value="${word.meaning}" /></h1>
</div
>

<div id="form">

<%
//正解の場合、正解メッセージを表示
if(Cong !=null) { %>
<h3><%= Cong %></h3><br>
<a href="/Englishapp/wordcontroller" class="answer_button">次の問題へ</a>
<a href ="https://ejje.weblio.jp/content/<%= word %>" class="answer_button">Weblio辞典で単語を調べる</a>
<% } %>
<%
//不正解の場合、間違いメッセージを表示
if(Mistake !=null) { %>
<h1><%= Meaning %></h1>
<h3><%= Mistake %></h3><br>


<div id="dl" style="display:none;">
  <p>この単語の頭文字は、<%= HINT %>だよ！</p>
</div>

<div id="dl2" style="display:none;">
  <p>問題の答えは、<%= Kaitou %>だよ！</p>
</div>

<div style="padding : 20px;">
  <input type="button" class="answer_button" id="btn" value="ヒントをみる">
  <input type="button" class="answer_button" id="btn2" value="答えを表示">

<a href="/Englishapp/wordcontroller" class="answer_button">次の問題へ</a><br>

</div>

<% } %>

<form id="mondai" action="/Englishapp/wordcontroller" method="post">

<input class="textbox" type="text" name="answer" placeholder="答えを記入してください" autocomplete="off" maxlength="60">
<br>
<br>
<input type="hidden" name="meaning" value="${word.meaning}">
<input type="hidden" name="username" value="${username}"><br>
<input type="hidden" name="hint" value="${word.word.substring(0,1)}">

<input type="submit" class="answer_button" id="btn_action" value="答え合わせ">
</form>

</div>

<a href="/Englishapp/index.jsp"  class="btn btn--orange">トップ画面に戻る</a><br>
</body>
</html>