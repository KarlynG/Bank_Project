package index;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import faded.FadeEffect;
import login_data.login_check;
import login_data.login_register;

import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class login {

	public JFrame frame = new JFrame();
	public JTextField textfieldN;
	public JTextField textfieldC;
	private JTextField nombreR;
	private JTextField passR;
	private JTextField emailR;
	private JTextField creditR;
	private JComboBox comboBox = new JComboBox();
	
	int xMouse;
	int yMouse;
	
	public static String usuario;
	public static String password;
	
	public static String name;
	public static String last_name;
	public static String gender;
	public static String email;
	public static String ccard;
	public JLabel lblNewLabel_1 = new JLabel("Leer Terminos");
	public JLabel lblNoAcc = new JLabel("¿No tienes cuenta? Registrarse");
	public JLabel lblNewLabel = new JLabel("Cargando, por favor espere...");
	public JLabel lblNombre = new JLabel("variable");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		frame.getContentPane().setBackground(new Color(0, 0, 0, 0));
		frame.setTitle("Banco Dominicano: Login");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/adminsrc/senko_admin.png")));
		frame.setBackground(new Color(0, 0, 0, 0));
		FadeEffect.fadeInFrame(frame, 25, 0.1f);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setResizable(false);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setLayout(null);
	
		
	// Primer panel
		JPanel pnlLeft = new JPanel();
		pnlLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		pnlLeft.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x - xMouse, y - yMouse);
				
			}
		});
		pnlLeft.setBackground(Color.DARK_GRAY);
		pnlLeft.setBounds(0, 0, 460, 624);
		frame.getContentPane().add(pnlLeft);
		pnlLeft.setLayout(null);
		
		Operaciones a = new Operaciones();
		ImageIcon imageIcon = new ImageIcon(login.class.getResource("/img/16-512.png"));
		
		// Bottom text
		JLabel label1 = new JLabel("Programa hecho por \r\n");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Myanmar Text", Font.PLAIN, 11));
		label1.setBounds(83, 564, 113, 38);
		pnlLeft.add(label1);
		
		//Bottom text 2
		JLabel label2 = new JLabel("Karlyn Garcia Rojas 2019-8847");
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Myanmar Text", Font.BOLD, 11));
		label2.setBounds(195, 564, 178, 38);
		pnlLeft.add(label2);
		ImageIcon imageIcon2 = new ImageIcon(login.class.getResource("/img/icon1.png"));
		ImageIcon imageIcon3 = new ImageIcon(login.class.getResource("/img/icon2.png"));
		ImageIcon imageIcon4 = new ImageIcon(login.class.getResource("/img/icon3.png"));
		
		JPanel pnlSemiTransparent = new JPanel();
		pnlSemiTransparent.setBackground(new Color(0, 206, 209, 100));
		pnlSemiTransparent.setBounds(10, 169, 440, 187);
		pnlLeft.add(pnlSemiTransparent);
		
		JLabel lblBankIco = new JLabel("");
		lblBankIco.setBounds(9, 5, 160, 160);
		imageIcon4 = new ImageIcon(login.class.getResource("/img/16-512.png"));
		pnlSemiTransparent.setLayout(null);
		lblBankIco.setIcon((a.resized_img(imageIcon4, 160, 160)));
		pnlSemiTransparent.add(lblBankIco);
		
		JLabel lblBanco = new JLabel("<html>El banco de<br>los dominicanos</br></html>");
		lblBanco.setForeground(new Color(255, 255, 255));
		lblBanco.setFont(new Font("Mongolian Baiti", Font.PLAIN, 39));
		lblBanco.setBounds(174, 39, 257, 92);
		pnlSemiTransparent.add(lblBanco);
		
		JLabel lblBanco_1 = new JLabel("Empiece hoy y reciba un bono de 5,000$ en el saldo de su cuenta");
		lblBanco_1.setForeground(Color.WHITE);
		lblBanco_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		lblBanco_1.setBounds(28, 370, 412, 18);
		pnlLeft.add(lblBanco_1);
		
		JLabel lblLoginBackground = new JLabel("");
		imageIcon4 = new ImageIcon(login.class.getResource("/img/LoginBack2.png"));
		lblLoginBackground.setIcon((a.resized_img(imageIcon4, 480, 620)));
		lblLoginBackground.setBounds(0, 0, 460, 618);
		pnlLeft.add(lblLoginBackground);
		
		
		
		
		
		// Panel cargando
		JPanel pnlLoading = new JPanel();
		pnlLoading.setBackground(Color.WHITE);
		pnlLoading.setBounds(420, 18, 427, 585);
		pnlLoading.setVisible(false);
		frame.getContentPane().add(pnlLoading);
		pnlLoading.setLayout(null);
		
		
		
	// Segundo Panel
		JPanel pnlRight = new JPanel();
		pnlRight.setBackground(Color.WHITE);
		pnlRight.setBounds(420, 18, 427, 585);
		frame.getContentPane().add(pnlRight);
		pnlRight.setLayout(null);
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblNewLabel_1.setForeground(Color.CYAN);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel_1.setForeground(new Color(0, 0, 255));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(frame,
						    "Al crearse la cuenta usted acepta que tendremos acceso\n"
						   +"a toda su información personal, incluyendo contactos y \n"
						   + "cuentas bancarias.\n"
						   + "Como agradecimiento por crearse la cuenta usted obtendra un\n"
						   + "bono de 5,000 pesos para usarlos como guste.", "Terminos y condiciones", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			
			JLabel lblLoading = new JLabel("");
			lblLoading.setBackground(Color.WHITE);
			lblLoading.setIcon(new ImageIcon(login.class.getResource("/img/loading.gif")));
			lblLoading.setBounds(89, 134, 316, 182);
			pnlLoading.add(lblLoading);
			
			
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(29, 233, 182));
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			lblNewLabel.setBounds(71, 292, 346, 76);
			pnlLoading.add(lblNewLabel);
			
			lblNombre.setVisible(false);
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setForeground(new Color(29, 233, 182));
			lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			lblNombre.setBounds(114, 353, 262, 38);
			pnlLoading.add(lblNombre);
			
			JButton btnClose = new JButton("");
			btnClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnClose.setBackground(Color.LIGHT_GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnClose.setBackground(Color.white);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					FadeEffect.fadeOutFrameSplash(frame, 25, 0.1f);
				}
			});
			btnClose.setBackground(Color.white);
			btnClose.setBounds(364, 11, 45, 44);
			
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnClose.setBorder(emptyBorder);
			btnClose.setFocusPainted(false);
			imageIcon4 = new ImageIcon(login.class.getResource("/img/close.png"));
			btnClose.setIcon((a.resized_img(imageIcon4, 30, 30)));
			pnlRight.add(btnClose);
			
			lblNewLabel_1.setForeground(new Color(0, 0, 255));
			lblNewLabel_1.setBackground(new Color(192, 192, 192));
			lblNewLabel_1.setBounds(317, 403, 130, 25);
			lblNewLabel_1.setVisible(false);
			pnlRight.add(lblNewLabel_1);
			
			JLabel lblCuenta = new JLabel("¿Ya tienes cuenta? Log in");
			
			lblCuenta.setForeground(new Color(0, 0, 255));
			lblCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblCuenta.setBounds(70, 514, 339, 25);
			lblCuenta.setVisible(false);
			pnlRight.add(lblCuenta);
			lblNoAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
			lblNoAcc.setForeground(new Color(0, 0, 255));
			lblNoAcc.setBackground(new Color(192, 192, 192));
			lblNoAcc.setBounds(212, 384, 197, 25);
			pnlRight.add(lblNoAcc);
		
		// Texto Nombre de Usuario
			JLabel labelN = new JLabel("Ingrese un ID");
			labelN.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
			labelN.setBounds(83, 97, 208, 40);
			pnlRight.add(labelN);
			
			// Textfield 
			textfieldN = new JTextField();
			textfieldN.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Para que no tenga borde
			textfieldN.setColumns(10);
			textfieldN.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
			textfieldN.setForeground(Color.GRAY);
			textfieldN.setBounds(118, 148, 259, 27);
			pnlRight.add(textfieldN);
			
			JSeparator separator = new JSeparator(); // Separador
			separator.setBounds(83, 184, 304, 199);
			pnlRight.add(separator);
			
			// Texto contraseña
			JLabel labelC = new JLabel("Contrase\u00F1a");
			labelC.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
			labelC.setBounds(83, 240, 208, 40);
			pnlRight.add(labelC);
			
			JSeparator separator_1 = new JSeparator(); // Separador
			separator_1.setBounds(83, 327, 304, 56);
			pnlRight.add(separator_1);
			
			// PasswordField
			textfieldC = new JPasswordField();
			textfieldC.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Para que no tenga borde
			textfieldC.setForeground(Color.GRAY);
			textfieldC.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
			textfieldC.setBounds(118, 294, 259, 27);
			pnlRight.add(textfieldC);
			textfieldC.setColumns(10);
		
		// Registro nombre
			JLabel labelNR = new JLabel("Nombre");
			labelNR.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
			labelNR.setBounds(83, 51, 208, 20);
			labelNR.setVisible(false);
			pnlRight.add(labelNR);
			
			nombreR = new JTextField();
			nombreR.setBounds(114, 79, 263, 20);
			nombreR.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Para que no tenga borde
			nombreR.setForeground(Color.GRAY);
			nombreR.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
			nombreR.setColumns(10);
			nombreR.setVisible(false);
			pnlRight.add(nombreR);
			
			JSeparator separatorR = new JSeparator();
			separatorR.setBounds(83, 104, 304, 279);
			separatorR.setVisible(false);
			pnlRight.add(separatorR);
			
			// Registro contraseña
			JLabel labelCR = new JLabel("Apellido");
			labelCR.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
			labelCR.setBounds(83, 116, 208, 20);
			labelCR.setVisible(false);
			pnlRight.add(labelCR);
			
			passR = new JTextField();
			passR.setColumns(10);
			passR.setBounds(114, 144, 263, 20);
			
			passR.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Para que no tenga borde
			passR.setForeground(Color.GRAY);
			passR.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
			pnlRight.add(passR);
			passR.setVisible(false);
			
			JSeparator separatorR2 = new JSeparator();
			separatorR2.setBounds(83, 169, 304, 214);
			separatorR2.setVisible(false);
			pnlRight.add(separatorR2);
			
			// Registro Genero
			JLabel lblGender = new JLabel("Genero");
			lblGender.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
			lblGender.setBounds(83, 184, 208, 20);
			lblGender.setVisible(false);
			pnlRight.add(lblGender);
			
			
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino", "Otro"}));
			comboBox.setBounds(114, 215, 263, 22);
			comboBox.setBorder(emptyBorder);
			comboBox.setVisible(false);
			pnlRight.add(comboBox);
			
			JSeparator separatorG1 = new JSeparator();
			separatorG1.setBounds(83, 249, 304, 134);
			separatorG1.setVisible(false);
			pnlRight.add(separatorG1);
			
			// Registro email
			JLabel labelE = new JLabel("Ingrese su correo electronico");
			labelE.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
			labelE.setBounds(83, 264, 232, 20);
			labelE.setVisible(false);
			pnlRight.add(labelE);
			
			emailR = new JTextField();
			emailR.setColumns(10);
			emailR.setBounds(114, 292, 263, 20);
			
			emailR.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Para que no tenga borde
			emailR.setForeground(Color.GRAY);
			emailR.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
			
			pnlRight.add(emailR);
			emailR.setVisible(false);
			
			JSeparator separatorR_1 = new JSeparator();
			separatorR_1.setBounds(83, 317, 304, 66);
			separatorR_1.setVisible(false);
			pnlRight.add(separatorR_1);
			
			// Registro tarjeta de credito
			JLabel lblTarjetaDeCredito = new JLabel("Tarjeta de credito");
			lblTarjetaDeCredito.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
			lblTarjetaDeCredito.setBounds(83, 329, 208, 20);
			lblTarjetaDeCredito.setVisible(false);
			pnlRight.add(lblTarjetaDeCredito);
			
			creditR = new JTextField();
			creditR.setColumns(10);
			creditR.setBounds(114, 357, 263, 20);
			
			creditR.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Para que no tenga borde
			creditR.setForeground(Color.GRAY);
			creditR.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
			
			pnlRight.add(creditR);
			creditR.setVisible(false);
			
			JSeparator separatorR_2 = new JSeparator();
			separatorR_2.setBounds(83, 382, 304, 1);
			separatorR_2.setVisible(false);
			pnlRight.add(separatorR_2);
		
		// Boton principal login
		JLabel login = new JLabel("");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setIcon(new ImageIcon(login.class.getResource("/buttons/button_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login.setIcon(new ImageIcon(login.class.getResource("/buttons/button.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				login.setIcon(new ImageIcon(login.class.getResource("/buttons/button.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				login.setIcon(new ImageIcon(login.class.getResource("/buttons/button_1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				pnlRight.setVisible(false);
				pnlLoading.setVisible(true);
				
				new java.util.Timer().schedule(new TimerTask() {

					@Override
					public void run() {
						usuario = textfieldN.getText();
						password = textfieldC.getText();
						
						login_check h = new login_check();
						h.check_user();
						
						switch(login_check.state) {
						
						case "successful_user":
							bank ba = new bank();
							lblNewLabel.setText("Bienvenid@ de vuelta");
							lblNombre.setVisible(true);
							lblNombre.setText(bank.lblNombre2Acc.getText() + " !");
							new java.util.Timer().schedule(new TimerTask() {
								public void run() {
									ba.frame.setVisible(true);
									frame.dispose();
									pnlLoading.setVisible(false);  
									pnlRight.setVisible(true);
								}
							}, 1000 * 4);
							break;
							
						case "successful_admin":
							admin adm = new admin();
							lblNewLabel.setText("Hola");
							lblNombre.setVisible(true);
							lblNombre.setText("Administrador Karlyn");
							new java.util.Timer().schedule(new TimerTask() {
								public void run() {
									adm.frame.setVisible(true);
									frame.dispose();
									pnlLoading.setVisible(false);  
									pnlRight.setVisible(true);
								}
							}, 1000 * 4);
							break;
							
						default:
							pnlLoading.setVisible(false);
							pnlRight.setVisible(true);
						}
					}
					
				}, 1000*2);
				
				
			}
		});
		login.setIcon(new ImageIcon(login.class.getResource("/buttons/button.png")));
		login.setBounds(135, 448, 208, 55);
		pnlRight.add(login);
		
		JLabel registro = new JLabel("");
		registro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				registro.setIcon(new ImageIcon(login.class.getResource("/buttons/button4_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				registro.setIcon(new ImageIcon(login.class.getResource("/buttons/button4.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				registro.setIcon(new ImageIcon(login.class.getResource("/buttons/button4.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				registro.setIcon(new ImageIcon(login.class.getResource("/buttons/button4_1.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int n = JOptionPane.showConfirmDialog(
						frame,
					    "¿Enviar solicitud?",
					    "Confirmar",
					    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				
				if (n == 0) {
					try {
										
						login_register register = new login_register();
						name = nombreR.getText();
						last_name = passR.getText();
						gender = comboBox.getSelectedItem().toString();
						email = emailR.getText();
						ccard = creditR.getText();
						
						register.register_user();
						
					}
					catch (Exception exec) {
						JOptionPane.showMessageDialog(frame,
							    "Rellene todos los campos e intentelo de nuevo");
					}
				}
				else {
					
				}
			}
		});
		registro.setIcon(new ImageIcon(login.class.getResource("/buttons/button4.png")));
		registro.setBounds(102, 449, 263, 55);
		pnlRight.add(registro);
		registro.setVisible(false);
		
		// Icono usuario
		
			JLabel usericon = new JLabel("");
			ImageIcon i_user = new ImageIcon(login.class.getResource("/img/icon4.png"));
			usericon.setIcon((a.resized_img(i_user, 25, 25)));
			usericon.setBounds(83, 145, 25, 32);
			pnlRight.add(usericon);
			
			// Icono contraseña
			JLabel usericon_1 = new JLabel("");
			ImageIcon i_pass = new ImageIcon(login.class.getResource("/img/icon5.png"));
			usericon_1.setIcon((a.resized_img(i_pass, 25, 25)));
			usericon_1.setBounds(83, 287, 25, 32);
			pnlRight.add(usericon_1);
			
			// Icono Nombre
			
			JLabel usericon_2 = new JLabel("");
			ImageIcon i_userR = new ImageIcon(login.class.getResource("/img/name.png"));
			usericon_2.setIcon((a.resized_img(i_userR, 25, 25)));
			usericon_2.setBounds(83, 72, 25, 32);
			pnlRight.add(usericon_2);
			usericon_2.setVisible(false);
			
			// Icono Genero
			JLabel lblGIcon = new JLabel("");
			i_userR = new ImageIcon(login.class.getResource("/img/gender.png"));
			lblGIcon.setIcon((a.resized_img(i_userR, 25, 25)));
			lblGIcon.setBounds(83, 209, 25, 32);
			pnlRight.add(lblGIcon);
			lblGIcon.setVisible(false);
			
			// Icono Apellido 
			
			JLabel usericon_2_1 = new JLabel("");
			ImageIcon i_passR = new ImageIcon(login.class.getResource("/img/name.png"));
			usericon_2_1.setIcon((a.resized_img(i_passR, 25, 25)));
			usericon_2_1.setBounds(83, 137, 25, 32);
			pnlRight.add(usericon_2_1);
			usericon_2_1.setVisible(false);
			
			// Icono email registro
			
			JLabel usericon_2_2 = new JLabel("");
			ImageIcon i_emailR = new ImageIcon(login.class.getResource("/img/icon6.png"));
			usericon_2_2.setIcon((a.resized_img(i_emailR, 25, 25)));
			usericon_2_2.setBounds(83, 285, 25, 32);
			pnlRight.add(usericon_2_2);
			usericon_2_2.setVisible(false);
			
			// Icono tarjeta de credito registro
			
			JLabel usericon_2_3 = new JLabel("");
			ImageIcon i_creditR = new ImageIcon(login.class.getResource("/img/icon7.png"));
			usericon_2_3.setIcon((a.resized_img(i_creditR, 25, 25)));
			usericon_2_3.setBounds(83, 350, 25, 32);
			pnlRight.add(usericon_2_3);
			usericon_2_3.setVisible(false);
			
			// Checkbox
			JCheckBox chckbxNewCheckBox = new JCheckBox("Aceptar los terminos y condiciones.");
			chckbxNewCheckBox.setBounds(83, 403, 232, 23);
			chckbxNewCheckBox.setVisible(false);
			pnlRight.add(chckbxNewCheckBox);
			
			// Segundo Checkbox
			JCheckBox recordar = new JCheckBox("Recuerdame");
			recordar.setBounds(83, 384, 117, 23);
			recordar.setVisible(true);
			pnlRight.add(recordar);
			
		
		ImageIcon buttonIcon2 = new ImageIcon(login.class.getResource("/buttons/button2.png"));
		
		// Boton no tienes cuenta
		lblNoAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNoAcc.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNoAcc.setForeground(new Color(0, 0, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// Textos y fields login
				labelN.setVisible(false);
				labelN.setVisible(false);
				textfieldN.setVisible(false);
				separator.setVisible(false);
				labelC.setVisible(false);
				separator_1.setVisible(false);
				textfieldC.setVisible(false);
				login.setVisible(false);
				recordar.setVisible(false);
				lblNoAcc.setVisible(false);
				
				//Iconos login
				usericon.setVisible(false);
				usericon_1.setVisible(false);
				
				//Textos y fields registro
				labelNR.setVisible(true);
				nombreR.setVisible(true);
				separatorR.setVisible(true);
				labelCR.setVisible(true);
				passR.setVisible(true);
				separatorR2.setVisible(true);
				labelE.setVisible(true);
				emailR.setVisible(true);
				separatorR_1.setVisible(true);
				lblTarjetaDeCredito.setVisible(true);
				creditR.setVisible(true);
				separatorR_2.setVisible(true);
				registro.setVisible(true);
				lblGender.setVisible(true);
				comboBox.setVisible(true);
				separatorG1.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblCuenta.setVisible(true);
				
				//Iconos registro
				usericon_2.setVisible(true);
				usericon_2_1.setVisible(true);
				usericon_2_2.setVisible(true);
				usericon_2_3.setVisible(true);
				lblGIcon.setVisible(true);
				
				// Checkbox
				chckbxNewCheckBox.setVisible(true);
			}
		});
		
		lblCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCuenta.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCuenta.setForeground(new Color(0, 0, 255));
			}
			
			public void mouseClicked(MouseEvent e) {
				// Textos y fields login
				labelN.setVisible(true);
				labelN.setVisible(true);
				textfieldN.setVisible(true);
				separator.setVisible(true);
				labelC.setVisible(true);
				separator_1.setVisible(true);
				textfieldC.setVisible(true);
				login.setVisible(true);
				recordar.setVisible(true);
				lblNoAcc.setVisible(true);
				
				//Iconos login
				usericon.setVisible(true);
				usericon_1.setVisible(true);
				
				//Textos y fields registro
				labelNR.setVisible(false);
				nombreR.setVisible(false);
				separatorR.setVisible(false);
				labelCR.setVisible(false);
				passR.setVisible(false);
				separatorR2.setVisible(false);
				labelE.setVisible(false);
				emailR.setVisible(false);
				separatorR_1.setVisible(false);
				lblTarjetaDeCredito.setVisible(false);
				creditR.setVisible(false);
				separatorR_2.setVisible(false);
				registro.setVisible(false);
				lblGender.setVisible(false);
				comboBox.setVisible(false);
				separatorG1.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblCuenta.setVisible(false);
				//Iconos registro
				usericon_2.setVisible(false);
				usericon_2_1.setVisible(false);
				usericon_2_2.setVisible(false);
				usericon_2_3.setVisible(false);
				lblGIcon.setVisible(false);
				
				// Checkbox
				chckbxNewCheckBox.setVisible(false);
			}
		});
		ImageIcon buttonIcon = new ImageIcon(login.class.getResource("/buttons/button3.png"));
		
		
		frame.setBounds(100, 100, 857, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
	}
}
