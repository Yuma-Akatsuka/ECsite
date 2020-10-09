package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CategoryBean;

public class CategoryDao {
	public ArrayList<CategoryBean> Categorylist() {
		ArrayList<CategoryBean> cat_list = new ArrayList<CategoryBean>();
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			String query = "select * from category";
			pst = cnct.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				CategoryBean cb = new CategoryBean();
				cb.setId(rs.getInt("cat_id"));
				cb.setCategory(rs.getString("cat_name"));
				cat_list.add(cb);

			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
		return cat_list;

	}

	public String getCategoryName(int catid) {
		ArrayList<CategoryBean> cat_list = new ArrayList<CategoryBean>();
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String name = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			String query = "select * from category where cat_id= ?";
			pst = cnct.prepareStatement(query);
			pst.setInt(1, catid);
			rs = pst.executeQuery();
			rs.next();
			name = rs.getString("cat_name");

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
		return name;

	}

}
