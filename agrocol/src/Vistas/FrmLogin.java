package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.UsuarioController;
import Genericos.UsuarioLogeadoSingleton;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel JFrame_Login;
	private JTextField txtNomUsuario;
	private JPasswordField txtClave;
	private final Action action = new SwingAction();
	private JLabel lbl_MensajeError;
	private JLabel lbl_MensajeError_1;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/Img/Logo_SL.png")));
		setBounds(100, 100, 700, 450);
		setUndecorated(true);
		JFrame_Login = new JPanel();
		setLocationRelativeTo(null);
		JFrame_Login.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JFrame_Login);
		JFrame_Login.setLayout(null);

		txtClave = new JPasswordField();
		txtClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10) {
					String nomusuario = txtNomUsuario.getText();
					String clave = txtClave.getText();
					if (UsuarioController.logIn(nomusuario, clave)) {
						FrmMenuPrincipal frame = new FrmMenuPrincipal();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						hide();
					} else {
						lbl_MensajeError.show();
					}
				}
			}
		});
		
		lbl_MensajeError_1 = new JLabel("X");
		lbl_MensajeError_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lbl_MensajeError_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MensajeError_1.setForeground(new Color(0, 0, 0));
		lbl_MensajeError_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_MensajeError_1.setBounds(664, 11, 26, 24);
		JFrame_Login.add(lbl_MensajeError_1);
		txtClave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtClave.setBorder(null);
		txtClave.setBounds(437, 268, 179, 20);
		JFrame_Login.add(txtClave);

		lbl_MensajeError = new JLabel("Usuario y/o contraseña incorrecta");
		lbl_MensajeError.setForeground(Color.RED);
		lbl_MensajeError.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_MensajeError.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MensajeError.setBounds(427, 299, 206, 14);
		JFrame_Login.add(lbl_MensajeError);

		JButton btn_Ingresar = new JButton("");
		btn_Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomusuario = txtNomUsuario.getText();
				String clave = txtClave.getText();
				if (UsuarioController.logIn(nomusuario, clave)) {
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					hide();
				} else {
					lbl_MensajeError.show();
				}
			}
		});
		
		btn_Ingresar.setSelectedIcon(new ImageIcon(FrmLogin.class.getResource("/Img/Boton_Ingreso.png")));
		btn_Ingresar.setBorder(null);
		btn_Ingresar.setBackground(new Color(0, 0, 0, 0));
		btn_Ingresar.setIcon(new ImageIcon(FrmLogin.class.getResource("/Img/Boton_Ingreso.png")));
		btn_Ingresar.setBounds(427, 365, 199, 31);
		JFrame_Login.add(btn_Ingresar);
		
				txtNomUsuario = new JTextField();
				txtNomUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
				txtNomUsuario.setBorder(null);
				txtNomUsuario.setBounds(437, 171, 179, 23);
				JFrame_Login.add(txtNomUsuario);
				txtNomUsuario.setColumns(10);
				
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setBackground(Color.WHITE);
						lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/Img/PantallaLogin.png")));
						lblNewLabel.setBounds(0, 0, 700, 450);
						JFrame_Login.add(lblNewLabel);
		lbl_MensajeError.hide();

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
	

	
	
}
