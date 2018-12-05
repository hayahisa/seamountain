package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KyDao;

/**
 * Servlet implementation class KeyState
 */
@WebServlet("/KeyState")
public class KeyState extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeyState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		int ky_id = Integer.parseInt(request.getParameter("ky_id"));

		KyDao KyDao = new KyDao();
		KyDao.CancelKyState(ky_id);

		Timeget time = new Timeget();
		time.doPost(request, response);


		RequestDispatcher rd = request.getRequestDispatcher("Next_main");
        rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		int ky_id = Integer.parseInt(request.getParameter("ky_id"));

		KyDao KyDao = new KyDao();
		KyDao.ChangeKyState(ky_id);

		Timeget time = new Timeget();
		time.doPost(request, response);

		 RequestDispatcher rd = request.getRequestDispatcher("Next_main");
	        rd.forward(request, response);
	}

}
