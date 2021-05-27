package user_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import index.confFrame;
import index.login;

public class config {
	
	public void complain() {
		
		switch (confFrame.lblVariable.getText()) {
		
		case "Correo electronico antiguo":
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				
				String sql = "insert into opciones (id, nombre, cambioe, otro)"
						+ "   values"
						+ "			(options.nextval, '@nombre', '@cambio', '@otro')";
				sql = sql.replaceAll("@nombre", confFrame.txtNombre.getText());
				sql = sql.replaceAll("@cambio", confFrame.txtVar.getText());
				sql = sql.replaceAll("@otro", confFrame.txtVar2.getText());
				
				Statement st = con.createStatement();
				
				st.executeQuery(sql);
				con.close();
				
			}
			catch(Exception sqlerror) {
				System.out.println("Hubo un fallo insertando el registro #1, este es el error:");
				System.out.println(sqlerror);
			}
			
			break;
			
		case "Contraseña antigua":
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				
				String sql = "insert into opciones (id, nombre, cambiop, otro)"
						+ "   values"
						+ "			(options.nextval, '@nombre', '@cambio', '@otro')";
				sql = sql.replaceAll("@nombre", confFrame.txtNombre.getText());
				sql = sql.replaceAll("@cambio", confFrame.txtVar.getText());
				sql = sql.replaceAll("@otro", confFrame.txtVar2.getText());
				
				Statement st = con.createStatement();
				
				st.executeQuery(sql);
				con.close();
				
			}
			catch(Exception sqlerror) {
				System.out.println("Hubo un fallo insertando el registro #2, este es el error:");
				System.out.println(sqlerror);
			}
			break;
		
		case "Correo electronico":
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				
				String sql = "insert into opciones (id, nombre, correo, otro)"
						+ "   values"
						+ "			(options.nextval, '@nombre', '@cambio', '@otro')";
				sql = sql.replaceAll("@nombre", confFrame.txtNombre.getText());
				sql = sql.replaceAll("@cambio", confFrame.txtVar.getText());
				sql = sql.replaceAll("@otro", confFrame.txtVar2.getText());
				
				Statement st = con.createStatement();
				
				st.executeQuery(sql);
				con.close();
				
			}
			catch(Exception sqlerror) {
				System.out.println("Hubo un fallo insertando el registro #3, este es el error:");
				System.out.println(sqlerror);
			}
			break;
		}
	}

}
