package user_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import index.bank;
import index.login;

public class withdraw {
	public static String status;
	public static String esMenor;
	
	public void do_withdraw() {
		String cantidad = bank.fieldWidth1.getText();
		String tarjeta = bank.fieldWidth2.getText();
		String tarjeta_check = null;
		int balance = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "Select tarjeta, balance from usuarios where user_id = '@user'";
			sql = sql.replaceAll("@user", login.usuario);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				tarjeta_check = rs.getString(1);
				balance = rs.getInt(2);
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
			System.out.println("Hubo un fallo recibiendo la tarjeta, este es el error:");
			System.out.println(e);
		}
		
		if (tarjeta_check.equals(tarjeta) && (esMenor == "false")) {
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
				
				status = "hecho";
				con.close();
				
			}
			catch (Exception e) {
				System.out.println("Hubo un fallo actualizando el salario, este es el error:");
				System.out.println(e);
			}
		}
		else {
			status = "failed";
			esMenor = "true";
		}
		
		
	}

}
