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

//		time_detailに入れるためのBEAN
		ArrayList<TimeDetailBean> mondayList = new ArrayList<>();
		ArrayList<TimeDetailBean> tuesdayList = new ArrayList<>();
		ArrayList<TimeDetailBean> wednesdayList = new ArrayList<>();
		ArrayList<TimeDetailBean> thursdayList = new ArrayList<>();
		ArrayList<TimeDetailBean> fridayList = new ArrayList<>();

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

//		subject_nameとroom_nameを取得
		for(int id : monArray){
			int i = 1;
			if(i % 2 == 0){	//room
				room_name = cdao.roomName(id);
			}else{	//subject
				subject_name = cdao.subjectName(id);
			}
			i++;
		}

		for(int id : monArray){
			int i = 1;
			if(i % 2 == 0){	//room
				room_name = cdao.roomName(id);
			}else{	//subject
				subject_name = cdao.subjectName(id);
			}
			i++;
		}

//		時間割名を挿入しIDを取得する
		int time_id = cdao.setTime(time_name);


		System.out.println(mon1_sub + "mon1_sub");
		System.out.println(mon1_room + "mon1_room");
	}

}
