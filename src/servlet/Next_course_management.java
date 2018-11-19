package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import model.CourseBean;

/**
 * Servlet implementation class Next_course_management
 */
@WebServlet("/Next_course_management")
public class Next_course_management extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_course_management() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CourseBean cbean = new CourseBean();
		CourseDao cdao =new CourseDao();

		ArrayList<CourseBean> cList = new ArrayList<CourseBean>(); //学科一覧の為のlist
		cList=cdao.AllSelectCourse();  //学科一覧取得

		request.setAttribute("cList",cList );
		request.getRequestDispatcher("WEB-INF/jsp/department_next.jsp").forward(request, response);

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
