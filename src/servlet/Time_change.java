package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TimeChangeDao;
import dao.TimeDao;
import model.TimeListBean;
import model.UserBean;

/**
 * Servlet implementation class Time_change
 */
@WebServlet("/Time_change")
public class Time_change extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Time_change() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("11");
		String tId = String.valueOf(session.getAttribute("selectTimeId"));
		int timeId = Integer.parseInt(tId);//選択されている時間割のIDをセッションから取得
		System.out.println("*");

		UserBean userbean = (UserBean)session.getAttribute("userBean");//ユーザIDを取得
		String userNo = userbean.getUserNo();

		TimeChangeDao tdao = new TimeChangeDao();
		tdao.timeChange(userNo, timeId);

		//新しいtimeIdをuserのsessionに格納
		userbean.setTimeId(timeId);

		TimeDao timedao = new TimeDao();
		//時間割の一覧を表示させる
		ArrayList<TimeListBean> time_all = timedao.timeList();
		session.setAttribute("allTime",time_all);
		Timeget tg = new Timeget();
		tg.doPost(request, response);

		request.getRequestDispatcher("WEB-INF/jsp/time_change_confirmation.jsp").forward(request, response);

	}

}
