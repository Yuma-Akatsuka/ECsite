package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
import model.userbean;

/**
 * Servlet implementation class MakeAccountServlet
 */
@WebServlet("/makeaccount")
public class MakeAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/view/MakeAccount.jsp");
		rd.forward(request, response);}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (name.equals("") || password.equals("")) {
			request.setAttribute("error1", "名前またはパスワードを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/view/MakeAccount.jsp");
			rd.forward(request, response);
			return;
		}
		userbean userbean = new userbean();
		userdao dao = new userdao();
		int count =dao.account(name);


		if (count != 0) {
			request.setAttribute("error2", "この名前は既に使われています");
			RequestDispatcher rd = request.getRequestDispatcher("/view/MakeAccount.jsp");
			rd.forward(request, response);
			return;

	}else {
			dao.accountadd(name,password);
		request.setAttribute("OK", "登録完了");
		 RequestDispatcher rd = request.getRequestDispatcher("/view/MakeAccount.jsp");
		    rd.forward (request, response);
		    return;
	}

	}}





