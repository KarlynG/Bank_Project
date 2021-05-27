package login_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import index.login;

public class login_register {
	public static ArrayList<String> datos_registro = new ArrayList<String>();
	
	public void register_user() {
		login a = new login();
		try {
			datos_registro.add(a.name);
			datos_registro.add(a.last_name);
			datos_registro.add(a.gender);
			datos_registro.add(a.email);
			datos_registro.add(a.ccard);
		}
		catch(Exception vacio) {
			JOptionPane.showMessageDialog(a.frame,
				    "Rellene todos los campos e intentelo de nuevo");
		}
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "insert into usuarios(id, Nombre, Apellidos, Genero, Tarjeta, Email, Balance, Rol)"
					+ "   values"
					+ "			(users.nextval, '@nombre', '@last_name', '@gender', @credit, '@email', 5000, 'user')";
			sql = sql.replaceAll("@nombre", datos_registro.get(0));
			sql = sql.replaceAll("@last_name", datos_registro.get(1));
			sql = sql.replaceAll("@gender", datos_registro.get(2));
			sql = sql.replaceAll("@email", datos_registro.get(3));
			sql = sql.replaceAll("@credit", datos_registro.get(4));
			
			Statement st = con.createStatement();
			
			st.executeQuery(sql);
			con.close();
			datos_registro.clear();
			
			JOptionPane.showMessageDialog(a.frame,
				    "Solicitud enviada correctamente \n"
				    + "Podrá ingresar cuando un administrador le asigne su usuario y contraseña.");
		}
		catch(Exception sqlerror) {
			datos_registro.clear();
			JOptionPane.showMessageDialog(a.frame,
				    "Escriba la información correctamente e intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
