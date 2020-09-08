<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="search-form" class="design-1">
  <form name="myForm" method="get" action="https://esearch.rakuten.co.jp/rms/sd/isearch/vc" accept-charset="EUC-JP">
    <input type="hidden" name="username" value="******">
    <input type="text" name="sitem" id="sitem" placeholder="ショップ内から探す">
    <div class="search-button"><input type="submit" value="検索"></div>
  </form>
  <ul class="search-keyword">
    <li><a href="https://search.rakuten.co.jp/search/mall/検索キーワード1/?sid=******">キーワード1</a></li>
    <li><a href="https://search.rakuten.co.jp/search/mall/検索キーワード2/?sid=******">キーワード2</a></li>
    <li><a href="https://search.rakuten.co.jp/search/mall/検索キーワード3/?sid=******">キーワード3</a></li>
    <li><a href="https://search.rakuten.co.jp/search/mall/検索キーワード4/?sid=******">キーワード4</a></li>
  </ul>
</div>

</body>
</html>