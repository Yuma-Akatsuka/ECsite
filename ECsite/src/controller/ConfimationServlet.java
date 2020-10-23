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

import dao.ProductDao;
import dao.SalesDao;
import model.CartBean;
import model.ProductBean;
import model.userbean;

/**
 * Servlet implementation class ConfimationServlet
 */
@WebServlet("/confimation")
public class ConfimationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfimationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/login.jsp");
			rd.forward(request, response);
			return;

		}

		ProductDao productdao = new ProductDao();
		SalesDao salesdao =new SalesDao();
		ProductBean productbean = new ProductBean();
		CartBean cartbean =new CartBean();
		userbean userbean =new userbean();
		int Zaiko = 1;

		ArrayList<CartBean> cartlist = (ArrayList<CartBean>) session.getAttribute("cartlist");
		ArrayList<ProductBean> prolist = productdao.Productlist1();
		userbean = (userbean)session.getAttribute("userinfo");

		for(int i=0;i < cartlist.size();i++){
			CartBean cb = cartlist.get(i);


		for(int a=0;a < prolist.size();a++){
			ProductBean pb =prolist.get(a);
		 if(cb.getProcd() == pb.getCd()) {
			Zaiko =pb.getStock();



		 salesdao.sales(userbean.getId(),cartlist);}}

		   System.out.println(Zaiko);
		   productdao.zaiko(Zaiko-cb.getCount(),cb.getProcd());
		}
		session.removeAttribute("cartlist");
		 RequestDispatcher rd = request.getRequestDispatcher("/view/Complete.jsp");
		    rd.forward (request, response);
		    return;
	}
}
