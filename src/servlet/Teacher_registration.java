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
 * Servlet implementation class Teacher_registration
 */
@WebServlet("/Teacher_registration")
public class Teacher_registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String number = request.getParameter("number");
		String username = request.getParameter("username");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		System.out.println(number + username + mail + pass);

		String encPass = "";
		String path = "";

		//パスワードを"*"に変換
		for(int count=0;count<pass.length();count++){

			encPass = encPass + "*";

		}

		UserDao userdao = new UserDao();

		boolean userFlg = userdao.userNocheck(number);
		boolean mailFlg = userdao.mailCheck(mail);

		if(userFlg == true){
			request.setAttribute("noflg","1");
			path = "/teacher_registration.jsp";
		}else{
			//メールアドレス重複チェック(重複:true)
			if(mailFlg == true){
				request.setAttribute("mailflg","1");
				path = "/teacher_registration.jsp";
			}else{
				UserBean userbean = new UserBean();
				userbean.setUserNo(number);
				userbean.setUserName(username);
				userbean.setMail(mail);
				userbean.setCourseId(4);
				userbean.setTimeId(1);
				userbean.setUserYear(0);
				userbean.setRoleFlg("T");

				PasswordBean passbean = new PasswordBean();
				passbean.setUserNo(number);
				passbean.setPassword(pass);
				passbean.setKomePass(encPass);

//				CourseDao coursedao = new CourseDao();
//				String courseName = coursedao.selectCourseName(course);
				request.setAttribute("courseName", "教務員");

				HttpSession session = request.getSession();
				session.setAttribute("userBean",userbean);
				session.setAttribute("passBean",passbean);

				path = "WEB-INF/jsp/teacher_registration_confirm.jsp";
			}
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
