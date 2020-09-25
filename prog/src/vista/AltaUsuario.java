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
import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import java.awt.Button;
import javax.swing.JFormattedTextField.AbstractFormatter;
import API.BizcochoEnARG;
import API.ILogica;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import API.datatypes.*;

public class AltaUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField txtDiaint;
	private JTextField textField_6;
	private JTextField textField_7;
	private JRadioButton rdbtnDocente;
	JFileChooser jf = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	private final Action action = new SwingAction();
	File imagen = null;

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
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		setResizable(true);
		setTitle("Alta de usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 354);
		getContentPane().setLayout(null);

		
		//Contenedor principal
		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 400, 250);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		

		
		
		JLabel lblNickname = new JLabel("Nickname");
		panel.add(lblNickname);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
				
		JLabel lblPassword = new JLabel("Password");
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		
		JLabel lblRepetirPassword = new JLabel("Repetir password");
		panel.add(lblRepetirPassword);
		
		passwordField_1 = new JPasswordField();
		panel.add(passwordField_1);

		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido");
		panel.add(lblApellido);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		panel.add(lblEmail);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		panel.add(lblFechaNacimiento);
				
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		txtDiaint = new JTextField();
		panel_1.add(txtDiaint);
		txtDiaint.setColumns(10);
		
		textField_6 = new JTextField();
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		panel_1.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel = new JLabel("Empty");
		panel.add(lblNewLabel);
		
		Button button = new Button("Elegir imagen");
		panel.add(button);
		button.setFont(new Font("Dialog", Font.BOLD, 10));

		JLabel lblInstituto = new JLabel("Instituto");
		panel.add(lblInstituto);
		
		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setEditable(false);
		
		
		textField_5.setColumns(10);
		
		rdbtnDocente = new JRadioButton("Docente");
		panel.add(rdbtnDocente);
		rdbtnDocente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnDocente.isSelected()) {
					textField_5.setEditable(true);
				} else {
					textField_5.setEditable(false);
				}
			}
		});
		rdbtnDocente.setSelected(true);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int r;
			JFileChooser jf = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
			jf.setFileFilter(filter);
			r = jf.showOpenDialog(AltaUsuario.this);
			if (r == JFileChooser.APPROVE_OPTION) {
				imagen = jf.getSelectedFile();
				lblNewLabel.setText(imagen.getName());
			} else {
				System.err.println("Te falta calle.");
			}				
		}});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			ILogica Interfaz = new BizcochoEnARG().getInterface();
			String nickname = textField.getText();
			String nombre = textField_1.getText();
			String apellido = textField_2.getText();
			String email = textField_3.getText();
			String fecha = (textField_7.getText() + "-" + textField_6.getText() + "-" + txtDiaint.getText());
			String pass = String.valueOf(passwordField.getPassword());
			String verPass = String.valueOf(passwordField_1.getPassword());
			String pp = "";
			//System.out.println(pass+" "+verPass);
			if(!nickname.equals("") && !nombre.equals("") && !email.equals("") && !textField_7.getText().equals("") &&
					!textField_6.getText().equals("")  && !pass.equals("") && !verPass.equals("") && !txtDiaint.getText().isEmpty()) {
				Date nacDate = Date.valueOf(fecha);
				if(pass.equals(verPass)) {
					if (rdbtnDocente.isSelected()) {
						pp = Interfaz.crearUsuarioDocente(nickname, nombre, apellido, email, nacDate, textField_5.getText(),imagen,pass, verPass);
						if (pp.isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Se ha agregado el estudiante con los siguentes datos:\n      " + "Nickname: "
											+ nickname + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEmail: "
											+ email + "\nFecha nac: " + nacDate.toString());
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_7.setText("");
							textField_6.setText("");
							txtDiaint.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
						}else {
							JOptionPane.showMessageDialog(null, pp);
						}
					}else {
						pp = Interfaz.crearUsuarioEstudiante(nickname, nombre, apellido, email, nacDate, imagen, pass,verPass);
						if (pp.isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Se ha agregado el docente con los siguentes datos:\n      " + "Nickname: " + nickname
											+ "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEmail: " + email
											+ "\nFecha nac: " + nacDate.toString());
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_7.setText("");
							textField_6.setText("");
							txtDiaint.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
						}else {
							JOptionPane.showMessageDialog(null, pp);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "ERROR, no coiciden las contrasenias.");
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null, "No pueden haber campos vacios");
			}
			
			
		}});
		
		btnAgregar.setBounds(258, 282, 117, 25);
		getContentPane().add(btnAgregar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(100, 282, 117, 25);
		getContentPane().add(btnCancelar);
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