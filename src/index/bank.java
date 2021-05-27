package index;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import faded.FadeEffect;
import login_data.login_check;
import user_data.convert;
import user_data.dashboard;
import user_data.transaction;
import user_data.transfer;
import user_data.withdraw;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class bank {

	public JFrame frame;
	public static JTextField fieldTrans1;
	public static JTextField fieldTrans2;
	public static JTextField fieldWidth2;
	public static JTextField fieldWidth1;
	public static JTextField fieldAcc2;
	public static JTextField fieldAcc1;
	public static JTextField fieldDolar2;
	public static JTextField fieldDolar1;
	public JPanel home1 = new JPanel();
	public JPanel home2 = new JPanel();
	
	public JPanel configurations = new JPanel();
	public JButton settings = new JButton("");
	public JButton home = new JButton("");
	
	public static JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
	public static JLabel lblBalan = new JLabel("0");
	public static ImageIcon profileIco = new ImageIcon();
	public static JLabel profile = new JLabel("");
	public static JLabel lblProfillePlus = new JLabel("");
	
	public static JLabel lblNombre2Acc = new JLabel("Fulano");
	public static JLabel lblApellidoAcc = new JLabel("De tal");
	public static JLabel lblGeneroDisplay = new JLabel("Masculino");
	public static JLabel lblEmailDisplay = new JLabel("fulano@hotmail.com");
	public static JLabel lblCreditAcc = new JLabel("5469587456952365");
	public static JLabel lblBalanceAcc = new JLabel("999999999");
	public static JLabel lblUserAcc = new JLabel("id_del_usuario");
	public static JLabel lblUserPassAcc = new JLabel("contrase\u00F1a_del_usuario");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bank window = new bank();
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
	public bank() {
		dashboard da = new dashboard();
		initialize();
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		FadeEffect.fadeInFrame(frame, 25, 0.1f);
		
		da.get_dash_data();
		da.set_dash_data();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Banco dominicano: Tu banco de confianza");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(bank.class.getResource("/adminsrc/senko_admin.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 999, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlRoot = new JPanel();
		pnlRoot.setBackground(new Color(0, 0, 0, 0));
		frame.getContentPane().add(pnlRoot, BorderLayout.CENTER);
		pnlRoot.setLayout(null);
		
		JPanel pnlSide = new JPanel();
		pnlSide.setBackground(new Color(47, 49, 54));
		pnlSide.setBounds(0, 142, 130, 419);
		pnlRoot.add(pnlSide);
		pnlSide.setLayout(null);
		
		// Llamando metodo para redimencionar imagenes
		Operaciones a = new Operaciones();
		Border emptyBorder = BorderFactory.createEmptyBorder();
		home.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		home.setForeground(Color.GRAY);
		home.setBorder(emptyBorder);
		home.setBackground(new Color(182, 182, 182));
		home.setFocusPainted(false);

		ImageIcon imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/home.png"));
		home.setIcon((a.resized_img(imageIcon, 30, 30)));
		
		home.setBounds(0, 35, 130, 39);
		pnlSide.add(home);
		
		JButton operations = new JButton("");
		operations.setForeground(Color.GRAY);
		operations.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		operations.setFocusPainted(false);
		operations.setBorder(emptyBorder);
		
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/money.png"));
		operations.setIcon((a.resized_img(imageIcon, 30, 30)));
		
		operations.setBackground(new Color(47, 49, 54));
		operations.setBounds(0, 85, 130, 39);
		pnlSide.add(operations);
		
		JButton account = new JButton("");
		account.setForeground(Color.GRAY);
		account.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		account.setFocusPainted(false);
		account.setBorder(emptyBorder);
		
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/account.png"));
		account.setIcon((a.resized_img(imageIcon, 30, 30)));
		
		account.setBackground(new Color(47, 49, 54));
		account.setBounds(0, 135, 130, 39);
		pnlSide.add(account);
		settings.setForeground(Color.GRAY);
		settings.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		
		settings.setFocusPainted(false);
		settings.setBorder(emptyBorder);
		
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/settings.png"));
		settings.setIcon((a.resized_img(imageIcon, 30, 30)));
		
		settings.setBackground(new Color(47, 49, 54));
		settings.setBounds(0, 185, 130, 39);
		pnlSide.add(settings);
		
		JButton close = new JButton("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				close.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				close.setBackground(new Color(47, 49, 54));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				FadeEffect.fadeOutFrameSplash(frame, 25, 0.1f);
			}
		});
		close.setFocusPainted(false);
		close.setBorder(emptyBorder);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/close.png"));
		close.setIcon((a.resized_img(imageIcon, 30, 30)));
		
		close.setBackground(new Color(47, 49, 54));
		close.setBounds(0, 342, 130, 39);
		pnlSide.add(close);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBounds(129, 0, 854, 561);
		pnlCenter.setBackground(new Color(21, 25, 28));
		pnlRoot.add(pnlCenter);
		pnlCenter.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 139, 139, 200));
		panel_3.setBounds(0, 26, 854, 75);
		pnlCenter.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel Bienvenido = new JLabel("Bienvenido");
		Bienvenido.setForeground(new Color(255, 255, 255));
		Bienvenido.setFont(new Font("Rockwell", Font.PLAIN, 24));
		Bienvenido.setBounds(10, 8, 126, 29);
		panel_3.add(Bienvenido);
		
		JLabel AcercaDe = new JLabel("Acerca de");
		AcercaDe.setForeground(new Color(255, 255, 255));
		AcercaDe.setFont(new Font("Rockwell", Font.PLAIN, 16));
		AcercaDe.setBounds(737, 34, 80, 18);
		panel_3.add(AcercaDe);
		
		JLabel b_bottom = new JLabel("Eliga una opci\u00F3n para comenzar");
		b_bottom.setForeground(new Color(255, 255, 255));
		b_bottom.setFont(new Font("Rockwell", Font.PLAIN, 14));
		b_bottom.setBounds(10, 48, 207, 18);
		panel_3.add(b_bottom);
		
		
		JButton search_ico = new JButton("");
		search_ico.setBackground(new Color(10, 128, 132));
		search_ico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				search_ico.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				search_ico.setBackground(new Color(10, 128, 132));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "Aquí puede ver la información de su cuenta a la vez que \n"
					    + "realizar opciones como transferir su balance desde su tarjeta \n"
					    + "o transferir a otra cuenta. \n"
					    + "Si tiene algún problema utilicé el botón de quejas/recomendaciones \n"
					    + "para que un administrador se ponga en contacto con usted.");
			}
		});
		search_ico.setBounds(817, 23, 37, 37);
		search_ico.setFocusPainted(false);
		search_ico.setBorder(emptyBorder);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/about.png"));
		search_ico.setIcon((a.resized_img(imageIcon, 27, 27)));
		panel_3.add(search_ico);
		
		JPanel user = new JPanel();
		user.setBackground(new Color(0, 0, 0, 70));
		user.setBounds(20, 112, 824, 438);
		user.setLayout(null);
		user.setVisible(false);
		pnlCenter.add(user);
		
		// Panel configurations
		
		configurations.setVisible(false);
		configurations.setBackground(new Color(0, 0, 0, 70));
		configurations.setBounds(20, 112, 824, 438);
		configurations.setLayout(null);
		pnlCenter.add(configurations);
		
		JPanel pnlEmail = new JPanel();
		pnlEmail.setBackground(new Color(72, 75, 83));
		pnlEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlEmail.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlEmail.setBackground(new Color(72, 75, 83));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				confFrame a = new confFrame();
				a.frame.setVisible(true);
				confFrame.lblVariable.setText("Correo electronico antiguo");
				confFrame.lblVariable2.setText("Nuevo correo e información adicional");
				
				new java.util.Timer().schedule(new TimerTask() {
					
					public void run() {
						frame.dispose();
					}
				}, 1000 * 1);
			}
		});
		pnlEmail.setBounds(52, 113, 186, 238);
		configurations.add(pnlEmail);
		pnlEmail.setLayout(null);
		
		JLabel lblEmailIco = new JLabel("");
		imageIcon = new ImageIcon(bank.class.getResource("/img/email2.png"));
		lblEmailIco.setIcon((a.resized_img(imageIcon, 50, 50)));
		lblEmailIco.setBounds(63, 162, 68, 65);
		pnlEmail.add(lblEmailIco);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Solicitar cambio<br>de email</br></html>");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 29, 166, 71);
		pnlEmail.add(lblNewLabel_1);
		
		JPanel pnlPassword = new JPanel();
		pnlPassword.setBackground(new Color(72, 75, 83));
		pnlPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlPassword.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlPassword.setBackground(new Color(72, 75, 83));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				confFrame a = new confFrame();
				a.frame.setVisible(true);
				confFrame.lblVariable.setText("Contraseña antigua");
				confFrame.lblVariable2.setText("Nueva contraseña e información adicional");
				
				new java.util.Timer().schedule(new TimerTask() {
					
					public void run() {
						frame.dispose();
					}
				}, 1000 * 1);
			}
		});
		pnlPassword.setLayout(null);
		pnlPassword.setBounds(323, 113, 186, 238);
		configurations.add(pnlPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("<html>Solicitar cambio<br>de contrase\u00F1a</br></html>");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 29, 166, 71);
		pnlPassword.add(lblNewLabel_1_1);
		
		JLabel lblPasswordIco = new JLabel("");
		imageIcon = new ImageIcon(bank.class.getResource("/img/change.png"));
		lblPasswordIco.setIcon((a.resized_img(imageIcon, 50, 50)));
		lblPasswordIco.setBounds(63, 162, 68, 65);
		pnlPassword.add(lblPasswordIco);
		
		JPanel pnlOther = new JPanel();
		pnlOther.setBackground(new Color(72, 75, 83));
		pnlOther.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlOther.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlOther.setBackground(new Color(72, 75, 83));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				confFrame a = new confFrame();
				a.frame.setVisible(true);
				confFrame.lblVariable.setText("Correo electronico");
				confFrame.lblVariable2.setText("Escriba su sugerencia o inquietud");
				
				new java.util.Timer().schedule(new TimerTask() {
					
					public void run() {
						frame.dispose();
					}
				}, 1000 * 1);
			}
		});
		pnlOther.setLayout(null);
		pnlOther.setBounds(595, 113, 186, 238);
		configurations.add(pnlOther);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("<html>Quejas / <br>Sugerencias</br></html>");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(40, 29, 111, 71);
		pnlOther.add(lblNewLabel_1_1_1);
		
		JLabel lblOtherIco = new JLabel("");
		lblOtherIco.setBounds(70, 162, 50, 65);
		imageIcon = new ImageIcon(bank.class.getResource("/img/coffee.png"));
		lblOtherIco.setIcon((a.resized_img(imageIcon, 50, 50)));
		pnlOther.add(lblOtherIco);
		
		JPanel pnlTopText = new JPanel();
		pnlTopText.setBackground(new Color(0, 0, 0, 100));
		pnlTopText.setBounds(0, 22, 824, 52);
		configurations.add(pnlTopText);
		pnlTopText.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Configuraciones");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(320, 5, 166, 41);
		pnlTopText.add(lblNewLabel_1_2);
		
		// Panel datos usuario
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0, 0));
		panel_1.setBounds(61, 8, 311, 430);
		user.add(panel_1);
		panel_1.setLayout(null);
		
		lblProfillePlus.setBounds(36, 11, 238, 236);
		panel_1.add(lblProfillePlus);
		
		JLabel lblNombreAcc = new JLabel("Tu nombre");
		lblNombreAcc.setForeground(new Color(255, 255, 255));
		lblNombreAcc.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNombreAcc.setBounds(21, 272, 109, 26);
		panel_1.add(lblNombreAcc);
		
		
		lblNombre2Acc.setForeground(Color.LIGHT_GRAY);
		lblNombre2Acc.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 16));
		lblNombre2Acc.setBounds(160, 272, 130, 16);
		panel_1.add(lblNombre2Acc);
		
		
		lblApellidoAcc.setForeground(Color.LIGHT_GRAY);
		lblApellidoAcc.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 13));
		lblApellidoAcc.setBounds(160, 292, 130, 26);
		panel_1.add(lblApellidoAcc);
		
		JLabel lblGeneroAcc = new JLabel("Genero");
		lblGeneroAcc.setForeground(new Color(255, 255, 255));
		lblGeneroAcc.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 13));
		lblGeneroAcc.setBounds(21, 335, 83, 16);
		panel_1.add(lblGeneroAcc);
		
		
		lblGeneroDisplay.setForeground(new Color(255, 255, 255));
		lblGeneroDisplay.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 13));
		lblGeneroDisplay.setBounds(160, 335, 130, 16);
		panel_1.add(lblGeneroDisplay);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 360, 280, 2);
		panel_1.add(separator_5);
		
		JLabel lblEmailAcc = new JLabel("Email");
		lblEmailAcc.setForeground(new Color(255, 255, 255));
		lblEmailAcc.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 13));
		lblEmailAcc.setBounds(21, 378, 83, 16);
		panel_1.add(lblEmailAcc);
		
		
		lblEmailDisplay.setForeground(new Color(255, 255, 255));
		lblEmailDisplay.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 13));
		lblEmailDisplay.setBounds(160, 378, 130, 16);
		panel_1.add(lblEmailDisplay);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 400, 280, 2);
		panel_1.add(separator_6);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(72, 75, 83));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "Esta función aún está en desarrollo.");
			}
		});
		btnNewButton_1.setBackground(new Color(72, 75, 83));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(emptyBorder);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setBounds(225, 212, 49, 49);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/add.png"));
		btnNewButton_1.setIcon((a.resized_img(imageIcon, 50, 50)));
		panel_1.add(btnNewButton_1);
		
		JLabel lblFirstBackground = new JLabel("");
		lblFirstBackground.setBounds(0, 0, 309, 430);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/figure1.png"));
		lblFirstBackground.setIcon((a.resized_img(imageIcon, 300, 430)));
		panel_1.add(lblFirstBackground);
		
		
		
		
		// Panel datos bancarios
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(475, 2, 281, 202);
		panel_2.setBackground(new Color(0, 0, 0, 0));
		user.add(panel_2);
		panel_2.setLayout(null);
		
		// Info bancaria
		JLabel lblBankInfo = new JLabel("Información bancaria");
		lblBankInfo.setForeground(Color.WHITE);
		lblBankInfo.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblBankInfo.setBounds(67, 11, 196, 30);
		panel_2.add(lblBankInfo);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(39, 45, 226, 2);
		panel_2.add(separator_7);
		lblCreditAcc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditAcc.setForeground(Color.WHITE);
		
		// Tareta de credito
		
		lblCreditAcc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCreditAcc.setBounds(115, 78, 148, 22);
		panel_2.add(lblCreditAcc);
		
		JLabel lblCreditAccIco = new JLabel("");
		lblCreditAccIco.setBounds(47, 65, 53, 47);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/credit.png"));
		lblCreditAccIco.setIcon((a.resized_img(imageIcon, 40, 40)));
		panel_2.add(lblCreditAccIco);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(99, 109, 166, 2);
		panel_2.add(separator_8);
		lblBalanceAcc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalanceAcc.setForeground(Color.WHITE);
		
		// Balance de la cuenta
		
		lblBalanceAcc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBalanceAcc.setBounds(115, 129, 150, 22);
		panel_2.add(lblBalanceAcc);
		
		JLabel lblBalanceAccIco = new JLabel("");
		lblBalanceAccIco.setBounds(47, 116, 53, 47);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/savings.png"));
		lblBalanceAccIco.setIcon((a.resized_img(imageIcon, 40, 40)));
		panel_2.add(lblBalanceAccIco);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(99, 159, 166, 2);
		panel_2.add(separator_9);
		
		JLabel lblNewLabel_7 = new JLabel("#");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(105, 78, 24, 22);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("$");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(105, 129, 24, 22);
		panel_2.add(lblNewLabel_7_1);
		
		// Fondo rectangular
		
		JLabel lblSecondBack = new JLabel("");
		lblSecondBack.setBounds(0, 0, 281, 202);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/figure2.png"));
		lblSecondBack.setIcon((a.resized_img(imageIcon, 280, 190)));
		panel_2.add(lblSecondBack);
		
		
		// Panel información de usuario
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(475, 240, 281, 202);
		panel_2_1.setBackground(new Color(0, 0, 0, 0));
		user.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		// Nombre de usuario
		
		JLabel lblUserInfo = new JLabel("Detalles de Login");
		lblUserInfo.setForeground(Color.WHITE);
		lblUserInfo.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblUserInfo.setBounds(83, 11, 196, 30);
		panel_2_1.add(lblUserInfo);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(39, 45, 226, 2);
		panel_2_1.add(separator_10);
		
		// Id del usuario
		JLabel lblUserAccIco = new JLabel("");
		lblUserAccIco.setBounds(47, 64, 53, 47);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/account.png"));
		lblUserAccIco.setIcon((a.resized_img(imageIcon, 45, 45)));
		panel_2_1.add(lblUserAccIco);
		lblUserAcc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserAcc.setForeground(Color.WHITE);
		
		
		lblUserAcc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserAcc.setBounds(99, 77, 166, 22);
		panel_2_1.add(lblUserAcc);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(99, 108, 166, 2);
		panel_2_1.add(separator_11);
		lblUserPassAcc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserPassAcc.setForeground(Color.WHITE);
		
		// Contraseña del usuario
		
		lblUserPassAcc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserPassAcc.setBounds(99, 128, 166, 22);
		panel_2_1.add(lblUserPassAcc);
		
		JLabel lblUserPassIco = new JLabel("");
		lblUserPassIco.setBounds(55, 113, 40, 47);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/password.png"));
		lblUserPassIco.setIcon((a.resized_img(imageIcon, 30, 30)));
		panel_2_1.add(lblUserPassIco);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(99, 158, 166, 2);
		panel_2_1.add(separator_12);
		
		// Fondo rectangular
		JLabel lblThirdBack = new JLabel("");
		lblThirdBack.setBounds(0, 0, 281, 202);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/figure2.png"));
		lblThirdBack.setIcon((a.resized_img(imageIcon, 280, 190)));
		panel_2_1.add(lblThirdBack);
		
		
		
		home1.setBackground(new Color(0, 0, 0, 0));
		home1.setBounds(38, 125, 384, 406);
		pnlCenter.add(home1);
		home1.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setForeground(Color.LIGHT_GRAY);
		lblBalance.setFont(new Font("Rockwell", Font.PLAIN, 24));
		lblBalance.setBounds(53, 266, 108, 25);
		home1.add(lblBalance);
		
		JButton btnNewButton = new JButton("Hacer un deposito");
		
		btnNewButton.setForeground(new Color(240, 248, 255));
		btnNewButton.setBackground(new Color(0, 0, 0, 0));
		btnNewButton.setBounds(10, 340, 364, 38);
		home1.add(btnNewButton);
		
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 0));
		separator_3.setBackground(new Color(47, 79, 79));
		separator_3.setBounds(155, 295, 219, 2);
		home1.add(separator_3);
		lblBalan.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		lblBalan.setForeground(new Color(192, 192, 192));
		lblBalan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBalan.setBounds(175, 267, 188, 25);
		home1.add(lblBalan);
		
		JPanel panel = new JPanel();
		// panel.setBackground(new Color(51, 51, 51));
		panel.setBackground(new Color(0, 0, 0, 100));
		panel.setBounds(10, 7, 364, 200);
		home1.add(panel);
		panel.setLayout(null);
		
		JButton btnOptions_1 = new JButton("");
		
		btnOptions_1.setFocusPainted(false);
		btnOptions_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOptions_1.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOptions_1.setBackground(new Color(38, 40, 40));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int n = JOptionPane.showConfirmDialog(
						frame,
					    "¿Quiere salir de su cuenta?",
					    "Confirmar",
					    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (n == 0) {
					login_check.datos.clear();
					
					frame.dispose();
					login b = new login();
					b.frame.setVisible(true);
				}
				else {
					
				}
				
			}
		});
		
		btnOptions_1.setBorder(emptyBorder);
		
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/logout.png"));
		btnOptions_1.setIcon((a.resized_img(imageIcon, 32, 32)));
		
		btnOptions_1.setBackground(new Color(38, 40, 40));
		btnOptions_1.setBounds(258, 137, 47, 49);
		panel.add(btnOptions_1);
		
		JLabel lblUser = new JLabel("Miembro");
		lblUser.setBounds(188, 40, 138, 25);
		panel.add(lblUser);
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setFont(new Font("Rockwell", Font.BOLD, 24));
		profile.setBounds(10, 3, 177, 189);
		panel.add(profile);
		lblNombreDeUsuario.setBounds(188, 76, 166, 25);
		panel.add(lblNombreDeUsuario);
		
		
		lblNombreDeUsuario.setForeground(Color.LIGHT_GRAY);
		lblNombreDeUsuario.setFont(new Font("Rockwell", Font.PLAIN, 18));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(188, 112, 151, 2);
		panel.add(separator_2);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(new Color(47, 79, 79));
		
		JButton btnOptions = new JButton("");
		btnOptions.setBounds(188, 137, 47, 49);
		panel.add(btnOptions);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/settings.png"));
		btnOptions.setIcon((a.resized_img(imageIcon, 38, 38)));
		btnOptions.setBackground(new Color(35, 37, 38));
		
		btnOptions.setFocusPainted(false);
		btnOptions.setBorder(emptyBorder);
		
		JLabel lblMoney = new JLabel("");
		lblMoney.setBounds(10, 255, 39, 42);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon3.png"));
		lblMoney.setIcon((a.resized_img(imageIcon, 40, 40)));
		home1.add(lblMoney);
		
		JLabel lblNewLabel_6 = new JLabel("$");
		lblNewLabel_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(160, 266, 21, 24);
		home1.add(lblNewLabel_6);
		
		JLabel lblBackground2 = new JLabel("");
		lblBackground2.setIcon(new ImageIcon(bank.class.getResource("/adminsrc/Background2.png")));
		lblBackground2.setBounds(0, 0, 384, 406);
		home1.add(lblBackground2);
		
		// Panel Home 2
		home2.setLayout(null);
		home2.setBackground(new Color(0, 0, 0, 0));
		home2.setBounds(460, 125, 384, 406);
		pnlCenter.add(home2);
		
		JLabel lblSacar = new JLabel("\u00BFNecesita cash ya mismo?");
		lblSacar.setForeground(Color.LIGHT_GRAY);
		lblSacar.setFont(new Font("Rockwell", Font.PLAIN, 24));
		lblSacar.setBounds(57, 28, 305, 25);
		home2.add(lblSacar);
		
		JLabel lblTajertaIcon = new JLabel("");
		lblTajertaIcon.setBounds(20, 91, 39, 42);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon2.png"));
		lblTajertaIcon.setIcon((a.resized_img(imageIcon, 30, 30)));
		home2.add(lblTajertaIcon);
		
		JButton btnSacar = new JButton("Retirar fondos de la cuenta");
		
		btnSacar.setForeground(new Color(240, 248, 255));
		btnSacar.setBackground(new Color(0, 0, 0, 0));
		btnSacar.setBounds(69, 91, 305, 42);
		home2.add(btnSacar);
		
		JButton btnEstado = new JButton("Ver información de la cuenta");
		
		btnEstado.setForeground(new Color(240, 248, 255));
		btnEstado.setBackground(new Color(0, 0, 0, 0));
		btnEstado.setBounds(69, 200, 305, 42);
		home2.add(btnEstado);
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setBounds(20, 200, 39, 42);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon4.png"));
		lblUserIcon.setIcon((a.resized_img(imageIcon, 30, 30)));
		home2.add(lblUserIcon);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(new Color(240, 248, 255));
		btnSalir.setBackground(new Color(0, 0, 0, 0));
		btnSalir.setBounds(57, 346, 305, 36);
		home2.add(btnSalir);
		
		JLabel lblBackground3 = new JLabel("");
		lblBackground3.setIcon(new ImageIcon(bank.class.getResource("/adminsrc/Background2.png")));
		lblBackground3.setBounds(0, 0, 384, 406);
		home2.add(lblBackground3);
		
		JPanel cash = new JPanel();
		cash.setBackground(new Color(0, 0, 0, 70));
		cash.setBounds(20, 112, 824, 438);
		cash.setVisible(false);
		cash.setLayout(null);
		pnlCenter.add(cash);
		
		JPanel pnlTopText2 = new JPanel();
		pnlTopText2.setBackground(new Color(0, 0, 0, 100));
		pnlTopText2.setBounds(0, 15, 824, 52);
		cash.add(pnlTopText2);
		pnlTopText2.setLayout(null);
		
		JLabel lblOp = new JLabel("Operaciones");
		lblOp.setForeground(new Color(255, 255, 255));
		lblOp.setHorizontalAlignment(SwingConstants.CENTER);
		lblOp.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblOp.setBounds(320, 5, 166, 41);
		pnlTopText2.add(lblOp);
		
		JPanel pnlTransaction = new JPanel();
		pnlTransaction.setBackground(new Color(0, 0, 0, 90));
		pnlTransaction.setBounds(79, 82, 274, 151);
		cash.add(pnlTransaction);
		pnlTransaction.setLayout(null);
		
		// Boton info 1
		JButton info1 = new JButton("");
		info1.setBackground(new Color(123, 104, 238));
		info1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "Introduzca la siguiente información: \n"
					    + "Campo 1: Numero a depositar en la cuenta\n"
					    + "Campo 2: Numero de la tarjeta");
			}
		});
		info1.setBounds(220, 10, 39, 40);
		info1.setFocusPainted(false);
		info1.setBorder(emptyBorder);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/about.png"));
		info1.setIcon((a.resized_img(imageIcon, 37, 37)));
		pnlTransaction.add(info1);
		
		
		
		JLabel lblTransferencia = new JLabel("Deposito");
		lblTransferencia.setForeground(new Color(255, 255, 255));
		lblTransferencia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblTransferencia.setBounds(100, 11, 107, 25);
		pnlTransaction.add(lblTransferencia);
		
		JLabel lblTrans1 = new JLabel("");
		lblTrans1.setBounds(20, 46, 30, 36);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon2.png"));
		
		lblTrans1.setIcon((a.resized_img(imageIcon, 30, 30)));
		pnlTransaction.add(lblTrans1);
		
		JLabel lblTrans2 = new JLabel("");
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon7.png"));
		
		lblTrans2.setIcon((a.resized_img(imageIcon, 30, 30)));
		lblTrans2.setBounds(20, 102, 40, 30);
		pnlTransaction.add(lblTrans2);
		
		fieldTrans1 = new JTextField();
		fieldTrans1.setForeground(new Color(255, 255, 255));
		fieldTrans1.setBounds(67, 60, 141, 20);
		fieldTrans1.setOpaque(false);
		
		pnlTransaction.add(fieldTrans1);
		fieldTrans1.setColumns(10);
		
		fieldTrans2 = new JTextField();
		fieldTrans2.setForeground(new Color(255, 255, 255));
		fieldTrans2.setColumns(10);
		fieldTrans2.setOpaque(false);
		
		fieldTrans2.setBounds(67, 112, 141, 20);
		pnlTransaction.add(fieldTrans2);
		
		JButton btnTrans = new JButton("GO");
		btnTrans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transaction a = new transaction();
				int n = JOptionPane.showConfirmDialog(
						frame,
					    "¿Esta seguro de que desea realizar esta operación?",
					    "Advertencia",
					    JOptionPane.YES_NO_OPTION);
				
				if (n == 0) {
					try {
						a.do_transaction();
						if (transaction.status.equals("hecho")) {
							JOptionPane.showMessageDialog(frame,
								    "Se han agregado " + fieldTrans1.getText() + " a su cuenta\n"
								    		+ "Los cambios se verán reflejados cuando reinicie.");	
						}
						else {
							JOptionPane.showMessageDialog(frame,
								    "El numero de tarjeta introducido no corresponde al asociado a su cuenta.\n"
								    + "Si esto es un error por favor contacte con el soporte.");
						}
					}
					catch (Exception exec) {
						System.out.println(exec);
						
					}
				}
				else {
					
				}
			}
		});
		btnTrans.setForeground(new Color(255, 255, 255));
		btnTrans.setBackground(new Color(123, 104, 238));
		btnTrans.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnTrans.setBounds(218, 102, 53, 30);
		btnTrans.setFocusable(false);
		pnlTransaction.add(btnTrans);
		
		JLabel lblNewLabel_2 = new JLabel("");
		imageIcon = new ImageIcon(bank.class.getResource("/img/gradient.png"));
		lblNewLabel_2.setIcon((a.resized_img(imageIcon, 300, 200)));
		lblNewLabel_2.setBounds(0, 0, 271, 148);
		pnlTransaction.add(lblNewLabel_2);
		
		JPanel pnlWithdrawn = new JPanel();
		pnlWithdrawn.setBackground(new Color(0, 0, 0, 90));
		pnlWithdrawn.setBounds(79, 265, 274, 151);
		cash.add(pnlWithdrawn);
		pnlWithdrawn.setLayout(null);
		
		// Boton info 2
		JButton info2 = new JButton("");
		info2.setBackground(new Color(123, 104, 238));
		info2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "Introduzca la siguiente información: \n"
					    + "Campo 1: Balance a retirar de la cuenta\n"
					    + "Campo 2: Numero de la tarjeta");
			}
		});
		info2.setBounds(220, 10, 39, 40);
		info2.setFocusPainted(false);
		info2.setBorder(emptyBorder);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/about.png"));
		info2.setIcon((a.resized_img(imageIcon, 37, 37)));
		pnlWithdrawn.add(info2);
		
		JLabel lblSacar_1 = new JLabel("Retirar");
		lblSacar_1.setBackground(new Color(255, 255, 255));
		lblSacar_1.setForeground(Color.LIGHT_GRAY);
		lblSacar_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblSacar_1.setBounds(110, 11, 52, 25);
		pnlWithdrawn.add(lblSacar_1);
		
		fieldWidth2 = new JTextField();
		fieldWidth2.setForeground(new Color(255, 255, 255));
		fieldWidth2.setColumns(10);
		fieldWidth2.setOpaque(false);
		fieldWidth2.setBounds(67, 120, 141, 20);
		pnlWithdrawn.add(fieldWidth2);
		
		fieldWidth1 = new JTextField();
		fieldWidth1.setForeground(new Color(255, 255, 255));
		fieldWidth1.setColumns(10);
		fieldWidth1.setOpaque(false);
		fieldWidth1.setBounds(67, 68, 141, 20);
		pnlWithdrawn.add(fieldWidth1);
		
		JLabel lblWidth1 = new JLabel("");
		lblWidth1.setBounds(21, 53, 30, 41);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon2.png"));
		
		lblWidth1.setIcon((a.resized_img(imageIcon, 30, 30)));
		pnlWithdrawn.add(lblWidth1);
		
		JLabel lblWidth2 = new JLabel("");
		lblWidth2.setBounds(21, 107, 30, 41);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon7.png"));
		
		lblWidth2.setIcon((a.resized_img(imageIcon, 30, 30)));
		pnlWithdrawn.add(lblWidth2);
		
		JButton btnTrans_1 = new JButton("GO");
		btnTrans_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				withdraw with = new withdraw();
				int n = JOptionPane.showConfirmDialog(
						frame,
					    "¿Esta seguro de que desea realizar esta operación?",
					    "Advertencia",
					    JOptionPane.YES_NO_OPTION);
				
				if (n == 0) {
					try {
						with.do_withdraw();
						if (withdraw.esMenor.equals("true")) {
							JOptionPane.showMessageDialog(frame,
								    "No tiene fondos suficientes o el numero de tarjeta introducido no esta\n"
								    + "asociado a su cuenta, por favor intentelo de nuevo.");	
						}
						else if (withdraw.status.equals("hecho")) {
							JOptionPane.showMessageDialog(frame,
								    "Se han retirado " + fieldWidth1.getText() + " de su cuenta\n"
								    		+ "Los cambios se verán reflejados cuando reinicie.");
						}
						else {
							JOptionPane.showMessageDialog(frame,
								    "El numero de tarjeta introducido no corresponde al asociado a su cuenta.\n"
								    + "Si esto es un error por favor contacte con el soporte.");
						}
					}
					catch (Exception exec) {
						System.out.println(exec);
					}
				}
				else {
					
				}
			}
		});
		btnTrans_1.setForeground(new Color(255, 255, 255));
		btnTrans_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnTrans_1.setFocusable(false);
		btnTrans_1.setBackground(new Color(123, 104, 238));
		btnTrans_1.setBounds(218, 110, 53, 30);
		pnlWithdrawn.add(btnTrans_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		imageIcon = new ImageIcon(bank.class.getResource("/img/gradient.png"));
		lblNewLabel_3.setIcon((a.resized_img(imageIcon, 300, 200)));
		lblNewLabel_3.setBounds(0, 0, 271, 148);
		pnlWithdrawn.add(lblNewLabel_3);
		
		JPanel pnlTransfer = new JPanel();
		pnlTransfer.setBackground(new Color(0, 0, 0, 90));
		pnlTransfer.setBounds(474, 82, 274, 151);
		cash.add(pnlTransfer);
		pnlTransfer.setLayout(null);
		
		JButton info3 = new JButton("");
		info3.setBackground(new Color(123, 104, 238));
		info3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "Introduzca la siguiente información: \n"
					    + "Campo 1: Id de la cuenta a tranferir\n"
					    + "Campo 2: Balance a transferir");
			}
		});
		info3.setBounds(220, 35, 39, 40);
		info3.setFocusPainted(false);
		info3.setBorder(emptyBorder);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/about.png"));
		info3.setIcon((a.resized_img(imageIcon, 37, 37)));
		pnlTransfer.add(info3);
		
		JLabel lblTransferirAOtra = new JLabel("Transferir a otra cuenta");
		lblTransferirAOtra.setBackground(new Color(255, 255, 255));
		lblTransferirAOtra.setForeground(Color.LIGHT_GRAY);
		lblTransferirAOtra.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblTransferirAOtra.setBounds(55, 11, 191, 25);
		pnlTransfer.add(lblTransferirAOtra);
		
		fieldAcc2 = new JTextField();
		fieldAcc2.setForeground(new Color(255, 255, 255));
		fieldAcc2.setColumns(10);
		fieldAcc2.setOpaque(false);
		fieldAcc2.setBounds(67, 120, 141, 20);
		pnlTransfer.add(fieldAcc2);
		
		fieldAcc1 = new JTextField();
		fieldAcc1.setForeground(new Color(255, 255, 255));
		fieldAcc1.setColumns(10);
		fieldAcc1.setOpaque(false);
		fieldAcc1.setBounds(67, 68, 141, 20);
		pnlTransfer.add(fieldAcc1);
		
		
		
		JLabel lblAcc1 = new JLabel("");
		lblAcc1.setBounds(20, 50, 32, 41);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon4.png"));
		
		lblAcc1.setIcon((a.resized_img(imageIcon, 30, 30)));
		pnlTransfer.add(lblAcc1);
		
		JLabel lblAcc2 = new JLabel("");
		lblAcc2.setBounds(20, 102, 32, 41);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon2.png"));
		
		lblAcc2.setIcon((a.resized_img(imageIcon, 30, 30)));
		pnlTransfer.add(lblAcc2);
		
		JButton btnTrans_2 = new JButton("GO");
		btnTrans_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transfer trans = new transfer();
				int n = JOptionPane.showConfirmDialog(
						frame,
					    "¿Esta seguro de que desea realizar esta operación?",
					    "Advertencia",
					    JOptionPane.YES_NO_OPTION);
				
				if (n == 0) {
					try {
						trans.do_transfer();
						if (transfer.existe.equals("false")) {
							JOptionPane.showMessageDialog(frame,
								    "No tiene balance suficiente o la cuenta no existe, intentelo de nuevo.");	
						}
						else if (transfer.existe.equals("true")) {
							JOptionPane.showMessageDialog(frame,
								    "Se han enviado " + fieldAcc2.getText() + " de su cuenta a la cuenta " + fieldAcc1.getText() + ". \n"
								    		+ "Los cambios se verán reflejados cuando reinicie.");
						}
						else {
							JOptionPane.showMessageDialog(frame,
								    "Ha ocurrido un error, intentelo de nuevo.");
						}
					}
					catch (Exception exec) {
						System.out.println(exec);

					}
				}
				else {
					
				}
			}
		});
		btnTrans_2.setForeground(new Color(255, 255, 255));
		btnTrans_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnTrans_2.setFocusable(false);
		btnTrans_2.setBackground(new Color(123, 104, 238));
		btnTrans_2.setBounds(218, 110, 53, 30);
		pnlTransfer.add(btnTrans_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		imageIcon = new ImageIcon(bank.class.getResource("/img/gradient.png"));
		lblNewLabel_4.setIcon((a.resized_img(imageIcon, 300, 200)));
		lblNewLabel_4.setBounds(0, 0, 271, 148);
		pnlTransfer.add(lblNewLabel_4);
		
		JPanel pnlDolar = new JPanel();
		pnlDolar.setBackground(new Color(0, 0, 0, 90));
		pnlDolar.setBounds(474, 265, 274, 151);
		cash.add(pnlDolar);
		pnlDolar.setLayout(null);
		
		JButton info4 = new JButton("");
		info4.setBackground(new Color(123, 104, 238));
		info4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "Introduzca la siguiente información: \n"
					    + "Campo 1: Cantidad en pesos dominicanos\n"
					    + "Campo 2: Pulse GO para ver el balance en dolares");
			}
		});
		info4.setBounds(220, 10, 39, 40);
		info4.setFocusPainted(false);
		info4.setBorder(emptyBorder);
		imageIcon = new ImageIcon(bank.class.getResource("/mainIcons/about.png"));
		info4.setIcon((a.resized_img(imageIcon, 37, 37)));
		pnlDolar.add(info4);
		
		
		JLabel lblConvertirADolar = new JLabel("Convertir a dolar");
		lblConvertirADolar.setBackground(new Color(255, 255, 255));
		lblConvertirADolar.setForeground(Color.LIGHT_GRAY);
		lblConvertirADolar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblConvertirADolar.setBounds(78, 11, 142, 25);
		pnlDolar.add(lblConvertirADolar);
		
		fieldDolar2 = new JTextField();
		fieldDolar2.setForeground(new Color(255, 255, 255));
		fieldDolar2.setColumns(10);
		fieldDolar2.setOpaque(false);
		fieldDolar2.setBounds(67, 120, 141, 20);
		pnlDolar.add(fieldDolar2);
		
		fieldDolar1 = new JTextField();
		fieldDolar1.setForeground(new Color(255, 255, 255));
		fieldDolar1.setColumns(10);
		fieldDolar1.setOpaque(false);
		fieldDolar1.setBounds(67, 68, 141, 20);
		pnlDolar.add(fieldDolar1);
		
		JLabel lblDolar1 = new JLabel("");
		lblDolar1.setBounds(17, 53, 40, 41);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon3.png"));
		
		lblDolar1.setIcon((a.resized_img(imageIcon, 40, 40)));
		pnlDolar.add(lblDolar1);
		
		JLabel lblDolar2 = new JLabel("");
		lblDolar2.setBounds(21, 107, 40, 41);
		imageIcon = new ImageIcon(bank.class.getResource("/img/icon2.png"));
		lblDolar2.setIcon((a.resized_img(imageIcon, 30, 30)));
		pnlDolar.add(lblDolar2);
		
		JButton btnTrans_3 = new JButton("GO");
		btnTrans_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					convert con = new convert();
					con.conversion();
				}
				catch(Exception no) {
					JOptionPane.showMessageDialog(frame,
						    "Rellene solo el primer campo e intentelo de nuevo.");
				}
			}
		});
		btnTrans_3.setForeground(new Color(255, 255, 255));
		btnTrans_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		btnTrans_3.setFocusable(false);
		btnTrans_3.setBackground(new Color(123, 104, 238));
		btnTrans_3.setBounds(218, 110, 53, 30);
		pnlDolar.add(btnTrans_3);
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		imageIcon = new ImageIcon(bank.class.getResource("/img/gradient.png"));
		lblNewLabel_5.setIcon((a.resized_img(imageIcon, 300, 200)));
		lblNewLabel_5.setBounds(0, 0, 271, 148);
		pnlDolar.add(lblNewLabel_5);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(bank.class.getResource("/mainIcons/backgroundtest2.png")));
		lblBackground.setBounds(0, 0, 854, 561);
		pnlCenter.add(lblBackground);
		
		JPanel pnlLogo = new JPanel();
		pnlLogo.setBackground(new Color(41, 43, 47));
		pnlLogo.setBounds(0, 0, 130, 146);
		pnlRoot.add(pnlLogo);
		pnlLogo.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(10, 0, 110, 82);
		pnlLogo.add(logo);
		imageIcon = new ImageIcon(bank.class.getResource("/img/neko.png"));
		logo.setIcon((a.resized_img(imageIcon, 100, 100)));
		
		JLabel lblNewLabel = new JLabel("Karlyn INC.");
		lblNewLabel.setBounds(20, 104, 100, 21);
		pnlLogo.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		
		// Metodos botones que manejan paneles
		List<Integer> color=new ArrayList<Integer>();
		color.add(182);
		color.add(182);
		color.add(182);
		color.add(47);
		color.add(49);
		color.add(54);
		color.add(47);
		color.add(49);
		color.add(54);
		color.add(47);
		color.add(49);
		color.add(54);
		
		
		// Botones en Home
		
		// Boton hacer transferencia en home
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home1.setVisible(false);
				home2.setVisible(false);
				cash.setVisible(true);
				
				home.setBackground(new Color(47, 49, 54));
				operations.setBackground(new Color(182, 182, 182));
				
				color.set(0, 47);
				color.set(1, 49);
				color.set(2, 54);
				color.set(3, 182);
				color.set(4, 182);
				color.set(5, 182);
			}
		});
		
		//Boton opciones de la ventana principal
		btnOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOptions.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOptions.setBackground(new Color(35, 37, 38));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				home1.setVisible(false);
				home2.setVisible(false);
				configurations.setVisible(true);
				
				home.setBackground(new Color(47, 49, 54));
				settings.setBackground(new Color(182, 182, 182));
				
				color.set(0, 47);
				color.set(1, 49);
				color.set(2, 54);
				color.set(9, 182);
				color.set(10, 182);
				color.set(11, 182);
			}
		});
		
		// Boton retirar de la ventana principal
		btnSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home1.setVisible(false);
				home2.setVisible(false);
				cash.setVisible(true);
				
				home.setBackground(new Color(47, 49, 54));
				operations.setBackground(new Color(182, 182, 182));
				
				color.set(0, 47);
				color.set(1, 49);
				color.set(2, 54);
				color.set(3, 182);
				color.set(4, 182);
				color.set(5, 182);
			}
		});
		
		// Boton opciones de la cuenta de la ventana principal
		btnEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home1.setVisible(false);
				home2.setVisible(false);
				user.setVisible(true);
				
				home.setBackground(new Color(47, 49, 54));
				operations.setBackground(new Color(47, 49, 54));
				account.setBackground(new Color(182, 182, 182));
				color.set(0, 47);
				color.set(1, 49);
				color.set(2, 54);
				color.set(6, 182);
				color.set(7, 182);
				color.set(8, 182);
			}
		});
		
		// Boton Home
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				home.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				home.setBackground(new Color(color.get(0), color.get(1), color.get(2)));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cash.setVisible(false);
				user.setVisible(false);
				configurations.setVisible(false);
				home1.setVisible(true);
				home2.setVisible(true);
				
				home.setBackground(new Color(182, 182, 182));
				account.setBackground(new Color(47, 49, 54));
				operations.setBackground(new Color(47, 49, 54));
				settings.setBackground(new Color(47, 49, 54));
				color.set(0, 182);
				color.set(1, 182);
				color.set(2, 182);
				color.set(3, 47);
				color.set(4, 49);
				color.set(5, 54);
				color.set(6, 47);
				color.set(7, 49);
				color.set(8, 54);
				color.set(9, 47);
				color.set(10, 49);
				color.set(11, 54);
			}
		});
		
		// Operaciones
		operations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				operations.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				operations.setBackground(new Color(color.get(3), color.get(4), color.get(5)));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				home1.setVisible(false);
				home2.setVisible(false);
				user.setVisible(false);
				configurations.setVisible(false);
				cash.setVisible(true);
				
				
				home.setBackground(new Color(47, 49, 54));
				operations.setBackground(new Color(182, 182, 182));
				account.setBackground(new Color(47, 49, 54));
				settings.setBackground(new Color(47, 49, 54));
				
				color.set(0, 47);
				color.set(1, 49);
				color.set(2, 54);
				color.set(3, 182);
				color.set(4, 182);
				color.set(5, 182);
				color.set(6, 47);
				color.set(7, 49);
				color.set(8, 54);
				color.set(9, 47);
				color.set(10, 49);
				color.set(11, 54);
			}
		});
		
		// Boton Account
		account.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				account.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				account.setBackground(new Color(color.get(6), color.get(7), color.get(8)));
			}
			
			public void mouseClicked(MouseEvent e) {
				cash.setVisible(false);
				home1.setVisible(false);
				home2.setVisible(false);
				configurations.setVisible(false);
				user.setVisible(true);
				
				home.setBackground(new Color(47, 49, 54));
				operations.setBackground(new Color(47, 49, 54));
				account.setBackground(new Color(182, 182, 182));
				settings.setBackground(new Color(47, 49, 54));
				
				color.set(0, 47);
				color.set(1, 49);
				color.set(2, 54);
				color.set(3, 47);
				color.set(4, 49);
				color.set(5, 54);
				color.set(6, 182);
				color.set(7, 182);
				color.set(8, 182);
				color.set(9, 47);
				color.set(10, 49);
				color.set(11, 54);
			}
		});
		
		//Botton other
		settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				settings.setBackground(new Color(182, 182, 182));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				settings.setBackground(new Color(color.get(9), color.get(10), color.get(11)));
			}
			public void mouseClicked(MouseEvent e) {
				cash.setVisible(false);
				home1.setVisible(false);
				home2.setVisible(false);
				user.setVisible(false);
				configurations.setVisible(true);
				
				home.setBackground(new Color(47, 49, 54));
				operations.setBackground(new Color(47, 49, 54));
				account.setBackground(new Color(47, 49, 54));
				settings.setBackground(new Color(182, 182, 182));
				
				color.set(0, 47);
				color.set(1, 49);
				color.set(2, 54);
				color.set(3, 47);
				color.set(4, 49);
				color.set(5, 54);
				color.set(6, 47);
				color.set(7, 49);
				color.set(8, 54);
				color.set(9, 182);
				color.set(10, 182);
				color.set(11, 182);
				
				
			}
		});
	}
}
