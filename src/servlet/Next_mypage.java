package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.UserBean;

/**
 * Servlet implementation class Next_mypage
 */
@WebServlet("/Next_mypage")
public class Next_mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_mypage() {
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
		HttpSession session = request.getSession();	//セッション
		UserDao udao = new UserDao();
		UserBean userbean = new UserBean();

		String user_no = (String)session.getAttribute("user_number");	//セッションにユーザナンバーを確認

		userbean = (UserBean)udao.userSession(user_no);

		session.setAttribute("userBean",userbean);	//ユーザ情報をセッションに格納

		int timeId = userbean.getTimeId();
		TimeTableDisplay timetable = new TimeTableDisplay();
		timetable.doPost(request, response, timeId);

		request.getRequestDispatcher("WEB-INF/jsp/mypage.jsp").forward(request, response);
	}

}
