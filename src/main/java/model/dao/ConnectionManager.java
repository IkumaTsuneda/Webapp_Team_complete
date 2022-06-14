/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author user
 *
 */
public class ConnectionManager {
  /*
   * 
   */
  private final static String URL = "jdbc:mysql://localhost:3306/book_db";
  /*
   * 
   */
  private final static String USER = "embexU";
  /*
   * 
   */
  private final static String PASSWORD = "embexP";

  /*
   * 
   */
  public static Connection getConnection() throws SQLException, ClassNotFoundException {
    //
    Class.forName("com.mysql.cj.jdbc.Driver");
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }
}
