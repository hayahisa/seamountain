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
 * Servlet implementation class Next_user_management
 */
@WebServlet("/Next_user_management")
public class Next_user_management extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_user_management() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<CourseBean> courseArray = new ArrayList<CourseBean>();
		
		CourseDao coursedao = new CourseDao();
		courseArray = coursedao.AllSelectCourse();
		
		HttpSession session = request.getSession();	
		session.setAttribute("courseArray", courseArray);
		
		request.getRequestDispatcher("WEB-INF/jsp/admin_user_management.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
