package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
			{
			this.doPost(request, response);
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// ログインID、パスワードを取得
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String  pass = request.getParameter("pass");

		// 入力値のチェック
		if ((pass == null || name == null || tel == null) || ("".equals(pass) || "".equals(name)|| "".equals(tel))) {
			// メッセージ設定

			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;

		}else {

			HttpSession session = request.getSession();

			session.setAttribute("tourokuname", name);
			session.setAttribute("tourokutel", tel);
			session.setAttribute("tourokupass", pass);

			// 次画面指定
			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);

		}
	}
}
