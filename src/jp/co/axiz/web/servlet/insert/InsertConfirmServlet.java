package jp.co.axiz.web.servlet.insert;


	import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Userinfo;
import service.UsersService;

	@WebServlet("/insertConfirm")
	public class InsertConfirmServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 文字化け対策
			request.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();

			String pass = (String) session.getAttribute("tourokupass");
			String pass2 = request.getParameter("rePass");
			Userinfo usersinfo = new Userinfo(request.getParameter("name"), request.getParameter("tel"), request.getParameter("rePass"));
			//System.out.print(pass2);


			// 入力値のチェック
			if(pass.equals(pass2)) {

				// メッセージ設定
				System.out.print("一致");

				// ユーザーを登録
				UsersService userService = new UsersService();
				userService.register(usersinfo);

				// userを設定
				request.setAttribute("user", usersinfo);

				request.getRequestDispatcher("insertResult.jsp").forward(request, response);
				return;

			}else {

				request.setAttribute("msg", "前画面で入力したパスワードと一致しません。");
				// 次画面指定
				request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);

			}
		}
	}


