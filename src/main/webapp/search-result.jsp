<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.List,model.entity.BookBean"%>
<%
List<BookBean> bookList = (List<BookBean>) request.getAttribute("bookList");
%>

<%
if (bookList == null) {
%>
<%
} else if (bookList.size() == 0) {
%>
<hr>
<h2>書籍検索結果</h2>
対象のデータがありません。
<%
} else {
%>
<form action="modify" method="POST">
  <hr>
  <h2>書籍検索結果</h2>
  <input type="submit" value="削除"><br>

  <table border="1">
    <tr>
      <td>削除</td>
      <td>No.</td>
      <td>書籍名</td>
      <td>著者名</td>
    <tr>

      <%
      for (BookBean book : bookList) {
      %>
    
    <tr>
      <td><input type="checkbox" name="book" value="<%=book.getId()%>"></td>
      <td><%=book.getId()%></td>
      <td><%=book.getBookTitle()%></td>
      <td><%=book.getAuthorName()%></td>
    </tr>
    <%
    }
    %>

  </table>

</form>

<%
}
%>