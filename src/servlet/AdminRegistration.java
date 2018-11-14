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
import model.AdminPassBean;
import model.HashPassword;

/**
 * Servlet implementation class AdminRegistration
 */
@WebServlet("/AdminRegistration")
public class AdminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";

		HttpSession session = request.getSession(false);

		if (session == null) {

			path = "WEB-INF/jsp/admin_new_regist.jsp";

		} else {
			AdminPassBean passBean = (AdminPassBean) session.getAttribute("passBean");
			AdminBean adminbean = (AdminBean) session.getAttribute("adminBean");

			// パスワードをSHA-256でハッシュ化
			HashPassword hashPass = new HashPassword();
			String encryptPass = hashPass.encryptPass(passBean.getAdminPassword());

			// passのsessionを破棄
			session.removeAttribute("passBean");

			// ユーザ情報をuserテーブルに格納
			AdminDao admindao = new AdminDao();
			admindao.registrationAdmin(adminbean);
			// パスワードをpasswordテーブルに格納
			AdminPassDao passDao = new AdminPassDao();
			passDao.registrationAdminPass(adminbean.getAdmin_id(), encryptPass);
			
			path = "WEB-INF/jsp/admin_new_regist_complete.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String admin_no = request.getParameter("no");
		String admin_name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		String encPass = "";
		String path = "";
		
		//パスワードを"*"に変換
		for(int count=0;count<pass.length();count++){
			
			encPass = encPass + "*";
			
		}
		
		AdminDao admindao = new AdminDao();
		boolean adminFlg = admindao.adminNocheck(admin_no);
		
		//管理者番号重複チェック(重複:true)
		if(adminFlg == true){
			request.setAttribute("noflg","1");
			path = "WEB-INF/jsp/admin_new_regist.jsp";
		}else{
			AdminBean adminbean = new AdminBean();
			adminbean.setAdmin_id(admin_no);
			adminbean.setAdmin_name(admin_name);
			
			AdminPassBean passbean = new AdminPassBean();
			passbean.setAdminNo(admin_no);
			passbean.setAdminPassword(pass);
			passbean.setKomePass(encPass);
			
			HttpSession session = request.getSession();
			session.setAttribute("adminBean",adminbean);
			session.setAttribute("passBean",passbean);

			path = "WEB-INF/jsp/admin_new_regist_confirmation.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
