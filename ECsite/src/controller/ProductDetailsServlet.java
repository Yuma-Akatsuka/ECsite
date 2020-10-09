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

import model.CartBean;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  	request.setCharacterEncoding("UTF-8");
	  	HttpSession session = request.getSession();
        int count = Integer.parseInt(request.getParameter("count"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int procd = Integer.parseInt(request.getParameter("procd"));
        ArrayList<CartBean> cp =  (ArrayList<CartBean>)session.getAttribute("productbean");
        if(cp == null) {
        cp =new ArrayList<CartBean>();
        }
        CartBean pb =new CartBean();
        pb.setName(name);
        pb.setPrice(price);
        pb.setCount(count);
        pb.setProcd(procd);
        cp.add(pb);
        session.setAttribute("productbean",cp);

	    RequestDispatcher rd = request.getRequestDispatcher("/view/Cart.jsp");
	    rd.forward (request, response);
	    return;



	}



}
