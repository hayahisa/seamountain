package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminId = request.getParameter("id");
		String adminPass = request.getParameter("pass");
		
		HashPassword hashpass = new HashPassword();
		String encryptPass = hashpass.encryptPass(adminPass);
		
		AdminPassDao adminpassdao = new AdminPassDao();
		boolean flg = adminpassdao.adminLogin(adminId, encryptPass);
		
		if(flg == true){
			AdminBean adminbean = new AdminBean();
			//admindaoから管理者情報取得しセッションに格納
		}
	}

}
