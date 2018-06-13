package jp.co.axiz.web.servlet.update;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Userinfo;
import service.UsersService;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


/*	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
			{
			this.doPost(request, response);
			}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String id = request.getParameter("id");

		if("".equals(id)) {
			request.setAttribute("msg", "必須項目を入力してください。");
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}

		// 入力値のチェック
		if(id != null  || !("".equals(id))) {

			Integer iId = Integer.parseInt(id);
			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationID_UPDATE(iId);

			 if (list ==null) {
					request.setAttribute("msg", "入力されたデータは存在しません。");
					request.getRequestDispatcher("update.jsp").forward(request, response);
					return;
			 }else {

			session.setAttribute("UserinfoList", list);
			 }

			// 次画面指定
						request.getRequestDispatcher("updateInput.jsp").forward(request, response);

		}else {

			// 次画面指定
			request.getRequestDispatcher("update.jsp").forward(request, response);

		}
	}
}

