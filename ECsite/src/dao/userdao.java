package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.userbean;

public class userdao{
public static userbean user(String name, String password){
	String url = "jdbc:mysql://localhost/ECsite";
	String id = "root";
	String pw = "password";
	Connection cnct = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	userbean A = new userbean();
try {
Class.forName("com.mysql.jdbc.Driver");
cnct = DriverManager.getConnection(url,id,pw);
String query = "select * from user where login_cd = ? and login_pw = ?";
pst = cnct.prepareStatement(query);
pst.setString(1,name);
pst.setString(2,password);
rs = pst.executeQuery();
if(rs.next()){

A.setId(rs.getInt("user_id"));
A.setName(rs.getString("login_cd"));
A.setPassword(rs.getString("login_pw"));


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
return A;
}

public static void account( String name, String password){
	String url = "jdbc:mysql://localhost/ECsite";
	String id = "root";
	String pw = "password";
	Connection cnct = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	try {
Class.forName("com.mysql.jdbc.Driver");
cnct = DriverManager.getConnection(url,id,pw);
String query = "insert into sales values(null,?,?)";
pst = cnct.prepareStatement(query);
userbean userbean = new userbean();
pst.setString(1,name);
pst.setString(2, password);
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
}

}
}

