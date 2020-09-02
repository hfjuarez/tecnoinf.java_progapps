package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Checkbox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario();
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
	public AltaUsuario() {
		setTitle("Alta de usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(10, 43, 150, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 68, 150, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 93, 150, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 118, 150, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setBounds(10, 143, 150, 15);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setBounds(10, 168, 150, 15);
		getContentPane().add(lblInstituto);
		
		textField = new JTextField();
		textField.setBounds(160, 43, 250, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 68, 250, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 93, 250, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(160, 118, 250, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(160, 143, 250, 19);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(160, 168, 250, 19);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JRadioButton rdbtnDocente = new JRadioButton("Docente");
		rdbtnDocente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(rdbtnDocente.isSelected()) {
					textField_5.setEditable(true);
				}else {
					textField_5.setEditable(false);
				}
			}
		});
		rdbtnDocente.setSelected(true);
		rdbtnDocente.setBounds(10, 10, 149, 23);
		getContentPane().add(rdbtnDocente);

	}
}
