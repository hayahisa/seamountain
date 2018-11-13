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

import dao.KyDao;

/**
 * Servlet implementation class Admin_ky_change
 */
@WebServlet("/Admin_ky_change")
public class Admin_ky_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_ky_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	HttpSession session = request.getSession();

        // GETメソッドのパラメータ名を取得
    	System.out.print("aaaa1");
        Enumeration<String> names = request.getParameterNames();

        String name;        // 現在のパラメータ名
        int Ky_id = 0;        // KyID
        System.out.print("aaaa");

        // 削除ボタンがクリックされた場所を特定
        while (names.hasMoreElements()) {
            // 渡ってきたパラメータを順番に処理
            // パラメータ名を取得
            name = names.nextElement();
            if ("削除".equals(request.getParameter(name))) {
            	
            	
                Ky_id = Integer.parseInt(name);
                System.out.println(Ky_id);
                KyDao KD = new KyDao();
        		KD.DeleteKy(Ky_id);
        		System.out.println("実行完了");
            }
        }

		RequestDispatcher dispatcher = request.getRequestDispatcher("Ky_delete");
        dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("aaaa1");
		doGet(request, response);
	}

}
