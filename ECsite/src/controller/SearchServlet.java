package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.ProductDao;
import model.CategoryBean;
import model.ProductBean;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pro_cd =request.getParameter("pro_cd");
		ProductDao pd =new ProductDao();
		ProductBean pb = pd.getProduct(Integer.parseInt(pro_cd));
		CategoryDao cd = new CategoryDao();
		String name = cd.getCategoryName(pb.getCatid());
		request.setAttribute("catname",name);
		request.setAttribute("productlist", pb);

		RequestDispatcher rd = request.getRequestDispatcher("/view/ProductDatails.jsp");
		rd.forward(request, response);

    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String keyword= request.getParameter("keyword");
		String category = request.getParameter("category");



		ProductDao productdao = new ProductDao();
		ArrayList<ProductBean> ap = new ArrayList<ProductBean>();

		if(keyword.equals("") && category.equals("")) {
			System.out.println("全取得");
			ap = productdao.Productlist1();
		}else if(!keyword.equals("") && !category.equals("")) {
			System.out.println("両方検索");
			ap = productdao.Productlist4(keyword,Integer.parseInt(category));

		}else if(!keyword.equals("")) {
			System.out.println("キーワード");
			ap = productdao.Productlist2(keyword);
		}else if(!category.equals("")) {
			System.out.println("カテゴリー");
			ap = productdao.Productlist3(Integer.parseInt(category));
		}

			CategoryDao cat_dao = new CategoryDao();
			ArrayList<CategoryBean> ac = cat_dao.Categorylist();
			request.setAttribute("categoryinfo", ac);
			request.setAttribute("pattern",ap);
			RequestDispatcher rd = request.getRequestDispatcher("/view/Search.jsp");
			rd.forward(request, response);


	}










}
