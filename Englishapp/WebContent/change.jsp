<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Account" %>
<%
Account account = (Account)session.getAttribute("account");
%>
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


  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/pepper-grinder/jquery-ui.css">
 


  <script>
    window.addEventListener("beforeunload", function (event) {
      var confirmationMessage = "入力内容を破棄します。";

      event.returnValue = confirmationMessage;
      return confirmationMessage;
    });
  </script>
  
  
  
   <script>
 $(function(){
	
	// ボタンがクリックされたときの処理
	$("#confirm_button").click(function(){
		// ダイアログに入力内容を追加
		$("#dialog").html("この内容で送信してもよろしいですか？ <br><hr>");
		$("#dialog").append("<span>名前：</span>"+$("#name").val()+"<br>");
		$("#dialog").append("<span>性別：</span>"+$("#gender").val()+"<br>");
		$("#dialog").append("<span>電話番号：</span>"+$("#tel").val()+"<br>");
		$("#dialog").append("<span>郵便番号：</span>"+$("#zip").val()+"<br>");
		$("#dialog").append("<span>都道府県：</span>"+$("#address1").val()+"<br>");
		$("#dialog").append("<span>それ以降の住所：</span>"+$("#address2").val()+"<br>");
		$("#dialog").append("<span>メールアドレス：</span>"+$("#email").val()+"<br>");
		$("#dialog").append("<span>年齢：</span>"+$("#age").val()+"<br>");

		// ダイアログを開く
		$("#dialog").dialog("open");
	});

	// ダイアログの指定
	$("#dialog").dialog({
		autoOpen: false,
		width: 450,
		height: 450,
		modal: true,
		buttons: {
			"この内容で送信": function() {
				// フォーム送信
				$("form").submit();
			},
			"キャンセル": function() {
				// ダイアログを閉じる
				$("#dialog").dialog("close");
			}
		}
	});
});
</script>
  
  
  
  
  
  
  
</head>
<body>
  <div class="container">
    <div class="navbar">
    <c:out value="${username}"/>さんのユーザー情報<br  />


      <h1>登録内容の変更</h1>
    </div>

    <form action="http://localhost:8080/Englishapp/ChangeServlet" method="post">
    
    <input type="hidden" name="username" id="username" value="${username}" />

      <div class="form-row">
        <label class="col-sm-3 col-form-label">お名前 <span class="badge badge-danger">必須</span></label>
        <div class="col-sm-9">
          <p>
            <input type="text" name="name" id="name" autocomplete="name" class="form-control" value="<c:out value="${Info[0].name}" />" required />
          </p>
        </div>
      </div>
      
      <div class="form-row">
        <label class="col-sm-3 col-form-label">パスワード <span class="badge badge-danger">必須</span></label>
        <div class="col-sm-9">
          <p>
            <input type="password" name="pass" id="pass" autocomplete="password" class="form-control" value="<c:out value="${Info[0].pass}" />" required />
          </p>
        </div>
      </div>
      
      <div class="form-row">
        <label class="col-sm-3 col-form-label">性別 </label>
        <div class="col-sm-9">
          <p>
          <c:if test="${Info[0].gender == '男性'}" var="gender" />
          <label><input type="radio" name="gender" id="gender" value="male" <c:if test="${gender}">checked="checked"</c:if>>男性</label>
          <label><input type="radio" name="gender" id="gender" value="female"<c:if test="${!gender}">checked="checked"</c:if>>女性</label><br /> 
          </p>
        </div>
      </div>

      <div class="form-row">
        <label class="col-sm-3 col-form-label">電話番号 </label>
        <div class="col-sm-9">
          <p>
            <input type="tel" name="tel" id="tel" autocomplete="tel" class="form-control" value="<c:out value="${Info[0].tel }" />"/>
          </p>
        </div>
      </div>    
      
 

      <div class="form-row">
        <label class="col-sm-3 col-form-label">郵便番号</label>
        <div class="col-sm-9">
          <p>
            <input type="text" name="zip" id="zip" autocomplete="zip" class="form-control" value="<c:out value="${Info[0].zip}"/>
            " size="10" maxlength="8" onkeyup="AjaxZip3.zip2addr(this,'','address1','address2');" />
          </p>
        </div>
      </div>


      <div class="form-row">
        <label class="col-sm-3 col-form-label">都道府県</label>
        <div class="col-sm-9">
          <p>
            <input type="text" name="address1" id="address1" autocomplete="address1" class="form-control"
              value="<c:out value="${Info[0].address1}"/>"/>
          </p>
        </div>
      </div>
      
      <div class="form-row">
        <label class="col-sm-3 col-form-label">それ以降の住所</label>
        <div class="col-sm-9">
          <p>
            <input type="text" name="address2" id="address2" autocomplete="address2" class="form-control"
              value="<c:out value="${Info[0].address2}"/>"/>
          </p>
        </div>
      </div>      

      <div class="form-row">
        <label class="col-sm-3 col-form-label">メールアドレス</label>
        <div class="col-sm-9">
          <p>
            <input type="email" name="email" id="email" autocomplete="email" class="form-control" value="<c:out value="${Info[0].email }" />" />
          </p>
        </div>
      </div>
      
      <div class="form-row">
        <label class="col-sm-3 col-form-label">年齢</label>

        <div class="col-sm-9">

          <select class="custom-select w-25" title="age" name="age" id="age" autocomplete="age">
          <!--   <option selected="">----</option>  -->
            <option value="10歳未満"<c:if test="${Info[0].age == '10歳未満'}">selected"</c:if>>10歳未満</option>
            <option value="10代"<c:if test="${Info[0].age == '10代'}">selected</c:if>>10代</option>
            <option value="20代"<c:if test="${Info[0].age == '20代'}">selected</c:if>>20代</option>
            <option value="30代"<c:if test="${Info[0].age == '30代'}">selected</c:if>>30代</option>
            <option value="40代"<c:if test="${Info[0].age == '40代'}">selected</c:if>>40代</option>
            <option value="50代"<c:if test="${Info[0].age == '50代'}">selected</c:if>>50代</option>
            <option value="60代"<c:if test="${Info[0].age == '60代'}">selected</c:if>>60代</option>
            <option value="70代"<c:if test="${Info[0].age == '70代以上'}">selected</c:if>>70代以上</option>
            
          </select>
          
        </div>
        
        
        
      </div>

      <div class="text-center my-5">
        <button type="submit" class="btn btn-primary" id="confirm_button">確認する</button>
      </div>

    </form>
    
     <div id="dialog" title="送信内容の確認"></div>
</div>

  </div>
</body>
</html>