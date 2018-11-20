package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PassDao;
import dao.UserDao;
import model.HashPassword;

/**
 * Servlet implementation class Re_pass_regist
 */
@WebServlet("/Re_pass_regist")
public class Re_pass_regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Re_pass_regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		新しいパスワードを登録する
		
		String userno = request.getParameter("number");
		String pass = request.getParameter("pass");
		
		String path = "";
		
		// パスワードをSHA-256でハッシュ化
		HashPassword hashPass = new HashPassword();
		String encryptPass = hashPass.encryptPass(pass);
		
		UserDao userdao = new UserDao();
		boolean flg = userdao.userNocheck(userno);
		if(flg == true){
			PassDao passdao = new PassDao();
			passdao.updatePass(userno,encryptPass);
			path = "WEB-INF/jsp/new_pass_complete.jsp";
		}else{
			request.setAttribute("flg", "1");
			path = "WEB-INF/jsp/new_pass.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
