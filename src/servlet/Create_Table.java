package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateTableDao;
import model.TimeDetailBean;

/**
 * Servlet implementation class Create_Table
 */
@WebServlet("/Create_Table")
public class Create_Table extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create_Table() {
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

//		time_detailに入れるためのBean
		TimeDetailBean monbean = new TimeDetailBean();
		TimeDetailBean tuesbean = new TimeDetailBean();
		TimeDetailBean wedbean = new TimeDetailBean();
		TimeDetailBean thubean = new TimeDetailBean();
		TimeDetailBean fribean = new TimeDetailBean();

//		DAOをしようするときのArrayList
		ArrayList<Integer> monArray = new ArrayList<Integer>();
		ArrayList<Integer> tuesArray = new ArrayList<Integer>();
		ArrayList<Integer> wedArray = new ArrayList<Integer>();
		ArrayList<Integer> thuArray = new ArrayList<Integer>();
		ArrayList<Integer> friArray = new ArrayList<Integer>();

//		DAO
		CreateTableDao cdao = new CreateTableDao();

//		曜日
		String monday = "monday";
		String tuesday = "tuesday";
		String wednesday = "wednesday";
		String thursday = "thursday";
		String friday = "friday";

//		教科と教室
		String subject_name = null;
		String room_name = null;
		int time_id = 0;
		int i = 1;

//		時間割名
		String time_name = String.valueOf(request.getParameter("index"));

//		月曜日
		int mon1_sub = Integer.parseInt(request.getParameter("mon1_sub"));
		int mon1_room = Integer.parseInt(request.getParameter("mon1_room"));
		int mon2_sub = Integer.parseInt(request.getParameter("mon2_sub"));
		int mon2_room = Integer.parseInt(request.getParameter("mon2_room"));
		int mon3_sub = Integer.parseInt(request.getParameter("mon3_sub"));
		int mon3_room = Integer.parseInt(request.getParameter("mon3_room"));
		int mon4_sub = Integer.parseInt(request.getParameter("mon4_sub"));
		int mon4_room = Integer.parseInt(request.getParameter("mon4_room"));

//		火曜日
		int tues1_sub = Integer.parseInt(request.getParameter("tues1_sub"));
		int tues1_room = Integer.parseInt(request.getParameter("tues1_room"));
		int tues2_sub = Integer.parseInt(request.getParameter("tues2_sub"));
		int tues2_room = Integer.parseInt(request.getParameter("tues2_room"));
		int tues3_sub = Integer.parseInt(request.getParameter("tues3_sub"));
		int tues3_room = Integer.parseInt(request.getParameter("tues3_room"));
		int tues4_sub = Integer.parseInt(request.getParameter("tues4_sub"));
		int tues4_room = Integer.parseInt(request.getParameter("tues4_room"));

//		水曜日
		int wed1_sub = Integer.parseInt(request.getParameter("wed1_sub"));
		int wed1_room = Integer.parseInt(request.getParameter("wed1_room"));
		int wed2_sub = Integer.parseInt(request.getParameter("wed2_sub"));
		int wed2_room = Integer.parseInt(request.getParameter("wed2_room"));
		int wed3_sub = Integer.parseInt(request.getParameter("wed3_sub"));
		int wed3_room = Integer.parseInt(request.getParameter("wed3_room"));
		int wed4_sub = Integer.parseInt(request.getParameter("wed4_sub"));
		int wed4_room = Integer.parseInt(request.getParameter("wed4_room"));

//		木曜日
		int thu1_sub = Integer.parseInt(request.getParameter("thu1_sub"));
		int thu1_room = Integer.parseInt(request.getParameter("tues1_room"));
		int thu2_sub = Integer.parseInt(request.getParameter("thu2_sub"));
		int thu2_room = Integer.parseInt(request.getParameter("tues2_room"));
		int thu3_sub = Integer.parseInt(request.getParameter("thu3_sub"));
		int thu3_room = Integer.parseInt(request.getParameter("tues3_room"));
		int thu4_sub = Integer.parseInt(request.getParameter("thu4_sub"));
		int thu4_room = Integer.parseInt(request.getParameter("tues4_room"));

//		金曜日
		int fry1_sub = Integer.parseInt(request.getParameter("fry1_sub"));
		int fry1_room = Integer.parseInt(request.getParameter("fry1_room"));
		int fry2_sub = Integer.parseInt(request.getParameter("fry2_sub"));
		int fry2_room = Integer.parseInt(request.getParameter("fry2_room"));
		int fry3_sub = Integer.parseInt(request.getParameter("fry3_sub"));
		int fry3_room = Integer.parseInt(request.getParameter("fry3_room"));
		int fry4_sub = Integer.parseInt(request.getParameter("fry4_sub"));
		int fry4_room = Integer.parseInt(request.getParameter("fry4_room"));

//		Arrayに格納
		for (int item : new int[]{mon1_sub, mon1_room, mon2_sub, mon2_room, mon3_sub, mon3_room, mon4_sub, mon4_room}) {
			monArray.add(item);
		}
		for (int item : new int[]{tues1_sub, tues1_room, tues2_sub, tues2_room, tues3_sub, tues3_room, tues4_sub, tues4_room}) {
			tuesArray.add(item);
		}
		for (int item : new int[]{wed1_sub, wed1_room, wed2_sub, wed2_room, wed3_sub, wed3_room, wed4_sub, wed4_room}) {
			wedArray.add(item);
		}
		for (int item : new int[]{thu1_sub, thu1_room, thu2_sub, thu2_room, thu3_sub, thu3_room, thu4_sub, thu4_room}) {
			thuArray.add(item);
		}
		for (int item : new int[]{fry1_sub, fry1_room, fry2_sub, fry2_room, fry3_sub, fry3_room, fry4_sub, fry4_room}) {
			friArray.add(item);
		}

//		時間割名を挿入しIDを取得する
		cdao.setTime(time_name);
		time_id = cdao.getTimeId();

//		TimeIdとDayとtime_idとroom_idをset
//		月曜日
		monbean.setTime_id(time_id);
		monbean.setDay(monday);
		monbean.setOne_subject_id(mon1_sub);
		monbean.setOne_room_id(mon1_room);
		monbean.setTwo_subject_id(mon2_sub);
		monbean.setTwo_room_id(mon2_room);
		monbean.setThree_subject_id(mon3_sub);
		monbean.setThree_room_id(mon3_room);
		monbean.setFour_subject_id(mon4_sub);
		monbean.setFour_room_id(mon4_room);
//		火曜日
		tuesbean.setTime_id(time_id);
		tuesbean.setDay(tuesday);
		tuesbean.setOne_subject_id(tues1_sub);
		tuesbean.setOne_room_id(tues1_room);
		tuesbean.setTwo_subject_id(tues2_sub);
		tuesbean.setTwo_room_id(tues2_room);
		tuesbean.setThree_subject_id(tues3_sub);
		tuesbean.setThree_room_id(tues3_room);
		tuesbean.setFour_subject_id(tues4_sub);
		tuesbean.setFour_room_id(tues4_room);
//		水曜日
		wedbean.setTime_id(time_id);
		wedbean.setDay(wednesday);
		wedbean.setOne_subject_id(wed1_sub);
		wedbean.setOne_room_id(wed1_room);
		wedbean.setTwo_subject_id(wed2_sub);
		wedbean.setTwo_room_id(wed2_room);
		wedbean.setThree_subject_id(wed3_sub);
		wedbean.setThree_room_id(wed3_room);
		wedbean.setFour_subject_id(wed4_sub);
		wedbean.setFour_room_id(wed4_room);
//		木曜日
		thubean.setTime_id(time_id);
		thubean.setDay(thursday);
		thubean.setOne_subject_id(thu1_sub);
		thubean.setOne_room_id(thu1_room);
		thubean.setTwo_subject_id(thu2_sub);
		thubean.setTwo_room_id(thu2_room);
		thubean.setThree_subject_id(thu3_sub);
		thubean.setThree_room_id(thu3_room);
		thubean.setFour_subject_id(thu4_sub);
		thubean.setFour_room_id(thu4_room);
//		金曜日
		fribean.setTime_id(time_id);
		fribean.setDay(friday);
		fribean.setOne_subject_id(fry1_sub);
		fribean.setOne_room_id(fry1_room);
		fribean.setTwo_subject_id(fry2_sub);
		fribean.setTwo_room_id(fry2_room);
		fribean.setThree_subject_id(fry3_sub);
		fribean.setThree_room_id(fry3_room);
		fribean.setFour_subject_id(fry4_sub);
		fribean.setFour_room_id(fry4_room);

//		subject_nameとroom_nameをbeanに格納

		for(int id : monArray){		//月曜日
			if(i == 1){
				room_name = cdao.roomName(id);
				monbean.setOne_room_name(room_name);

			}else if(i == 2){
				subject_name = cdao.subjectName(id);
				monbean.setOne_subject_name(subject_name);
			}else if(i == 3){
				room_name = cdao.roomName(id);
				monbean.setTwo_room_name(room_name);
			}else if(i == 4){
				subject_name = cdao.subjectName(id);
				monbean.setTwo_subject_name(subject_name);
			}else if(i == 5){
				room_name = cdao.roomName(id);
				monbean.setThree_room_name(room_name);
			}else if(i == 6){
				subject_name = cdao.subjectName(id);
				monbean.setThree_subject_name(subject_name);
			}else if(i == 7){
				room_name = cdao.roomName(id);
				monbean.setFour_room_name(room_name);
			}else if(i == 8){
				subject_name = cdao.subjectName(id);
				monbean.setFour_subject_name(subject_name);
			}
			i++;
		}
		i = 1;
		for(int id : tuesArray){		//火曜日
			if(i == 1){
				room_name = cdao.roomName(id);
				tuesbean.setOne_room_name(room_name);

			}else if(i == 2){
				subject_name = cdao.subjectName(id);
				tuesbean.setOne_subject_name(subject_name);
			}else if(i == 3){
				room_name = cdao.roomName(id);
				tuesbean.setTwo_room_name(room_name);
			}else if(i == 4){
				subject_name = cdao.subjectName(id);
				tuesbean.setTwo_subject_name(subject_name);
			}else if(i == 5){
				room_name = cdao.roomName(id);
				tuesbean.setThree_room_name(room_name);
			}else if(i == 6){
				subject_name = cdao.subjectName(id);
				tuesbean.setThree_subject_name(subject_name);
			}else if(i == 7){
				room_name = cdao.roomName(id);
				tuesbean.setFour_room_name(room_name);
			}else if(i == 8){
				subject_name = cdao.subjectName(id);
				tuesbean.setFour_subject_name(subject_name);
			}
			i++;
		}
		i = 1;
		for(int id : wedArray){		//水曜日
			if(i == 1){
				room_name = cdao.roomName(id);
				wedbean.setOne_room_name(room_name);
			}else if(i == 2){
				subject_name = cdao.subjectName(id);
				wedbean.setOne_subject_name(subject_name);
			}else if(i == 3){
				room_name = cdao.roomName(id);
				wedbean.setTwo_room_name(room_name);
			}else if(i == 4){
				subject_name = cdao.subjectName(id);
				wedbean.setTwo_subject_name(subject_name);
			}else if(i == 5){
				room_name = cdao.roomName(id);
				wedbean.setThree_room_name(room_name);
			}else if(i == 6){
				subject_name = cdao.subjectName(id);
				wedbean.setThree_subject_name(subject_name);
			}else if(i == 7){
				room_name = cdao.roomName(id);
				wedbean.setFour_room_name(room_name);
			}else if(i == 8){
				subject_name = cdao.subjectName(id);
				wedbean.setFour_subject_name(subject_name);
			}
			i++;
		}
		i = 1;
		for(int id : thuArray){		//木曜日
			if(i == 1){
				room_name = cdao.roomName(id);
				thubean.setOne_room_name(room_name);
			}else if(i == 2){
				subject_name = cdao.subjectName(id);
				thubean.setOne_subject_name(subject_name);
			}else if(i == 3){
				room_name = cdao.roomName(id);
				thubean.setTwo_room_name(room_name);
			}else if(i == 4){
				subject_name = cdao.subjectName(id);
				thubean.setTwo_subject_name(subject_name);
			}else if(i == 5){
				room_name = cdao.roomName(id);
				thubean.setThree_room_name(room_name);
			}else if(i == 6){
				subject_name = cdao.subjectName(id);
				thubean.setThree_subject_name(subject_name);
			}else if(i == 7){
				room_name = cdao.roomName(id);
				thubean.setFour_room_name(room_name);
			}else if(i == 8){
				subject_name = cdao.subjectName(id);
				thubean.setFour_subject_name(subject_name);
			}
			i++;
		}
		i = 1;
		for(int id : friArray){		//金曜日
			if(i == 1){
				room_name = cdao.roomName(id);
				fribean.setOne_room_name(room_name);
			}else if(i == 2){
				subject_name = cdao.subjectName(id);
				fribean.setOne_subject_name(subject_name);
			}else if(i == 3){
				room_name = cdao.roomName(id);
				fribean.setTwo_room_name(room_name);
			}else if(i == 4){
				subject_name = cdao.subjectName(id);
				fribean.setTwo_subject_name(subject_name);
			}else if(i == 5){
				room_name = cdao.roomName(id);
				fribean.setThree_room_name(room_name);
			}else if(i == 6){
				subject_name = cdao.subjectName(id);
				fribean.setThree_subject_name(subject_name);
			}else if(i == 7){
				room_name = cdao.roomName(id);
				fribean.setFour_room_name(room_name);
			}else if(i == 8){
				subject_name = cdao.subjectName(id);
				fribean.setFour_subject_name(subject_name);
			}
			i++;
		}

//		時間割の登録
		cdao.setTimeTable(monbean);
		cdao.setTimeTable(tuesbean);
		cdao.setTimeTable(wedbean);
		cdao.setTimeTable(thubean);
		cdao.setTimeTable(fribean);

	}

}
