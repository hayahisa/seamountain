package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PassDao;
import dao.UserDao;
import model.HashPassword;
import model.PasswordBean;
import model.UserBean;

/**
 * Servlet implementation class UserRegistrationConfirm
 */
@WebServlet("/UserRegistrationConfirm")
public class UserRegistrationConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationConfirm() {
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
			
			path = "WEB-INF/jsp/new_regist.jsp";
			
		} else {
			PasswordBean passBean = (PasswordBean) session.getAttribute("passBean");
			UserBean userBean = (UserBean) session.getAttribute("userBean");
			
			// パスワードをSHA-256でハッシュ化
			HashPassword hashPass = new HashPassword();
			String encryptPass = hashPass.encryptPass(passBean.getPassword());
			
			// passのsessionを破棄
			session.removeAttribute("passBean");
			
			// ユーザ情報をuserテーブルに格納
			UserDao userdao = new UserDao();
			userdao.registrationUser(userBean);
			// パスワードをpasswordテーブルに格納
			PassDao passDao = new PassDao();
			passDao.registrationPassword(userBean.getUserNo(), encryptPass);
			
			//時間割を取得
			Timeget time = new Timeget();
			time.doPost(request, response);
			
			path = "WEB-INF/jsp/new_regist_complete.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
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
