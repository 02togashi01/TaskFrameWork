package jp.co.axiz.web.servlet.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Userinfo;
import service.UsersService;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");

		// 入力値のチェック
		//未入力
		if ((id == null && name == null && tel == null) || ("".equals(id) && "".equals(name)&& "".equals(tel))) {
			// メッセージ設定
			UsersService userService = new UsersService();

			List<Userinfo> list = userService.find();
			request.setAttribute("UserinfoList", list);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);

			//IDのみ
		}else if ((id != null && name == null && tel == null) || (!("".equals(id)) && "".equals(name)&& "".equals(tel))) {

			try {
				Integer iId = Integer.parseInt(id);
				UsersService userService = new UsersService();
				List<Userinfo> list = userService.authenticationID(iId);

				if (list ==null) {
					request.setAttribute("msg", "入力されたデータはありませんでした。");
					request.getRequestDispatcher("select.jsp").forward(request, response);
					return;
				}

				request.setAttribute("UserinfoList", list);

				// 次画面指定
				request.getRequestDispatcher("selectResult.jsp").forward(request, response);

			} catch (NumberFormatException e) {
				request.setAttribute("msg", "入力されたデータはありませんでした。");
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}

			//nameのみ
		}else if((id == null && name != null && tel == null) || ("".equals(id) && !("".equals(name))&& "".equals(tel))) {

			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationname(name);

			if (list ==null) {
				request.setAttribute("msg", "入力されたデータはありませんでした。");
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}

			//List<Userinfo> list = userService.find();
			request.setAttribute("UserinfoList", list);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);

			//telのみ
		}else if((id == null && name == null && tel != null) || ("".equals(id) && "".equals(name)&& !("".equals(tel)))) {

			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationtel(tel);

			if (list ==null) {
				request.setAttribute("msg", "入力されたデータはありませんでした。");
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}

			//List<Userinfo> list = userService.find();
			request.setAttribute("UserinfoList", list);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);

			//name,tel
		}else if((id == null && name != null && tel != null) || ("".equals(id)) && !("".equals(name))&& !("".equals(tel))) {

			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationnameANDtel(name,tel);

			if (list ==null) {
				request.setAttribute("msg", "入力されたデータはありませんでした。");
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}

			//List<Userinfo> list = userService.find();
			request.setAttribute("UserinfoList", list);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);

			//id,tel
		}else if((id != null && name == null && tel != null) || (!("".equals(id))) && "".equals(name)&& !("".equals(tel))) {

			try {
				Integer iId = Integer.parseInt(id);
				UsersService userService = new UsersService();
				List<Userinfo> list = userService.authenticationidANDtel(iId,tel);

				if (list ==null) {
					request.setAttribute("msg", "入力されたデータはありませんでした。");
					request.getRequestDispatcher("select.jsp").forward(request, response);
					return;
				}

				//List<Userinfo> list = userService.find();
				request.setAttribute("UserinfoList", list);

				// 次画面指定
				request.getRequestDispatcher("selectResult.jsp").forward(request, response);

			} catch (NumberFormatException e) {
				request.setAttribute("msg", "入力されたデータはありませんでした。");
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}

			//id,name
		}else if((id != null && name != null && tel == null) || (!("".equals(id))) && !("".equals(name))&& "".equals(tel)) {
			try {
				Integer iId = Integer.parseInt(id);
				UsersService userService = new UsersService();
				List<Userinfo> list = userService.authenticationidANDname(iId,name);

				if (list ==null) {
					request.setAttribute("msg", "入力されたデータはありませんでした。");
					request.getRequestDispatcher("select.jsp").forward(request, response);
					return;
				}

				//List<Userinfo> list = userService.find();
				request.setAttribute("UserinfoList", list);

				// 次画面指定
				request.getRequestDispatcher("selectResult.jsp").forward(request, response);

			} catch (NumberFormatException e) {
				request.setAttribute("msg", "入力されたデータはありませんでした。");
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}

			//id,name,tel
		}else if((id != null && name != null && tel != null) || (!("".equals(id))) && !("".equals(name))&& !("".equals(tel))) {
			try {
				Integer iId = Integer.parseInt(id);
				UsersService userService = new UsersService();
				List<Userinfo> list = userService.authenticationidANDnameANDtel(iId,name,tel);

				if (list ==null) {
					request.setAttribute("msg", "入力されたデータはありませんでした。");
					request.getRequestDispatcher("select.jsp").forward(request, response);
					return;
				}

				//List<Userinfo> list = userService.find();
				request.setAttribute("UserinfoList", list);

				// 次画面指定
				request.getRequestDispatcher("selectResult.jsp").forward(request, response);

			} catch (NumberFormatException e) {
				request.setAttribute("msg", "入力されたデータはありませんでした。");
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}
		}
	}
}
