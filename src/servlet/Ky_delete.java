package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KyDao;
import model.KyBean;
import model.KyInfoBean;

/**
 * Servlet implementation class Ky_delete
 */
@WebServlet("/Ky_delete")
public class Ky_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ky_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KyDao KD = new KyDao();
		KyInfoBean KIB= new KyInfoBean();
		ArrayList<KyBean> kyArray = new ArrayList<>();
		KIB=KD.getKyall();
		ArrayList<KyBean> mo = new ArrayList<KyBean>();
		mo=KIB.getKyArray();
		request.setAttribute("kyall", mo);
		request.getRequestDispatcher("WEB-INF/jsp/admin_ky_delete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KyDao KD = new KyDao();
		KyInfoBean KIB= new KyInfoBean();
		ArrayList<KyBean> kyArray = new ArrayList<>();
		KIB=KD.getKyall();
		ArrayList<KyBean> mo = new ArrayList<KyBean>();
		mo=KIB.getKyArray();
		request.setAttribute("kyall", mo);
		request.getRequestDispatcher("WEB-INF/jsp/admin_ky_delete.jsp").forward(request, response);
	}

}
