package index;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import faded.FadeEffect;
import user_data.config;
import user_data.transfer;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class confFrame {

	public JFrame frame;
	public static JTextField txtNombre;
	public static JTextField txtVar;
	public static JTextArea txtVar2;
	public static JLabel lblVariable = new JLabel("Variable");
	public static JLabel lblVariable2 = new JLabel("Segunda variable");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					confFrame window = new confFrame();
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
	public confFrame() {
		initialize();
		frame.setBackground(new Color(0, 0, 0, 0));
		FadeEffect.fadeInFrame(frame, 25, 0.1f);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Banco Dominicano");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(confFrame.class.getResource("/adminsrc/senko_admin.png")));
		frame.setBounds(100, 100, 985, 561);
		frame.setLocation(185, 65);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 75, 83));
		panel.setBounds(330, 0, 331, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 49, 54));
		panel_1.setBounds(0, 0, 331, 53);
		panel.add(panel_1);
		
		Operaciones a = new Operaciones();
		JButton btnBack = new JButton("Volver");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(new Color(57, 60, 67));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setBackground(new Color(47, 49, 54));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				bank a = new bank();
				a.frame.setVisible(true);
				a.home1.setVisible(false);
				a.home2.setVisible(false);
				a.configurations.setVisible(true);
				a.settings.setBackground(new Color(182, 182, 182));
				a.home.setBackground(new Color(47, 49, 54));
				
				new java.util.Timer().schedule(new TimerTask() {
					
					public void run() {
						frame.dispose();
					}
				}, 1000 * 1);
			}
		});
		btnBack.setBackground(new Color(47, 49, 54));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setFocusPainted(false);
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon imageIco = new ImageIcon(confFrame.class.getResource("/img/back.png"));
		btnBack.setIcon(a.resized_img(imageIco, 25, 25));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		panel_1.setLayout(null);
		btnBack.setBorder(emptyBorder);
		btnBack.setBounds(0, 0, 90, 53);
		panel_1.add(btnBack);
		
		JLabel lblTop = new JLabel("<html>Por favor rellene todos los<br>campos antes de continuar</bt></html>");
		lblTop.setForeground(new Color(255, 255, 255));
		lblTop.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblTop.setBounds(68, 64, 222, 71);
		panel.add(lblTop);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNombre.setBounds(10, 146, 311, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(255, 255, 255));
		txtNombre.setBackground(new Color(72, 75, 83));
		txtNombre.setBounds(10, 165, 311, 20);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(119, 136, 153));
		separator.setBounds(10, 191, 311, 2);
		panel.add(separator);
		
		
		lblVariable.setForeground(Color.WHITE);
		lblVariable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblVariable.setBounds(10, 221, 311, 14);
		panel.add(lblVariable);
		
		txtVar = new JTextField();
		txtVar.setForeground(new Color(255, 255, 255));
		txtVar.setBackground(new Color(72, 75, 83));
		txtVar.setColumns(10);
		txtVar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtVar.setBounds(10, 240, 311, 20);
		panel.add(txtVar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setForeground(new Color(119, 136, 153));
		separator_1.setBounds(10, 266, 311, 2);
		panel.add(separator_1);
		
		txtVar2 = new JTextArea();
		txtVar2.setForeground(new Color(255, 255, 255));
		txtVar2.setBackground(new Color(47, 49, 54));
		txtVar2.setColumns(10);
		txtVar2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtVar2.setBounds(10, 316, 311, 194);
		panel.add(txtVar2);
		
		
		lblVariable2.setForeground(Color.WHITE);
		lblVariable2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblVariable2.setBounds(10, 297, 311, 14);
		panel.add(lblVariable2);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				config a = new config();
				
				int n = JOptionPane.showConfirmDialog(
						frame,
					    "¿Enviar datos?",
					    "Confirmar",
					    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				
				if (n == 0) {
					try {
						a.complain();
						
						JOptionPane.showMessageDialog(frame,
							    "Datos enviados correctamente.");
					}
					catch (Exception e2) {
						System.out.println("Ha ocurrido un error grave, chequea:");
						System.out.println(e2);
						
					}
					
				}
			}
		});
		btnNewButton.setBackground(new Color(119, 136, 153));
		btnNewButton.setBounds(10, 527, 311, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 985, 561);
		lblNewLabel.setIcon(new ImageIcon(confFrame.class.getResource("/img/test2.jpg")));
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
