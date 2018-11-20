package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReservationDao;
import model.UserBean;

/**
 * Servlet implementation class Next_reservation_conf
 */
@WebServlet("/Next_reservation_conf")
public class Next_reservation_conf extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_reservation_conf() {
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
		//予約を行う
		HttpSession session = request.getSession();
		GetSelectDays sday = new GetSelectDays();
		ReservationDao rdao = new ReservationDao();

//		requestを取得
		int room_id = Integer.parseInt(request.getParameter("room_id"));
		String day = String.valueOf(request.getParameter("day"));
		int lecture = Integer.parseInt(request.getParameter("lecture"));
		String resDate = String.valueOf(request.getParameter("resDate"));
		String room_name = String.valueOf(request.getParameter("room_name"));

//		予約日
		int res_date = sday.changeDate(resDate);
		String x_room = null;
		String Eday = null;

//		何限目か
		switch(lecture){
		case 1:
			x_room = "one_room_state_id";
			break;
		case 2:
			x_room = "two_room_state_id";
			break;
		case 3:
			x_room = "three_room_state_id";
			break;
		case 4:
			x_room = "four_room_state_id";
			break;
		}

//		曜日変換
		switch(day){
		case "月":
			Eday = "monday";
			break;
		case "火":
			Eday = "tuesday";
			break;
		case "水":
			Eday = "wednesday";
			break;
		case "木":
			Eday = "thursday";
			break;
		case "金":
			Eday = "friday";
			break;
		}

//		user_noを取得
		UserBean userbean = new UserBean();
		userbean = (UserBean)session.getAttribute("userBean");
		String user_no = String.valueOf(userbean.getUserNo());

//		daoへ挿入 reservationとreservation_state_detail
		rdao.insertReservation(user_no, room_id, res_date, Eday, lecture);
		rdao.updateReservationDetail(x_room, room_id, Eday);

		session.setAttribute("room_name", room_name);
		session.setAttribute("day", day);
		session.setAttribute("lecture", lecture);

		request.getRequestDispatcher("WEB-INF/jsp/reservation_conf.jsp").forward(request, response);
	}

}
