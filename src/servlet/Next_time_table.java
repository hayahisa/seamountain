package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TimeDetailDao;
import model.UserBean;

/**
 * Servlet implementation class Next_time_table
 */
@WebServlet("/Next_time_table")
public class Next_time_table extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_time_table() {
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
		HttpSession session = request.getSession();
		//sessionに格納されたユーザ情報の時間割IDを取り出す
		System.out.println("*01");
		UserBean userbean = (UserBean)session.getAttribute("userBean");
		System.out.println("*02*" + userbean.getTimeId() + "*");
		int timeId = userbean.getTimeId();
		//int timeId = Integer.parseInt((String)request.getAttribute("userId"));
		System.out.println(timeId);
		String monday = "monday";
		String tuesday = "tuesday";
		String wednesday = "wednesday";
		String thursday = "thursday";
		String friday = "friday";

		TimeDetailDao tddao = new TimeDetailDao();
		session.setAttribute("monday", tddao.timetable(timeId,monday));
		session.setAttribute("tuesday", tddao.timetable(timeId,tuesday));
		session.setAttribute("wednesday", tddao.timetable(timeId,wednesday));
		session.setAttribute("thursday", tddao.timetable(timeId,thursday));
		session.setAttribute("friday", tddao.timetable(timeId,friday));



		//画面遷移（時間割表示）
		request.getRequestDispatcher("WEB-INF/jsp/time_table.jsp").forward(request, response);
	}

}
