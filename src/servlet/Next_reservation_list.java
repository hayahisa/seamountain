package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReservationDao;
import model.ReservationBean;

/**
 * Servlet implementation class Next_reservation_list
 */
@WebServlet("/Next_reservation_list")
public class Next_reservation_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_reservation_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		int roomId = Integer.parseInt(request.getParameter("room"));	//x限目
		String day = request.getParameter("day");						//x曜日
		int timeId = Integer.parseInt(request.getParameter("time"));	//時間割
		//初期値 1 monday 1

		System.out.println(roomId + day + timeId);
		if(roomId == 1){

		}else if(timeId == 1){

		}
		ReservationDao rdao = new ReservationDao();
		ArrayList<ReservationBean> reservatioinArray = rdao.reservatioin(timeId,day);
		session.setAttribute("reservatioinArray", reservatioinArray);


		request.getRequestDispatcher("WEB-INF/jsp/reservation_list.jsp").forward(request, response);
	}

}
