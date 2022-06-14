/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.BookBean;

/**
 * @author user
 *
 */
public class BookDao {
  /**
   * 
   * @param param 入力された書籍名、著者名を持ったBookBeanのインスタンス
   * @return
   * @throws SQLException 
   * @throws ClassNotFoundException 
   */
  public List<BookBean> select(BookBean param) throws ClassNotFoundException, SQLException {
    //sql
    String sql = "SELECT * FROM m_book WHERE book_title LIKE ? AND author_name LIKE ?";
    //
    List<BookBean> bookList = new ArrayList<>();

    try (Connection con = ConnectionManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {

      //Beanから値の取得し、プレースホルダに値を設定
      pstmt.setString(1, "%" + param.getBookTitle() + "%");
      pstmt.setString(2, "%" + param.getAuthorName() + "%");

      //
      ResultSet rs = pstmt.executeQuery();
      //sqlの実行
      while(rs.next()) {
        BookBean book = new BookBean();
        
        book.setId(rs.getInt("id"));
        book.setBookTitle(rs.getString("book_title"));
        book.setAuthorName(rs.getString("author_name"));
        
        bookList .add(book);
      }
    }

    return bookList;
  }

  /**
   * 
   * @param book BookBeanのインスタンス
   * @return count 登録件数
   * @throws SQLException 
   * @throws ClassNotFoundException 
   */
  public int insert(BookBean book) throws ClassNotFoundException, SQLException {
    //sql
    String sql = "INSERT INTO m_book (book_title, author_name) VALUES(?, ?)";
    //登録件数
    int count = 0;

    try (Connection con = ConnectionManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {

      //Beanから値の取得し、プレースホルダに値を設定
      pstmt.setString(1, book.getBookTitle());
      pstmt.setString(2, book.getAuthorName());

      //sql実行と結果代入
      count = pstmt.executeUpdate();
    }

    return count;
  }

  /**
   * 
   * @param ids 削除対象のid
   * @return 削除件数
   * @throws SQLException 
   * @throws ClassNotFoundException 
   */
  public int delete(String[] ids) throws ClassNotFoundException, SQLException {
    //sql
    String sql = "DELETE FROM m_book WHERE id = ?";
    //削除件数
    int count = 0;

    try (Connection con = ConnectionManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {

      //削除件数分だけsqlを発行
      for (String s: ids) {
        pstmt.setString(1, s);
      //sql実行と結果代入
        count += pstmt.executeUpdate();
      }
    }

    return count;
  }
}
