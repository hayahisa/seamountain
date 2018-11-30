package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import dao.UserDao;

@WebServlet("/RePassMail")
public class RePassMail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(""
				+ "<form action=\"/SeaMountain/mail\" method=\"POST\">"
				+ "  <button type=\"submit\">submit</button>"
				+ "</form>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("mail post");

			String email = request.getParameter("email");

			UserDao userdao = new UserDao();
			boolean mailflg = userdao.mailCheck(email);
			if(mailflg == false){
				System.out.println("false");
				request.setAttribute("flg", "1");
				request.getRequestDispatcher("WEB-INF/jsp/re_pass.jsp").forward(request, response);
			}else{
				mail.Mail.sendMail("パスワード再設定", "パスワード再設定", email);
				System.out.println("true");

				request.getRequestDispatcher("WEB-INF/jsp/re_pass_mail_confirm.jsp").forward(request, response);
			}
		} catch (MessagingException | javax.mail.MessagingException e) {
			e.printStackTrace();
		}
	}

}

