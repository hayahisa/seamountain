package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubi
		String name = null;
		String result = null;
		String path = null;

		Start start = new Start();

		 //Cookieから"test_cookie_name"というKeyで登録された値(文字列)を取り出す
        String value = start.getCookie(request, "test_cookie_name");

        if(value == null){
        	path = "login.jsp";
        }else{
        	path = "WEB-INF/jsp/main01.jsp";
        }

		request.getRequestDispatcher(path).forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	public String getCookie(HttpServletRequest request,String name){
		String result = null;

		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(name.equals(cookie.getName())){
					result = cookie.getValue();
					break;
				}
			}
		}

		return result;

	}

    public void setCookie(HttpServletRequest request, HttpServletResponse response, String path, String name, String value, int maxAge) {

    	Cookie cookie = new Cookie(name,value);
    	cookie.setMaxAge(maxAge);
    	cookie.setPath(path);

    	if("https".equals(request.getScheme())){
    		cookie.setSecure(true);
    	}

    	response.addCookie(cookie);
    }



}
