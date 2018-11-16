package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetSelectDays
 */
@WebServlet("/GetSelectDays")
public class GetSelectDays extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSelectDays() {
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
		doGet(request, response);
	}

	public String getSelectDays(String day) throws ServletException, IOException {
//		dayが送られてきたらその日を返す
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Calendar cal = Calendar.getInstance();
		int today = cal.get(Calendar.DAY_OF_WEEK);
		int count = 0;	//今日から予約日まで何日プラスするか
		int less = 0;	//日にちの差

//		予約する曜日をintに変換
		int resday = 0;
		switch(day){
		case "monday":
			resday = 2;
			break;
		case "tuesday":
			resday = 3;
			break;
		case "wednesday":
			resday = 4;
			break;
		case "thursday":
			resday = 5;
			break;
		case "friday":
			resday = 6;
			break;
		}

//		今日の日にちと予約の日にちを比べる
		if(today == resday){
			count = 7;
		}else if(today > resday){
			less = today - resday;
			count = 7 - less;
		}else if(today < resday){
			less = resday - today;
			count = less;
		}

//		日付の加算
		cal.add(Calendar.DATE,count);
		Date rDate = cal.getTime();
		String resDate = String.valueOf(sdf.format(rDate));

		return resDate;
	}

	public int changeDate(String resDate){
//		Stringで渡された日付をint型に変換する
		int date = 0;;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		String str = resDate;
		String[] year = str.split("年", 0);
		String[] month = year[1].split("月", 0);
		String[] day = month[1].split("日",0);

		date = Integer.parseInt(year[0] + month[0] + day[0]);


		return date;
	}
}
