package jp.co.axiz.web.servlet.delete;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Userinfo;
import service.UsersService;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


/*	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
			{
			this.doPost(request, response);
			}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		if("".equals(id)) {
			request.setAttribute("msg", "必須項目を入力してください。");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}


		// 入力値のチェック
		if(id != null  || !("".equals(id))) {

			Integer iId = Integer.parseInt(id);
			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationID(iId);

			 if (list ==null) {
					request.setAttribute("msg", "入力されたデータは存在しません。");
					request.getRequestDispatcher("delete.jsp").forward(request, response);
					return;
			 }

			//List<Userinfo> list = userService.find();
			request.setAttribute("UserinfoList", list);



			// 次画面指定
						request.getRequestDispatcher("deleteConfirm.jsp").forward(request, response);

		}else {

			request.setAttribute("msg", "入力されたデータは存在しません。");
			// 次画面指定
			request.getRequestDispatcher("delete.jsp").forward(request, response);

		}



	}

}



