package user;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao {
	
	
	public ArrayList<User> search(String userName) {
		
		ArrayList<User> userlist = new ArrayList<User>();
		
		try {
			String sql = "select * from \"USER\" where username like "+"'%"+userName+"%'";
			String url = "jdbc:oracle:thin:@localhost:1521:xepdb1";
			String dbuser = "DLSDLWORLD";
			String password = "1234";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(url, dbuser, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setUserAge(rs.getInt(2));
				user.setUserGender(rs.getString(3));
				user.setUserEmail(rs.getString(4));
				userlist.add(user);
			}
			return userlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userlist;
	}
}
