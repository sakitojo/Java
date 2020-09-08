<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/Englishapp/css/Choice_wb.css">
</head>
<body>


	<div class="wrapper tabled">
		<div class="stage" id="page1">
			<div class="middled">

				<h2>以下の内容から選んでください</h2>
				<h4>Let's make only your Word Book!!</h4>
				<div class="link-1">
					<a href="http://localhost:8080/Englishapp/SelectwbServlet"> <span
						class="thin">1</span><span class="thick">Look</span>
					</a>
					<p>単語を調べる、見る</p>
				</div>

				<div class="link-2">
					<a href="http://localhost:8080/Englishapp/WordBookServlet"> <span
						class="thin">2</span><span class="thick">Create</span>
					</a>
					<p>単語帳に単語を追加する</p>
				</div>

				<div class="link-3">
					<a href="http://localhost:8080/Englishapp/DeletewbServlet"> <span
						class="thin">3</span><span class="thick">Delete</span>
					</a>
					<p>単語帳から単語を削除する</p>
				</div>

			</div>
		</div>
</body>
</html>