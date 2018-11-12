package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.UserBean;

/**
 * Servlet implementation class AdminUserSelect
 */
@WebServlet("/AdminUserSelect")
public class AdminUserSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	//ユーザー詳細
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_no = request.getParameter("user_no");
		
		UserDao userdao = new UserDao();
		UserBean userdetails = new UserBean();
		userdetails = userdao.userSession(user_no);
		
		request.setAttribute("userdetails", userdetails);
		
		request.getRequestDispatcher("WEB-INF/jsp/admin_user_management_details.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	//ユーザー一覧
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String year[] = request.getParameterValues("year");
		String course[] = request.getParameterValues("course");
		
		ArrayList<UserBean> userArray = new ArrayList<UserBean>();
		ArrayList<Integer> yearArray = new ArrayList<Integer>();
		ArrayList<String> courseArray = new ArrayList<String>();
		
		for(int count=0;count<year.length;count++){
			yearArray.add(Integer.parseInt(year[count]));
		}
		
		for(int count=0;count<course.length;count++){
			courseArray.add(course[count]);
		}
		
		UserDao userdao = new UserDao();
		userArray = userdao.UserGetSelect(yearArray,courseArray);
		
		if(userArray.size() != 0){
			request.setAttribute("userArray", userArray);
		}else{
			
			String notResult = "検索結果がありませんでした";
			request.setAttribute("notResult", notResult);
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/admin_user_management_list.jsp").forward(request, response);
		
	}
}
