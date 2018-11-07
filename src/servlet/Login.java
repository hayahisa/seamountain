package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.UserDao;
import model.HashPassword;
import model.UserBean;
import model.UserPassBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response)
		HttpSession session = request.getSession();	//セッション
		String path = null;	//遷移用path
		int len; //user_noのlength

		UserDao udao = new UserDao();
		UserBean userbean = new UserBean();

		String user_no = request.getParameter("user_number");	//ユーザ番号
		String user_pass = request.getParameter("user_pass"); 	//ユーザパス
		int no = Integer.parseInt(user_no);

		// パスワードをSHA-256でハッシュ化
		HashPassword hashPass = new HashPassword();
		String encryptPass = hashPass.encryptPass(user_pass);


		//LoginDao
		LoginDao ldao = new LoginDao();
		UserPassBean userpassbean = ldao.User_loginDao(user_no);
		
		if(ldao.User_loginDao(user_no) == null){
			path = "/login.jsp";
		}else if(userpassbean.getUser_number() ==  no && userpassbean.getUser_pass().equals(encryptPass)){
			session.setAttribute("user_number",user_no);	//セッションにユーザナンバーを確認
			path = "WEB-INF/jsp/main01.jsp";
			userbean = (UserBean)udao.userSession(user_no);

			session.setAttribute("userBean",userbean);	//ユーザ情報をセッションに格納
			
			 Timeget time = new Timeget();
			 time.doPost(request, response);

		}else{
			path = "/login.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);

	}

}
