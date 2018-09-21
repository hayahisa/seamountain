package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.PasswordBean;
import model.UserBean;

/**
 * Servlet implementation class UserRegistConfirmation
 */
@WebServlet("/UserRegistConfirmation")
public class UserRegistConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistConfirmation() {
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
		
		String number = request.getParameter("number");
		String username = request.getParameter("username");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		
		String path = "";
		
		UserDao userdao = new UserDao();
		boolean userFlg = userdao.userIDcheck(number);
		
		if(userFlg == false){
			request.setAttribute("msgflg","1");
			path = "WEB-INF/new_regist.jsp";
			
		}else if(userFlg = true){
			UserBean userbean = new UserBean();
			userbean.setUserNo(number);
			userbean.setUserName(username);
			userbean.setMail(mail);
			
			PasswordBean passbean = new PasswordBean();
			passbean.setUserNo(number);
			passbean.setPassword(pass);
			
			HttpSession session = request.getSession();
			session.setAttribute("userBean",userbean);
			session.setAttribute("passBean",passbean);
			
			path = "WEB-INF/new_regist_confirmation.jsp";
			
			request.getRequestDispatcher(path).forward(request, response);

		}
		
	}

}
