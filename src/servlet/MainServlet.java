package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

@WebServlet("/mail")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(""
				+ "<form action=\"/MailTest/mail\" method=\"POST\">"
				+ "  <button type=\"submit\">submit</button>"
				+ "</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			mail.Mail.sendMail("Request", "test", "1601137@st.asojuku.ac.jp");
		} catch (MessagingException | javax.mail.MessagingException e) {
			e.printStackTrace();
		}
	}

}

