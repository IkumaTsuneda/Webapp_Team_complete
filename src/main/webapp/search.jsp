<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍検索画面</title>
</head>
<body>
<%
String bookTitle = request.getParameter("booktitle");
String authorName = request.getParameter("authorname");
%>
<form action ="search" method ="POST">

<h1>書籍検索画面</h1><br>
書籍名：<input type ="text" size="50" name="booktitle" <%if(bookTitle != null)%>value=<%=bookTitle%>><br>
著者名：<input type ="text" size="50" name="authorname" <%if(authorName != null)%>value=<%=authorName%>><br>

<input type ="submit" value="検索"><br>
</form>

<form action ="create.jsp">
<input type="submit" value="新規登録">
</form>

<jsp:include page="search-result.jsp">
<jsp:param value="bookList" name="bookList"/>
</jsp:include>
</body>
</html>