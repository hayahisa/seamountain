package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReservationDao;
import model.ConfirmationViewBean;
import model.UserBean;

/**
 * Servlet implementation class Next_confirmation
 */
@WebServlet("/Next_confirmation")
public class Next_confirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next_confirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		自分が予約した物を確認する
		HttpSession session = request.getSession();
		ReservationDao rdao = new ReservationDao();

//		ユーザのセッションを取得
		UserBean user = new UserBean();
		user = (UserBean) session.getAttribute("userBean");
		String user_no = String.valueOf(user.getUserNo());

		ArrayList<ConfirmationViewBean> rArray = rdao.viewReservation(user_no);

		session.setAttribute("rArray", rArray);

		//リストに中身があるか
		if(!rArray.isEmpty()){	//中身あり

		}else{	//中身なし
			request.setAttribute("message", "該当する対象がありません");
		}

		request.getRequestDispatcher("WEB-INF/jsp/confirmation_view.jsp").forward(request, response);


	}

}
