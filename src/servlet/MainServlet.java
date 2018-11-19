package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import dao.UserDao;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
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
			
			String email = request.getParameter("email");
			
			UserDao userdao = new UserDao();
			boolean mailflg = userdao.mailCheck(email);
			if(mailflg == true){
				request.setAttribute("flg", "1");
				request.getRequestDispatcher("WEB-INF/jsp/re_pass.jsp").forward(request, response);
			}else{
				
				mail.Mail.sendMail("Request", "test", email);
			}
		} catch (MessagingException | javax.mail.MessagingException e) {
			e.printStackTrace();
		}
	}

}

