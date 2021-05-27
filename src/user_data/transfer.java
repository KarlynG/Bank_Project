package user_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import index.bank;
import index.login;

public class transfer {
	public static String status;
	public static String esMenor;
	public static String existe;
	
	public void do_transfer(){
		String cantidad = bank.fieldAcc2.getText();
		String user = bank.fieldAcc1.getText();
		String user_check = null;
		int balance = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "Select balance from usuarios where user_id = '@user'";
			sql = sql.replaceAll("@user", login.usuario);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				balance = rs.getInt(1);
			}
			
			if (balance < Integer.parseInt(cantidad)) {
				esMenor = "true";
			}
			else {
				esMenor = "false";
			}
			
			
			con.close();
		}
		catch (Exception e) {
			System.out.println("Hubo un almacenando el balance del id, este es el error:");
			System.out.println(e);
		}
		
		if (esMenor == "false") {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				
				String sql = "Select user_id from usuarios where user_id = '@user'";
				sql = sql.replaceAll("@user", user);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					user_check = rs.getString(1);
				}
				
				if (user.equals(user_check)) {
					existe = "true";
				}
				else {
					existe = "false";
				}
				
				
				con.close();
			}
			catch (Exception e) {
				System.out.println("Hubo un fallo comparando usuarios, este es el error:");
				System.out.println(e);
			}
		}
		else {
			
		}
		if (existe == "true" && (esMenor == "false")) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				
				String sql = "update usuarios"
						+ "   set balance = balance - @salary"
						+ "   where user_id = @user";
				
				sql = sql.replaceAll("@user", login.usuario);
				sql = sql.replaceAll("@salary", cantidad);
				
				Statement st = con.createStatement();
				st.executeQuery(sql);
				
				String sql2 = "update usuarios"
						+ "   set balance = balance + @salary"
						+ "   where user_id = @user";
				
				sql2 = sql2.replaceAll("@user", user);
				sql2 = sql2.replaceAll("@salary", cantidad);
				
				st = con.createStatement();
				st.executeQuery(sql2);
				
				status = "hecho";
				con.close();
				
			}
			catch (Exception e) {
				System.out.println("Hubo un fallo en el último proceso, este es el error:");
				System.out.println(e);
			}
		}
		else {
			status = "failed";
			esMenor = "true";
			existe = "false";
		}
	}

}
