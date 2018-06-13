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

@WebServlet("/deleteConfirm")
public class DeleteConfirmServlet extends HttpServlet {
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


		// 入力値のチェック
		if(id != null  || !("".equals(id))) {

			Integer iId = Integer.parseInt(id);
			UsersService userService = new UsersService();
			List<Userinfo> list = userService.authenticationID_DELETE(iId);


			//List<Userinfo> list = userService.find();
			request.setAttribute("UserinfoList", list);



			// 次画面指定
						request.getRequestDispatcher("deleteResult.jsp").forward(request, response);

		}else {


			// 次画面指定
			request.getRequestDispatcher("delete.jsp").forward(request, response);

		}



	}

}
