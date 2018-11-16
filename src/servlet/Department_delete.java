package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DepartmentDao;

/**
 * Servlet implementation class Department_delete
 */
@WebServlet("/Department_delete")
public class Department_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Department_delete() {
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
		HttpSession session = request.getSession();

		// GETメソッドのパラメータ名を取得
		Enumeration<String> names = request.getParameterNames();

		String name;        // 現在のパラメータ名
		int subject_id = 0;        // KyID

		// 削除ボタンがクリックされた場所を特定
		while (names.hasMoreElements()) {
		    // 渡ってきたパラメータを順番に処理
		    // パラメータ名を取得
		    name = names.nextElement();
		    if ("削除".equals(request.getParameter(name))) {

		        subject_id = Integer.parseInt(name);

		        DepartmentDao ddao = new DepartmentDao();
				    ddao.subjectDelete(subject_id);
				System.out.println("実行完了");
		    }
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("Sub_delete");
		dispatcher.forward(request, response);
	}

}