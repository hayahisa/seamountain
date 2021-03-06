package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Next_main
 */
@WebServlet("/Next_main")
public class Next_main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "";

		HttpSession session = request.getSession(false);

		if(session == null){
			path = "login.jsp";
		}else{
			path = "WEB-INF/jsp/main01.jsp";
		}

		Timeget time = new Timeget();
		time.doPost(request, response);
		request.getRequestDispatcher(path).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = "";

		HttpSession session = request.getSession(false);

		if(session == null){
			path = "login.jsp";
		}else{
			path = "WEB-INF/jsp/main01.jsp";
		}

		Timeget time = new Timeget();
		time.doPost(request, response);
		request.getRequestDispatcher(path).forward(request, response);

	}

}
