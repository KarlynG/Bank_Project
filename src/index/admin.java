package index;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.event.MouseMotionAdapter;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import faded.FadeEffect;
import login_data.login_check;

import javax.swing.JSeparator;
import java.awt.Toolkit;

public class admin {

	public JFrame frame;
	int xMouse;
	int yMouse;
	public JTable table;
	public JTextField textField;
	public JTextField textField_1;
	private JTable table_1;
	
	ArrayList<String> datos = new ArrayList<String>();
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Eliminar usuario
	public void borrar() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "delete from usuarios"
					+ "   where id = @table";
			
			sql = sql.replaceAll("@table", (String) table_1.getModel().getValueAt(table_1.getSelectedRow(), 0));
			Statement st = con.createStatement();
			st.executeQuery(sql);
			
			JOptionPane.showMessageDialog(frame,
				    "Se ha eliminado el usuario");
			
			con.close();
			
			DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
			dtm.setRowCount(0);
			datos2();
		}
		catch (Exception ef) { 
			System.out.println(ef);
		}
	}
	
	// Agregar usuario
	public void set_user(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			String sql = "update usuarios"
					+ "   set user_id = @user, user_pass = @pass"
					+ "   where id = @table";
			
			sql = sql.replaceAll("@user", textField.getText());
			sql = sql.replaceAll("@pass", textField_1.getText());
			sql = sql.replaceAll("@table", (String) table.getModel().getValueAt(table.getSelectedRow(), 0));
			
			
			Statement st = con.createStatement();
			st.executeQuery(sql);
			
			JOptionPane.showMessageDialog(frame,
				    "Se ha agregado el usuario y la contraseña.");
			
			con.close();
			
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			data();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// Poner los datos de la tabla usuarios en la tabla normal
	public void data() {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			System.out.println();
			String sql = "select * from usuarios order by id";
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
			
			
			int numCols = table.getModel().getColumnCount();
			Object [] fila = new Object[numCols];
			
			for (int counter = 0; counter < datos.size();) {
				fila[0] = datos.get(counter);
				counter++;
				fila[1] = datos.get(counter);
				counter++;
				fila[2] = datos.get(counter);
				counter++;
				fila[3] = datos.get(counter);
				counter++;
				fila[4] = datos.get(counter);
				counter++;
				fila[5] = datos.get(counter);
				counter++;
				fila[6] = datos.get(counter);
				counter++;
				fila[7] = datos.get(counter);
				counter++;
				fila[8] = datos.get(counter);
				counter++;
				fila[9] = datos.get(counter);
				counter++;
				
				((DefaultTableModel) table.getModel()).addRow(fila);
				
			}
			datos.clear();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	// Lo mismo pero con la segunda tabla
	public void datos2() {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			System.out.println();
			String sql = "select * from usuarios order by id";
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
			
			
			int numCols = table_1.getModel().getColumnCount();
			Object [] fila = new Object[numCols];
			
			for (int counter = 0; counter < datos.size();) {
				fila[0] = datos.get(counter);
				counter++;
				fila[1] = datos.get(counter);
				counter++;
				fila[2] = datos.get(counter);
				counter++;
				fila[3] = datos.get(counter);
				counter++;
				fila[4] = datos.get(counter);
				counter++;
				fila[5] = datos.get(counter);
				counter++;
				fila[6] = datos.get(counter);
				counter++;
				fila[7] = datos.get(counter);
				counter++;
				fila[8] = datos.get(counter);
				counter++;
				fila[9] = datos.get(counter);
				counter++;
				
				((DefaultTableModel) table_1.getModel()).addRow(fila);
				
			}
			datos.clear();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	// Lo mismo pero con la tercera tabla
		public void datos3() {
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				System.out.println();
				String sql = "select * from opciones order by id";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					datos.add(rs.getString(1));
					datos.add(rs.getString(2));
					datos.add(rs.getString(3));
					datos.add(rs.getString(4));
					datos.add(rs.getString(5));
					datos.add(rs.getString(6));
				}
				con.close();
				
				
				int numCols = table_2.getModel().getColumnCount();
				Object [] fila = new Object[numCols];
				
				for (int counter = 0; counter < datos.size();) {
					fila[0] = datos.get(counter);
					counter++;
					fila[1] = datos.get(counter);
					counter++;
					fila[2] = datos.get(counter);
					counter++;
					fila[3] = datos.get(counter);
					counter++;
					fila[4] = datos.get(counter);
					counter++;
					fila[5] = datos.get(counter);
					counter++;
					
					((DefaultTableModel) table_2.getModel()).addRow(fila);
					
				}
				datos.clear();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}

	/**
	 * Create the application.
	 */
	public admin() {
		initialize();
		frame.setBackground(new Color(0, 0, 0, 0));
		FadeEffect.fadeInFrame(frame, 25, 0.1f);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Banco Dominicano: Admin");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(admin.class.getResource("/adminsrc/senko_admin.png")));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JButton btnExit = new JButton("");
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnExit.setBorder(emptyBorder);
		btnExit.setFocusPainted(false);
		
		Operaciones a = new Operaciones();
		ImageIcon imageIco = new ImageIcon(login.class.getResource("/img/close.png"));
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(51, 51, 51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setIcon((a.resized_img(imageIco, 30, 30)));
		btnExit.setBackground(new Color(0, 0, 0, 0));
		btnExit.setBounds(942, 0, 42, 38);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(30, 40, 44));
		panel_4.setBounds(20, 181, 941, 363);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_5_1 = new JButton("Actualizar Tabla");
		btnNewButton_5_1.setForeground(Color.WHITE);
		btnNewButton_5_1.setBackground(new Color(30, 40, 44));
		btnNewButton_5_1.setBounds(727, 318, 167, 34);
		panel_4.add(btnNewButton_5_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 11, 921, 172);
		panel_4.add(scrollPane_1_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Nombre", "Solicitud Email", "Solicitud Contrase\u00F1a", "Correo", "Otro"
			}
		));
		table_2.getColumnModel().getColumn(1).setPreferredWidth(89);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(112);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(131);
		scrollPane_1_1.setViewportView(table_2);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(41, 54, 47));
		panel_3_2.setBounds(10, 225, 296, 127);
		panel_4.add(panel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setBounds(20, 17, 69, 72);
		imageIco = new ImageIcon(admin.class.getResource("/adminsrc/data.png"));
		lblNewLabel_2_2.setIcon((a.resized_img(imageIco, 70, 70)));
		
		panel_3_2.add(lblNewLabel_2_2);
		
		JLabel lbleligaUnUsuario_2 = new JLabel("<html>Aqu\u00ED se pueden ver<br>la lista de las solicitudes de cambio de email, contrase\u00F1a,</br> quejas o sugerencias. </html>");
		lbleligaUnUsuario_2.setForeground(Color.WHITE);
		lbleligaUnUsuario_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbleligaUnUsuario_2.setBounds(108, 0, 178, 72);
		panel_3_2.add(lbleligaUnUsuario_2);
		
		JLabel lblAdvertenciaEstaOpcin_2 = new JLabel("en contacto con un adminitrador de la database.");
		lblAdvertenciaEstaOpcin_2.setForeground(Color.WHITE);
		lblAdvertenciaEstaOpcin_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAdvertenciaEstaOpcin_2.setBounds(10, 100, 276, 22);
		panel_3_2.add(lblAdvertenciaEstaOpcin_2);
		
		JLabel lblAdvertenciaEstaOpcin_2_1 = new JLabel("Para hacer un cambio pongase");
		lblAdvertenciaEstaOpcin_2_1.setForeground(Color.WHITE);
		lblAdvertenciaEstaOpcin_2_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAdvertenciaEstaOpcin_2_1.setBounds(108, 81, 178, 22);
		panel_3_2.add(lblAdvertenciaEstaOpcin_2_1);
		panel_4.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 40, 44));
		panel_2.setBounds(20, 181, 941, 363);
		panel_2.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 40, 44));
		panel_1.setBounds(20, 181, 941, 363);
		panel_1.setVisible(false);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 921, 172);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "user_id", "user_pass", "Nombre", "Apellido", "Genero", "Tarjeta", "Email", "Balance", "Rol"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(8).setResizable(false);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		imageIco = new ImageIcon(admin.class.getResource("/img/icon4.png"));
		lblNewLabel.setIcon((a.resized_img(imageIco, 35, 35)));
		lblNewLabel.setBounds(347, 214, 46, 41);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(403, 226, 167, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(128, 128, 128));
		separator.setBounds(403, 253, 167, 2);
		panel_1.add(separator);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(403, 278, 167, 20);
		panel_1.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(403, 305, 167, 2);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(347, 266, 46, 41);
		imageIco = new ImageIcon(admin.class.getResource("/img/icon5.png"));
		lblNewLabel_1.setIcon((a.resized_img(imageIco, 35, 35)));
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Confirmar");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				set_user();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(30, 40, 44));
		btnNewButton_3.setBounds(424, 329, 95, 23);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(41, 54, 47));
		panel_3_1.setBounds(10, 226, 296, 127);
		panel_1.add(panel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(29, 11, 69, 61);
		imageIco = new ImageIcon(admin.class.getResource("/adminsrc/set_user.png"));
		lblNewLabel_2_1.setIcon((a.resized_img(imageIco, 60, 60)));
		panel_3_1.add(lblNewLabel_2_1);
		
		JLabel lbleligaUnUsuario_1 = new JLabel("<html>Eliga un usuario de <br>la lista para asignar un ID de numero y una contrase\u00F1a. Rellene los campos con la informaci\u00F3n</br> y luego pulse el bot\u00F3n para confirmar</html>");
		lbleligaUnUsuario_1.setForeground(Color.WHITE);
		lbleligaUnUsuario_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbleligaUnUsuario_1.setBounds(108, 0, 178, 102);
		panel_3_1.add(lbleligaUnUsuario_1);
		
		JLabel lblAdvertenciaEstaOpcin_1 = new JLabel("Advertencia, esta opci\u00F3n no se puede deshacer.");
		lblAdvertenciaEstaOpcin_1.setForeground(Color.WHITE);
		lblAdvertenciaEstaOpcin_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAdvertenciaEstaOpcin_1.setBounds(10, 100, 276, 22);
		panel_3_1.add(lblAdvertenciaEstaOpcin_1);
		
		
		// Boton actualizar 1
		JButton btnNewButton_4 = new JButton("Actualizar Tabla");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(30, 40, 44));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				data();
			}
		});
		btnNewButton_4.setBackground(new Color(30, 40, 44));
		btnNewButton_4.setForeground(Color.WHITE);
		imageIco = new ImageIcon(admin.class.getResource("/adminsrc/refresh.png"));
		btnNewButton_4.setIcon((a.resized_img(imageIco, 30, 30)));
		btnNewButton_4.setBounds(727, 318, 167, 34);
		panel_1.add(btnNewButton_4);
		
		
		
		
		JButton btnNewButton_5 = new JButton("Actualizar Tabla");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_5.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_5.setBackground(new Color(30, 40, 44));
			}
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
				dtm.setRowCount(0);
				datos2();
			}
		});
		btnNewButton_5.setBackground(new Color(30, 40, 44));
		btnNewButton_5.setForeground(Color.WHITE);
		imageIco = new ImageIcon(admin.class.getResource("/adminsrc/refresh.png"));
		btnNewButton_5.setIcon((a.resized_img(imageIco, 30, 30)));
		btnNewButton_5.setBounds(727, 318, 167, 34);
		panel_2.add(btnNewButton_5);
		
		
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 921, 172);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "user_id", "user_pass", "Nombre", "Apellido", "Genero", "Tarjeta", "Email", "Balance", "Rol"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		table_1.getColumnModel().getColumn(5).setResizable(false);
		table_1.getColumnModel().getColumn(7).setResizable(false);
		table_1.getColumnModel().getColumn(8).setResizable(false);
		table_1.getColumnModel().getColumn(9).setResizable(false);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_3_1 = new JButton("Confirmar");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n = JOptionPane.showConfirmDialog(
						frame,
					    "¿Está seguro de que quiere eliminar al usuario? esta opción no se puede deshacer",
					    "Advertencia",
					    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if (n == 0) {
					try {
						borrar();
					}
					catch (Exception exec) {
						System.out.println(exec);
					}
				}
				else {
					
				}
				
			}
		});
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setBackground(new Color(30, 40, 44));
		btnNewButton_3_1.setBounds(424, 329, 95, 23);
		panel_2.add(btnNewButton_3_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(41, 54, 47));
		panel_3.setBounds(10, 225, 296, 127);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(29, 11, 69, 61);
		imageIco = new ImageIcon(bank.class.getResource("/adminsrc/question.png"));
		lblNewLabel_2.setIcon((a.resized_img(imageIco, 60, 60)));
		
		
		panel_3.add(lblNewLabel_2);
		
		JLabel lbleligaUnUsuario = new JLabel("<html>Eliga un usuario de <br>la lista para eliminarlo. Haga click a un usuario en la tabla</br> y luego pulse el boton confirmar para eliminarlo. </html>");
		lbleligaUnUsuario.setForeground(Color.WHITE);
		lbleligaUnUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbleligaUnUsuario.setBounds(108, 0, 178, 89);
		panel_3.add(lbleligaUnUsuario);
		
		JLabel lblAdvertenciaEstaOpcin = new JLabel("Advertencia, esta opci\u00F3n no se puede deshacer.");
		lblAdvertenciaEstaOpcin.setForeground(Color.WHITE);
		lblAdvertenciaEstaOpcin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAdvertenciaEstaOpcin.setBounds(10, 100, 276, 22);
		panel_3.add(lblAdvertenciaEstaOpcin);
		
		
		frame.getContentPane().add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 127, 959, 43);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ver Solicitudes de cuentas");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		
		
		btnNewButton.setBorder(emptyBorder);
		btnNewButton.setFocusPainted(false);
		imageIco = new ImageIcon(bank.class.getResource("/adminsrc/view.png"));
		btnNewButton.setIcon((a.resized_img(imageIco, 40, 40)));
		btnNewButton.setBounds(42, 0, 200, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar una cuenta");
		btnNewButton_1.setForeground(Color.WHITE);
		
		btnNewButton_1.setFocusPainted(false);
		imageIco = new ImageIcon(bank.class.getResource("/adminsrc/close.png"));
		btnNewButton_1.setIcon((a.resized_img(imageIco, 40, 40)));
		btnNewButton_1.setBorder(emptyBorder);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(270, 0, 200, 43);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cerrar");
		btnNewButton_2.setForeground(Color.WHITE);
		
		btnNewButton_2.setFocusPainted(false);
		imageIco = new ImageIcon(bank.class.getResource("/adminsrc/close2.png"));
		btnNewButton_2.setIcon((a.resized_img(imageIco, 40, 40)));
		btnNewButton_2.setBorder(emptyBorder);
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setBounds(725, 0, 200, 43);
		panel.add(btnNewButton_2);
		
		JButton btnVer3 = new JButton("Ver Solicitudes");
		btnVer3.setForeground(Color.WHITE);
		
		btnVer3.setFocusPainted(false);
		imageIco = new ImageIcon(bank.class.getResource("/adminsrc/system.png"));
		btnVer3.setIcon((a.resized_img(imageIco, 40, 40)));
		btnVer3.setBorder(emptyBorder);
		btnVer3.setBackground(Color.GRAY);
		btnVer3.setBounds(497, 0, 200, 43);
		panel.add(btnVer3);
		
		JLabel lblAdmin = new JLabel("");
		lblAdmin.setBounds(26, 42, 86, 74);
		imageIco = new ImageIcon(login.class.getResource("/adminsrc/senko_admin.png"));
		lblAdmin.setIcon((a.resized_img(imageIco, 75, 75)));
		frame.getContentPane().add(lblAdmin);
		
		JLabel lblTextAdmin = new JLabel("Administrador");
		lblTextAdmin.setForeground(Color.WHITE);
		lblTextAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblTextAdmin.setBounds(116, 42, 155, 22);
		frame.getContentPane().add(lblTextAdmin);
		
		JLabel lblEstasLogeadoComo = new JLabel("<html>Nombre: <br></br>Matric. : </html>");
		lblEstasLogeadoComo.setForeground(Color.WHITE);
		lblEstasLogeadoComo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEstasLogeadoComo.setBounds(116, 69, 78, 53);
		frame.getContentPane().add(lblEstasLogeadoComo);
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_check.datos.clear();
				
				frame.dispose();
				login b = new login();
				b.frame.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogOut.setForeground(new Color(255, 255, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogOut.setForeground(Color.CYAN);
			}
		});
		lblLogOut.setForeground(Color.CYAN);
		lblLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblLogOut.setBounds(917, 94, 59, 22);
		frame.getContentPane().add(lblLogOut);
		
		JLabel lblEstasLogeadoComo_1 = new JLabel("<html>Karlyn Garcia Rojas <br> 2019-8847</br> </html>");
		lblEstasLogeadoComo_1.setForeground(Color.WHITE);
		lblEstasLogeadoComo_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEstasLogeadoComo_1.setBounds(180, 69, 145, 53);
		frame.getContentPane().add(lblEstasLogeadoComo_1);
		
		JLabel lblIniciasteSesinComo = new JLabel("Iniciaste sesi\u00F3n como administrador");
		lblIniciasteSesinComo.setForeground(Color.WHITE);
		lblIniciasteSesinComo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblIniciasteSesinComo.setBounds(703, 94, 217, 22);
		frame.getContentPane().add(lblIniciasteSesinComo);
		
		
		// Funciones de los Botones
		// Boton solicitudes
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_4.setVisible(false);
				
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				data();
			}
		});
		
		// Boton cancelar cuenta
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_4.setVisible(false);
				
				DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
				dtm.setRowCount(0);
				datos2();
			}
		});
		
		// Botón tumbar sistema
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_4.setVisible(false);
			}
		});
		// Boton ver Número 3
		btnVer3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVer3.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVer3.setBackground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_4.setVisible(true);
				
				DefaultTableModel dtm = (DefaultTableModel) table_2.getModel();
				dtm.setRowCount(0);
				datos3();
				
			}
		});
		

		
		JLabel lblBackground = new JLabel("");
		lblBackground.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		lblBackground.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x - xMouse, y - yMouse);
			}
		});
		
		
		lblBackground.setIcon(new ImageIcon(admin.class.getResource("/adminsrc/Background2.png")));
		lblBackground.setBounds(0, 0, 984, 561);
		
		frame.getContentPane().add(lblBackground);
		
		
		
	}
}
