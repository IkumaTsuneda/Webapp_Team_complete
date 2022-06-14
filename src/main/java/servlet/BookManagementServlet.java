package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BookDao;
import model.entity.BookBean;

/**
 * Servlet implementation class BookManagementServlet
 */
@WebServlet("/search")
public class BookManagementServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookManagementServlet() {
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

    String booktitle = request.getParameter("booktitle");
    String authorname = request.getParameter("authorname");
    BookBean param = new BookBean();
    List<BookBean> bookList = null;
    BookDao dao = new BookDao();
    try {
      
      param.setBookTitle(booktitle);
      param.setAuthorName(authorname);
      
      
      bookList = (List<BookBean>)dao.select(param);


    } catch (SQLException  | ClassNotFoundException e) {
      e.printStackTrace();
    }


    request.setAttribute("bookList", bookList);


    // リクエストの転送
    RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
    rd.forward(request, response);
  }
    
  }


