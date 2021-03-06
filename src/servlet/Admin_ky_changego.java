package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KyDao;
import model.KyBean;

/**
 * Servlet implementation class Admin_ky_changego
 */
@WebServlet("/Admin_ky_changego")
public class Admin_ky_changego extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_ky_changego() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ky_id = Integer.parseInt(request.getParameter("Ky_id"));

		KyBean kybean = new KyBean();
		KyDao kdao = new KyDao();
		kybean = kdao.getKyName(ky_id);

		request.setAttribute("kybean", kybean);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/admin_ky_change.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
