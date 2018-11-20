package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import dao.CourseDao;
import dao.UserDao;
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
		
		try{
			HttpSession session = request.getSession();
			UserBean userbean = (UserBean) session.getAttribute("userBean");
			
			System.out.println(userbean.getMail());
			
			mail.NewRegistMail.sendMail("新規会員登録", "新規会員登録", userbean.getMail());
		} catch (MessagingException | javax.mail.MessagingException e) {
			e.printStackTrace();
		}
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
		boolean mailFlg = userdao.mailCheck(mail);
		
		//学籍番号重複チェック(重複:true)
		if(userFlg == true){
			request.setAttribute("noflg","1");
			path = "WEB-INF/jsp/new_regist.jsp";
		}else{
			//メールアドレス重複チェック(重複:true)
			if(mailFlg == true){
				request.setAttribute("mailflg","1");
				path = "WEB-INF/jsp/new_regist.jsp";
			}else{
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
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
