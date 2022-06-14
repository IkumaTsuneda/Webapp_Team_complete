/**
 * 
 */
package model.entity;

import java.io.Serializable;

/**
 * @author user
 *
 */
public class BookBean implements Serializable {
  /**
   * ID
   */
  private int id;
  /**
  * 書籍名
  */
  private String bookTitle;
  /**
  * 著者名
  */
  private String authorName;

  /**
   * @param id
   * @param bookTitle
   * @param authorName
   */
  public BookBean() {
    
  }

  /**
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id セットする id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return bookTitle
   */
  public String getBookTitle() {
    return bookTitle;
  }

  /**
   * @param bookTitle セットする bookTitle
   */
  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  /**
   * @return authorName
   */
  public String getAuthorName() {
    return authorName;
  }

  /**
   * @param authorName セットする authorName
   */
  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }
}
