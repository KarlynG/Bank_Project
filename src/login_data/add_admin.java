package login_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import login_data.login_check;

public class add_admin {
	/*
	 public static void main(String[] args) 
    { 
        login_check a = new login_check();
        a.add_user();
    } 
	 */
	
	public static void add_user(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "insert into usuarios "
					+ "	  values"
					+ "			(0, 42069, 1234, 'Karlyn', 'Garcia Rojas', 'Masrculino', '010101010101', 'karlynl251@gmail.com', 9999999999, 'admin')";
			Statement st = con.createStatement();
			st.executeQuery(sql);
			System.out.println("Funcinó!");
			
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
