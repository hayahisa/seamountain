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
		HttpSession session = request.getSession();	//セッション
		String path = null;	//遷移用path
		int len; //user_noのlength
		boolean flg; //user_noが存在するか

		UserDao udao = new UserDao();
		UserBean userbean = new UserBean();

		String user_no = request.getParameter("user_number");	//ユーザ番号
		String user_pass = request.getParameter("user_pass"); 	//ユーザパス
		int no = Integer.parseInt(user_no);

//		cookie
		Start start = new Start();

		//Cookieから"test_cookie_name"というKeyで登録された値(文字列)を取り出す
		String value = start.getCookie(request, "test_cookie_name");

		//valueがnullの場合のみCookieをセットする(期限は5分)
		if (value == null) {
//			user_noがDBに存在するか調べる
			flg = udao.userNocheck(user_no);
			if(flg == true){//user_no存在
//				cookieのset
				start.setCookie(request, response, "WEB-INF/jsp/main01.jsp", "test_cookie_name", user_no, 1 * 60);

				session.setAttribute("user_number",user_no);
				userbean = (UserBean)udao.userSession(user_no);
				session.setAttribute("userBean",userbean);	//ユーザ情報をセッションに格納

				Timeget time = new Timeget();
				time.doPost(request, response);
				path = "WEB-INF/jsp/main01.jsp";

			}else{//user_no存在しない
				request.setAttribute("msg", "　※ユーザ番号かパスワードが間違っています　");
				path = "/login.jsp";
			}

		}else{
			user_no = value;
			// パスワードをSHA-256でハッシュ化
			HashPassword hashPass = new HashPassword();
			String encryptPass = hashPass.encryptPass(user_pass);

			//LoginDao
			LoginDao ldao = new LoginDao();
			UserPassBean userpassbean = ldao.User_loginDao(user_no);

			if(ldao.User_loginDao(user_no) == null){
				request.setAttribute("msg", "　※ユーザ番号かパスワードが間違っています　");
				path = "/login.jsp";
			}else if(userpassbean.getUser_number() ==  no && userpassbean.getUser_pass().equals(encryptPass)){
				session.setAttribute("user_number",user_no);	//セッションにユーザナンバーを確認
				path = "WEB-INF/jsp/main01.jsp";
				userbean = (UserBean)udao.userSession(user_no);

				session.setAttribute("userBean",userbean);	//ユーザ情報をセッションに格納

				Timeget time = new Timeget();
				time.doPost(request, response);
				request.setAttribute("msg", "");

			}else{
				request.setAttribute("msg", "　※ユーザ番号かパスワードが間違っています　");
				path = "/login.jsp";
			}
		}
		request.getRequestDispatcher(path).forward(request, response);

	}

}
