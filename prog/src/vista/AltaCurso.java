package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AltaCurso extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private final JButton btnNewButton = new JButton("Cancelar");
	private JTextField textField_8;
	public static ArrayList<String> previas= new ArrayList<>();
	private ListaCursos listaCursos=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCurso frame = new AltaCurso();
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
	public AltaCurso() {
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("Alta de curso");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblInstituto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Matematica");
		comboBox.addItem("Matematica 1");
		comboBox.addItem("Matematica 2");
		comboBox.addItem("Matematica 3");
		comboBox.addItem("Matematica 4");
		getContentPane().add(comboBox);
		
		JLabel lblCursos = new JLabel("Nombre curso");
		lblCursos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCursos);
		
		textField = new JTextField();
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDescripcion);
		
		textField_8 = new JTextField();
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDuracion);
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas");
		lblCantidadDeHoras.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCantidadDeHoras);
		
		textField_2 = new JTextField();
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de creditos");
		lblCantidadDeCreditos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCantidadDeCreditos);
		
		textField_3 = new JTextField();
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUrl = new JLabel("Url");
		lblUrl.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblUrl);
		
		textField_4 = new JTextField();
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de alta");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFecha);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPrevias = new JLabel("Previaturas");
		lblPrevias.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPrevias);
		
		JButton btnNewButton_1 = new JButton("Agregar previas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> cursos =  new ArrayList<>();
				cursos.add("Matematiaca 1");
				cursos.add("Matematiaca 2");
				cursos.add("Programacion");
				cursos.add("Fisica 2");
				cursos.add("Filosofia");
				cursos.add("Educacion fisica");
				cursos.add("Literatura");
				cursos.add("Dibujo");
				
				if(listaCursos == null) {
					listaCursos = new ListaCursos(cursos);
					VentanaPrincipal.desktopPane.add(listaCursos);
				}
				listaCursos.setVisible(true);
			}
		});
		getContentPane().add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		getContentPane().add(btnNewButton);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!previas.isEmpty()) {
					for(String p: previas) {
						System.out.println(p);
					}
				}
				
				if(validarFormulario()) {
					JOptionPane.showMessageDialog(null,"Se agrego los datos del curso");
					resetFormulario();
					//dispose();
				}else {
					JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
				}
			}
		});
		getContentPane().add(btnAceptar);

	}
	
	Boolean validarFormulario() {
		if(!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("") &&
				!textField_3.getText().equals("") && !textField_4.getText().equals("") && !textField_5.getText().equals("") &&
				!textField_6.getText().equals("") && !textField_7.getText().equals("") && !textField_8.getText().equals("")) {
			
			return true;
		}else {
			return false;
		}
		
	}
	
	void resetFormulario() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField_8.setText("");
	}

}
