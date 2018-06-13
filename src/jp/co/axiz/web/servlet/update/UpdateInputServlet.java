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

@WebServlet("/updateInput")
public class UpdateInputServlet extends HttpServlet {
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

		//Userinfo userinfo = new Userinfo();

		List<Userinfo>list = (List<Userinfo>) session.getAttribute("UserinfoList");

		Userinfo userinfo = list.get(0);

		String oldName = userinfo.getUsersName();
		String oldTel = userinfo.getTelephone();
		String oldPass = userinfo.getPassword();
		String newName = request.getParameter("newName");
		String newTel = request.getParameter("newTel");
		String newPass = request.getParameter("newPass");

		// 入力値のチェック
		if(newName.equals(oldName)  && newTel.equals(oldTel)  && newPass.equals(oldPass)) {

			System.out.print("全て一致");

			request.setAttribute("msg", "1項目以上変更してください。");

			request.getRequestDispatcher("updateInput.jsp").forward(request, response);

		}else {

			session.setAttribute("kousinpass", newPass);
			userinfo = new Userinfo(request.getParameter("newName"), request.getParameter("newTel"), request.getParameter("newPass"));
			session.setAttribute("update", userinfo);

			request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
		}
	}
}


