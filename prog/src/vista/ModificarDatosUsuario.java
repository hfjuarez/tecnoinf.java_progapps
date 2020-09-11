package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class ModificarDatosUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private String usuario;
	private String inti;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosUsuario frame = new ModificarDatosUsuario();
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
	public ModificarDatosUsuario() {
		setResizable(true);
		setTitle("Modificar datos de usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 442, 260);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				usuario = e.getItem().toString();
			}
		});
		comboBox.addItem("");
		comboBox.addItem("carlos1234");
		comboBox.addItem("cajjdfkkaka");
		comboBox.addItem("cardfadgsdgadg");
		comboBox.addItem("mariadfasdasdgad");
		comboBox.addItem("martinaghdjjadf");
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Ver datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCamposUsuario();
			}
		});
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(600, 400));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNickname);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEmail);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombre);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblApellido);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblFechaDeNacimiento);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField_5 = new JTextField();
		panel_1.add(textField_5);
		textField_5.setColumns(5);
		
		textField_6 = new JTextField();
		panel_1.add(textField_6);
		textField_6.setColumns(5);
		
		textField_4 = new JTextField();
		panel_1.add(textField_4);
		textField_4.setColumns(5);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblInstituto);
		
		JComboBox comboBox_1 = new JComboBox();
		for(String instituto:listaInstitutos()) {
			comboBox_1.addItem(instituto);
		}
		panel.add(comboBox_1);
		
		JButton btnAceptar = new JButton("Cancelar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Aceptar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText()+
				textField_1.getText()+
				textField_2.getText()+
				textField_3.getText()+
				textField_4.getText()+
				textField_5.getText()+
				textField_6.getText());
			}
		});
		getContentPane().add(btnCancelar);

	}
	
	private ArrayList<String> listaInstitutos(){
		ArrayList<String> institutos = new ArrayList<>();
		institutos.add("INstituto 1");
		institutos.add("INstituto 2");
		institutos.add("INstituto 3");
		institutos.add("INstituto 4");
		institutos.add("INstituto 5");
		return institutos;
	}
	
	private void setCamposUsuario() {
		//Se busca el dtusuario con el nickname usuairo, se rellena los campos con esos datos
		//Nikname
		textField.setText(usuario);
		//Email
		textField_1.setText(usuario);
		//Nombre
		textField_2.setText(usuario);
		//Apellido
		textField_3.setText(usuario);
		//fecha nacimiento
		//dia
		textField_4.setText(usuario);
		//mes
		textField_5.setText(usuario);
		//anio
		textField_6.setText(usuario);
		
	}

}
