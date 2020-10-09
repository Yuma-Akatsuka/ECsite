package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CartBean;

public class SalesDao {
public void sales(int userid,ArrayList<CartBean> cartlist){
	String url = "jdbc:mysql://localhost/ECsite";
	String id = "root";
	String pw = "password";
	Connection cnct = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		cnct = DriverManager.getConnection(url,id,pw);
		String query = "insert into sales values(null,?,?,now(),?)";
		pst = cnct.prepareStatement(query);
		CartBean cartbean= new CartBean();
		for(int i=0;i < cartlist.size();i++) {
		cartbean =cartlist.get(i);
		pst.setInt(1,userid);
		pst.setInt(2,cartbean.getProcd());
		pst.setInt(3,cartbean.getPrice() * cartbean.getCount());}
		pst.executeUpdate();
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
			} catch(SQLException ex) {
			ex.printStackTrace();
			} finally {
			try {
			if (pst!=null) pst.close();
			if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
			}}}

