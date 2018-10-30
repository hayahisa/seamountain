package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KyStateDao;
import model.TimeTableBean;
import model.UserBean;

/**
 * Servlet implementation class Timeget
 */
@WebServlet("/Timeget")
public class Timeget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Timeget() {
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
		UserBean userbean = (UserBean)session.getAttribute("userBean");
		int timeId = userbean.getTimeId();
		 TimeTableDisplay timetable = new TimeTableDisplay();
		 timetable.doPost(request, response, timeId);
		
		 Calendar cal = Calendar.getInstance();
		 
		 TimeTableBean Timelist = new TimeTableBean();
		 TimeTableBean Nexttimelist = new TimeTableBean();
		 String nextsubject="";
		 String nextroom="";
		 switch(cal.get(Calendar.DAY_OF_WEEK)){
		 case Calendar.SUNDAY://日曜
			 
			 break;
		 case Calendar.MONDAY://月曜
			 Timelist=(TimeTableBean) session.getAttribute("monday");
			 break;
		 case Calendar.TUESDAY://火曜
			 Timelist=(TimeTableBean) session.getAttribute("tuesday"); 
			 break;
		 case Calendar.WEDNESDAY://水曜
			 Timelist=(TimeTableBean) session.getAttribute("wednesday"); 
			 break;
		 case Calendar.THURSDAY://木曜
			 Timelist=(TimeTableBean) session.getAttribute("thursday"); 
			 break;
		 case Calendar.FRIDAY://金曜
			 Timelist=(TimeTableBean) session.getAttribute("friday"); 
			 break;
		 case Calendar.SATURDAY://土曜
			 
			 break;
		 }
		 //int hour=cal.get(Calendar.HOUR_OF_DAY);
		 //int min=cal.get(Calendar.MINUTE);
		 int hour=12;
		 int min=20;
		 if(hour<=9){
			if(hour==9&&min>=45){//9:45分以上
				System.out.println("9:45");
				nextsubject=Timelist.getTwo_subject_name();
				nextroom=Timelist.getTwo_room_name();
		    }else{
				nextsubject=Timelist.getOne_subject_name();
				nextroom=Timelist.getOne_room_name();
			}
		 }else if(hour==10){
				nextsubject=Timelist.getTwo_subject_name();
				nextroom=Timelist.getTwo_room_name();
		 }else if(hour==11){
			 if(min<=35){//11:35分以下
				nextsubject=Timelist.getTwo_subject_name();
				nextroom=Timelist.getTwo_room_name();
			 }else{
				nextsubject=Timelist.getThree_subject_name();
				 nextroom=Timelist.getThree_room_name();
			 }
		 }else if(hour==12){
			    nextsubject=Timelist.getThree_subject_name();
			    nextroom=Timelist.getThree_room_name();
		 }else if(hour==13){
			 if(min<=49){
				 nextsubject=Timelist.getThree_subject_name();
				 nextroom=Timelist.getThree_room_name(); 
			 }else{
				 nextsubject=Timelist.getFour_subject_name();
				 nextroom=Timelist.getFour_room_name();
			 }
		 }else if(hour==14){
			 System.out.println("14:00");
			 nextsubject=Timelist.getFour_subject_name();
			  nextroom=Timelist.getFour_room_name();
			  System.out.println("14:00");
				 System.out.println(nextsubject);
				 System.out.println(nextroom);
		 }else if(hour==15){
			 if(min<=34){
			     nextsubject=Timelist.getFour_subject_name();
				 nextroom=Timelist.getFour_room_name();	 
			 }else{
				 int day=cal.get(Calendar.DAY_OF_WEEK);
				 day=day+1;
				  switch(day){
				  case 3:
				   Nexttimelist=(TimeTableBean) session.getAttribute("tuesday");
				   break;
				  case 4:
				   Nexttimelist=(TimeTableBean) session.getAttribute("wednesday");
				   break;
				  case 5:
				   Nexttimelist=(TimeTableBean) session.getAttribute("thursday");
				   break;
				  case 6:
				   Nexttimelist=(TimeTableBean) session.getAttribute("friday");
				   break;
				  default:
				   Nexttimelist=(TimeTableBean) session.getAttribute("monday");
				   break;
				 }
				nextsubject=Nexttimelist.getOne_subject_name();
				nextroom=Nexttimelist.getOne_room_name();
			 }
		 }else{
			 int day=cal.get(Calendar.DAY_OF_WEEK);
			 System.out.println(day);
			 day=day+1;
			 System.out.println(day);
			  switch(day){
			  case 3:
			   Nexttimelist=(TimeTableBean) session.getAttribute("tuesday");
			   break;
			  case 4:
			   Nexttimelist=(TimeTableBean) session.getAttribute("wednesday");
			   break;
			  case 5:
			   Nexttimelist=(TimeTableBean) session.getAttribute("thursday");
			   break;
			  case 6:
			   Nexttimelist=(TimeTableBean) session.getAttribute("friday");
			   break;
			  default:
			   Nexttimelist=(TimeTableBean) session.getAttribute("monday");
			   break;
			 }
			nextsubject=Nexttimelist.getOne_subject_name();
			nextroom=Nexttimelist.getOne_room_name();
		 }
		 System.out.println(nextsubject);
		 System.out.println(nextroom);
		 request.setAttribute("nextsubject", nextsubject);
		 request.setAttribute("nextroom", nextroom);
		 KyStateDao KyDao = new KyStateDao();	
		 String ky=KyDao.getKeyState(nextroom);
		 request.setAttribute("ky", ky);
		doGet(request, response);
	}

}
