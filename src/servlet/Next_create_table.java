package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoomDao;
import dao.SubjectDao;
import model.RoomBean;
import model.SubjectBean;
import model.SubjectInfoBean;

/**
 * Servlet implementation class Next_create_table
 */
@WebServlet("/Next_create_table")
public class Next_create_table extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_create_table() {
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
		SubjectDao SD = new SubjectDao();
		SubjectInfoBean SIB = new SubjectInfoBean();

		ArrayList<RoomBean> roomArray = new ArrayList<>();
		RoomDao RD = new RoomDao();
		roomArray=RD.roomList();
		SIB = SD.getSubject();

		ArrayList<SubjectBean> mo = new ArrayList<SubjectBean>();
		mo = SIB.getSubjectArray();

		request.setAttribute("room",roomArray);
		request.setAttribute("getSub", mo);
		request.getRequestDispatcher("WEB-INF/jsp/create_table.jsp").forward(request, response);
	}

}
