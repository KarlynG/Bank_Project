package login_data;
import java.sql.*;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import faded.FadeEffect;
import index.login;

import index.admin;
import index.bank;


public class login_check {
	public static ArrayList<String> datos = new ArrayList<String>();
	
	public static String state;
	
	public void check_user() {
		login b = new login();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "Select * from usuarios where user_id = '@user'";
			sql = sql.replaceAll("@user", b.usuario);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				datos.add(rs.getString(2));
				datos.add(rs.getString(3));
				datos.add(rs.getString(10));
			}
			
			
			
			con.close();
		}
		catch (Exception e) {
			state = "failed";
		}
		
		
		try {
			switch(datos.get(2)) {
			case "user":
				if (datos.get(0).equals(b.usuario) && datos.get(1).equals(b.password)) {
					login log = new login();
					state = "successful_user";
				}
				else {
					JOptionPane.showMessageDialog(b.frame,
						    "Usuario o contraseña incorrecto");
					state = "failed";
				}
				break;
			case "admin":
				if (datos.get(0).equals(b.usuario) && datos.get(1).equals(b.password)) {
					state = "successful_admin";
				}
				else {
					JOptionPane.showMessageDialog(b.frame,
						    "Usuario o contraseña incorrecto");
					state = "failed";
				}
				break;
			}
			
		}
		catch (Exception r) {
			JOptionPane.showMessageDialog(b.frame,
				    "Usuario o contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			state = "failed";
			
		}
		
		
	}

}
