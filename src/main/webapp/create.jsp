<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍登録画面</title>
</head>
<body>
<form action ="modify" method ="POST">
<h1>書籍登録画面</h1><br>
書籍名：<input type ="text" size="70" name="booktitle" required><br>
著者名：<input type ="text" size="70" name="authorname" required><br>
<input type ="reset" value="クリア">
<input type ="submit" value="登録"><br>
<a href="search.jsp">書籍検索画面に戻る</a>

</form>
</body>
</html>