package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BookDao;
import model.entity.BookBean;

/**
 * Servlet implementation class BookModifyServlet
 */
@WebServlet("/modify")
public class BookModifyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public BookModifyServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    request.setCharacterEncoding("UTF-8");

    int count = 0;
    String booktitle = request.getParameter("booktitle");
    BookDao dao = new BookDao();

    try {

      if (booktitle != null) {

        String authorname = request.getParameter("authorname");

        BookBean book = new BookBean();

        book.setBookTitle(booktitle);
        book.setAuthorName(authorname);

        count = dao.insert(book);

      } else {

        String[] ids = request.getParameterValues("book");

        if (ids == null) {

        } else {

          count = dao.delete(ids);

        }
      }

    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    request.setAttribute("count", count);

    // リクエストの転送
    RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
    rd.forward(request, response);
  }

}
