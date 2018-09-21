package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("login.java");
		HttpSession session = request.getSession();	//セッション
		String path = null;	//遷移用path

		int user_no = Integer.parseInt(request.getParameter("user_number"));	//ユーザ番号
		String user_pass = request.getParameter("user_pass"); 	//ユーザパス

		System.out.println(user_no);
		System.out.println(user_pass);

		//LoginDao
		LoginDao ldao = new LoginDao();
		UserPassBean userpassbean = ldao.User_loginDao(user_no);

		if(ldao.User_loginDao(user_no) == null){
			System.out.println("e1");
			path = "/login.jsp";
		}else if(userpassbean.getUser_number() ==  user_no && userpassbean.getUser_pass().equals(user_pass)){
			session.setAttribute("user_number",user_no);	//セッションにユーザナンバーを確認
			path = "WEB-INF/jsp/main01.jsp";
			System.out.println("e2");
		}else{
			path = "/login.jsp";
			System.out.println("e3");
		}
		System.out.println(path);
		request.getRequestDispatcher(path).forward(request, response);

		System.out.println("aiueo");
	}

}
