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

import dao.ReservationDao;
import model.ReservationConfBean;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
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

	}

//	予約のすぎた予約を消すメソッド
	public void deleteReservation(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		ArrayList<ReservationConfBean> reservationconfList = new ArrayList<ReservationConfBean>();
		ReservationDao rdao = new ReservationDao();	//Dao
		String reservationDate = null;
		String day = null;
		String x_room = null;
		int i = 0;
		int lecture = 0;
		int reservation_no = 0;
		int room_id = 0;

//		今日の日付、時間を取得
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);

		String StrDay = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(date);

//		reservationの一覧を取得
		reservationconfList = rdao.getAllReservation();

//		reservationのdateを取得
		for(ReservationConfBean array : reservationconfList){
			reservationDate = String.valueOf(reservationconfList.get(i).getDate());
			lecture = reservationconfList.get(i).getLecture();	//何限目か
			System.out.println(reservationDate);

//			年、月、日に分解
			String[] reservationDateArray = reservationDate.split("-",0);
			int resYear = Integer.parseInt(reservationDateArray[0]);
			int resMonth = Integer.parseInt(reservationDateArray[1]);
			int resDate = Integer.parseInt(reservationDateArray[2]);

			System.out.println("lecture="+lecture);
			System.out.println("month="+month);
			System.out.println("year="+year);
			System.out.println("date="+date);

//			今日と予約の日の差
			if(year >= resYear){
				System.out.println("year");
				if(month >= resMonth){
					System.out.println("month");
					if(date >= resDate){
						System.out.println("date");
//						何限目かでの時間を比べる
						System.out.println("hour="+hour);
						switch(lecture){
						case 1:
							if(hour >= 10){
								reservation_no = reservationconfList.get(i).getReservation_no();
								day = reservationconfList.get(i).getDay();
								room_id = reservationconfList.get(i).getRoom_id();
								x_room = "one_room_state_id";
								rdao.deleteReservation(reservation_no);
								rdao.deleteRoomStateDetail(x_room, room_id, day);
							}
							break;
						case 2:
							if(hour >= 12){
								reservation_no = reservationconfList.get(i).getReservation_no();
								day = reservationconfList.get(i).getDay();
								room_id = reservationconfList.get(i).getRoom_id();
								x_room = "two_room_state_id";
								rdao.deleteReservation(reservation_no);
								rdao.deleteRoomStateDetail(x_room, room_id, day);
							}
							break;
						case 3:
							if(hour >= 14){
								reservation_no = reservationconfList.get(i).getReservation_no();
								day = reservationconfList.get(i).getDay();
								room_id = reservationconfList.get(i).getRoom_id();
								x_room = "three_room_state_id";
								rdao.deleteReservation(reservation_no);
								rdao.deleteRoomStateDetail(x_room, room_id, day);
							}
							break;
						case 4:
							if(hour >= 15){
								reservation_no = reservationconfList.get(i).getReservation_no();
								day = reservationconfList.get(i).getDay();
								room_id = reservationconfList.get(i).getRoom_id();
								x_room = "four_room_state_id";
								rdao.deleteReservation(reservation_no);
								rdao.deleteRoomStateDetail(x_room, room_id, day);
							}
							break;
						}
					}
				}
			}
			i++;
		}

	}

}
