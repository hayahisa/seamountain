package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SearchDao;
import model.TimeListBean;

/**
 * Servlet implementation class Time_search
 */
@WebServlet("/Time_search")
public class Time_search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Time_search() {
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
		HttpSession session = request.getSession();
		String searchWord = request.getParameter("search");

		SearchDao sdao = new SearchDao();
		ArrayList<TimeListBean> timelist = sdao.searchTime(searchWord);

		session.setAttribute("allTime",timelist);

		//検索結果があるか
		if(!timelist.isEmpty()){	//検索結果あり

		}else{	//検索結果なし
			request.setAttribute("message", "該当する対象がありません");
		}

		request.getRequestDispatcher("WEB-INF/jsp/time_table_change.jsp").forward(request, response);

	}

}
