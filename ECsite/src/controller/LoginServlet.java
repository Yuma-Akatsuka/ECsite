package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import dao.userdao;
import model.CategoryBean;
import model.userbean;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
		rd.forward(request, response);}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (name.equals("") || password.equals("")) {
			request.setAttribute("error1", "名前またはパスワードを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
			rd.forward(request, response);
			return;
		}
		userbean userbean = new userbean();
		userdao dao = new userdao();
		userbean = dao.user(name, password);

		if (userbean.getId() == 0) {
			request.setAttribute("error2", "名前またはパスワードが一致しません");
			RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
			rd.forward(request, response);
			return;
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("userinfo", userbean);

			CategoryDao cat_dao = new CategoryDao();
			ArrayList<CategoryBean> ac = cat_dao.Categorylist();
			request.setAttribute("categoryinfo", ac);

			RequestDispatcher rd = request.getRequestDispatcher("/view/Search.jsp");
			rd.forward(request, response);

		}



	}
}
