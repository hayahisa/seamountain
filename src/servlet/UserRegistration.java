package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDao;
import dao.PassDao;
import dao.UserDao;
import model.HashPassword;
import model.PasswordBean;
import model.UserBean;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
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

		String number = request.getParameter("number");
		String username = request.getParameter("username");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		int course = Integer.parseInt(request.getParameter("course"));
		int useryear = Integer.parseInt(request.getParameter("useryear"));
		
		String encPass = "";
		String path = "";
		
		//パスワードを"*"に変換
		for(int count=0;count<pass.length();count++){
			
			encPass = encPass + "*";
			
		}
		
		UserDao userdao = new UserDao();
		
		boolean userFlg = userdao.userNocheck(number);
		//学籍番号重複チェック
		if(userFlg == false){
			request.setAttribute("msgflg","1");
			path = "WEB-INF/jsp/new_regist.jsp";

		}else if(userFlg == true){
			UserBean userbean = new UserBean();
			userbean.setUserNo(number);
			userbean.setUserName(username);
			userbean.setMail(mail);
			userbean.setCourseId(course);
			userbean.setTimeId(1);
			userbean.setUserYear(useryear);
			userbean.setRoleFlg("S");

			PasswordBean passbean = new PasswordBean();
			passbean.setUserNo(number);
			passbean.setPassword(pass);
			passbean.setKomePass(encPass);
			
			CourseDao coursedao = new CourseDao();
			String courseName = coursedao.selectCourseName(course);
			request.setAttribute("courseName", courseName);
			
			HttpSession session = request.getSession();
			session.setAttribute("userBean",userbean);
			session.setAttribute("passBean",passbean);

			path = "WEB-INF/jsp/new_regist_confirmation.jsp";

		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
