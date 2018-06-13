package jp.co.axiz.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Userinfo;
import entity.Users;
import service.UsersService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// ログインID、パスワードを取得
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// 入力値のチェック
		if ((id == null || pass == null) || ("".equals(id)) || ("".equals(pass))) {
			// メッセージ設定
			request.setAttribute("msg", "IDまたはPASSが間違っています。");

			// 次画面指定
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		// ログインチェック null以外 DBから取得、判定用インスタンスへ入れる
		UsersService userService = new UsersService();
		Users user = userService.authentication(id, pass);
		boolean isSuccess = user != null;

		// 表示メッセージの受け渡し
		if (isSuccess) {
			List<Userinfo> list = userService.find();
			request.setAttribute("usersList", list);

			//未ログインのリダイレクト
			HttpSession session = request.getSession();
			session.setAttribute("Name", user.getUsersName());

			// 次画面指定
			request.getRequestDispatcher("menu.jsp").forward(request, response);

		} else {
			// メッセージ設定
			request.setAttribute("msg", "IDまたはPASSが間違っています。");

			// 次画面指定
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
