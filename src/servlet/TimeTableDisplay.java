package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TimeDetailDao;
import model.TimeTableBean;

/**
 * Servlet implementation class TimeTableDisplay
 */
@WebServlet("/TimeTableDisplay")
public class TimeTableDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeTableDisplay() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response,int timeId) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String monday = "monday";
		String tuesday = "tuesday";
		String wednesday = "wednesday";
		String thursday = "thursday";
		String friday = "friday";

		TimeDetailDao tddao = new TimeDetailDao();
		TimeTableBean mondaylist = new TimeTableBean();
		TimeTableBean tuesdaylist = new TimeTableBean();
		TimeTableBean wednesdaylist = new TimeTableBean();
		TimeTableBean thursdaylist = new TimeTableBean();
		TimeTableBean fridaylist = new TimeTableBean();

		mondaylist = (TimeTableBean)tddao.timetable(timeId,monday);
		tuesdaylist = (TimeTableBean)tddao.timetable(timeId,tuesday);
		wednesdaylist = (TimeTableBean)tddao.timetable(timeId,wednesday);
		thursdaylist = (TimeTableBean)tddao.timetable(timeId,thursday);
		fridaylist = (TimeTableBean)tddao.timetable(timeId,friday);

		session.setAttribute("monday", mondaylist);
		session.setAttribute("tuesday", tuesdaylist);
		session.setAttribute("wednesday", wednesdaylist);
		session.setAttribute("thursday", thursdaylist);
		session.setAttribute("friday", fridaylist);

	}

}
