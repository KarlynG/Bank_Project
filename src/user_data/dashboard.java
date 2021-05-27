package user_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import index.Operaciones;
import index.bank;
import index.login;



public class dashboard {
	ArrayList<String> datos = new ArrayList<String>();
	
	
	public void get_dash_data() {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			System.out.println();
			String sql = "Select * from usuarios where user_id = '@user'";
			sql = sql.replace("@user", login.usuario);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				datos.add(rs.getString(1));
				datos.add(rs.getString(2));
				datos.add(rs.getString(3));
				datos.add(rs.getString(4));
				datos.add(rs.getString(5));
				datos.add(rs.getString(6));
				datos.add(rs.getString(7));
				datos.add(rs.getString(8));
				datos.add(rs.getString(9));
				datos.add(rs.getString(10));
			}
			con.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void set_dash_data() {
		Operaciones a = new Operaciones();
		
		bank.lblNombreDeUsuario.setText(datos.get(3) + " " + datos.get(4));
		bank.lblBalan.setText(datos.get(8));
		
		bank.lblNombre2Acc.setText(datos.get(3));
		bank.lblApellidoAcc.setText(datos.get(4));
		bank.lblGeneroDisplay.setText(datos.get(5));
		bank.lblEmailDisplay.setText(datos.get(7));
		bank.lblCreditAcc.setText(datos.get(6));
		bank.lblBalanceAcc.setText(datos.get(8));
		bank.lblUserAcc.setText(datos.get(1));
		bank.lblUserPassAcc.setText(datos.get(2));
		
		if (datos.get(5).equals("Femenino")) {
			bank.profileIco = new ImageIcon(bank.class.getResource("/mainIcons/senko_profile.png"));
			bank.profile.setIcon((a.resized_img(bank.profileIco, 175, 175)));
			
			bank.lblProfillePlus.setIcon((a.resized_img(bank.profileIco, 240, 240)));
		}
		else {
			bank.profileIco = new ImageIcon(bank.class.getResource("/mainIcons/male.png"));
			bank.profile.setIcon((a.resized_img(bank.profileIco, 160, 160)));
			
			bank.lblProfillePlus.setIcon((a.resized_img(bank.profileIco, 225, 225)));
		}
			
	}
	


}
