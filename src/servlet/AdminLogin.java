package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.AdminPassDao;
import model.AdminBean;
import model.HashPassword;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/admin_Top.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminId = request.getParameter("id");
		String adminPass = request.getParameter("pass");

		String path = "";

		HashPassword hashpass = new HashPassword();
		String encryptPass = hashpass.encryptPass(adminPass);

		AdminPassDao adminpassdao = new AdminPassDao();
		boolean flg = adminpassdao.adminLogin(adminId, encryptPass);

		if(flg == true){
			//管理者情報を取得しセッションに格納
			AdminBean adminbean = new AdminBean();
			AdminDao admindao = new AdminDao();
			adminbean = admindao.getAdminInfo(adminId);

			HttpSession session = request.getSession();
			session.setAttribute("adminbean", adminbean);

			path = "WEB-INF/jsp/admin_Top.jsp";
		}else{
			request.setAttribute("msg", "　※IDかパスワードが間違っています　");
			path = "Admin_login.jsp";
		}

		request.getRequestDispatcher(path).forward(request, response);

	}

}
