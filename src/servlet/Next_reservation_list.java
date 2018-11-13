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

		String one_room = "one_room_id";
		String two_room = "two_room_id";
		String three_room = "three_room_id";
		String four_room = "four_room_id";

		ReservationDao rdao = new ReservationDao();	//予約に関するDAO

		int roomId = Integer.parseInt(request.getParameter("room"));	//x教室
		String day = request.getParameter("day");						//x曜日
		int time = Integer.parseInt(request.getParameter("time"));	//x限目
		//何も選ばなければ「0」を取得 timeは何限目かだよ
		int x = 1;	//何限目を選んだか

		String timeNo = null;
		if(time == 1){			//1限目
			timeNo = "one_subject_id";
		}else if(time == 2){	//2限目
			timeNo = "two_subject_id";
		}else if(time == 3){	//3限目
			timeNo = "three_subject_id";
		}else if(time == 4){	//4限目
			timeNo = "four_subject_id";
		}

		ArrayList<ReservationBean> reservatioinList = new ArrayList<ReservationBean>();
		System.out.println(roomId + day + time);

		reservatioinList = rdao.Reservation(one_room,1);

//		if(roomId == 0 && day.equals("0") && time == 0){
//			//選択無し（全て表示）
//			System.out.println("all is no");
//			reservatioinList = rdao.rdtReservation();
//			x  = 0;
//
//		}else if(roomId == 0 && day.equals("0")){
//			//roomId,dayが無し
//			System.out.println("roomId,day is no");
//			reservatioinList = rdao.rdReservation();
//
//		}else if(day.equals("0") && time == 0){
//			//day,timeIdが無し
//			System.out.println("day,time is no");
//			reservatioinList = rdao.dtReservation(roomId);
//
//		}else if(roomId == 0 && time == 0){
//			//roomId,timeIdが無し
//			System.out.println("room,timeId is no");
//
//		}else if(roomId == 0){
//			//roomIdが無し
//			System.out.println("room,timeId is no");
//
//		}else if(day.equals("0")){
//			//dayが無し
//			System.out.println("room,timeId is no");
//
//		}else if(time == 0){
//			//timeIdが無し
//			System.out.println("room,timeId is no");
//
//		}else{
//			//全て選択
//			System.out.println("all is getting");
//
//		}

		//何限目を指定したかどうかのセッション
		session.setAttribute("timeX",x);
		session.setAttribute("time",time);
		session.setAttribute("reservatioinList", reservatioinList);
		request.getRequestDispatcher("WEB-INF/jsp/reservation_list.jsp").forward(request, response);
	}

}
