package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;


/**
 * Servlet implementation class User_change
 */
@WebServlet("/User_change")
public class User_change extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_change() {
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

		String mail = (String)request.getAttribute("mail");
		String user_name= (String)request.getAttribute("uname");

		HttpSession session = request.getSession();	//セッション
		String user_no = (String)session.getAttribute("user_no");

		UserDao udao = new UserDao();
		udao.userChange(mail, user_name, user_no);

		request.getRequestDispatcher("WEB-INF/jsp/mypage.jsp").forward(request, response);
	}

}