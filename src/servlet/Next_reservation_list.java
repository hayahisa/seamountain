package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
		GetSelectDays sday = new GetSelectDays();

		String one_room = "one_room_state_id";
		String two_room = "two_room_state_id";
		String three_room = "three_room_state_id";
		String four_room = "four_room_state_id";

		String msg = null;
		String resDate = null;

		ReservationDao rdao = new ReservationDao();	//予約に関するDAO

		int roomId = Integer.parseInt(request.getParameter("room"));	//x教室
		String day = request.getParameter("day");						//x曜日
		int time = Integer.parseInt(request.getParameter("time"));		//x限目
		//何も選ばなければ「0」を取得 timeは何限目かだよ
		int x = 1;	//何限目を選んだか

//		今日の日付を取得と予約の日付について
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Calendar cal = Calendar.getInstance();

//		SQL用に変換する
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

//		ArrayList
		ArrayList<ReservationBean> reservationList = new ArrayList<ReservationBean>();	//一応作った
		ArrayList<ReservationBean> oneList = new ArrayList<ReservationBean>();			//１限のリスト
		ArrayList<ReservationBean> twoList = new ArrayList<ReservationBean>();			//２限のリスト
		ArrayList<ReservationBean> threeList = new ArrayList<ReservationBean>();		//３限のリスト
		ArrayList<ReservationBean> fourList = new ArrayList<ReservationBean>();			//４限のリスト

		if(roomId == 0 && day.equals("0") && time == 0){
			//選択無し（全て表示）
//			１限ずつ取得
			oneList = rdao.AllReservation(one_room,1,resDate);
			twoList = rdao.AllReservation(two_room,2,resDate);
			threeList = rdao.AllReservation(three_room,3,resDate);
			fourList = rdao.AllReservation(four_room,4,resDate);

		}else if(roomId == 0 && day.equals("0")){
			//roomId,dayが無し
			if(time == 1){			//1限目
				reservationList = rdao.AllReservation(one_room, 1,resDate);
			}else if(time == 2){	//2限目
				reservationList = rdao.AllReservation(two_room, 2,resDate);
			}else if(time == 3){	//3限目
				reservationList = rdao.AllReservation(three_room, 3,resDate);
			}else if(time == 4){	//4限目
				reservationList = rdao.AllReservation(four_room, 4,resDate);
			}

		}else if(day.equals("0") && time == 0){
			//day,timeIdが無し
			oneList = rdao.dtReservation(one_room,1,roomId,resDate);
			twoList = rdao.dtReservation(two_room,2,roomId,resDate);
			threeList = rdao.dtReservation(three_room,3,roomId,resDate);
			fourList = rdao.dtReservation(four_room,4,roomId,resDate);

		}else if(roomId == 0 && time == 0){
			//roomId,timeIdが無し
			resDate = sday.getSelectDays(day);
			oneList = rdao.rtReservation(one_room,1,day,resDate);
			twoList = rdao.rtReservation(two_room,2,day,resDate);
			threeList = rdao.rtReservation(three_room,3,day,resDate);
			fourList = rdao.rtReservation(four_room,4,day,resDate);

		}else if(roomId == 0){
			//roomIdが無し
			resDate = sday.getSelectDays(day);
			if(time == 1){
				oneList = rdao.rtReservation(one_room,1,day,resDate);
			}else if(time == 2){
				twoList = rdao.rtReservation(two_room,2,day,resDate);
			}else if(time == 3){
				threeList = rdao.rtReservation(three_room,3,day,resDate);
			}else if(time == 4){
				fourList = rdao.rtReservation(four_room,4,day,resDate);
			}

		}else if(day.equals("0")){
			//dayが無し
			if(time == 1){			//1限目
				reservationList = rdao.dReservation(one_room, 1, roomId,resDate);
			}else if(time == 2){	//2限目
				reservationList = rdao.dReservation(two_room, 2, roomId,resDate);
			}else if(time == 3){	//3限目
				reservationList = rdao.dReservation(three_room, 3, roomId,resDate);
			}else if(time == 4){	//4限目
				reservationList = rdao.dReservation(four_room, 4, roomId,resDate);
			}

		}else if(time == 0){
			//timeIdが無し
			resDate = sday.getSelectDays(day);
			oneList = rdao.tReservation(one_room,1,day,roomId,resDate);
			twoList = rdao.tReservation(two_room,2,day,roomId,resDate);
			threeList = rdao.tReservation(three_room,3,day,roomId,resDate);
			fourList = rdao.tReservation(four_room,4,day,roomId,resDate);

		}else{
			//全て選択
			resDate = sday.getSelectDays(day);
			if(time == 1){			//1限目
				reservationList = rdao.Reservation(one_room, 1, day, roomId,resDate);
			}else if(time == 2){	//2限目
				reservationList = rdao.Reservation(two_room, 2, day, roomId,resDate);
			}else if(time == 3){	//3限目
				reservationList = rdao.Reservation(three_room, 3, day, roomId,resDate);
			}else if(time == 4){	//4限目
				reservationList = rdao.Reservation(four_room, 4, day, roomId,resDate);
			}

		}

//		４つListを１つのListにまとめる
		for(ReservationBean reservation : oneList){
			reservationList.add(reservation);
		}
		for(ReservationBean reservation : twoList){
			reservationList.add(reservation);
		}
		for(ReservationBean reservation : threeList){
			reservationList.add(reservation);
		}
		for(ReservationBean reservation : fourList){
			reservationList.add(reservation);
		}

//		リストの中身が空かどうかの判定
		if (reservationList == null || reservationList.size() == 0) {
			msg = "該当する対象がありません";
			}

		//何限目を指定したかどうかのセッション
		session.setAttribute("reservationList", reservationList);
		session.setAttribute("msg", msg);
		request.getRequestDispatcher("WEB-INF/jsp/reservation_list.jsp").forward(request, response);
	}

}
