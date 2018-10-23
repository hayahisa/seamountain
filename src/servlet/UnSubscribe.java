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
import model.UserBean;

/**
 * Servlet implementation class UnSubscribe
 */
@WebServlet("/UnSubscribe")
public class UnSubscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnSubscribe() {
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
		
		String path = "";
		boolean flg = false;
		
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			
			path = "WEB-INF/jsp/login.jsp";
		
		} else {
			
			UserBean userbean = (UserBean) session.getAttribute("userBean");
			String pass = request.getParameter("pass");
			
			HashPassword hashPass = new HashPassword();
			String encryptPass = hashPass.encryptPass(pass);
			
			PassDao passdao = new PassDao();
			flg = passdao.passwordCheck(userbean.getUserNo(), encryptPass);
			
			System.out.println(flg);
			
			if(flg == true){
				UserDao userdao = new UserDao();
				userdao.deleteUser(userbean.getUserNo());
				
				path = "WEB-INF/jsp/unsubscribe_complete.jsp";
			}else{
				request.setAttribute("error", "1");
				path = "WEB-INF/jsp/unsubscribe.jsp";
			}
		
		request.getRequestDispatcher(path).forward(request, response);
			
		}
	}

}
