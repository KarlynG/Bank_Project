package user_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import index.bank;
import index.login;

public class transaction {
	public static String status;
	
	public void do_transaction() {
		String cantidad = bank.fieldTrans1.getText();
		String tarjeta = bank.fieldTrans2.getText();
		String tarjeta_check = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "Select tarjeta from usuarios where user_id = '@user'";
			sql = sql.replaceAll("@user", login.usuario);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				tarjeta_check = rs.getString(1);
			}
			
			con.close();
		}
		catch (Exception e) {
			System.out.println("Hubo un fallo recibiendo la tarjeta, este es el error:");
			System.out.println(e);
		}
		
		if (tarjeta_check.equals(tarjeta)) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				
				String sql = "update usuarios"
						+ "   set balance = balance + @salary"
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
		}
		
		
	}

}
