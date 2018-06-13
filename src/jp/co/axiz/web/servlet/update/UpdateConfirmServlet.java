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

@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		List<Userinfo>list = (List<Userinfo>) session.getAttribute("UserinfoList");

		Userinfo userinfo = list.get(0);

		String id = request.getParameter("id");
		String olPass =  (String) session.getAttribute("kousinpass");
		String rePass = request.getParameter("rePass");

		// 入力値のチェック
		if(rePass.equals(olPass)) {

			System.out.print("PAss一致");

			Integer iId = Integer.parseInt(id);

			 UsersService userService = new UsersService();

			Userinfo updateinfo = (Userinfo) session.getAttribute("update");

			userService.authenticationID_UPDATE_LAST(iId,updateinfo);

			request.getRequestDispatcher("updateResult.jsp").forward(request, response);

		}else {

			request.setAttribute("msg", "前画面で入力したパスワードと一致しません。");
			request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
			return;

		}
	}
}


