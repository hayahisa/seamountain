package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDao;
import model.CourseBean;

/**
 * Servlet implementation class Next_new_regist
 */
@WebServlet("/Next_new_regist")
public class Next_new_regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_new_regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CourseDao coursedao = new CourseDao();
		ArrayList<CourseBean> courseArray = new ArrayList<CourseBean>();
		
		courseArray = coursedao.AllSelectCourse();
		
		HttpSession session = request.getSession();
		session.setAttribute("courseArray", courseArray);
		
		request.getRequestDispatcher("WEB-INF/jsp/new_regist.jsp").forward(request, response);
	}

}
