package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDao;
import model.SubjectBean;

/**
 * Servlet implementation class Next_subject_change
 */
@WebServlet("/Next_subject_change")
public class Next_subject_change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_subject_change() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int subjectid = Integer.parseInt(request.getParameter("subjectid"));
		
		SubjectBean subjectbean = new SubjectBean();
		SubjectDao subjectdao = new SubjectDao();
		subjectbean = subjectdao.getSubject(subjectid);
		
		request.setAttribute("subjectbean", subjectbean);
		
		request.getRequestDispatcher("WEB-INF/jsp/admin_subject_change.jsp").forward(request, response);
		
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
