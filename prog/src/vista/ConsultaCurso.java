package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ConsultaCurso extends JInternalFrame {
	private JLabel lblNewLabel;
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
					ConsultaCurso frame = new ConsultaCurso();
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
	public ConsultaCurso() {
		setTitle("Consulta de curso");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 424, 470);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 30, 350, 81);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel = new JLabel("Instituto");
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Curso");
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(30, 125, 350, 150);
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		panel_3.add(lblNombre);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		panel_3.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		panel_3.add(textArea);
		
		JLabel lblDuracion = new JLabel("Duracion");
		panel_3.add(lblDuracion);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas");
		panel_3.add(lblCantidadDeHoras);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de creditos");
		panel_3.add(lblCantidadDeCreditos);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUrl = new JLabel("Url");
		panel_3.add(lblUrl);
		
		textField_4 = new JTextField();
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblF = new JLabel("Fecha de alta");
		panel_3.add(lblF);
		
		textField_5 = new JTextField();
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(30, 282, 350, 100);
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblEdicionDeCurso = new JLabel("Edicion de curso");
		panel_5.add(lblEdicionDeCurso);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		
		JButton btnNewButton = new JButton("New button");
		panel_5.add(btnNewButton);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblProgramaDeFormacion = new JLabel("Programa de formacion");
		panel_6.add(lblProgramaDeFormacion);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_6.add(btnNewButton_1);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(263, 401, 117, 25);
		getContentPane().add(btnCerrar);

	}
	
	public void setLabel(String curso) {
		lblNewLabel.setText(curso);
	}
}
