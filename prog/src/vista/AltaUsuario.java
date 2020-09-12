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


public class AltaUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField txtDiaint;
	private JTextField textField_6;
	private JTextField textField_7;
	private final Action action = new SwingAction();
	File imagen=null;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empty");
		lblNewLabel.setBounds(160, 154, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(new Rectangle(0, 1, 0, 0));
		lblNickname.setBounds(10, 10, 150, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(new Rectangle(0, 20, 0, 0));
		lblNombre.setBounds(10, 38, 150, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(new Rectangle(0, 20, 0, 0));
		lblApellido.setBounds(10, 63, 150, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(new Rectangle(0, 20, 0, 0));
		lblEmail.setBounds(10, 88, 150, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setBounds(new Rectangle(0, 20, 0, 0));
		lblFechaNacimiento.setBounds(10, 113, 150, 15);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setBounds(10, 198, 150, 15);
		getContentPane().add(lblInstituto);
		
		textField = new JTextField();
		textField.setBounds(new Rectangle(0, 20, 0, 0));
		textField.setBounds(160, 10, 250, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(new Rectangle(0, 20, 0, 0));
		textField_1.setBounds(160, 38, 250, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(new Rectangle(0, 20, 0, 0));
		textField_2.setBounds(160, 63, 250, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(new Rectangle(0, 20, 0, 0));
		textField_3.setBounds(160, 88, 250, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(160, 198, 250, 19);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		txtDiaint = new JTextField();
		txtDiaint.setBounds(new Rectangle(0, 20, 0, 0));
		txtDiaint.setBounds(280, 113, 30, 19);
		getContentPane().add(txtDiaint);
		txtDiaint.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(new Rectangle(0, 20, 0, 0));
		textField_6.setBounds(320, 113, 30, 19);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(new Rectangle(0, 20, 0, 0));
		textField_7.setBounds(360, 113, 50, 19);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
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
		rdbtnDocente.setBounds(170, 168, 149, 23);
		getContentPane().add(rdbtnDocente);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ILogica Interfaz = new BizcochoEnARG().getInterface();
				System.out.println("este es el 1 " + textField.getText());
				System.out.println("este es el 2 " + txtDiaint.getText());
				System.out.println("este es el 3 " +textField_1.getText());
				System.out.println("este es el 4 " +textField_2.getText());
				System.out.println("este es el 5 " +textField_3.getText());
				System.out.println("este es el 6 " +textField_5.getText());
				System.out.println(txtDiaint.getText()+" "+textField_6.getText()+" "+textField_7.getText());
				String nickname = textField.getText();
				String nombre = textField_1.getText();
				String apellido = textField_2.getText();
				String email = textField_3.getText();
				String fecha = (textField_7.getText()+"-"+textField_6.getText()+"-"+txtDiaint.getText());
	            Date nacDate = Date.valueOf(fecha);
	            String pp="";
	            
	            if(rdbtnDocente.isSelected()) {
	            	pp = Interfaz.crearUsuarioDocente(nickname,nombre, apellido, email, nacDate,textField_5.getText(),imagen);
	            	if(pp.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"Agregado");
					}
					else
					{
						JOptionPane.showMessageDialog(null,pp);
					}
				}else {
					pp =Interfaz.crearUsuarioEstudiante(nickname,nombre, apellido, email, nacDate,imagen);
					if(pp.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"Agregado");
					}
					else
					{
						JOptionPane.showMessageDialog(null,pp);
					}
				}
			}
		});
		btnAgregar.setBounds(290, 224, 117, 25);
		getContentPane().add(btnAgregar);
		
		Button button = new Button("Elegir imagen");
		button.setFont(new Font("Dialog", Font.BOLD, 10));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r;
				JFileChooser jf = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
				jf.setFileFilter(filter);
				r=jf.showOpenDialog(AltaUsuario.this);
				if(r==JFileChooser.APPROVE_OPTION)
				{
					imagen=jf.getSelectedFile();
					lblNewLabel.setText(imagen.getName());
				}
				else
				{
					System.err.println("Te falta calle.");
				}
			}
		});
		button.setBounds(300, 146, 110, 22);
		getContentPane().add(button);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(160, 224, 117, 25);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("D / M / A  (INT)");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_1.setBounds(160, 113, 100, 19);
		getContentPane().add(lblNewLabel_1);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	
	JFileChooser jf = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
}