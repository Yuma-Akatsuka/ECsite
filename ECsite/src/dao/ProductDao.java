package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductBean;

public class ProductDao {
	public ArrayList<ProductBean> Productlist1(){
		ArrayList<ProductBean> pro_list1 = new ArrayList<ProductBean>();
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	cnct = DriverManager.getConnection(url,id,pw);
	String query = "select * from product";
	pst = cnct.prepareStatement(query);
	rs = pst.executeQuery();
	while(rs.next()){
		ProductBean pb = new ProductBean();
	pb.setCd(rs.getInt("pro_cd"));
	pb.setName(rs.getString("pro_name"));
	pb.setStock(rs.getInt("stock_no"));
    pb.setPrice(rs.getInt("pro_price"));
    pb.setCatid(rs.getInt("cat_id"));
    pb.setImg(rs.getString("pro_img"));
    pb.setMsg(rs.getString("pro_msg"));
    pro_list1.add(pb);




	}
	} catch(ClassNotFoundException ex){
	ex.printStackTrace();
	} catch(SQLException ex) {
	ex.printStackTrace();
	} finally {
	try {
	if (pst!=null) pst.close();
	if (cnct!=null) cnct.close();
	} catch(Exception ex) { }
	}
	return pro_list1;

	}


	public ArrayList<ProductBean> Productlist2(String name){
		ArrayList<ProductBean> pro_list2 = new ArrayList<ProductBean>();
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	cnct = DriverManager.getConnection(url,id,pw);
	String query = "select * from product where pro_name like ? ";
	pst = cnct.prepareStatement(query);
	pst.setString(1,"%" + name + "%");
	rs = pst.executeQuery();
	while(rs.next()){
		ProductBean pb = new ProductBean();
		pb.setCd(rs.getInt("pro_cd"));
		pb.setName(rs.getString("pro_name"));
		pb.setStock(rs.getInt("stock_no"));
	    pb.setPrice(rs.getInt("pro_price"));
	    pb.setCatid(rs.getInt("cat_id"));
	    pb.setImg(rs.getString("pro_img"));
	    pb.setMsg(rs.getString("pro_msg"));
	    pro_list2.add(pb);




	}
	} catch(ClassNotFoundException ex){
	ex.printStackTrace();
	} catch(SQLException ex) {
	ex.printStackTrace();
	} finally {
	try {
	if (pst!=null) pst.close();
	if (cnct!=null) cnct.close();
	} catch(Exception ex) { }
	}
	return pro_list2;

	}

	public ArrayList<ProductBean> Productlist3(int catid){
		ArrayList<ProductBean> pro_list3 = new ArrayList<ProductBean>();
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	cnct = DriverManager.getConnection(url,id,pw);
	String query ="select * from product where cat_id = ?";
	pst = cnct.prepareStatement(query);
	pst.setInt(1,catid);
	rs = pst.executeQuery();
	while(rs.next()){
		ProductBean pb = new ProductBean();
		pb.setCd(rs.getInt("pro_cd"));
		pb.setName(rs.getString("pro_name"));
		pb.setStock(rs.getInt("stock_no"));
	    pb.setPrice(rs.getInt("pro_price"));
	    pb.setCatid(rs.getInt("cat_id"));
	    pb.setImg(rs.getString("pro_img"));
	    pb.setMsg(rs.getString("pro_msg"));
	    pro_list3.add(pb);




	}
	} catch(ClassNotFoundException ex){
	ex.printStackTrace();
	} catch(SQLException ex) {
	ex.printStackTrace();
	} finally {
	try {
	if (pst!=null) pst.close();
	if (cnct!=null) cnct.close();
	} catch(Exception ex) { }
	}
	return pro_list3;

	}

	public ArrayList<ProductBean> Productlist4(String name,int catid){
		ArrayList<ProductBean> pro_list4 = new ArrayList<ProductBean>();
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	cnct = DriverManager.getConnection(url,id,pw);
	String query = "select * from product where pro_name like ? And cat_id = ? ";
	pst = cnct.prepareStatement(query);
	pst.setString(1,"%" + name + "%");
	pst.setInt(2,catid);
	rs = pst.executeQuery();
	while(rs.next()){
		ProductBean pb = new ProductBean();
		pb.setCd(rs.getInt("pro_cd"));
		pb.setName(rs.getString("pro_name"));
		pb.setStock(rs.getInt("stock_no"));
	    pb.setPrice(rs.getInt("pro_price"));
	    pb.setCatid(rs.getInt("cat_id"));
	    pb.setImg(rs.getString("pro_img"));
	    pb.setMsg(rs.getString("pro_msg"));
	    pro_list4.add(pb);




	}
	} catch(ClassNotFoundException ex){
	ex.printStackTrace();
	} catch(SQLException ex) {
	ex.printStackTrace();
	} finally {
	try {
	if (pst!=null) pst.close();
	if (cnct!=null) cnct.close();
	} catch(Exception ex) { }
	}
	return pro_list4;

	}

	public ProductBean getProduct(int pro_cd){
		ProductBean pb = new ProductBean();
		ArrayList<ProductBean> pro_list1 = new ArrayList<ProductBean>();
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	cnct = DriverManager.getConnection(url,id,pw);
	String query = "select * from product where pro_cd = ?";
	pst = cnct.prepareStatement(query);
	pst.setInt(1,pro_cd);
	rs = pst.executeQuery();
	rs.next();
	pb.setCd(rs.getInt("pro_cd"));
	pb.setName(rs.getString("pro_name"));
	pb.setStock(rs.getInt("stock_no"));
    pb.setPrice(rs.getInt("pro_price"));
    pb.setCatid(rs.getInt("cat_id"));
    pb.setImg(rs.getString("pro_img"));
    pb.setMsg(rs.getString("pro_msg"));





	} catch(ClassNotFoundException ex){
	ex.printStackTrace();
	} catch(SQLException ex) {
	ex.printStackTrace();
	} finally {
	try {
	if (pst!=null) pst.close();
	if (cnct!=null) cnct.close();
	} catch(Exception ex) { }
	}
	return pb;


	}}
