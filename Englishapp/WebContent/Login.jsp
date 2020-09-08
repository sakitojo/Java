<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport"
    content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <!-- Latest compiled and minified CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
 
</head>
<body>
  <div class="container">
    <div class="navbar">
      <h1>ログイン画面</h1>
    </div>
    
    <form action="http://localhost:8080/Englishapp/LoginServlet" method="post">
      
      <div class="form-row">
        <label class="col-sm-3 col-form-label">ユーザー名</label>
        <div class="col-sm-9">
          <p>
            <input type="text" name="username" autocomplete="username" class="form-control" placeholder="例：t.yamada" required />
          </p>
        </div>
      </div>
      
      <div class="form-row">
        <label class="col-sm-3 col-form-label">パスワード </label>
        <div class="col-sm-9">
          <p>
            <input type="password" name="pass" autocomplete="pass" class="form-control" placeholder="パスワード" required />
          </p>
        </div>
      </div>
        

      <div class="text-center my-5">
        <button type="submit" class="btn btn-primary">ログイン</button>
      </div>
      
      </form>
      
      <c:if test="${not empty errorMsg}">
      <p>${errorMsg}</p>
    </c:if>
    
  </div>
 
</body>
</html>